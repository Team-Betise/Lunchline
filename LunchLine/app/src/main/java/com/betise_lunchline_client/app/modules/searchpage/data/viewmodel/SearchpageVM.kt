package com.betise_lunchline_client.app.modules.searchpage.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.betise_lunchline_client.app.modules.searchpage.`data`.model.SearchpageModel
import org.koin.core.KoinComponent

class SearchpageVM : ViewModel(), KoinComponent {
  val searchpageModel: MutableLiveData<SearchpageModel> = MutableLiveData(SearchpageModel())

  var navArguments: Bundle? = null
}
