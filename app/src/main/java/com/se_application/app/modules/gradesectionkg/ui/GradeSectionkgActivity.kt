package com.se_application.app.modules.gradesectionkg.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.se_application.app.R
import com.se_application.app.appcomponents.base.BaseActivity
import com.se_application.app.databinding.ActivityGradeSectionkgBinding
import com.se_application.app.modules.grade7nine.ui.Grade7NineActivity
import com.se_application.app.modules.gradeelementary.ui.GradeElementaryActivity
import com.se_application.app.modules.gradesectionkg.`data`.viewmodel.GradeSectionkgVM
import kotlin.String
import kotlin.Unit

class GradeSectionkgActivity :
    BaseActivity<ActivityGradeSectionkgBinding>(R.layout.activity_grade_sectionkg) {
  private val viewModel: GradeSectionkgVM by viewModels<GradeSectionkgVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.gradeSectionkgVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linearRowgradesseventynine.setOnClickListener {
      val destIntent = Grade7NineActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.linearRowgradessixteen.setOnClickListener {
      val destIntent = GradeElementaryActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "GRADE_SECTIONKG_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, GradeSectionkgActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
