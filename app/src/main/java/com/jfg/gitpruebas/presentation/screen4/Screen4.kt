package com.jfg.gitpruebas.presentation.screen4

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
import com.jfg.gitpruebas.presentation.navigation.Routes

@Composable
fun Screen4(controller: NavController,saludo: String?) {
    Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Screen3, $saludo")
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { controller.navigate(Routes.Bombitas.route) }) {
            Text(text = "Bombitas")
        }
    }


}