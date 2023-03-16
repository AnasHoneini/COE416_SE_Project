package com.se_application.app.modules.studentfeedback.ui

import androidx.activity.viewModels
import com.se_application.app.R
import com.se_application.app.appcomponents.base.BaseActivity
import com.se_application.app.databinding.ActivityStudentFeedbackBinding
import com.se_application.app.modules.studentfeedback.`data`.viewmodel.StudentFeedbackVM
import kotlin.String
import kotlin.Unit

class StudentFeedbackActivity :
    BaseActivity<ActivityStudentFeedbackBinding>(R.layout.activity_student_feedback) {
  private val viewModel: StudentFeedbackVM by viewModels<StudentFeedbackVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.studentFeedbackVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "STUDENT_FEEDBACK_ACTIVITY"

  }
}
