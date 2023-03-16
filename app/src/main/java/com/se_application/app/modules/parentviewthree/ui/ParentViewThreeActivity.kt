package com.se_application.app.modules.parentviewthree.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.se_application.app.R
import com.se_application.app.appcomponents.base.BaseActivity
import com.se_application.app.databinding.ActivityParentViewThreeBinding
import com.se_application.app.modules.parentviewfour.ui.ParentViewFourActivity
import com.se_application.app.modules.parentviewthree.`data`.viewmodel.ParentViewThreeVM
import kotlin.String
import kotlin.Unit

class ParentViewThreeActivity :
    BaseActivity<ActivityParentViewThreeBinding>(R.layout.activity_parent_view_three) {
  private val viewModel: ParentViewThreeVM by viewModels<ParentViewThreeVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.parentViewThreeVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.imageArrowleftOne.setOnClickListener {
      finish()
    }
    binding.linearRowcontactsupervi.setOnClickListener {
      val destIntent = ParentViewFourActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "PARENT_VIEW_THREE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ParentViewThreeActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
