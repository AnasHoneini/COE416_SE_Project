package com.se_application.app.modules.grade7nine.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.se_application.app.modules.grade7nine.`data`.model.Grade7NineModel
import org.koin.core.KoinComponent

class Grade7NineVM : ViewModel(), KoinComponent {
  val grade7NineModel: MutableLiveData<Grade7NineModel> = MutableLiveData(Grade7NineModel())

  var navArguments: Bundle? = null
}
