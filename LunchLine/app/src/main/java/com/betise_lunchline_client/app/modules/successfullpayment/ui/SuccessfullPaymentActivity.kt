package com.betise_lunchline_client.app.modules.successfullpayment.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.betise_lunchline_client.app.R
import com.betise_lunchline_client.app.appcomponents.base.BaseActivity
import com.betise_lunchline_client.app.databinding.ActivitySuccessfullPaymentBinding
import com.betise_lunchline_client.app.modules.SharedObjects
import com.betise_lunchline_client.app.modules.notificationcomplete.ui.NotificationCompleteActivity
import com.betise_lunchline_client.app.modules.successfullpayment.`data`.viewmodel.SuccessfullPaymentVM
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FieldValue.serverTimestamp
import com.google.firebase.firestore.local.ReferenceSet
import kotlin.String
import kotlin.Unit

class SuccessfullPaymentActivity :
    BaseActivity<ActivitySuccessfullPaymentBinding>(R.layout.activity_successfull_payment) {
    private val viewModel: SuccessfullPaymentVM by viewModels<SuccessfullPaymentVM>()
    private var items = ArrayList<SharedObjects.Item>()
    private var itemsdb = ArrayList<SharedObjects.ItemDB>()

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
        var amount:Long = 0
        var timePlaced = Timestamp.now()
        for(i in 0 until SharedObjects.cart.size)
        {
            amount += buildItem(i, timePlaced)
        }
        SharedObjects.order = SharedObjects.Order("Cooking", amount, items.size.toLong(), items, timePlaced, "1234")
        SharedObjects.orderDB = SharedObjects.OrderDB(SharedObjects.db.collection("users").document(SharedObjects.user_email), amount, items.size.toLong(), "Cooking", timePlaced, "1234")
        SharedObjects.db.collection("orders")
            .add(SharedObjects.orderDB!!)
            .addOnSuccessListener{ documentReference ->
                for(itemdb in itemsdb) {documentReference.collection("Items").add(itemdb)}
            }
            .addOnFailureListener{ e -> println("Error adding document: $e")}
    }

    // Fix endTime
    private fun buildItem(Idx: Int, timePlaced: Timestamp): Long {
        var endTime = Timestamp(timePlaced.seconds + SharedObjects.dishes[Idx].eta.seconds, 0)
        val item = SharedObjects.Item(SharedObjects.dishes[Idx], endTime, "Cooking")
        items.add(item)
        val itemdb = SharedObjects.ItemDB(SharedObjects.menuCollection.document(SharedObjects.dish_ids[Idx]), endTime, "Cooking")
        itemsdb.add(itemdb)
        return SharedObjects.dishes[Idx].itemCost
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
