package com.se_application.app.modules.parentviewone.`data`.model

import com.se_application.app.R
import com.se_application.app.appcomponents.di.MyApp
import kotlin.String

data class ParentViewOneModel(
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
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.lbl_2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtExposedtoVerb: String? =
      MyApp.getInstance().resources.getString(R.string.msg_exposed_to_verb)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTimeTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_10_00_am)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMilaJames: String? = MyApp.getInstance().resources.getString(R.string.lbl_mila_james)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguageOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_view_all)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguageTwo: String? =
      MyApp.getInstance().resources.getString(R.string.msg_search_for_chil)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtJoeJamesOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_joe_james)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMilaJamesOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_mila_james)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtKarlJames: String? = MyApp.getInstance().resources.getString(R.string.lbl_karl_james)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtContactSupervi: String? =
      MyApp.getInstance().resources.getString(R.string.msg_contact_supervi)

)
