package com.betise_lunchline_client.app.modules.searchpage.`data`.model

import com.betise_lunchline_client.app.R
import com.betise_lunchline_client.app.appcomponents.di.MyApp
import kotlin.String

data class SearchpageModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtGroupNine: String? = MyApp.getInstance().resources.getString(R.string.lbl_suggestion)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroupTen: String? = MyApp.getInstance().resources.getString(R.string.lbl_suggestion)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroupEleven: String? = MyApp.getInstance().resources.getString(R.string.lbl_suggestion)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroupTwelve: String? = MyApp.getInstance().resources.getString(R.string.lbl_suggestion)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroupThirteen: String? = MyApp.getInstance().resources.getString(R.string.lbl_suggestion)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroupFourteen: String? = MyApp.getInstance().resources.getString(R.string.lbl_suggestion)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroupFifteen: String? = MyApp.getInstance().resources.getString(R.string.lbl_suggestion)

)
