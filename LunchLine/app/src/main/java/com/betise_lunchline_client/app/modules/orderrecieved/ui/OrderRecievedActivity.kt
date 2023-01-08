package com.betise_lunchline_client.app.modules.orderrecieved.ui

import android.content.Context
import android.content.Intent
import android.media.Rating
import android.os.Bundle
import androidx.activity.viewModels
import com.betise_lunchline_client.app.R
import com.betise_lunchline_client.app.appcomponents.base.BaseActivity
import com.betise_lunchline_client.app.databinding.ActivityOrderRecievedBinding
import com.betise_lunchline_client.app.modules.SharedObjects
import com.betise_lunchline_client.app.modules.dishpage.ui.DishPageActivity
import com.betise_lunchline_client.app.modules.homepage.ui.HomePageActivity
import com.betise_lunchline_client.app.modules.orderrecieved.`data`.viewmodel.OrderRecievedVM
import kotlin.String
import kotlin.Unit

class OrderRecievedActivity :
    BaseActivity<ActivityOrderRecievedBinding>(R.layout.activity_order_recieved) {
    private val viewModel: OrderRecievedVM by viewModels<OrderRecievedVM>()

    override fun onInitialized(): Unit {
        viewModel.navArguments = intent.extras?.getBundle("bundle")
        binding.orderRecievedVM = viewModel
    }

    override fun setUpClicks(): Unit {
        binding.linearRowpngeggninetynineOne.setOnClickListener {
            val destIntent = DishPageActivity.getIntent(this, null)
            startActivity(destIntent)
        }
        binding.btnGoToHome.setOnClickListener {
            val destIntent = HomePageActivity.getIntent(this, null)
            startActivity(destIntent)
        }
        binding.linearRowpngeggninetynine.setOnClickListener {
            val destIntent = DishPageActivity.getIntent(this, null)
            startActivity(destIntent)
        }
    }

    private fun rateDish(dish:SharedObjects.Dish, rating: Int): Unit {
        SharedObjects.menuCollection
            .whereEqualTo("ItemName", dish.ItemName)
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    val newRating = dish.Rating*(dish.ReviewCount/(dish.ReviewCount + 1)) + (rating.toDouble())/(dish.ReviewCount + 1)
                    SharedObjects.menuCollection.document(document.id).update("Rating", newRating)
                    SharedObjects.menuCollection.document(document.id).update("ReviewCount", dish.ReviewCount + 1)
                }
            }
    }

    companion object {
        const val TAG: String = "ORDER_RECIEVED_ACTIVITY"


        fun getIntent(context: Context, bundle: Bundle?): Intent {
            val destIntent = Intent(context, OrderRecievedActivity::class.java)
            destIntent.putExtra("bundle", bundle)
            return destIntent
        }
    }
}
