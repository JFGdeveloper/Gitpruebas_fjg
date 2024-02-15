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
import com.jfg.gitpruebas.presentation.Screen3.Screen3
import com.jfg.gitpruebas.presentation.bombitas.BombitasVm
import com.jfg.gitpruebas.presentation.bombitas.ValidateBombitas
import com.jfg.gitpruebas.presentation.navigation.Routes
import com.jfg.gitpruebas.presentation.screen1.Screen1
import com.jfg.gitpruebas.presentation.screen2.Screen2
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
                    NavHost(navController = controller, startDestination = Routes.Bombitas.route) {
                        composable(Routes.Bombitas.route) { ValidateBombitas(vm = vm, controller = controller )}
                        composable("screen1/{name}") {
                            val name = it.arguments?.getString("name") ?: "No name"
                            Screen1(controller = controller, name = name)
                        }
                        composable(Routes.Screen2.route) { Screen2(controller = controller) }
                        composable(Routes.Screen3.route) { Screen3(controller = controller) }
                    }

                }
            }
        }
    }
}

/***
 * RAMA DE NAVEGACION CON PARAMETROS STRING
 * PASAMOS UN STRING DE UNA PANTALLA A OTRA
 */

