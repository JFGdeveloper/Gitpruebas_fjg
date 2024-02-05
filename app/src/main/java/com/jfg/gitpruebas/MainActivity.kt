package com.jfg.gitpruebas

import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.jfg.gitpruebas.presentation.GitPruebasViewModel
import com.jfg.gitpruebas.presentation.ui.MainResponse
import com.jfg.gitpruebas.presentation.ui.theme.GitPruebasTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    val vm by viewModels<GitPruebasViewModel>()


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
                    ValidateScreen(vm = vm)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
                text = "Bombitas: $name!",
                modifier = modifier
        )
    }

}

@Composable
fun ValidateScreen(vm: GitPruebasViewModel) {

    val context = LocalContext.current
    when(val repo = vm.bombitasState){
        MainResponse.Loading -> {
            ProgressBar(context)
        }

        is MainResponse.Error -> {

            Toast.makeText(context,"ERROR: ${repo.msg}",Toast.LENGTH_SHORT).show()
        }
        is MainResponse.Success -> {
            Greeting(name = repo.bombitas.toString())
        }
    }

}

