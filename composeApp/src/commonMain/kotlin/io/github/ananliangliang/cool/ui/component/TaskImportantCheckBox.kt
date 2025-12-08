package io.github.ananliangliang.cool.ui.component

import androidx.compose.animation.Crossfade
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.StarBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale

@Composable
fun TaskImportantCheckBox(checked: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier) {
    IconButton(onClick = onClick, modifier = modifier.scale(1.5f)) {
        Crossfade(targetState = checked) { targetState ->
            if (targetState)
                Icon(Icons.Rounded.Star, "checked", tint = MaterialTheme.colorScheme.primary)
            else
                Icon(Icons.Rounded.StarBorder, "unchecked")
        }
    }
}