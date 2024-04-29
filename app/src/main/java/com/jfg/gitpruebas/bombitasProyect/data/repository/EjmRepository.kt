package com.jfg.gitpruebas.bombitasProyect.data.repository

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class EjmRepository {

    val conuter = flow<Int> {
        var bombitas = 0
        while (true){
            bombitas += 1
            delay(1000)
            emit(bombitas)
        }
    }

}