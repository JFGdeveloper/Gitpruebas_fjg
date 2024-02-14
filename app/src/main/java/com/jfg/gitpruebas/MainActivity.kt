package com.jfg.gitpruebas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jfg.gitpruebas.presentation.BombitasVm
import com.jfg.gitpruebas.presentation.Screen1
import com.jfg.gitpruebas.presentation.Screen2
import com.jfg.gitpruebas.presentation.ValidateBombitas
import com.jfg.gitpruebas.presentation.ui.theme.GitPruebasTheme

class MainActivity : ComponentActivity() {

    val vm by viewModels<BombitasVm>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            GitPruebasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                ) {

                   vm.getBombitasState()
                    val controller = rememberNavController()
                    NavHost(navController = controller, startDestination = "screen1") {
                        composable("screen1") { Screen1(controller = controller) }
                        composable("screen2") { Screen2(controller = controller) }
                        composable("bombitas") { ValidateBombitas(vm = vm, controller = controller )}
                    }

                }
            }
        }
    }
}

/***
 * RAMA DE NAVEGACION SIMPLE EL HOST ESTA EN MAINACTIVITY
 */

