package com.se_application.app

data class User(
    val username: String,
    val email: String,
    val password: String,
    val position: String) {
    constructor() : this("", "", "","")
}


