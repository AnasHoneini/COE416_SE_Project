package com.se_application.app.modules.gradesectionkgone.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.se_application.app.modules.gradesectionkgone.`data`.model.GradeSectionkgOneModel
import org.koin.core.KoinComponent

class GradeSectionkgOneVM : ViewModel(), KoinComponent {
  val gradeSectionkgOneModel: MutableLiveData<GradeSectionkgOneModel> =
      MutableLiveData(GradeSectionkgOneModel())

  var navArguments: Bundle? = null
}
