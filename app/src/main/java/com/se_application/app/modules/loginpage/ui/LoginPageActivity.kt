package com.se_application.app.modules.loginpage.ui

import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.se_application.app.R
import com.se_application.app.appcomponents.base.BaseActivity
import com.se_application.app.databinding.ActivityLoginPageBinding
import com.se_application.app.modules.loginpage.`data`.viewmodel.LoginPageVM
import com.se_application.app.modules.signuppage.ui.SignupPageActivity
import kotlin.String
import kotlin.Unit

class LoginPageActivity : BaseActivity<ActivityLoginPageBinding>(R.layout.activity_login_page) {
  private val viewModel: LoginPageVM by viewModels<LoginPageVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.loginPageVM = viewModel
    Handler(Looper.getMainLooper()).postDelayed( {
      val destIntent = SignupPageActivity.getIntent(this, null)
      startActivity(destIntent)
      finish()
      }, 3000)
    }

    override fun setUpClicks(): Unit {
      binding.btnSignup.setOnClickListener {
        val destIntent = SignupPageActivity.getIntent(this, null)
        startActivity(destIntent)
      }
    }

    companion object {
      const val TAG: String = "LOGIN_PAGE_ACTIVITY"

    }
  }
