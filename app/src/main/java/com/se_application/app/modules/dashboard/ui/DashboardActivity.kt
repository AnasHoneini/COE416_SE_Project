package com.se_application.app.modules.dashboard.ui

import android.view.View
import androidx.activity.viewModels
import com.se_application.app.R
import com.se_application.app.appcomponents.base.BaseActivity
import com.se_application.app.databinding.ActivityDashboardBinding
import com.se_application.app.modules.dashboard.`data`.model.DashboardRowModel
import com.se_application.app.modules.dashboard.`data`.viewmodel.DashboardVM
import com.se_application.app.modules.grade10twelve.ui.Grade10TwelveActivity
import com.se_application.app.modules.gradesectionkg.ui.GradeSectionkgActivity
import com.se_application.app.modules.gradesectionkgone.ui.GradeSectionkgOneActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class DashboardActivity : BaseActivity<ActivityDashboardBinding>(R.layout.activity_dashboard) {
  private val viewModel: DashboardVM by viewModels<DashboardVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val dashboardAdapter = DashboardAdapter(viewModel.dashboardList.value?:mutableListOf())
    binding.recyclerDashboard.adapter = dashboardAdapter
    dashboardAdapter.setOnItemClickListener(
    object : DashboardAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : DashboardRowModel) {
        onClickRecyclerDashboard(view, position, item)
      }
    }
    )
    viewModel.dashboardList.observe(this) {
      dashboardAdapter.updateData(it)
    }
    binding.dashboardVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linearRowkindergarten.setOnClickListener {
      val destIntent = GradeSectionkgOneActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowhighschool.setOnClickListener {
      val destIntent = Grade10TwelveActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowelementary.setOnClickListener {
      val destIntent = GradeSectionkgActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  fun onClickRecyclerDashboard(
    view: View,
    position: Int,
    item: DashboardRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "DASHBOARD_ACTIVITY"

  }
}
