package io.github.ananliangliang.cool.ui.app

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun MyScreen() {

    var switch by remember { mutableStateOf(true) }

    SharedTransitionLayout(
        Modifier.fillMaxSize().padding(10.dp).clickable { switch = !switch },
    ) {

        val key = rememberSharedContentState(key = "text")
        AnimatedContent(switch) { targetSwitch ->
            if (targetSwitch) {
                Text(
                    "hello",
                    Modifier.sharedBounds(
                        key,
                        animatedVisibilityScope = this@AnimatedContent
                    ),
                    fontSize = 20.sp
                )
            } else {
                Text(
                    "hello1",
                    Modifier.sharedBounds(
                        key,
                        animatedVisibilityScope = this@AnimatedContent
                    ),
                    fontSize = 40.sp
                )
            }
        }
    }
}
