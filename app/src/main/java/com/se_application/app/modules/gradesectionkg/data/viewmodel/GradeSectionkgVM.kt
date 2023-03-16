package com.se_application.app.modules.gradesectionkg.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.se_application.app.modules.gradesectionkg.`data`.model.GradeSectionkgModel
import org.koin.core.KoinComponent

class GradeSectionkgVM : ViewModel(), KoinComponent {
  val gradeSectionkgModel: MutableLiveData<GradeSectionkgModel> =
      MutableLiveData(GradeSectionkgModel())

  var navArguments: Bundle? = null
}
