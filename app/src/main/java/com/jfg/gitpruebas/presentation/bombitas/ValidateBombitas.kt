package com.jfg.gitpruebas.presentation.bombitas

import android.widget.ProgressBar
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.jfg.gitpruebas.presentation.bombitas.BombitasVm
import com.jfg.gitpruebas.presentation.ui.MainResponse

@Composable
fun ValidateBombitas(vm: BombitasVm, controller: NavHostController) {

    val context = LocalContext.current
    when(val repo = vm.bombitasState){
        MainResponse.Loading -> {
            ProgressBar(context)
        }

        is MainResponse.Error -> {

            Toast.makeText(context, "ERROR: ${repo.msg}", Toast.LENGTH_SHORT).show()
        }
        is MainResponse.Success -> {
            Bombitas(name = repo.bombitas.toString(), controller = controller)
        }

        else -> {}
    }

}

