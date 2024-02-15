package com.jfg.gitpruebas.presentation.navigation

sealed class Routes (val route: String){
    object Screen1: Routes("screen1")
    object Screen2: Routes("screen2")
    object Bombitas: Routes("bombitas")
    object Screen3: Routes("screen3")
}