package com.jfg.gitpruebas.workProyect.proyec1.login.domain.usc

import com.jfg.gitpruebas.workProyect.proyec1.login.data.repository.LoginRepository

class LoginUsc {

    private val repository = LoginRepository()
    suspend  operator fun invoke()= repository.doLogin()
}