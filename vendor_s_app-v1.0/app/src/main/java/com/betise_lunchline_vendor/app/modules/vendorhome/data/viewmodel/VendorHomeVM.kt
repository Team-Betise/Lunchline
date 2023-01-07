package com.betise_lunchline_vendor.app.modules.vendorhome.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.betise_lunchline_vendor.app.modules.vendorhome.`data`.model.VendorHomeModel
import org.koin.core.KoinComponent

class VendorHomeVM : ViewModel(), KoinComponent {
  val vendorHomeModel: MutableLiveData<VendorHomeModel> = MutableLiveData(VendorHomeModel())

  var navArguments: Bundle? = null
}
