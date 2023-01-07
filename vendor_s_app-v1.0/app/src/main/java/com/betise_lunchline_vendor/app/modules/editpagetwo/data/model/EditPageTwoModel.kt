package com.betise_lunchline_vendor.app.modules.editpagetwo.`data`.model

import com.betise_lunchline_vendor.app.R
import com.betise_lunchline_vendor.app.appcomponents.di.MyApp
import kotlin.String

data class EditPageTwoModel(
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
  var txtButtonlite: String? = MyApp.getInstance().resources.getString(R.string.lbl_add)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtButtondark: String? = MyApp.getInstance().resources.getString(R.string.lbl_delete)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDishNameThree: String? = MyApp.getInstance().resources.getString(R.string.lbl_dish_name)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtButtonliteOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_add)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtButtondarkOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_delete)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDishNameFour: String? = MyApp.getInstance().resources.getString(R.string.lbl_dish_name)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtButtonliteTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_add)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtButtondarkTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_delete)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDishNameFive: String? = MyApp.getInstance().resources.getString(R.string.lbl_dish_name)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtButtonliteThree: String? = MyApp.getInstance().resources.getString(R.string.lbl_add)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtButtondarkThree: String? = MyApp.getInstance().resources.getString(R.string.lbl_delete)

)
