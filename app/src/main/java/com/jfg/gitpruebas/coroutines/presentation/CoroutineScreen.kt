package com.jfg.gitpruebas.coroutines.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

@Composable
fun CoroutinesScreen(vm: CoroutineViewModel ) {

    // ejecutando coroutine
    LaunchedEffect(key1 = Unit){
        vm.coroutineSecuencial()
        vm.coroutineParalelas()
    }


}