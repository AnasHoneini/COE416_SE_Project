package com.se_application.app.modules.studentfeedbackone.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.se_application.app.R
import com.se_application.app.appcomponents.base.BaseActivity
import com.se_application.app.databinding.ActivityStudentFeedbackOneBinding
import com.se_application.app.modules.studentfeedbackone.`data`.viewmodel.StudentFeedbackOneVM
import kotlin.String
import kotlin.Unit

class StudentFeedbackOneActivity :
    BaseActivity<ActivityStudentFeedbackOneBinding>(R.layout.activity_student_feedback_one) {
  private val viewModel: StudentFeedbackOneVM by viewModels<StudentFeedbackOneVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.studentFeedbackOneVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "STUDENT_FEEDBACK_ONE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, StudentFeedbackOneActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
