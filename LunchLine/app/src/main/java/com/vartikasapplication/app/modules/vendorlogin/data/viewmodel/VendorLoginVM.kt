package com.vartikasapplication.app.modules.vendorlogin.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vartikasapplication.app.modules.vendorlogin.`data`.model.VendorLoginModel
import org.koin.core.KoinComponent

class VendorLoginVM : ViewModel(), KoinComponent {
  val vendorLoginModel: MutableLiveData<VendorLoginModel> = MutableLiveData(VendorLoginModel())

  var navArguments: Bundle? = null
}
