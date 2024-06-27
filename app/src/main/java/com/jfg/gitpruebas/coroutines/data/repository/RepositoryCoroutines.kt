package com.jfg.gitpruebas.coroutines.data.repository

import kotlinx.coroutines.delay
import javax.inject.Inject

class RepositoryCoroutines @Inject constructor() {

    suspend fun getData(): String{
        delay(3000)
        return "respository ejecutado"
    }

    suspend fun getDataLong(): String{
        delay(6000)
        return "respository Long terminado"
    }


    suspend fun getDataSort(): String{
        delay(1000)
        return "respository sort terminado"
    }
}