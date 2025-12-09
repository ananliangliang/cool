package io.github.ananliangliang.cool.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable


private val ChessDarkColorScheme = darkColorScheme(
    background = ChessDarkColors.BackGround,
    surface = ChessDarkColors.LightSquare,
    surfaceVariant = ChessDarkColors.DarkSquare,
    primary = ChessDarkColors.WhitePiece,
    secondary = ChessDarkColors.BlackPiece,
)
private val ChessLightColorScheme = lightColorScheme(
    background = ChessLightColors.BackGround,
    surface = ChessLightColors.LightSquare,
    surfaceVariant = ChessLightColors.DarkSquare,
    primary = ChessLightColors.WhitePiece,
    secondary = ChessLightColors.BlackPiece,
)

@Composable
fun ChessTheme(isSystemInDarkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colorScheme = if (isSystemInDarkTheme) ChessDarkColorScheme else ChessLightColorScheme
    MaterialTheme(colorScheme, content = content)
}
