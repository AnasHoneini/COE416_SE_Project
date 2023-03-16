package com.se_application.app.modules.parentviewfive.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.se_application.app.modules.parentviewfive.`data`.model.ParentViewFiveModel
import org.koin.core.KoinComponent

class ParentViewFiveVM : ViewModel(), KoinComponent {
  val parentViewFiveModel: MutableLiveData<ParentViewFiveModel> =
      MutableLiveData(ParentViewFiveModel())

  var navArguments: Bundle? = null
}
