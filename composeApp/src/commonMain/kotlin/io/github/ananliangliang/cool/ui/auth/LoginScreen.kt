package io.github.ananliangliang.cool.ui.auth

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun LoginScreen(viewModel: AuthViewModel = koinViewModel()) {

    var text by remember { mutableStateOf("") }


    Row(Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("name") },
            placeholder = { Text("enter your name") }
        )
        Button({ viewModel.login(text) }) {
            Text("Login")
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}