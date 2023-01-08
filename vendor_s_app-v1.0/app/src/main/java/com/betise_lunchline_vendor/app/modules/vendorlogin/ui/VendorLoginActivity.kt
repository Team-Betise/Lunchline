package com.betise_lunchline_vendor.app.modules.vendorlogin.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.betise_lunchline_vendor.app.R
import com.betise_lunchline_vendor.app.appcomponents.base.BaseActivity
import com.betise_lunchline_vendor.app.databinding.ActivityVendorLoginBinding
import com.betise_lunchline_vendor.app.modules.vednorsignup1two.ui.VednorSignup1TwoActivity
import com.betise_lunchline_vendor.app.modules.vendorhome.ui.VendorHomeActivity
import com.betise_lunchline_vendor.app.modules.vendorlogin.`data`.viewmodel.VendorLoginVM
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.IdpResponse
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.ActionCodeSettings
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlin.String
import kotlin.Unit

class VendorLoginActivity : BaseActivity<ActivityVendorLoginBinding>(R.layout.activity_vendor_login)
    {
  private val viewModel: VendorLoginVM by viewModels<VendorLoginVM>()
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
        .build()

      var user: FirebaseUser? = FirebaseAuth.getInstance().currentUser

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.vendorLoginVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.txtNewUserSign.setOnClickListener {
      val destIntent = VednorSignup1TwoActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearGooglelogin.setOnClickListener {
      val destIntent = VendorHomeActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.txtLoginwithEmai.setOnClickListener{
//
      signInLauncher.launch(signInIntent)

    }
  }
      private fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) {
        val response: IdpResponse? = result.idpResponse
        if (result.resultCode == RESULT_OK) {
          // Successfully signed in
          user = FirebaseAuth.getInstance().currentUser
          val destIntent = VendorHomeActivity.getIntent(this,null)
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
    const val TAG: String = "VENDOR_LOGIN_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, VendorLoginActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
