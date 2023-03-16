package com.se_application.app.modules.classevaluation.`data`.model

import com.se_application.app.R
import com.se_application.app.appcomponents.di.MyApp
import kotlin.String

data class ClassEvaluationModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtGrade6Secti: String? = MyApp.getInstance().resources.getString(R.string.msg_grade_6_secti)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtClassEvaluatio: String? =
      MyApp.getInstance().resources.getString(R.string.msg_class_evaluatio2)

)
