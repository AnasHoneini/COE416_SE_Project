package com.se_application.app.modules.grade10twelve.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.se_application.app.modules.grade10twelve.`data`.model.Grade10TwelveModel
import org.koin.core.KoinComponent

class Grade10TwelveVM : ViewModel(), KoinComponent {
  val grade10TwelveModel: MutableLiveData<Grade10TwelveModel> =
      MutableLiveData(Grade10TwelveModel())

  var navArguments: Bundle? = null
}
