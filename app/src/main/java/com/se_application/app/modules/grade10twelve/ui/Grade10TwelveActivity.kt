package com.se_application.app.modules.grade10twelve.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.se_application.app.R
import com.se_application.app.appcomponents.base.BaseActivity
import com.se_application.app.databinding.ActivityGrade10TwelveBinding
import com.se_application.app.modules.grade10twelve.`data`.viewmodel.Grade10TwelveVM
import com.se_application.app.modules.studentlist.ui.StudentListActivity
import kotlin.String
import kotlin.Unit

class Grade10TwelveActivity :
    BaseActivity<ActivityGrade10TwelveBinding>(R.layout.activity_grade_10_twelve) {
  private val viewModel: Grade10TwelveVM by viewModels<Grade10TwelveVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.grade10TwelveVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linearRowsectionaOne.setOnClickListener {
      val destIntent = StudentListActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowsectionbOne.setOnClickListener {
      val destIntent = StudentListActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
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
    binding.linearRowgrcounter.setOnClickListener {
      val destIntent = StudentListActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "GRADE10TWELVE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, Grade10TwelveActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
