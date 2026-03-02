package io.github.ananliangliang.cool.ui.component

import androidx.compose.animation.Crossfade
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import cool.composeapp.generated.resources.Res
import cool.composeapp.generated.resources.ic_check_circle_outlined
import cool.composeapp.generated.resources.ic_radio_button_unchecked
import org.jetbrains.compose.resources.painterResource

@Composable
fun TaskCompleteCheckBox(checked: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier) {
    IconButton(onClick = onClick, modifier = modifier.scale(1.5f)) {
        Crossfade(targetState = checked) { targetState ->
            if (targetState)
                Icon(painterResource(Res.drawable.ic_check_circle_outlined), "checked", tint = MaterialTheme.colorScheme.primary)
            else
                Icon(painterResource(Res.drawable.ic_radio_button_unchecked), "unchecked")
        }
    }
}