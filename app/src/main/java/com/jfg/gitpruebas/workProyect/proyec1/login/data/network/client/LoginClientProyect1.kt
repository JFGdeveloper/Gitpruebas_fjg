package com.jfg.gitpruebas.workProyect.proyec1.login.data.network.client

import com.jfg.gitpruebas.workProyect.proyec1.login.data.network.response.LoginResponseProyect1
import retrofit2.Response
import retrofit2.http.GET

interface LoginClientProyect1 {
    @GET("v3/f78c9d33-28b1-4f81-9cf1-6d6ff78fa014")
    suspend fun doLogin(): Response<LoginResponseProyect1>
}