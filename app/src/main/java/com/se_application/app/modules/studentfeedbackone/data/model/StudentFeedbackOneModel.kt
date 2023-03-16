package com.se_application.app.modules.studentfeedbackone.`data`.model

import com.se_application.app.R
import com.se_application.app.appcomponents.di.MyApp
import kotlin.String

data class StudentFeedbackOneModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtGrade6Secti: String? = MyApp.getInstance().resources.getString(R.string.msg_grade_6_secti)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtJoeJames: String? = MyApp.getInstance().resources.getString(R.string.lbl_joe_james)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtReportStudent: String? =
      MyApp.getInstance().resources.getString(R.string.msg_report_student)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDate: String? = MyApp.getInstance().resources.getString(R.string.lbl_date)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txt4232023: String? = MyApp.getInstance().resources.getString(R.string.lbl_4_23_2023)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtInstructor: String? = MyApp.getInstance().resources.getString(R.string.lbl_instructor)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescription: String? = MyApp.getInstance().resources.getString(R.string.lbl_description2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtActionTaken: String? = MyApp.getInstance().resources.getString(R.string.lbl_action_taken)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGiveawarning: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_give_a_warning)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtStudentsCase: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_student_s_case)

)
