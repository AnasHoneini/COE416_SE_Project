package com.se_application.app.modules.parentviewtwo.`data`.model

import com.se_application.app.R
import com.se_application.app.appcomponents.di.MyApp
import kotlin.String

data class ListreportRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtReport: String? = MyApp.getInstance().resources.getString(R.string.lbl_report)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtInstructorName: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_instructor_name)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDateTime: String? = MyApp.getInstance().resources.getString(R.string.lbl_date_time)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtActionTaken: String? = MyApp.getInstance().resources.getString(R.string.lbl_action_taken2)

)
