package com.se_application.app.modules.gradesectionkgone.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.se_application.app.R
import com.se_application.app.appcomponents.base.BaseActivity
import com.se_application.app.databinding.ActivityGradeSectionkgOneBinding
import com.se_application.app.modules.gradesectionkgone.`data`.viewmodel.GradeSectionkgOneVM
import com.se_application.app.modules.studentlist.ui.StudentListActivity
import kotlin.String
import kotlin.Unit

class GradeSectionkgOneActivity :
    BaseActivity<ActivityGradeSectionkgOneBinding>(R.layout.activity_grade_sectionkg_one) {
  private val viewModel: GradeSectionkgOneVM by viewModels<GradeSectionkgOneVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.gradeSectionkgOneVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linearRowsectionbOne.setOnClickListener {
      val destIntent = StudentListActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowsectionaTwo.setOnClickListener {
      val destIntent = StudentListActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowsectionbTwo.setOnClickListener {
      val destIntent = StudentListActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowsectiona.setOnClickListener {
      val destIntent = StudentListActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowsectionb.setOnClickListener {
      val destIntent = StudentListActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowkgcounter.setOnClickListener {
      val destIntent = StudentListActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.linearRowsectionaOne.setOnClickListener {
      val destIntent = StudentListActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "GRADE_SECTIONKG_ONE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, GradeSectionkgOneActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
