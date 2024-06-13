package com.jfg.gitpruebas.workProyect.proyec1.login.data.network.service

import com.jfg.gitpruebas.workProyect.proyec1.core.network.RetrofitHelperProyect1
import com.jfg.gitpruebas.workProyect.proyec1.login.data.network.client.LoginClientProyect1
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginServiceProyect1 {
    private val retrofit = RetrofitHelperProyect1.getRetrofit()

    suspend fun doLogin(): Boolean {
        return  withContext(Dispatchers.IO){
          val response=   retrofit.create(LoginClientProyect1::class.java).doLogin()
            response.body()?.success?: false
        }
    }
}