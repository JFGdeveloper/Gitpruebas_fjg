package com.jfg.gitpruebas.login.domain.usc

import com.jfg.gitpruebas.login.data.repository.LoginRepository


class LoginUseCase {
    private val repository = LoginRepository()

    suspend operator fun invoke(user:String, password:String):Boolean{
        return repository.doLogin(user, password)
    }
}