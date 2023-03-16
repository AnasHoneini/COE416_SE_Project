package com.se_application.app.modules.classevaluation.`data`.model

import com.se_application.app.R
import com.se_application.app.appcomponents.di.MyApp
import kotlin.String

data class ListphysicalviolenRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtPhysicalViolen: String? =
      MyApp.getInstance().resources.getString(R.string.msg_physical_violen)

)
