package com.se_application.app

data class User(
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val password: String = "",
    val position: String = ""
)
 {
    constructor() : this("", "", "", "","")
}


