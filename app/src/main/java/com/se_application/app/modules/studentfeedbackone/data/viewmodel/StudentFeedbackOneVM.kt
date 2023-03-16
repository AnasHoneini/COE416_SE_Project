package com.se_application.app.modules.studentfeedbackone.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.se_application.app.modules.studentfeedbackone.`data`.model.StudentFeedbackOneModel
import org.koin.core.KoinComponent

class StudentFeedbackOneVM : ViewModel(), KoinComponent {
  val studentFeedbackOneModel: MutableLiveData<StudentFeedbackOneModel> =
      MutableLiveData(StudentFeedbackOneModel())

  var navArguments: Bundle? = null
}
