package com.betise_lunchline_client.app.modules.login.ui

import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.activity.viewModels
import com.betise_lunchline_client.app.R
import com.betise_lunchline_client.app.appcomponents.base.BaseActivity
import com.betise_lunchline_client.app.appcomponents.views.DatePickerFragment.Companion.TAG
import com.betise_lunchline_client.app.databinding.ActivityLoginBinding
import com.betise_lunchline_client.app.modules.SharedObjects
import com.betise_lunchline_client.app.modules.SharedObjects.Companion.db
import com.betise_lunchline_client.app.modules.homepage.ui.HomePageActivity
import com.betise_lunchline_client.app.modules.login.`data`.viewmodel.LoginVM
import com.betise_lunchline_client.app.modules.signup1two.ui.Signup1TwoActivity
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.IdpResponse
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlin.String
import kotlin.Unit
import com.google.firebase.auth.PhoneAuthCredential as PhoneAuthCredential1

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {
    private val viewModel: LoginVM by viewModels<LoginVM>()
    private val signInLauncher = registerForActivityResult(
        FirebaseAuthUIActivityResultContract()
    ) { res ->
        this.onSignInResult(res)
    }
    val providers = arrayListOf(
        AuthUI.IdpConfig.GoogleBuilder().build(),
    )
    val signInIntent = AuthUI.getInstance()
        .createSignInIntentBuilder()
        .setAvailableProviders(providers)
        .setTheme(R.style.FuckingHell)
        .build()

    val auth = Firebase.auth

    val phoneOptions = PhoneAuthOptions.newBuilder(auth)
        .setPhoneNumber("+919871054376")
        .setTimeout(60L, java.util.concurrent.TimeUnit.SECONDS)
        .setActivity(this)
        .setCallbacks(callbacks)
        .build()


    var user: FirebaseUser? = FirebaseAuth.getInstance().currentUser
    override fun onInitialized(): Unit {
        viewModel.navArguments = intent.extras?.getBundle("bundle")
        binding.loginVM = viewModel


    }


    override fun setUpClicks(): Unit {
        binding.txtNewUserSign.setOnClickListener {
            val destIntent = Signup1TwoActivity.getIntent(this, null)
            startActivity(destIntent)
        }
        binding.txtLoginwithEmai.setOnClickListener {
//
            signInLauncher.launch(signInIntent)

        }
    }

    private fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) {
        val response: IdpResponse? = result.idpResponse
        if (result.resultCode == RESULT_OK) {
            // Successfully signed in
            user = FirebaseAuth.getInstance().currentUser
            user?.let {
                // Name, email address, and profile photo Url
                val name = user!!.displayName
                val email = user!!.email
                SharedObjects.user_email = email.toString()
                val photoUrl = user!!.photoUrl

                // Check if user's email is verified
                val emailVerified = user!!.isEmailVerified

                // The user's ID, unique to the Firebase project. Do NOT use this value to
                // authenticate with your backend server, if you have one. Use
                // FirebaseUser.getToken() instead.
                val uid = user!!.uid
                val userRef = db.collection("users").document(email!!)
                userRef.get().addOnCompleteListener{ task ->
                    if(task.isSuccessful){
                        val document = task.result
                        if(document!!.exists()){
                            Log.d(TAG, "DocumentSnapshot data: ${document.data}")
                        }else{
                            val user = SharedObjects.User(name.toString(), email.toString(), photoUrl.toString(), "", "", "")
                            SharedObjects.db.collection("users")
                                .document(email!!).set(user)
                                .addOnSuccessListener {
                                    Log.d(TAG, "DocumentSnapshot written")
                                }
                                .addOnFailureListener { e ->
                                    Log.w(TAG, "Error adding document", e)
                                }
                        }
                    }else{
                        Log.d(TAG, "onSignInResult: ${task.exception}")
                    }
                }
            }

            val destIntent = HomePageActivity.getIntent(this, null)
            startActivity(destIntent)

        } else {
            // Sign in failed. If response is null the user canceled the
            // sign-in flow using the back button. Otherwise check
            // response.getError().getErrorCode() and handle the error.
            // ...
            if (response != null) {
                response.error?.errorCode
            }
        }
    }



    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential1) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithCredential:success")

                    val user = task.result?.user
                } else {
                    // Sign in failed, display a message and update the UI
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        // The verification code entered was invalid
                    }
                    // Update UI
                }
            }
    }

    object callbacks : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        override fun onVerificationCompleted(credential: PhoneAuthCredential1) {
            // This callback will be invoked in two situations:
            // 1 - Instant verification. In some cases the phone number can be instantly
            //     verified without needing to send or enter a verification code.
            // 2 - Auto-retrieval. On some devices Google Play services can automatically
            //     detect the incoming verification SMS and perform verification without
            //     user action.
            Log.d(TAG, "onVerificationCompleted:$credential")
            signInWithPhoneAuthCredential(credential)
        }

        override fun onVerificationFailed(e: FirebaseException) {
            // This callback is invoked in an invalid request for verification is made,
            // for instance if the the phone number format is not valid.
            Log.w(TAG, "onVerificationFailed", e)

            if (e is FirebaseAuthInvalidCredentialsException) {
                // Invalid request
            } else if (e is FirebaseTooManyRequestsException) {
                // The SMS quota for the project has been exceeded
            }

            // Show a message and update the UI
        }

        override fun onCodeSent(
            verificationId: String,
            token: PhoneAuthProvider.ForceResendingToken
        ) {
            // The SMS verification code has been sent to the provided phone number, we
            // now need to ask the user to enter the code and then construct a credential
            // by combining the code with a verification ID.
            Log.d(TAG, "onCodeSent:$verificationId")

            // Save verification ID and resending token so we can use them later
            storedVerificationId = verificationId
            resendToken = token
        }
    }


    companion object {
        const val TAG: String = "LOGIN_ACTIVITY"


        fun getIntent(context: Context, bundle: Bundle?): Intent {
            val destIntent = Intent(context, LoginActivity::class.java)
            destIntent.putExtra("bundle", bundle)
            return destIntent
        }
    }
}

