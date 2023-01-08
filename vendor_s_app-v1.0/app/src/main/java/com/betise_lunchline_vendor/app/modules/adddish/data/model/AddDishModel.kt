package com.betise_lunchline_vendor.app.modules.adddish.`data`.model

import com.betise_lunchline_vendor.app.R
import com.betise_lunchline_vendor.app.appcomponents.di.MyApp
import kotlin.String

data class AddDishModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtEnterDishName: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_enter_dish_name)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtEnterDishDesc: String? =
      MyApp.getInstance().resources.getString(R.string.msg_enter_dish_desc)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescription: String? = MyApp.getInstance().resources.getString(R.string.lbl_description)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPrice: String? = MyApp.getInstance().resources.getString(R.string.lbl_price)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtUploadapictur: String? =
      MyApp.getInstance().resources.getString(R.string.msg_upload_a_pictur)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtChooseapicN: String? = MyApp.getInstance().resources.getString(R.string.msg_choose_a_pic_n)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtEnterAvailable: String? =
      MyApp.getInstance().resources.getString(R.string.msg_enter_available)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFrom: String? = MyApp.getInstance().resources.getString(R.string.lbl_from)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTo: String? = MyApp.getInstance().resources.getString(R.string.lbl_to)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFrameTwoTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_hrs)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFrameThree: String? = MyApp.getInstance().resources.getString(R.string.lbl_min)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFrameFour: String? = MyApp.getInstance().resources.getString(R.string.lbl_hrs)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFrameFive: String? = MyApp.getInstance().resources.getString(R.string.lbl_min)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtChooseDayAvai: String? =
      MyApp.getInstance().resources.getString(R.string.msg_choose_day_avai)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtEstimatedtime: String? =
      MyApp.getInstance().resources.getString(R.string.msg_estimated_time)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etFrameTwoValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etFrameTwoOneValue: String? = null,

  /**
   * TODO Replace with dynamic value
   */
  var etFromHrs: String? = null,

  var etFromMin: String? = null,

  var etToHrs: String? = null,

  var etToMin: String? = null,

  var etETAHrs: String? = null,

  var etETAMin: String? = null,
)
