package com.betise_lunchline_vendor.app.modules.adddish.ui

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import android.widget.ToggleButton
import androidx.activity.viewModels
import com.betise_lunchline_vendor.app.R
import com.betise_lunchline_vendor.app.appcomponents.base.BaseActivity
import com.betise_lunchline_vendor.app.appcomponents.di.MyApp
import com.betise_lunchline_vendor.app.databinding.ActivityAddDishBinding
import com.betise_lunchline_vendor.app.modules.SharedObjects
import com.betise_lunchline_vendor.app.modules.adddish.data.model.AddDishModel
import com.betise_lunchline_vendor.app.modules.adddish.`data`.viewmodel.AddDishVM
import com.betise_lunchline_vendor.app.modules.editpagetwo.ui.EditPageTwoActivity
import java.sql.Timestamp
import kotlin.String
import kotlin.Unit

class AddDishActivity : BaseActivity<ActivityAddDishBinding>(R.layout.activity_add_dish) {
  private val viewModel: AddDishVM by viewModels<AddDishVM>()
    private var name: String? = null
    private var price: Long? = null
	private var description: String? = null
    private var sthrs: Int? = null
	private var stmin: Int? = null
	private var edhrs: Int? = null
	private var edmin: Int? = null
    private var end: Timestamp? = null
    private var etahrs: Int? = null
	private var etamin: Int? = null
	private var days : ArrayList<Boolean> = ArrayList()
	private var tog_list : ArrayList<ToggleButton> = ArrayList()


  override fun onInitialized(): Unit {
	viewModel.navArguments = intent.extras?.getBundle("bundle")
	binding.addDishVM = viewModel
  }

  override fun setUpClicks(): Unit {
	binding.imageArrowleft.setOnClickListener {
	  finish()
	}
	binding.btnSave.setOnClickListener {
      saveData()
//		val dish = SharedObjects.Dish(name!!,price!!,description!!,true,12.00,4,sthrs!!,stmin!!,etahrs!!,etamin,days,etahrs*60+etamin)
		printData()
	  val destIntent = EditPageTwoActivity.getIntent(this, null)
	  startActivity(destIntent)
	}
	   val toggle : ToggleButton = findViewById(R.id.toggleButtonMon)
	   val toggle1 : ToggleButton = findViewById(R.id.toggleButtonTue)
	   val toggle2 : ToggleButton = findViewById(R.id.toggleButtonWed)
	   val toggle3 : ToggleButton = findViewById(R.id.toggleButtonThu)
	   val toggle4 : ToggleButton = findViewById(R.id.toggleButtonFri)
	   val toggle5 : ToggleButton = findViewById(R.id.toggleButtonSat)
	   val toggle6 : ToggleButton = findViewById(R.id.toggleButtonSun)
	togglebutts(toggle)
	togglebutts(toggle1)
	togglebutts(toggle2)
	togglebutts(toggle3)
	togglebutts(toggle4)
	togglebutts(toggle5)
	togglebutts(toggle6)
	  tog_list.add(toggle)
	  tog_list.add(toggle1)
	  tog_list.add(toggle2)
	  tog_list.add(toggle3)
	  tog_list.add(toggle4)
	  tog_list.add(toggle5)
	  tog_list.add(toggle6)


  }

  fun togglebutts(toggle: ToggleButton )
  {
	if (toggle.isChecked) {
	  toggle.setBackgroundColor(Color.parseColor("#00BA4A"))
	} else {
	  toggle.setBackgroundColor(Color.parseColor("#EB0000"))
	}
	toggle.setOnCheckedChangeListener { buttonView, isChecked ->
	  if (isChecked) {
		Toast.makeText(this, "Toggle is on", Toast.LENGTH_SHORT).show()
		toggle.setBackgroundColor(Color.parseColor("#00BA4A"))
	  } else {
		toggle.setBackgroundColor(Color.parseColor("#EB0000"))
		Toast.makeText(this, "Toggle is off", Toast.LENGTH_SHORT).show()
	  }
	}

    fun addDish(dish: SharedObjects.Dish):Unit{
        SharedObjects.menuCollection
            .add(dish)
            .addOnSuccessListener {
                Toast.makeText(this, "Dish added successfully", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Error adding dish", Toast.LENGTH_SHORT).show()
            }
    }


  }
  fun saveData() {
      val edit:EditText=findViewById(R.id.etFrameTwo)
      name =edit.text.toString()
	  val edit1:EditText=findViewById(R.id.etDescription)
	  description =edit1.text.toString()
	  val edit2:EditText=findViewById(R.id.etFrameTwoOne)
	  price =edit2.text.toString().toLong()
	  val edit3:EditText=findViewById(R.id.etFromHrs)
	  sthrs =edit3.text.toString().toInt()
	  val edit4:EditText=findViewById(R.id.etFromMin)
	  stmin =edit4.text.toString().toInt()
	  val edit7:EditText=findViewById(R.id.etToHrs)
	  edhrs =edit7.text.toString().toInt()
	  val edit8:EditText=findViewById(R.id.etToMin)
	  edmin =edit8.text.toString().toInt()
//	  start = Timestamp.valueOf(edit3.text.toString())
//	  val edit4:EditText=findViewById(R.id.etToHrs)
//	  end = Timestamp.valueOf(edit4.text.toString())
	  val edit5:EditText=findViewById(R.id.etETAHrs)
	  etahrs =edit5.text.toString().toInt()
	  val edit6:EditText=findViewById(R.id.etETAMin)
	  etamin =edit6.text.toString().toInt()
	  for (i in tog_list)
	  {
		  days.add(i.isChecked)
	  }

  }
	fun printData() {
		println(name)
		println(price)
		println(description)
		println(sthrs)
		println(stmin)
		println(edhrs)
		println(edmin)
		println(etahrs)
		println(etamin)
		println(days)

	}
	private fun addDish(dish: SharedObjects.Dish):Unit{
		SharedObjects.menuCollection
			.add(dish)
			.addOnSuccessListener { documentReference ->
				Toast.makeText(this, "Dish added successfully", Toast.LENGTH_SHORT).show()
			}
			.addOnFailureListener { e ->
				Toast.makeText(this, "Error adding dish", Toast.LENGTH_SHORT).show()
			}
	}

  companion object {
	const val TAG: String = "ADD_DISH_ACTIVITY"
	fun getIntent(context: Context, bundle: Bundle?): Intent {
	  val destIntent = Intent(context, AddDishActivity::class.java)
	  destIntent.putExtra("bundle", bundle)
	  return destIntent
	}

  }
}
