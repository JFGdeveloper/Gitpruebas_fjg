package com.jfg.gitpruebas

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jfg.gitpruebas.login.LoginScreen
import com.jfg.gitpruebas.login.LoginViewModel
import com.jfg.gitpruebas.model.Contact
import com.jfg.gitpruebas.presentation.Screen3.Screen3
import com.jfg.gitpruebas.presentation.bombitas.BombitasVm
import com.jfg.gitpruebas.presentation.bombitas.ValidateBombitas
import com.jfg.gitpruebas.presentation.navigation.Routes
import com.jfg.gitpruebas.presentation.screen1.Screen1
import com.jfg.gitpruebas.presentation.screen2.Screen2
import com.jfg.gitpruebas.presentation.screen4.Screen4
import com.jfg.gitpruebas.presentation.ui.theme.GitPruebasTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val vm by viewModels<BombitasVm>()
    private val vmLogin by viewModels<LoginViewModel>()

    // creo la lista de contactos de hilt
    @Inject lateinit var contactos: List<Contact>


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

                    LoginApp(vm = vmLogin)
                }
            }
        }
    }
}

/***
 * USANDO ARQUITECTURA Y CLEAN ARQUITECTURE
 */


@Composable
fun BombitasApp(contactos: List<Contact>,vm: BombitasVm) {
    val controller = rememberNavController()
    contactos.forEach {
        Log.d("HIL","contacto creado con hilt: $it")
    }

    NavHost(navController = controller, startDestination = Routes.Bombitas.route) {
        composable(Routes.Bombitas.route) { ValidateBombitas(vm = vm, controller = controller )}

        // los param string no hace falta abrir arguments
        composable(Routes.Screen1.route) {
            val name = it.arguments?.getString("name") ?: "No name"
            Screen1(controller = controller, bombitas = name)
        }

        // COMO PASAMOS UN ARGUMENTO QUE YA NO ES STRING, NECESITAMOS LOS ARGUMENTS
        // DESPUES DE LA COMA, Y EL NOMBRE DEL ARGUMENTO
        composable(Routes.Screen2.route,
                   arguments=  listOf(navArgument("number") { type  = NavType.IntType })
        ) {
            val number = it.arguments?.getInt("number") ?: 0
            Screen2(controller = controller, number = number)
        }


        composable(Routes.Screen3.route) { Screen3(controller = controller) }

        // PANTALLA CON OPCIONAL
        composable(Routes.Screen4.route,
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