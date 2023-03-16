package com.se_application.app.modules.parentviewtwo.`data`.model

import com.se_application.app.R
import com.se_application.app.appcomponents.di.MyApp
import kotlin.String

data class ParentViewTwoModel(
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
  var txtReports: String? = MyApp.getInstance().resources.getString(R.string.lbl_reports)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtOnJan23202: String? = MyApp.getInstance().resources.getString(R.string.msg_on_jan_23_202)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescriptionOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_description)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFightwithafrOne: String? =
      MyApp.getInstance().resources.getString(R.string.msg_fight_with_a_f)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtChadiBouRjeil: String? =
      MyApp.getInstance().resources.getString(R.string.msg_chadi_bou_rjeil)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTimeOne: String? = MyApp.getInstance().resources.getString(R.string.msg_dec_10_2022_12)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtVerbalWarning: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_verbal_warning)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescriptionTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_description)
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

)
