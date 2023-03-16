package com.se_application.app.modules.studentdetail.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.se_application.app.modules.studentdetail.`data`.model.StudentDetailModel
import org.koin.core.KoinComponent

class StudentDetailVM : ViewModel(), KoinComponent {
  val studentDetailModel: MutableLiveData<StudentDetailModel> =
      MutableLiveData(StudentDetailModel())

  var navArguments: Bundle? = null
}
