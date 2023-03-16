package com.se_application.app.modules.signuppage.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.se_application.app.modules.signuppage.`data`.model.SignupPageModel
import org.koin.core.KoinComponent

class SignupPageVM : ViewModel(), KoinComponent {
  val signupPageModel: MutableLiveData<SignupPageModel> = MutableLiveData(SignupPageModel())

  var navArguments: Bundle? = null
}
