package com.betise_lunchline_client.app.modules.successfullpayment.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.betise_lunchline_client.app.R
import com.betise_lunchline_client.app.appcomponents.base.BaseActivity
import com.betise_lunchline_client.app.databinding.ActivitySuccessfullPaymentBinding
import com.betise_lunchline_client.app.modules.notificationcomplete.ui.NotificationCompleteActivity
import com.betise_lunchline_client.app.modules.successfullpayment.`data`.viewmodel.SuccessfullPaymentVM
import kotlin.String
import kotlin.Unit

class SuccessfullPaymentActivity :
    BaseActivity<ActivitySuccessfullPaymentBinding>(R.layout.activity_successfull_payment) {
    private val viewModel: SuccessfullPaymentVM by viewModels<SuccessfullPaymentVM>()

    override fun onInitialized(): Unit {
        buildOrder()
        viewModel.navArguments = intent.extras?.getBundle("bundle")
        binding.successfullPaymentVM = viewModel
    }

    override fun setUpClicks(): Unit {
        binding.imageArrowleft.setOnClickListener {
            finish()
        }
        binding.btnOkay.setOnClickListener {
            val destIntent = NotificationCompleteActivity.getIntent(this, null)
            startActivity(destIntent)
        }
    }

    private fun buildOrder(): Unit {

    }

    companion object {
        const val TAG: String = "SUCCESSFULL_PAYMENT_ACTIVITY"
        fun getIntent(context: Context, bundle: Bundle?): Intent {
            val destIntent = Intent(context, SuccessfullPaymentActivity::class.java)
            destIntent.putExtra("bundle", bundle)
            return destIntent
        }
    }
}
