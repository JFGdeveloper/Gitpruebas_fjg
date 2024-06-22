package com.jfg.gitpruebas.coroutines.data.repository

import kotlinx.coroutines.delay
import javax.inject.Inject

class RepositoryCoroutines @Inject constructor() {

    suspend fun getData(): String{
        delay(3000)
        return "respository ejecutado"
    }
}