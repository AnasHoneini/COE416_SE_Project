package com.se_application.app.modules.parentviewfive.`data`.model

import com.se_application.app.R
import com.se_application.app.appcomponents.di.MyApp
import kotlin.String

data class ParentViewFiveModel(
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
  var txtContactParent: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_contact_parent)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtParent: String? = MyApp.getInstance().resources.getString(R.string.lbl_parent2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtJamieJames: String? = MyApp.getInstance().resources.getString(R.string.lbl_jamie_james)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtEmail: String? = MyApp.getInstance().resources.getString(R.string.lbl_email2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtEmailOne: String? = MyApp.getInstance().resources.getString(R.string.msg_jjames_gmail_co)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPhoneNumber: String? = MyApp.getInstance().resources.getString(R.string.lbl_phone_number)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var et96170Value: String? = null
)
