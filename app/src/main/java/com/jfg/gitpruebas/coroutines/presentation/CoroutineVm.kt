package com.jfg.gitpruebas.coroutines.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfg.gitpruebas.coroutines.data.repository.RepositoryCoroutines
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.system.measureTimeMillis

@HiltViewModel
class CoroutineViewModel @Inject constructor(
    private val repository: RepositoryCoroutines
): ViewModel(){

    private val _TAG = "coroutine"

    // CREANDO COROUTINE CON CONSTRUCTOR LAUNCH E HILO PARA BD
    fun coroutineSecuencial()= viewModelScope.launch(Dispatchers.IO) {
            Log.d(_TAG,"trabajando secuencialmente primero una y luego otro")
        val tiempo = measureTimeMillis {
            val tarea1 = repository.getData() // delay de 6
            val tarea2 = repository.getData() // delay de 6
            Log.d(_TAG, tarea1)
            Log.d(_TAG, tarea2)
        }

        Log.d(_TAG,"Tiempo secuecial transcurrido: $tiempo ")
    }

    fun coroutineParalelas()= viewModelScope.launch(Dispatchers.IO) {
            Log.d(_TAG,"trabajando paralelo dos tareas a la vez")
        val tiempo = measureTimeMillis {

            var tarea1:String? = null
            var tarea2:String? = null
            val job1= launch {tarea1 = repository.getData()}
            val job2= launch {tarea2 = repository.getData()}
            job1.join()
            job2.join()

            Log.d(_TAG, "$tarea1")
            Log.d(_TAG, "$tarea2")
        }

        Log.d(_TAG,"Tiempo paralelo transcurrido: $tiempo ")
    }




}