package com.se_application.app.modules.parentviewfive.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.se_application.app.R
import com.se_application.app.appcomponents.base.BaseActivity
import com.se_application.app.databinding.ActivityParentViewFiveBinding
import com.se_application.app.modules.parentviewfive.`data`.viewmodel.ParentViewFiveVM
import kotlin.String
import kotlin.Unit

class ParentViewFiveActivity :
    BaseActivity<ActivityParentViewFiveBinding>(R.layout.activity_parent_view_five) {
  private val viewModel: ParentViewFiveVM by viewModels<ParentViewFiveVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.parentViewFiveVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "PARENT_VIEW_FIVE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ParentViewFiveActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
