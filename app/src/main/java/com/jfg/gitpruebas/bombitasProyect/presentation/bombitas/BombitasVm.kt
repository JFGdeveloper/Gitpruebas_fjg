package com.jfg.gitpruebas.bombitasProyect.presentation.bombitas

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfg.gitpruebas.bombitasProyect.data.repository.EjmRepository
import com.jfg.gitpruebas.bombitasProyect.data.network.response.MainResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class BombitasVm: ViewModel() {

    val objRepository = EjmRepository()

    private var _bombitasState = MutableStateFlow<MainResponse>(MainResponse.Loading)
    val bombitasState: StateFlow<MainResponse> get() = _bombitasState

    fun getBombitas() = viewModelScope.launch {
        objRepository.conuter.collect{
        }
    }

    fun getBomMapEach() = viewModelScope.launch {
        objRepository.conuter
           // .map { it.toString()  puedo mapear al objeto de data por ejem }
            .onEach {
                Log.d("bombitas","bombitas $it")
            }
            .catch {
                MainResponse.Error("fallo ${it.message}")
            }
            .collect{
               _bombitasState.value =  MainResponse.Success(it)
            }
    }

    private fun onSave() {
        TODO("Not yet implemented")
    }


    // EN ESTE EJEM NO SE LLAMA AL CASO DE USO
     fun getBombitasState() = viewModelScope.launch {
        _bombitasState.value = MainResponse.Loading
        objRepository.conuter
            .catch { MainResponse.Error("NO ENCUENTRO ERROR") }
            .collect(){
            _bombitasState.value = MainResponse.Success(it)
        }

    }
}