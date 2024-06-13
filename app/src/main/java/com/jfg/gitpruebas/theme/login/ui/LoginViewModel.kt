package com.jfg.gitpruebas.theme.login.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfg.gitpruebas.theme.login.domain.usc.LoginUsc
import kotlinx.coroutines.launch

class LoginViewModel:ViewModel() {
    private val usc = LoginUsc()

    fun onClickButton() = viewModelScope.launch{
        usc.invoke()
    }
}