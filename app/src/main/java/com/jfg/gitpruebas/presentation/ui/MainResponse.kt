package com.jfg.gitpruebas.presentation.ui

sealed class MainResponse{
    object Loading: MainResponse()
    data class Success(val bombitas: Int): MainResponse()
    data class Error(val msg: String): MainResponse()
}
