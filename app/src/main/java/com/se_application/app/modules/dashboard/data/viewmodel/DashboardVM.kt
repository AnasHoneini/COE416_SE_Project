package com.se_application.app.modules.dashboard.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.se_application.app.modules.dashboard.`data`.model.DashboardModel
import com.se_application.app.modules.dashboard.`data`.model.DashboardRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class DashboardVM : ViewModel(), KoinComponent {
  val dashboardModel: MutableLiveData<DashboardModel> = MutableLiveData(DashboardModel())

  var navArguments: Bundle? = null

  val dashboardList: MutableLiveData<MutableList<DashboardRowModel>> =
      MutableLiveData(mutableListOf())
}
