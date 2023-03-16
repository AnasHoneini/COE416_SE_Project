package com.se_application.app.modules.viewreports.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.se_application.app.modules.viewreports.`data`.model.ViewReportsModel
import org.koin.core.KoinComponent

class ViewReportsVM : ViewModel(), KoinComponent {
  val viewReportsModel: MutableLiveData<ViewReportsModel> = MutableLiveData(ViewReportsModel())

  var navArguments: Bundle? = null
}
