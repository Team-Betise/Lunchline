package com.betise_lunchline_client.app.modules.dishpage.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import com.betise_lunchline_client.app.R
import com.betise_lunchline_client.app.appcomponents.base.BaseActivity
import com.betise_lunchline_client.app.databinding.ActivityDishPageBinding
import com.betise_lunchline_client.app.modules.SharedObjects
import com.betise_lunchline_client.app.modules.SharedObjects.Companion.cart
import com.betise_lunchline_client.app.modules.SharedObjects.Companion.dish_ids
import com.betise_lunchline_client.app.modules.SharedObjects.Companion.dishtest
import com.betise_lunchline_client.app.modules.cart.ui.CartActivity
import com.betise_lunchline_client.app.modules.dishpage.`data`.viewmodel.DishPageVM
import org.koin.android.ext.android.bind
import java.lang.ProcessBuilder.Redirect.to
import kotlin.Boolean
import kotlin.String
import kotlin.Unit

class DishPageActivity : BaseActivity<ActivityDishPageBinding>(R.layout.activity_dish_page) {
    private val viewModel: DishPageVM by viewModels<DishPageVM>()
    var dishid: Int = 0
    var quantity: Int = 0
//    var textView: TextView? = null

    override fun onInitialized(): Unit {
        viewModel.navArguments = intent.extras?.getBundle("bundle")
        dishid = intent.getIntExtra("dishid", 0)
        binding.dishPageVM = viewModel
        println(dishtest[dishid].ItemName)
        val textView: TextView = findViewById(R.id.txtDishName)
        textView.text = dishtest[dishid].ItemName
        val textView2: TextView = findViewById(R.id.txtSeventy)
        textView2.text = dishtest[dishid].ItemCost.toString()
    }

    override fun setUpClicks(): Unit {
        binding.btnAddToCart.setOnClickListener {
            cart[dishtest[dishid]] = quantity
            println(cart)
            val destIntent = CartActivity.getIntent(this, null)
            startActivity(destIntent)
        }
        binding.imageArrowleft.setOnClickListener {
            finish()
        }
        binding.btnOne.setOnClickListener {
            val textView: TextView = findViewById(R.id.txtTwo)
            println(textView.text.toString())
//      increase txtquantity by 1
            textView.text = (textView.text.toString().toInt() - 1).toString()
            quantity = textView.text.toString().toInt()
        }
        binding.btnThree.setOnClickListener {
            val textView: TextView = findViewById(R.id.txtTwo)
            println(textView.text.toString())
            textView.text = (textView.text.toString().toInt() + 1).toString()
            quantity = textView.text.toString().toInt()

        }
    }

    companion object {
        const val TAG: String = "DISH_PAGE_ACTIVITY"


        fun getIntent(context: Context, bundle: Bundle?): Intent {
            val destIntent = Intent(context, DishPageActivity::class.java)
            destIntent.putExtra("bundle", bundle)
            return destIntent
        }
    }
}
