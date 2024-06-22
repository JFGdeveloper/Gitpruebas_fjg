package com.jfg.gitpruebas.bombitasFlow.presentation.bombitas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun BombitasScreen(vm: BombitasVm,bombitas: Int, modifier: Modifier = Modifier, controller: NavHostController) {
    // EJECUTANDO EJEM DEL REPOSITORY

    Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
    ) {
        Text(
                text = "Bombitas: $bombitas!",
                modifier = modifier
        )
        Text(text = "Bombitas")

        // navegamos a la pantalla3 y pasamos el parametro name
        Button(onClick = { controller.navigate("screen1/$bombitas") }) {
            Text(text = "Screen1")
        }
    }

}