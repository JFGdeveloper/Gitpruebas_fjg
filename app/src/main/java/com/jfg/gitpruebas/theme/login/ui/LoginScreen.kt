package com.jfg.gitpruebas.theme.login.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    Scaffold(
            topBar = {},
            content = { padding ->
                 ContentScreen(paddingValues = padding, viewModel)
            },
            bottomBar = {}
    )
}

@Composable
fun ContentScreen(paddingValues: PaddingValues,vm:LoginViewModel) {
    Column(modifier = Modifier.padding(paddingValues)) {
        Text(text = "conten del ejem network sin hilt")
        Button(onClick = { vm.onClickButton() }) {
            Text(text = "ON CLICK")
        }
    }
}