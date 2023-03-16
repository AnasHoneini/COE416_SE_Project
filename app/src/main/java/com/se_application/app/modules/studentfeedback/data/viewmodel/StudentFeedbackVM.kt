package com.se_application.app.modules.studentfeedback.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.se_application.app.modules.studentfeedback.`data`.model.StudentFeedbackModel
import org.koin.core.KoinComponent

class StudentFeedbackVM : ViewModel(), KoinComponent {
  val studentFeedbackModel: MutableLiveData<StudentFeedbackModel> =
      MutableLiveData(StudentFeedbackModel())

  var navArguments: Bundle? = null
}
