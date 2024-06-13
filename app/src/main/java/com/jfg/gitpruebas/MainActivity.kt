package com.jfg.gitpruebas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import com.jfg.gitpruebas.theme.GitPruebasTheme
import com.jfg.gitpruebas.theme.login.ui.LoginScreen
import com.jfg.gitpruebas.theme.login.ui.LoginViewModel

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val vm by viewModels<LoginViewModel>()


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

                        // PARAMETRO STRING
                        composable("screen1/{name}") {
                            val name = it.arguments?.getString("name") ?: "No name"
                            Screen1(controller = controller, bombitas = name)
                        }
                        // PARAMETRO INT
                        composable(Routes.Screen2.route+"/{number}",
                                   arguments=  listOf(navArgument("number") { type  = NavType.IntType })
                        ) {
                            val number = it.arguments?.getInt("number") ?: 0
                            Screen2(controller = controller, number = number)
                        }
                        composable(Routes.Screen3.route) { Screen3(controller = controller) }
                    }


                }
            }
        }
    }

}

@Composable
fun LoginApp(vm: LoginViewModel) {
    LoginScreen(loginViewModel = vm)
}

@Composable
fun Work1(vm: WorkViewModel) {
    WorkScreen(loginViewModel = vm)
}