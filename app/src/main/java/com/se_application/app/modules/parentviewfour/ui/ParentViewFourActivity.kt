package com.se_application.app.modules.parentviewfour.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.se_application.app.R
import com.se_application.app.appcomponents.base.BaseActivity
import com.se_application.app.databinding.ActivityParentViewFourBinding
import com.se_application.app.modules.parentviewfour.`data`.viewmodel.ParentViewFourVM
import kotlin.String
import kotlin.Unit

class ParentViewFourActivity :
    BaseActivity<ActivityParentViewFourBinding>(R.layout.activity_parent_view_four) {
  private val viewModel: ParentViewFourVM by viewModels<ParentViewFourVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.parentViewFourVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.imageArrowleftOne.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "PARENT_VIEW_FOUR_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ParentViewFourActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
