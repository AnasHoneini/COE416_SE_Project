package com.se_application.app.modules.studentdetail.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.se_application.app.R
import com.se_application.app.appcomponents.base.BaseActivity
import com.se_application.app.databinding.ActivityStudentDetailBinding
import com.se_application.app.modules.parentviewfive.ui.ParentViewFiveActivity
import com.se_application.app.modules.studentdetail.`data`.viewmodel.StudentDetailVM
import com.se_application.app.modules.studentfeedbackone.ui.StudentFeedbackOneActivity
import kotlin.String
import kotlin.Unit

class StudentDetailActivity :
    BaseActivity<ActivityStudentDetailBinding>(R.layout.activity_student_detail) {
  private val viewModel: StudentDetailVM by viewModels<StudentDetailVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.studentDetailVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.txtFeedback.setOnClickListener {
      val destIntent = StudentFeedbackOneActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowcontactparent.setOnClickListener {
      val destIntent = ParentViewFiveActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.txtFeedbackOne.setOnClickListener {
      val destIntent = StudentFeedbackOneActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "STUDENT_DETAIL_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, StudentDetailActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
