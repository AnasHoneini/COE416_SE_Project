package com.se_application.app.modules.grade10twelve.`data`.model

import com.se_application.app.R
import com.se_application.app.appcomponents.di.MyApp
import kotlin.String

data class Grade10TwelveModel(
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
  var txtSectionA: String? = MyApp.getInstance().resources.getString(R.string.lbl_section_a)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSectionB: String? = MyApp.getInstance().resources.getString(R.string.lbl_section_b)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSectionAOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_section_a)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSectionBOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_section_b)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGrCounter: String? = MyApp.getInstance().resources.getString(R.string.lbl_gr_12)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSectionATwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_section_a)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSectionBTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_section_b)

)
