package com.jfg.gitpruebas.bombitasFlow.presentation.bombitas

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfg.gitpruebas.bombitasFlow.data.repository.EjmRepository
import com.jfg.gitpruebas.bombitasFlow.data.network.response.MainResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
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

    // CONTROLA EL FLOW Y EL HILO PRINCIPAL A PARTIR DEL FLOWON
    fun getBomMapEach() = viewModelScope.launch {
        objRepository.conuter
           // .map { it.toString()  puedo mapear al objeto de data por ejem }
            .onEach {
                Log.d("bombitas","bombitas $it")
            }
            .catch {
                MainResponse.Error("fallo ${it.message}")
            }
            .flowOn(Dispatchers.IO) // DE AQUI HACIA ARRIBA EN HILO SECUNDARIO Y ABAJO EL PRINCIPAL
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