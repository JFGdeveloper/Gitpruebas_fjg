package com.jfg.gitpruebas.presentation.navigation

sealed class Routes (val route: String){
    object Screen1: Routes("screen1/{name}")
    object Screen2: Routes("screen2/{number}")
    object Bombitas: Routes("bombitas")
    object Screen3: Routes("screen3")
    object Screen4: Routes("screen4?saludo={saludo}"){
        // usamos el metodo para el controller enviar el objeto.json
        fun sendSaludo(saludo: String) = "screen4?saludo=$saludo"
    }
}