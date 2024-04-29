package com.jfg.gitpruebas.bombitasProyect.data.network.response

sealed class MainResponse{
    object Loading: MainResponse()
    data class Success(val bombitas: Int): MainResponse()
    data class Error(val msg: String): MainResponse()
}
