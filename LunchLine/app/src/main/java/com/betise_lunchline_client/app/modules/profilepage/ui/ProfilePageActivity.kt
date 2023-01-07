package com.betise_lunchline_client.app.modules.profilepage.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.betise_lunchline_client.app.R
import com.betise_lunchline_client.app.appcomponents.base.BaseActivity
import com.betise_lunchline_client.app.databinding.ActivityProfilePageBinding
import com.betise_lunchline_client.app.modules.profilepage.`data`.model.ListpngeggninetynineRowModel
import com.betise_lunchline_client.app.modules.profilepage.`data`.model.ListpngeggninetynineTwoRowModel
import com.betise_lunchline_client.app.modules.profilepage.`data`.viewmodel.ProfilePageVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class ProfilePageActivity : BaseActivity<ActivityProfilePageBinding>(R.layout.activity_profile_page)
    {
  private val viewModel: ProfilePageVM by viewModels<ProfilePageVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listpngeggninetynineAdapter =
    ListpngeggninetynineAdapter(viewModel.listpngeggninetynineList.value?:mutableListOf())
    binding.recyclerListpngeggninetynine.adapter = listpngeggninetynineAdapter
    listpngeggninetynineAdapter.setOnItemClickListener(
    object : ListpngeggninetynineAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : ListpngeggninetynineRowModel) {
        onClickRecyclerListpngeggninetynine(view, position, item)
      }
    }
    )
    viewModel.listpngeggninetynineList.observe(this) {
      listpngeggninetynineAdapter.updateData(it)
    }
    val listpngeggninetynineTwoAdapter =
    ListpngeggninetynineTwoAdapter(viewModel.listpngeggninetynineTwoList.value?:mutableListOf())
    binding.recyclerListpngeggninetynineTwo.adapter = listpngeggninetynineTwoAdapter
    listpngeggninetynineTwoAdapter.setOnItemClickListener(
    object : ListpngeggninetynineTwoAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item :
      ListpngeggninetynineTwoRowModel) {
        onClickRecyclerListpngeggninetynineTwo(view, position, item)
      }
    }
    )
    viewModel.listpngeggninetynineTwoList.observe(this) {
      listpngeggninetynineTwoAdapter.updateData(it)
    }
    binding.profilePageVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecyclerListpngeggninetynine(
    view: View,
    position: Int,
    item: ListpngeggninetynineRowModel
  ): Unit {
    when(view.id) {
    }
  }

  fun onClickRecyclerListpngeggninetynineTwo(
    view: View,
    position: Int,
    item: ListpngeggninetynineTwoRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "PROFILE_PAGE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ProfilePageActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
