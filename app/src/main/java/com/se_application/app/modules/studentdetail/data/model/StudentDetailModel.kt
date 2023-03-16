package com.se_application.app.modules.studentdetail.`data`.model

import com.se_application.app.R
import com.se_application.app.appcomponents.di.MyApp
import kotlin.String

data class StudentDetailModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtGrade6Secti: String? = MyApp.getInstance().resources.getString(R.string.msg_grade_6_secti)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescription: String? = MyApp.getInstance().resources.getString(R.string.msg_name_joe_james)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescriptionOne: String? =
      MyApp.getInstance().resources.getString(R.string.msg_today_jan_23)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtIncident: String? = MyApp.getInstance().resources.getString(R.string.lbl_incident)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTime: String? = MyApp.getInstance().resources.getString(R.string.lbl_time)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFightwithafr: String? =
      MyApp.getInstance().resources.getString(R.string.msg_fight_with_a_fr)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTimeOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_10_00_am)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFeedback: String? = MyApp.getInstance().resources.getString(R.string.lbl_feedback)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFightwithafrOne: String? =
      MyApp.getInstance().resources.getString(R.string.msg_fight_with_a_fr)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTimeTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_12_30_pm)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFeedbackOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_feedback)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTotalperday: String? = MyApp.getInstance().resources.getString(R.string.lbl_total_per_day)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_22)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.lbl_view_history)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtContactParent: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_contact_parent)

)
