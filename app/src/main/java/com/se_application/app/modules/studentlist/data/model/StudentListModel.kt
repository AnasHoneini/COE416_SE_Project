package com.se_application.app.modules.studentlist.`data`.model

import com.se_application.app.R
import com.se_application.app.appcomponents.di.MyApp
import kotlin.String

data class StudentListModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtGrade6Secti: String? = MyApp.getInstance().resources.getString(R.string.msg_grade_6_secti)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtStudents: String? = MyApp.getInstance().resources.getString(R.string.lbl_students)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtReport: String? = MyApp.getInstance().resources.getString(R.string.lbl_report)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTaptoviewmor: String? =
      MyApp.getInstance().resources.getString(R.string.msg_tap_to_view_mor)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtStudentName: String? = MyApp.getInstance().resources.getString(R.string.lbl_student_name)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.lbl_joe_james2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguageOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_joe_james2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguageTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_joe_james2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguageThree: String? = MyApp.getInstance().resources.getString(R.string.lbl_joe_james2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguageFour: String? = MyApp.getInstance().resources.getString(R.string.lbl_joe_james2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguageFive: String? = MyApp.getInstance().resources.getString(R.string.lbl_joe_james2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguageSix: String? = MyApp.getInstance().resources.getString(R.string.lbl_joe_james2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguageSeven: String? = MyApp.getInstance().resources.getString(R.string.lbl_joe_james2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguageEight: String? =
      MyApp.getInstance().resources.getString(R.string.msg_search_for_stud)

)
