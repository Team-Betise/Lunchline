package com.betise_lunchline_client.app.modules.homepage.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat.startActivity
import com.betise_lunchline_client.app.R
import com.betise_lunchline_client.app.appcomponents.base.BaseActivity
import com.betise_lunchline_client.app.databinding.ActivityHomePageBinding
import com.betise_lunchline_client.app.modules.SharedObjects
import com.betise_lunchline_client.app.modules.SharedObjects.Companion.dishes
import com.betise_lunchline_client.app.modules.dishpage.ui.DishPageActivity
import com.betise_lunchline_client.app.modules.homepage.`data`.viewmodel.HomePageVM
import com.betise_lunchline_client.app.modules.profilepage.ui.ProfilePageActivity
import com.google.firebase.Timestamp
import kotlin.Boolean
import kotlin.String
import kotlin.Unit

class HomePageActivity : BaseActivity<ActivityHomePageBinding>(R.layout.activity_home_page) {
    private val viewModel: HomePageVM by viewModels<HomePageVM>()
    private lateinit var linearHomePage: LinearLayout
    public var dishid: Int = 0

    override fun onInitialized(): Unit {
        viewModel.navArguments = intent.extras?.getBundle("bundle")
        binding.homePageVM = viewModel

        linearHomePage = findViewById(R.id.linearHomepage)
        setUpSearchViewSearchbarListener()

        val inflater: android.view.LayoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as
                android.view.LayoutInflater

        SharedObjects.dishes.clear()
        SharedObjects.dish_ids.clear()
        SharedObjects.menuCollection
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val dish = SharedObjects.Dish(
                        document.data["itemName"] as String,
                        document.data["itemCost"] as Long,
                        document.data["desc"] as String,
                        document.data["currentAvailability"] as Boolean,
                        document.data["rating"] as Double,
                        document.data["reviewCount"] as Long,
                        document.data["startTime"] as Timestamp,
                        document.data["endTime"] as Timestamp,
                        document.data["days"] as ArrayList<Boolean>,
                        document.data["eta"] as Timestamp,
                    )
                    dishes.add(dish)
                    println("Done till here")
                    SharedObjects.dish_ids.add(document.id)
                }
                println(dishes.size)
                println(dishes[0].itemName)
            }
//        val dish: SharedObjects.Dish = SharedObjects.Dish(
//            "Chicken Biryani",
//            100,
//            "Chicken Biryani",true,4.5,100,0,0, arrayOf(true,true,true,true,true,true,true).toCollection(ArrayList()))
//        dishes.add(dish)
        println(dishes)
        // Grab a reference to the component defined in dish_component.xml

        for (i in 0 until 2) {
            val dishComponent : View = inflater.inflate(R.layout.dish_component, null)
//      val view : View = inflater.inflate(R.layout.dish_component, dishComponent, false)
            val layout: LinearLayout = dishComponent.findViewById<LinearLayout>(R.id.linearColumndishname)
            val textView: TextView = layout.findViewById(R.id.txtDishName)
            textView.text = dishes[i].itemName
            val addButton: AppCompatButton = layout.findViewById(R.id.btnAdd)
            addButton.setOnClickListener {
                val destIntent = DishPageActivity.getIntent(this, null)
                destIntent.putExtra("dishid", i)
                startActivity(destIntent)
            }

//            textView.text = "Dish #$i"
//            linearHomePage.addView(dishComponent)
        }
    }

    override fun setUpClicks(): Unit {
        binding.btnUser.setOnClickListener {
            val destIntent = ProfilePageActivity.getIntent(this, null)
            startActivity(destIntent)
        }
//    binding.btnAdd.setOnClickListener {
//      val destIntent = DishPageActivity.getIntent(this, null)
//      startActivity(destIntent)
//    }
    }

    private fun setUpSearchViewSearchbarListener(): Unit {
        binding.searchViewSearchbar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0 : String) : Boolean {
                // Performs search when user hit
                // the search button on the keyboard
                return false
            }
            override fun onQueryTextChange(p0 : String) : Boolean {
                // Start filtering the list as user
                // start entering the characters
                return false
            }
        })
    }

    companion object {
        const val TAG: String = "HOME_PAGE_ACTIVITY"


        fun getIntent(context: Context, bundle: Bundle?): Intent {
            val destIntent = Intent(context, HomePageActivity::class.java)
            destIntent.putExtra("bundle", bundle)
            return destIntent
        }
    }
}