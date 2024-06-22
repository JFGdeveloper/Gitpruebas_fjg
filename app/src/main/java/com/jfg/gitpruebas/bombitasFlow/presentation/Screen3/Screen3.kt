package com.jfg.gitpruebas.bombitasFlow.presentation.Screen3

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
import androidx.navigation.NavController
import com.jfg.gitpruebas.bombitasFlow.presentation.navigation.Routes

@Composable
fun Screen3(controller: NavController) {

    Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Screen3")
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { controller.navigate(Routes.Screen4.sendSaludo("HOLA JAVI")) }) {
            Text(text = "Screen4")
        }
    }

}