package com.se_application.app.modules.viewreports.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.se_application.app.R
import com.se_application.app.appcomponents.base.BaseActivity
import com.se_application.app.databinding.ActivityViewReportsBinding
import com.se_application.app.modules.studentdetail.ui.StudentDetailActivity
import com.se_application.app.modules.studentlist.ui.StudentListActivity
import com.se_application.app.modules.viewreports.`data`.viewmodel.ViewReportsVM
import kotlin.String
import kotlin.Unit

class ViewReportsActivity : BaseActivity<ActivityViewReportsBinding>(R.layout.activity_view_reports)
    {
  private val viewModel: ViewReportsVM by viewModels<ViewReportsVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.viewReportsVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.txtLanguage.setOnClickListener {
      val destIntent = StudentDetailActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.txtStudents.setOnClickListener {
      val destIntent = StudentListActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "VIEW_REPORTS_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ViewReportsActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
