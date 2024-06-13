package com.jfg.gitpruebas.workProyect.proyec1.login.ui

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jfg.gitpruebas.workProyect.proyec1.login.data.repository.LoginRepository
import com.jfg.gitpruebas.workProyect.proyec1.login.domain.usc.LoginUsc
import kotlinx.coroutines.launch

class WorkViewModel (): ViewModel(){

    private val loginUseCases= LoginUsc()


    private val _email = MutableLiveData<String>()
    val email : LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password : LiveData<String> = _password

    private val _isLoginEnable = MutableLiveData<Boolean>()
    val isLoginEnable: LiveData<Boolean> = _isLoginEnable

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun onLoginChanged(email:String, password:String){
        _email.value = email
        _password.value = password
        _isLoginEnable.value = enableLogin(email, password)
    }

    fun enableLogin(email: String, password: String): Boolean {
      return  Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6
    }



     fun onLoginSelected()  {
         viewModelScope.launch {
             val result = loginUseCases()
             if(result){
                 //Navegar a la siguiente pantalla
                 Log.i("javi", "API ARIS //////result OK")
             }else{
                 Log.i("javi", "API ARIS //////result no valido")

             }
         }


    }


}