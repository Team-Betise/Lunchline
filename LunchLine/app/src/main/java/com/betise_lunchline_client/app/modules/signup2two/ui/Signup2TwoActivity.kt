package com.betise_lunchline_client.app.modules.signup2two.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.activity.viewModels
import com.betise_lunchline_client.app.R
import com.betise_lunchline_client.app.appcomponents.base.BaseActivity
import com.betise_lunchline_client.app.databinding.ActivitySignup2TwoBinding
import com.betise_lunchline_client.app.modules.homepage.ui.HomePageActivity
import com.betise_lunchline_client.app.modules.login.ui.LoginActivity
import com.betise_lunchline_client.app.modules.signup2two.`data`.viewmodel.Signup2TwoVM
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlin.String
import kotlin.Unit

class Signup2TwoActivity : BaseActivity<ActivitySignup2TwoBinding>(R.layout.activity_signup_2_two) {
    private val viewModel: Signup2TwoVM by viewModels<Signup2TwoVM>()
    private lateinit var phoneNo: String
    private lateinit var credential: PhoneAuthCredential

    override fun onInitialized(): Unit {
        viewModel.navArguments = intent.extras?.getBundle("bundle")
        binding.signup2TwoVM = viewModel

        val intent = getIntent();
        phoneNo = intent.getStringExtra("phoneNo").toString()
    }

    override fun setUpClicks(): Unit {
        binding.btnConfirm.setOnClickListener {
            val signup2:EditText = findViewById(R.id.edtOTP)
            val OTP=signup2.text.toString()




            val destIntent = HomePageActivity.getIntent(this, null)
            startActivity(destIntent)

        }
    }

    companion object {
        const val TAG: String = "SIGNUP2TWO_ACTIVITY"


        fun getIntent(context: Context, bundle: Bundle?): Intent {
            val destIntent = Intent(context, Signup2TwoActivity::class.java)
            destIntent.putExtra("bundle", bundle)
            return destIntent
        }
    }

    object callbacks : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        private lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
        private lateinit var storedVerificationId: String
        private val auth = Firebase.auth


        override fun onVerificationCompleted(credential: PhoneAuthCredential) {
            // This callback will be invoked in two situations:
            // 1 - Instant verification. In some cases the phone number can be instantly
            //     verified without needing to send or enter a verification code.
            // 2 - Auto-retrieval. On some devices Google Play services can automatically
            //     detect the incoming verification SMS and perform verification without
            //     user action.
            Log.d(LoginActivity.TAG, "onVerificationCompleted:$credential")
            signInWithPhoneAuthCredential(credential)
        }

        private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
            auth.signInWithCredential(credential)
                .addOnCompleteListener(this) { task : Task<AuthResult> ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(LoginActivity.TAG, "signInWithCredential:success")

                        val user = task.result?.user
                    } else {
                        // Sign in failed, display a message and update the UI
                        Log.w(LoginActivity.TAG, "signInWithCredential:failure", task.exception)
                        if (task.exception is FirebaseAuthInvalidCredentialsException) {
                            // The verification code entered was invalid
                        }
                        // Update UI
                    }
                }
        }




        override fun onVerificationFailed(e: FirebaseException) {
            // This callback is invoked in an invalid request for verification is made,
            // for instance if the the phone number format is not valid.
            Log.w(LoginActivity.TAG, "onVerificationFailed", e)

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
            Log.d(LoginActivity.TAG, "onCodeSent:$verificationId")

            // Save verification ID and resending token so we can use them later
            storedVerificationId = verificationId
            resendToken = token

        }


    }
}

private fun <TResult> Task<TResult>.addOnCompleteListener(callbacks: Signup2TwoActivity.callbacks, function: (Task<TResult>) -> Unit) {

}
