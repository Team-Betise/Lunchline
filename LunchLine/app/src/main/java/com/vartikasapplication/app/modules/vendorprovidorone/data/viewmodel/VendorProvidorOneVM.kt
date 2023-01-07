package com.vartikasapplication.app.modules.vendorprovidorone.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vartikasapplication.app.modules.vendorprovidorone.`data`.model.VendorProvidorOneModel
import org.koin.core.KoinComponent

class VendorProvidorOneVM : ViewModel(), KoinComponent {
  val vendorProvidorOneModel: MutableLiveData<VendorProvidorOneModel> =
      MutableLiveData(VendorProvidorOneModel())

  var navArguments: Bundle? = null
}
