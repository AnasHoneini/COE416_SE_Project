package com.se_application.app.modules.parentviewfour.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.se_application.app.modules.parentviewfour.`data`.model.ParentViewFourModel
import org.koin.core.KoinComponent

class ParentViewFourVM : ViewModel(), KoinComponent {
  val parentViewFourModel: MutableLiveData<ParentViewFourModel> =
      MutableLiveData(ParentViewFourModel())

  var navArguments: Bundle? = null
}
