package com.se_application.app.modules.studentfeedback.`data`.model

import com.se_application.app.R
import com.se_application.app.appcomponents.di.MyApp
import kotlin.String

data class StudentFeedbackModel(
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
  var txtPhysicalViolen: String? =
      MyApp.getInstance().resources.getString(R.string.msg_physical_violen)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHaveHarmfulOb: String? =
      MyApp.getInstance().resources.getString(R.string.msg_have_harmful_ob)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtVerbalViolence: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_verbal_violence)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtWarningsReceiv: String? =
      MyApp.getInstance().resources.getString(R.string.msg_warnings_receiv)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.lbl_view_past_weeks)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtContactParents: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_contact_parents)

)
