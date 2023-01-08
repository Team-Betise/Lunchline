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
import com.google.firebase.auth.ActionCodeSettings
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlin.String
import kotlin.Unit

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
    binding.txtLoginwithEmai.setOnClickListener{
        signInLauncher.launch(signInIntent)

      }
//          AuthUI.getInstance()
//        .createSignInIntentBuilder()
//        .setAvailableProviders(providers)
//        .setTheme(R.style.FuckingHell)
//        .build()
//      startA?ctivity(destIntent)
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

    companion object {
        const val TAG: String = "LOGIN_ACTIVITY"


        fun getIntent(context: Context, bundle: Bundle?): Intent {
            val destIntent = Intent(context, LoginActivity::class.java)
            destIntent.putExtra("bundle", bundle)
            return destIntent
        }
  }
//  private fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) {
//    val response: IdpResponse? = result.idpResponse
//    if (result.resultCode == RESULT_OK) {
//      // Successfully signed in
//      val user: FirebaseUser? = FirebaseAuth.getInstance().currentUser
//      val destIntent = HomePageActivity.getIntent(this,null)
//      startActivity(destIntent)
//
//    } else {
//      // Sign in failed. If response is null the user canceled the
//      // sign-in flow using the back button. Otherwise check
//      // response.getError().getErrorCode() and handle the error.
//      // ...
//      if (response != null) {
//        response.error?.errorCode
//      }
//    }
}

