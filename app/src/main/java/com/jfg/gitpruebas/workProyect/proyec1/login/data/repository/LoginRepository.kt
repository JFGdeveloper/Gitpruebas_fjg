package com.jfg.gitpruebas.workProyect.proyec1.login.data.repository

import com.jfg.gitpruebas.workProyect.proyec1.login.data.network.service.LoginServiceProyect1

class LoginRepository {
    private val api = LoginServiceProyect1()

    suspend fun doLogin():Boolean{
      return  api.doLogin()

    }
}