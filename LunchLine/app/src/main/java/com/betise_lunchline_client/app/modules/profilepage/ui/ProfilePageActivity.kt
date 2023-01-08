package com.betise_lunchline_client.app.modules.profilepage.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.betise_lunchline_client.app.R
import com.betise_lunchline_client.app.appcomponents.base.BaseActivity
import com.betise_lunchline_client.app.databinding.ActivityProfilePageBinding
import com.betise_lunchline_client.app.modules.SharedObjects
import com.betise_lunchline_client.app.modules.profilepage.`data`.model.ListpngeggninetynineRowModel
import com.betise_lunchline_client.app.modules.profilepage.`data`.model.ListpngeggninetynineTwoRowModel
import com.betise_lunchline_client.app.modules.profilepage.`data`.viewmodel.ProfilePageVM
import com.google.firebase.firestore.DocumentReference
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.Int
import kotlin.String
import kotlin.Unit

class ProfilePageActivity : BaseActivity<ActivityProfilePageBinding>(R.layout.activity_profile_page)
{
    private val viewModel: ProfilePageVM by viewModels<ProfilePageVM>()
    private var orders: MutableList<SharedObjects.Order> = mutableListOf<SharedObjects.Order>()

    override fun onInitialized(): Unit {

        getOrders()

        viewModel.navArguments = intent.extras?.getBundle("bundle")
        val listpngeggninetynineAdapter =
            ListpngeggninetynineAdapter(viewModel.listpngeggninetynineList.value?:mutableListOf())
        binding.recyclerListpngeggninetynine.adapter = listpngeggninetynineAdapter
        listpngeggninetynineAdapter.setOnItemClickListener(
            object : ListpngeggninetynineAdapter.OnItemClickListener {
                override fun onItemClick(view:View, position:Int, item : ListpngeggninetynineRowModel) {
                    onClickRecyclerListpngeggninetynine(view, position, item)
                }
            }
        )
        viewModel.listpngeggninetynineList.observe(this) {
            listpngeggninetynineAdapter.updateData(it)
        }
        val listpngeggninetynineTwoAdapter =
            ListpngeggninetynineTwoAdapter(viewModel.listpngeggninetynineTwoList.value?:mutableListOf())
        binding.recyclerListpngeggninetynineTwo.adapter = listpngeggninetynineTwoAdapter
        listpngeggninetynineTwoAdapter.setOnItemClickListener(
            object : ListpngeggninetynineTwoAdapter.OnItemClickListener {
                override fun onItemClick(view:View, position:Int, item :
                ListpngeggninetynineTwoRowModel) {
                    onClickRecyclerListpngeggninetynineTwo(view, position, item)
                }
            }
        )
        viewModel.listpngeggninetynineTwoList.observe(this) {
            listpngeggninetynineTwoAdapter.updateData(it)
        }
        binding.profilePageVM = viewModel
    }

    override fun setUpClicks(): Unit {
        binding.imageArrowleft.setOnClickListener {
            finish()
        }
    }

    fun onClickRecyclerListpngeggninetynine(
        view: View,
        position: Int,
        item: ListpngeggninetynineRowModel
    ): Unit {
        when(view.id) {
        }
    }

    fun onClickRecyclerListpngeggninetynineTwo(
        view: View,
        position: Int,
        item: ListpngeggninetynineTwoRowModel
    ): Unit {
        when(view.id) {
        }
    }

    private fun getOrders(){
        SharedObjects.db.collection("orders")
            .whereEqualTo("User", SharedObjects.db.collection("users").document(SharedObjects.user_email))
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    Toast.makeText(this, "Found a doc", Toast.LENGTH_SHORT).show()
                    var order_items: ArrayList<SharedObjects.Item> = ArrayList()
                    SharedObjects.db.collection("orders").document(document.id).collection("Items")
                        .get()
                        .addOnSuccessListener { items ->
                            for (item in items) {
                                val dish_ref = item.data["Item"] as DocumentReference
                                var dish: SharedObjects.Dish? = null
                                dish_ref.get()
                                    .addOnSuccessListener { result ->
                                        // change document to result otherwise error
                                        Toast.makeText(this, "Found a dish", Toast.LENGTH_SHORT).show()
//                                        dish = SharedObjects.Dish(
//                                            result.data["ItemName"] as String,
//                                            document.data["ItemCost"] as Long,
//                                            document.data["Desc"] as String,
//                                            document.data["CurrentAvailability"] as Boolean,
//                                            document.data["Rating"] as Double,
//                                            document.data["StartTime"] as com.google.firebase.Timestamp,
//                                            document.data["EndTime"] as com.google.firebase.Timestamp,
//                                            document.data["Days"] as ArrayList<Boolean>,
////                                        )
                                    }
                                    .addOnFailureListener { exception ->
                                        Toast.makeText(this, "Failed to find a dish", Toast.LENGTH_SHORT).show()
                                    }
//                                val order_item = SharedObjects.Item(
//                                    dish!! as SharedObjects.Dish,
//                                    item.data["EndTime"] as com.google.firebase.Timestamp,
//                                    item.data["Status"] as String,
//                                )
//                                order_items.add(order_item)
                            }
                        }
                        .addOnFailureListener() { exception ->
                            println("Error getting documents: $exception")
                        }
                    val order = SharedObjects.Order(
                        document.data["Status"] as String,
                        document.data["Amount"] as Long,
                        document.data["ItemsRemaining"] as Long,
                        order_items as ArrayList<SharedObjects.Item>,
                        document.data["TimePlaced"] as com.google.firebase.Timestamp,
                        document.data["VerificationCode"] as String,
                    )
                    orders.add(order)
                    Toast.makeText(this, document.data["VerificationCode"] as String, Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener { exception ->
                println("Error getting documents: $exception")
            }
    }

    companion object {
        const val TAG: String = "PROFILE_PAGE_ACTIVITY"


        fun getIntent(context: Context, bundle: Bundle?): Intent {
            val destIntent = Intent(context, ProfilePageActivity::class.java)
            destIntent.putExtra("bundle", bundle)
            return destIntent
        }
    }
}
