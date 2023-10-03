package com.jfg.gitpruebas.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfg.gitpruebas.data.EjmRepository
import com.jfg.gitpruebas.presentation.ui.MainResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class GitPruebasViewModel: ViewModel() {

    val objRepository = EjmRepository()

    private var _bombitasState = MutableStateFlow<MainResponse>(MainResponse.Success(0))
    val bombitasState: StateFlow<MainResponse> get() = _bombitasState

    fun getBombitas() = viewModelScope.launch {
        objRepository.conuter.collect(){
            Log.d("JAVI"," EL NUMERO DE BOMBITAS ES: $it")
        }
    }

    fun getBomMapEach() = viewModelScope.launch {
        objRepository.conuter
            .map { it.toString() }
            .onEach { onSave() }
            .catch { Log.d("JAVI","ejem del catch en un flow: ${it.message}") }
            .collect(){
                Log.d("JAVI","Todo salio bien")
            }
    }

    private fun onSave() {
        TODO("Not yet implemented")
    }


     fun getBombitasState() = viewModelScope.launch {
        _bombitasState.value = MainResponse.Loading
        objRepository.conuter
            .catch { MainResponse.Error("NO ENCUENTRO ERROR") }
            .collect(){
            _bombitasState.value = MainResponse.Success(it)
        }

    }
}