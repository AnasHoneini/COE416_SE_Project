package com.se_application.app.modules.parentviewone.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.se_application.app.modules.parentviewone.`data`.model.ListnoRowModel
import com.se_application.app.modules.parentviewone.`data`.model.ParentViewOneModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class ParentViewOneVM : ViewModel(), KoinComponent {
  val parentViewOneModel: MutableLiveData<ParentViewOneModel> =
      MutableLiveData(ParentViewOneModel())

  var navArguments: Bundle? = null

  val listnoList: MutableLiveData<MutableList<ListnoRowModel>> = MutableLiveData(mutableListOf())
}
