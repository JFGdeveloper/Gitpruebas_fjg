package com.jfg.gitpruebas.theme.login.data.repository

import com.jfg.gitpruebas.theme.login.data.network.service.LoginService

class LoginRepositoryImpl {
    private val api = LoginService()

    suspend fun doLogin(): Boolean {
      return  api.doLogin()
    }
}