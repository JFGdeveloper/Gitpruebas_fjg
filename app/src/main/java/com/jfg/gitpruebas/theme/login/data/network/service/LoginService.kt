package com.jfg.gitpruebas.theme.login.data.network.service

import com.jfg.gitpruebas.core.network.RetrofitHelper
import com.jfg.gitpruebas.theme.login.data.network.client.LoginClient
import com.jfg.gitpruebas.theme.login.data.network.response.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class LoginService() {
    private val retrofit = RetrofitHelper.getRetrofit()

     suspend fun doLogin():Boolean {
        return  withContext(Dispatchers.IO){
            val response=   retrofit.create(LoginClient::class.java).doLogin()
            response.body()?.success?: false
        }
    }


}