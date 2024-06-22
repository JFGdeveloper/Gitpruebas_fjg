package com.jfg.gitpruebas.bombitasFlow.presentation.screen2

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
import com.jfg.gitpruebas.bombitasFlow.presentation.navigation.Routes

@Composable
fun Screen2(controller: NavHostController, number : Int) {
    Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Screen2")
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "numero: $number")
        Button(onClick = { controller.navigate(Routes.Screen3.route) }) {
            Text(text = "Screen3")
        }
    }
}