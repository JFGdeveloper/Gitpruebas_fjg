package com.jfg.gitpruebas.login.domain.usc

import com.jfg.gitpruebas.login.data.repository.LoginRepository
import javax.inject.Inject


class LoginUseCase @Inject constructor(
    private val repository : LoginRepository
) {
    suspend operator fun invoke(user:String, password:String):Boolean{
        return repository.doLogin(user, password)
    }
}