package com.jfg.gitpruebas.presentation.screen1

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.jfg.gitpruebas.presentation.navigation.Routes

@Composable
fun Screen1(controller: NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Blue),
           horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Screen1")
        Button(onClick = { controller.navigate(Routes.Screen2.route) }) {
            Text(text = "Screen2")
        }
    }
}