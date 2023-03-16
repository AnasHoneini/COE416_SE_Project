package com.se_application.app.modules.gradeelementary.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.se_application.app.modules.gradeelementary.`data`.model.GradeElementaryModel
import org.koin.core.KoinComponent

class GradeElementaryVM : ViewModel(), KoinComponent {
  val gradeElementaryModel: MutableLiveData<GradeElementaryModel> =
      MutableLiveData(GradeElementaryModel())

  var navArguments: Bundle? = null
}
