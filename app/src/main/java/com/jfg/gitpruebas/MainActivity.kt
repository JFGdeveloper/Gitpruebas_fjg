package com.jfg.gitpruebas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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

                    LoginScreen(viewModel = vm)

                }
            }
        }
    }
}

/***
 * TRABAJANDO UN EJEM DE HILT
 */

