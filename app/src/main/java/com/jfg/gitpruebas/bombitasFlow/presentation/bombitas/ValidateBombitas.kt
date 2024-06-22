package com.jfg.gitpruebas.bombitasFlow.presentation.bombitas

import android.widget.ProgressBar
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.jfg.gitpruebas.bombitasFlow.data.network.response.MainResponse

@Composable
fun ValidateBombitas(vm: BombitasVm, controller: NavHostController) {
    val state = vm.bombitasState.collectAsState()

    val context = LocalContext.current
    when(val response = state.value){
        MainResponse.Loading -> {
            ProgressBar(context)
        }

        is MainResponse.Error -> {

            Toast.makeText(context, "ERROR: ${response.msg}", Toast.LENGTH_SHORT).show()
        }
        is MainResponse.Success -> {

            BombitasScreen(bombitas = response.bombitas, controller = controller, vm = vm)
        }

        else -> {}
    }

}

