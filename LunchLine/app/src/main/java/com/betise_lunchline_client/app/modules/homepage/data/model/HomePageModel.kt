package com.betise_lunchline_client.app.modules.homepage.`data`.model

import com.betise_lunchline_client.app.R
import com.betise_lunchline_client.app.appcomponents.di.MyApp
import kotlin.String

data class HomePageModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtDishName: String? = MyApp.getInstance().resources.getString(R.string.lbl_dish_name)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDishNameOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_dish_name)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDishNameTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_dish_name)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDishNameThree: String? = MyApp.getInstance().resources.getString(R.string.lbl_dish_name)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtButtonlite: String? = MyApp.getInstance().resources.getString(R.string.lbl_add)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDishNameFour: String? = MyApp.getInstance().resources.getString(R.string.lbl_dish_name)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtButtonliteOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_add)

)
