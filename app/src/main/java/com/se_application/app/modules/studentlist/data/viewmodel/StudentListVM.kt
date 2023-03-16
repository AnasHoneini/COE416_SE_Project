package com.se_application.app.modules.studentlist.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.se_application.app.modules.studentlist.`data`.model.StudentListModel
import org.koin.core.KoinComponent

class StudentListVM : ViewModel(), KoinComponent {
  val studentListModel: MutableLiveData<StudentListModel> = MutableLiveData(StudentListModel())

  var navArguments: Bundle? = null
}
