package com.jfg.gitpruebas.presentation.bombitas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.jfg.gitpruebas.presentation.navigation.Routes

@Composable
fun Bombitas(name: String, modifier: Modifier = Modifier,controller: NavHostController) {

    Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
    ) {
        Text(
                text = "Bombitas: $name!",
                modifier = modifier
        )
        Text(text = "Bombitas")

        // navegamos a la pantalla3 y pasamos el parametro name
        Button(onClick = { controller.navigate("screen1/$name") }) {
            Text(text = "Screen1")
        }
    }

}