package com.se_application.app.modules.grade7nine.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.se_application.app.R
import com.se_application.app.appcomponents.base.BaseActivity
import com.se_application.app.databinding.ActivityGrade7NineBinding
import com.se_application.app.modules.grade7nine.`data`.viewmodel.Grade7NineVM
import com.se_application.app.modules.studentlist.ui.StudentListActivity
import kotlin.String
import kotlin.Unit

class Grade7NineActivity : BaseActivity<ActivityGrade7NineBinding>(R.layout.activity_grade_7_nine) {
  private val viewModel: Grade7NineVM by viewModels<Grade7NineVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.grade7NineVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.linearRowgrcounter.setOnClickListener {
      val destIntent = StudentListActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowsectionaOne.setOnClickListener {
      val destIntent = StudentListActivity.getIntent(this, null)
      startActivity(destIntent)
    }
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
  }

  companion object {
    const val TAG: String = "GRADE7NINE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, Grade7NineActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
