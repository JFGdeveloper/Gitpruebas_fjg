package com.jfg.gitpruebas.coroutines.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfg.gitpruebas.coroutines.data.repository.RepositoryCoroutines
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import java.lang.NullPointerException
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
            val tarea1 = repository.getData() // delay de 3
            val tarea2 = repository.getDataLong() // delay de 6
            val tarea3 = repository.getDataSort() // delay de 1
            Log.d(_TAG, " secuencial,\ntarea1: $tarea1,\ntarea2: $tarea2,\ntarea3: $tarea3")

        }

        Log.d(_TAG,"Tiempo secuecial transcurrido: $tiempo ")
    }

    fun coroutineParalelas()= viewModelScope.launch(Dispatchers.IO) {
            Log.d(_TAG,"trabajando paralelo dos tareas a la vez")
        val tiempo = measureTimeMillis {

            val job1= async { repository.getData()}
            val job2= async { repository.getDataLong()}
            val job3= async { repository.getDataSort()}


            Log.d(_TAG, "Paralelo,\ntarea1: ${job1.await()},\ntarea2: ${job2.await()},\ntarea3: ${job3.await()}")

        }

        Log.d(_TAG,"Tiempo paralelo transcurrido: $tiempo ")
    }


    // FUNCIONA HASTA QUE SE DESTRUYE LA APP NO RESPETA EL CICLO DE VIDA DEL ACTIVITY
    // NO RECOMENDADA EN CASOS DE VARIOS ACTIVITYS
    fun globlalScope()= GlobalScope.launch {
        while (true){
            Log.d(_TAG,"Corroutine globalScope corriendo.......")
            delay(2000)


        }
    }


    fun viewModelScope()= viewModelScope.launch {
        while (true){
            Log.d(_TAG,"Corroutine viewModelScope corriendo.......")
            delay(2000)

        }

    }



    // ATRAPANDO NULL EN COROUTINES..
    fun nullCoroutines(){
        val scope = CoroutineScope(Dispatchers.Unconfined)

        scope.launch {
            try {
                throw NullPointerException()
            }catch (e: Exception){
                Log.d(_TAG,"CATCH EXCEPTION: $e en vm")
            }

        }
    }


    // USANDO EL COLLECT DE FORMA NORMAL RESPETA EL 1 SEGUNDO Y LUEGO EL 3 SEGUNDO
    // POR LO TANTO EL TIEMPO ESTIMADO SON 40 SEGUNDOS..
    fun flow()= viewModelScope.launch{

        val flow = kotlinx.coroutines.flow.flow<String> {
            for (i in 1..10){
                delay(1000)
                emit("Flow: #$i")
            }
        }

        val tiempo = measureTimeMillis {
            flow.collect{
                delay(3000)
                Log.d(_TAG, it)
            }
        }

        Log.d(_TAG,"tiempo de ejecucion flow: $tiempo")

    }

    // MEJORANDO EL COLLECT CON BUFFER ANTES
    // POR LO TANTO EL TIEMPO ESTIMADO SON 31 SEGUNDOS.. 9 menos.
    fun flowBuffer()= viewModelScope.launch{

        val flow = kotlinx.coroutines.flow.flow<String> {
            for (i in 1..10){
                delay(1000)
                emit("Flow: #$i")
            }
        }

        val tiempo = measureTimeMillis {
            flow.buffer().collect{
                delay(3000)
                Log.d(_TAG, it)
            }
        }

        Log.d(_TAG,"tiempo de ejecucion flow: $tiempo")

    }








}