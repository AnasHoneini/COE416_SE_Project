package com.se_application.app.modules.parentviewthree.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.se_application.app.modules.parentviewthree.`data`.model.ParentViewThreeModel
import org.koin.core.KoinComponent

class ParentViewThreeVM : ViewModel(), KoinComponent {
  val parentViewThreeModel: MutableLiveData<ParentViewThreeModel> =
      MutableLiveData(ParentViewThreeModel())

  var navArguments: Bundle? = null
}
