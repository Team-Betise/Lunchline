package com.betise_lunchline_client.app.modules.cart.`data`.model

import com.betise_lunchline_client.app.R
import com.betise_lunchline_client.app.appcomponents.di.MyApp
import kotlin.String

data class CartModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtYourCart: String? = MyApp.getInstance().resources.getString(R.string.lbl_your_cart)
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
  var txtFour: String? = MyApp.getInstance().resources.getString(R.string.lbl)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFive: String? = MyApp.getInstance().resources.getString(R.string.lbl2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPaymentMethod: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_payment_method)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txt1200: String? = MyApp.getInstance().resources.getString(R.string.lbl_12_00)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAmountDetail: String? = MyApp.getInstance().resources.getString(R.string.lbl_amount_detail)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPriceShipping: String? =
      MyApp.getInstance().resources.getString(R.string.msg_price_shipping)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txt1000: String? = MyApp.getInstance().resources.getString(R.string.lbl_10_00)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTwoHundred: String? = MyApp.getInstance().resources.getString(R.string.lbl_2_00)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txt1200One: String? = MyApp.getInstance().resources.getString(R.string.lbl_12_00)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupSixteenValue: String? = null
)
