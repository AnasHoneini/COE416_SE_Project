package com.se_application.app.modules.parentviewtwo.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.se_application.app.R
import com.se_application.app.appcomponents.base.BaseActivity
import com.se_application.app.databinding.ActivityParentViewTwoBinding
import com.se_application.app.modules.parentviewthree.ui.ParentViewThreeActivity
import com.se_application.app.modules.parentviewtwo.`data`.model.ListreportRowModel
import com.se_application.app.modules.parentviewtwo.`data`.viewmodel.ParentViewTwoVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class ParentViewTwoActivity :
    BaseActivity<ActivityParentViewTwoBinding>(R.layout.activity_parent_view_two) {
  private val viewModel: ParentViewTwoVM by viewModels<ParentViewTwoVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listreportAdapter = ListreportAdapter(viewModel.listreportList.value?:mutableListOf())
    binding.recyclerListreport.adapter = listreportAdapter
    listreportAdapter.setOnItemClickListener(
    object : ListreportAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : ListreportRowModel) {
        onClickRecyclerListreport(view, position, item)
      }
    }
    )
    viewModel.listreportList.observe(this) {
      listreportAdapter.updateData(it)
    }
    binding.parentViewTwoVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnFeedback.setOnClickListener {
      val destIntent = ParentViewThreeActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecyclerListreport(
    view: View,
    position: Int,
    item: ListreportRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "PARENT_VIEW_TWO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ParentViewTwoActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
