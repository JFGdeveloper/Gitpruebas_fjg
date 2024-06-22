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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jfg.gitpruebas.loginProyect.LoginScreen
import com.jfg.gitpruebas.loginProyect.presentation.LoginViewModel
import com.jfg.gitpruebas.bombitasFlow.presentation.Screen3.Screen3
import com.jfg.gitpruebas.bombitasFlow.presentation.bombitas.BombitasVm
import com.jfg.gitpruebas.bombitasFlow.presentation.bombitas.ValidateBombitas
import com.jfg.gitpruebas.bombitasFlow.presentation.navigation.Routes
import com.jfg.gitpruebas.bombitasFlow.presentation.screen1.Screen1
import com.jfg.gitpruebas.bombitasFlow.presentation.screen2.Screen2
import com.jfg.gitpruebas.bombitasFlow.presentation.screen4.Screen4
import com.jfg.gitpruebas.coroutines.presentation.CoroutineViewModel
import com.jfg.gitpruebas.coroutines.presentation.CoroutinesScreen
import com.jfg.gitpruebas.uiApp.theme.GitPruebasTheme
import com.jfg.gitpruebas.workProyect.proyec1.login.ui.WorkScreen
import com.jfg.gitpruebas.workProyect.proyec1.login.ui.WorkViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val vmBombitas by viewModels<BombitasVm>()
    private val vmLogin by viewModels<LoginViewModel>()
    private val vmWork by viewModels<WorkViewModel>()
    private val coroutineVm by viewModels<CoroutineViewModel>()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            GitPruebasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                ) {

                    //BombitasApp(vm = vmBombitas)
                    //Work1(vm = vmWork)
                    CoroutineApp(vm = coroutineVm)
                }
            }
        }
    }
}

/***
 * USANDO MVVM SIN LOGICA DE DATA SOLO PINTA LA SCREEN DE LOGIN Y TRABAJAMOS CON
 * LOS ESTADOS USANDO LIVEDATA.
 */


@Composable
fun BombitasApp(vm: BombitasVm) {
    val controller = rememberNavController()
    vm.getBomMapEach()


    NavHost(navController = controller, startDestination = Routes.Bombitas.route) {
        composable(Routes.Bombitas.route) {
            ValidateBombitas(vm = vm, controller = controller )

        }

        // los param string no hace falta abrir arguments
        composable(Routes.Screen1.route) {
            val name = it.arguments?.getString("name") ?: "No name"
            Screen1(controller = controller, bombitas = name)
        }

        // COMO PASAMOS UN ARGUMENTO QUE YA NO ES STRING, NECESITAMOS LOS ARGUMENTS
        // DESPUES DE LA COMA, Y EL NOMBRE DEL ARGUMENTO
        composable(
                Routes.Screen2.route,
                arguments=  listOf(navArgument("number") { type  = NavType.IntType })
        ) {
            val number = it.arguments?.getInt("number") ?: 0
            Screen2(controller = controller, number = number)
        }


        composable(Routes.Screen3.route) { Screen3(controller = controller) }

        // PANTALLA CON OPCIONAL
        composable(
                Routes.Screen4.route,
                arguments = listOf(navArgument("saludo"){defaultValue = "HOLA DEFAUL"})

        ){
            val saludo = it.arguments?.getString("saludo")
            Screen4(controller = controller, saludo = saludo)
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

@Composable
fun CoroutineApp(vm: CoroutineViewModel) {
    CoroutinesScreen(vm = vm)
}