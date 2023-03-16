package com.se_application.app.modules.gradesectionkg.`data`.model

import com.se_application.app.R
import com.se_application.app.appcomponents.di.MyApp
import kotlin.String

data class GradeSectionkgModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtWelcomeuser: String? = MyApp.getInstance().resources.getString(R.string.lbl_welcome_user)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDate2312023: String? = MyApp.getInstance().resources.getString(R.string.lbl_date_23_1_2023)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.msg_search_for_stud)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTaptochoosea: String? =
      MyApp.getInstance().resources.getString(R.string.msg_tap_to_choose_a)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGradesSixteen: String? = MyApp.getInstance().resources.getString(R.string.lbl_grades_1_6)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGradesSeventyNine: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_grades_7_9)

)
