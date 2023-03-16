package com.se_application.app.modules.studentlist.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.se_application.app.R
import com.se_application.app.appcomponents.base.BaseActivity
import com.se_application.app.databinding.ActivityStudentListBinding
import com.se_application.app.modules.classevaluation.ui.ClassEvaluationActivity
import com.se_application.app.modules.studentdetail.ui.StudentDetailActivity
import com.se_application.app.modules.studentlist.`data`.viewmodel.StudentListVM
import com.se_application.app.modules.viewreports.ui.ViewReportsActivity
import kotlin.String
import kotlin.Unit

class StudentListActivity : BaseActivity<ActivityStudentListBinding>(R.layout.activity_student_list)
    {
  private val viewModel: StudentListVM by viewModels<StudentListVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.studentListVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.txtLanguage.setOnClickListener {
      val destIntent = StudentDetailActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnClassEvaluationOne.setOnClickListener {
      val destIntent = ClassEvaluationActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.txtReport.setOnClickListener {
      val destIntent = ViewReportsActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "STUDENT_LIST_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, StudentListActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
