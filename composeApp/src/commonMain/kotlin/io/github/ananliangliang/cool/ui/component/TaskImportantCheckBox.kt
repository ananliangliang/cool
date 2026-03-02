package io.github.ananliangliang.cool.ui.component

import androidx.compose.animation.Crossfade
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import cool.composeapp.generated.resources.Res
import cool.composeapp.generated.resources.ic_star_filled
import cool.composeapp.generated.resources.ic_star_outlined
import org.jetbrains.compose.resources.painterResource

@Composable
fun TaskImportantCheckBox(checked: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier) {
    IconButton(onClick = onClick, modifier = modifier.scale(1.5f)) {
        Crossfade(targetState = checked) { targetState ->
            if (targetState)
                Icon(painterResource(Res.drawable.ic_star_filled), "checked", tint = MaterialTheme.colorScheme.primary)
            else
                Icon(painterResource(Res.drawable.ic_star_outlined), "unchecked")
        }
    }
}