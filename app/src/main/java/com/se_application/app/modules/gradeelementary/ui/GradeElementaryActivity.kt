package com.se_application.app.modules.gradeelementary.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.se_application.app.R
import com.se_application.app.appcomponents.base.BaseActivity
import com.se_application.app.databinding.ActivityGradeElementaryBinding
import com.se_application.app.modules.gradeelementary.`data`.viewmodel.GradeElementaryVM
import com.se_application.app.modules.studentlist.ui.StudentListActivity
import kotlin.String
import kotlin.Unit

class GradeElementaryActivity :
    BaseActivity<ActivityGradeElementaryBinding>(R.layout.activity_grade_elementary) {
  private val viewModel: GradeElementaryVM by viewModels<GradeElementaryVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.gradeElementaryVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.linearRowcThree.setOnClickListener {
      val destIntent = StudentListActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowlanguageFour.setOnClickListener {
      val destIntent = StudentListActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowaThree.setOnClickListener {
      val destIntent = StudentListActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowcOne.setOnClickListener {
      val destIntent = StudentListActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowlanguageTwo.setOnClickListener {
      val destIntent = StudentListActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowaOne.setOnClickListener {
      val destIntent = StudentListActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowcFour.setOnClickListener {
      val destIntent = StudentListActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowlanguageFive.setOnClickListener {
      val destIntent = StudentListActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowaFour.setOnClickListener {
      val destIntent = StudentListActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowcTwo.setOnClickListener {
      val destIntent = StudentListActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowlanguageThree.setOnClickListener {
      val destIntent = StudentListActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowaTwo.setOnClickListener {
      val destIntent = StudentListActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowcFive.setOnClickListener {
      val destIntent = StudentListActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowlanguageSix.setOnClickListener {
      val destIntent = StudentListActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowaFive.setOnClickListener {
      val destIntent = StudentListActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowc.setOnClickListener {
      val destIntent = StudentListActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowlanguageOne.setOnClickListener {
      val destIntent = StudentListActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowa.setOnClickListener {
      val destIntent = StudentListActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "GRADE_ELEMENTARY_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, GradeElementaryActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
