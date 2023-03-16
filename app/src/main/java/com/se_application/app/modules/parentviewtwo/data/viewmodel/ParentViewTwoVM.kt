package com.se_application.app.modules.parentviewtwo.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.se_application.app.modules.parentviewtwo.`data`.model.ListreportRowModel
import com.se_application.app.modules.parentviewtwo.`data`.model.ParentViewTwoModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class ParentViewTwoVM : ViewModel(), KoinComponent {
  val parentViewTwoModel: MutableLiveData<ParentViewTwoModel> =
      MutableLiveData(ParentViewTwoModel())

  var navArguments: Bundle? = null

  val listreportList: MutableLiveData<MutableList<ListreportRowModel>> =
      MutableLiveData(mutableListOf())
}
