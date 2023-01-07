package com.betise_lunchline_client.app.modules.profilepage.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.betise_lunchline_client.app.modules.profilepage.`data`.model.ListpngeggninetynineRowModel
import com.betise_lunchline_client.app.modules.profilepage.`data`.model.ListpngeggninetynineTwoRowModel
import com.betise_lunchline_client.app.modules.profilepage.`data`.model.ProfilePageModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class ProfilePageVM : ViewModel(), KoinComponent {
  val profilePageModel: MutableLiveData<ProfilePageModel> = MutableLiveData(ProfilePageModel())

  var navArguments: Bundle? = null

  val listpngeggninetynineList: MutableLiveData<MutableList<ListpngeggninetynineRowModel>> =
      MutableLiveData(mutableListOf())

  val listpngeggninetynineTwoList: MutableLiveData<MutableList<ListpngeggninetynineTwoRowModel>> =
      MutableLiveData(mutableListOf())
}
