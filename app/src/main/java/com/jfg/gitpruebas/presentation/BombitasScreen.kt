package com.jfg.gitpruebas.presentation

import androidx.compose.foundation.clickable
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
        Text(text = "BOmbitas")
        Button(onClick = { controller.navigate("screen1") }) {
            Text(text = "Screen1")
        }
    }

}