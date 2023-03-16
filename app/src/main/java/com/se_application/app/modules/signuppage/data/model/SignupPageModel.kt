package com.se_application.app.modules.signuppage.`data`.model

import com.se_application.app.R
import com.se_application.app.appcomponents.di.MyApp
import kotlin.String

data class SignupPageModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtUsername: String? = MyApp.getInstance().resources.getString(R.string.lbl_username)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPassword: String? = MyApp.getInstance().resources.getString(R.string.lbl_password)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtNameofSchool: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_name_of_school)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtEmail: String? = MyApp.getInstance().resources.getString(R.string.lbl_email)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPosition: String? = MyApp.getInstance().resources.getString(R.string.lbl_position)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSupervisor: String? = MyApp.getInstance().resources.getString(R.string.lbl_supervisor)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtParent: String? = MyApp.getInstance().resources.getString(R.string.lbl_parent)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtChildren: String? = MyApp.getInstance().resources.getString(R.string.lbl_children)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLogin: String? = MyApp.getInstance().resources.getString(R.string.lbl_login)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSignupOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_signup)

)
