package com.se_application.app.modules.parentviewfour.`data`.model

import com.se_application.app.R
import com.se_application.app.appcomponents.di.MyApp
import kotlin.String

data class ParentViewFourModel(
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
  var txtContactSupervi: String? =
      MyApp.getInstance().resources.getString(R.string.msg_contact_supervi)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtInstructor: String? = MyApp.getInstance().resources.getString(R.string.lbl_instructor)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtJoeTekli: String? = MyApp.getInstance().resources.getString(R.string.lbl_joe_tekli)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtEmail: String? = MyApp.getInstance().resources.getString(R.string.lbl_email2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtEmailOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_jtekli_lau_edu)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPhoneNumber: String? = MyApp.getInstance().resources.getString(R.string.lbl_phone_number)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txt96170: String? = MyApp.getInstance().resources.getString(R.string.lbl_961_70)

)
