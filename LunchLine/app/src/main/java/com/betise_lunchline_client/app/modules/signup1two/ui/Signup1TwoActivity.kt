package com.betise_lunchline_client.app.modules.signup1two.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.activity.viewModels
import com.betise_lunchline_client.app.R
import com.betise_lunchline_client.app.appcomponents.base.BaseActivity
import com.betise_lunchline_client.app.databinding.ActivitySignup1TwoBinding
import com.betise_lunchline_client.app.modules.login.ui.LoginActivity
import com.betise_lunchline_client.app.modules.signup1two.`data`.viewmodel.Signup1TwoVM
import com.betise_lunchline_client.app.modules.signup2two.ui.Signup2TwoActivity
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlin.String
import kotlin.Unit

class Signup1TwoActivity : BaseActivity<ActivitySignup1TwoBinding>(R.layout.activity_signup_1_two) {
    private val viewModel: Signup1TwoVM by viewModels<Signup1TwoVM>()
    private lateinit var phoneNo: String
    private lateinit var phoneOptionsBuilder: PhoneAuthOptions.Builder
    private val auth = Firebase.auth

    override fun onInitialized(): Unit {
        viewModel.navArguments = intent.extras?.getBundle("bundle")
        binding.signup1TwoVM = viewModel


        phoneOptionsBuilder = PhoneAuthOptions.newBuilder(auth)
            .setTimeout(60L, java.util.concurrent.TimeUnit.SECONDS)
            .setActivity(this)
            .setCallbacks(Signup2TwoActivity.callbacks)

    }

    override fun setUpClicks(): Unit {
        binding.btnGetOtp.setOnClickListener {
            val phNo = findViewById<EditText>(R.id.etMobileNo)
            phoneNo = phNo.text.toString()

            val phoneOptions = phoneOptionsBuilder.setPhoneNumber("+91$phoneNo").build()
            PhoneAuthProvider.verifyPhoneNumber(phoneOptions)

//            val destIntent = Signup2TwoActivity.getIntent(this, null)
            val destIntent = Intent(this, Signup2TwoActivity::class.java)
            destIntent.putExtra("phoneNo", phoneNo)
            startActivity(destIntent)

        }
    }

    companion object {
        const val TAG: String = "SIGNUP1TWO_ACTIVITY"

        fun getIntent(context: Context, bundle: Bundle?): Intent {

            val destIntent = Intent(context, Signup1TwoActivity::class.java)
            destIntent.putExtra("bundle", bundle)
            return destIntent
        }
    }
}
