package com.jfg.gitpruebas.theme.login.domain.usc

import com.jfg.gitpruebas.theme.login.data.repository.LoginRepositoryImpl

class LoginUsc {
    private val repo = LoginRepositoryImpl()
    suspend  operator fun invoke()= repo.doLogin()
}