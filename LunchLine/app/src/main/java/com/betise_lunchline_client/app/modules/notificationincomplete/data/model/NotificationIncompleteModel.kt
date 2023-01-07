package com.betise_lunchline_client.app.modules.notificationincomplete.`data`.model

import com.betise_lunchline_client.app.R
import com.betise_lunchline_client.app.appcomponents.di.MyApp
import kotlin.String

data class NotificationIncompleteModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtYourorderbein: String? =
      MyApp.getInstance().resources.getString(R.string.msg_your_order_bein)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDetails: String? = MyApp.getInstance().resources.getString(R.string.lbl_details)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFoodItem: String? = MyApp.getInstance().resources.getString(R.string.lbl_food_item)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPrice: String? = MyApp.getInstance().resources.getString(R.string.lbl_35)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.lbl_order_recieved)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguageOne: String? = MyApp.getInstance().resources.getString(R.string.msg_food_item_is)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFoodItembei: String? = MyApp.getInstance().resources.getString(R.string.msg_food_item_bei)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFoodItemis: String? = MyApp.getInstance().resources.getString(R.string.msg_food_item_is2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtETAxxHrsXxMi: String? =
      MyApp.getInstance().resources.getString(R.string.msg_eta_xxhrs_xxmi)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFoodItemOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_food_item)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPriceOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_35)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguageTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_order_recieved)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguageThree: String? = MyApp.getInstance().resources.getString(R.string.msg_food_item_is)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFoodItembeiOne: String? =
      MyApp.getInstance().resources.getString(R.string.msg_food_item_bei)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFoodItemisOne: String? =
      MyApp.getInstance().resources.getString(R.string.msg_food_item_is2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtETAxxHrsXxMiOne: String? =
      MyApp.getInstance().resources.getString(R.string.msg_eta_xxhrs_xxmi)

)
