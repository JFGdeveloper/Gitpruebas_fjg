package com.jfg.gitpruebas.bombitasProyect.presentation.screen1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Screen1(controller: NavHostController,bombitas: String) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Blue),
           horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Screen1")
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "parametro bombitas: $bombitas")

        // pasamos un int como parametro necesisto el slapsh y despues el int para que funcione
        Button(onClick = { controller.navigate("screen2/${bombitas.toInt()}") }) {
            Text(text = "Screen2")
        }
    }
}