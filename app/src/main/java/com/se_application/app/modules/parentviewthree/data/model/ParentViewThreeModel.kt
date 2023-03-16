package com.se_application.app.modules.parentviewthree.`data`.model

import com.se_application.app.R
import com.se_application.app.appcomponents.di.MyApp
import kotlin.String

data class ParentViewThreeModel(
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
  var txtFeedbackForm: String? = MyApp.getInstance().resources.getString(R.string.lbl_feedback_form)
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
  var txtDescription: String? = MyApp.getInstance().resources.getString(R.string.lbl_description2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtContactSupervi: String? =
      MyApp.getInstance().resources.getString(R.string.msg_contact_supervi)

)
