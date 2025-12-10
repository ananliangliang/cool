package io.github.ananliangliang.cool.ui.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyScreen() {
    Text("My Screen")


        BoxWithConstraints {
            println("$maxWidth x $maxHeight $minWidth x $minHeight")
        }
    Box(Modifier.fillMaxSize().background(Color.Red), contentAlignment = Alignment.Center) {
        Box(
            Modifier
                .size(600.dp)  // 首选固定大小
                .fillMaxSize()  // 先尝试填充父容器
                .background(Color.Yellow)
        ) {
            Row {
                Column(Modifier.weight(1F).background(Color.Green)) {
                    Text("Hello")
                    Text("World")
                }
                Column(Modifier.weight(1F).background(Color.Cyan)) { Text("Hello World") }
            }

        }
    }
}