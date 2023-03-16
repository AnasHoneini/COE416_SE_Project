package com.se_application.app.modules.classevaluation.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.se_application.app.modules.classevaluation.`data`.model.ClassEvaluationModel
import com.se_application.app.modules.classevaluation.`data`.model.ListphysicalviolenRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class ClassEvaluationVM : ViewModel(), KoinComponent {
  val classEvaluationModel: MutableLiveData<ClassEvaluationModel> =
      MutableLiveData(ClassEvaluationModel())

  var navArguments: Bundle? = null

  val listphysicalviolenList: MutableLiveData<MutableList<ListphysicalviolenRowModel>> =
      MutableLiveData(mutableListOf())
}
