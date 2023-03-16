package com.se_application.app.modules.signuppage.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.se_application.app.R
import com.se_application.app.appcomponents.base.BaseActivity
import com.se_application.app.databinding.ActivitySignupPageBinding
import com.se_application.app.modules.signuppage.`data`.viewmodel.SignupPageVM
import kotlin.String
import kotlin.Unit

class SignupPageActivity : BaseActivity<ActivitySignupPageBinding>(R.layout.activity_signup_page) {
  private val viewModel: SignupPageVM by viewModels<SignupPageVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.signupPageVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "SIGNUP_PAGE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignupPageActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
