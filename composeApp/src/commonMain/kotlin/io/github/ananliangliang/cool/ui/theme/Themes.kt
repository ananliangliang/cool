package io.github.ananliangliang.cool.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


val ColorScheme.darkSquare: Color
    @Composable get() = (if (isSystemInDarkTheme()) ChessDarkColors.DarkSquare else ChessLightColors.DarkSquare)
val ColorScheme.lightSquare: Color
    @Composable get() = (if (isSystemInDarkTheme()) ChessDarkColors.LightSquare else ChessLightColors.LightSquare)
val ColorScheme.whitePiece: Color
    @Composable get() = (if (isSystemInDarkTheme()) ChessDarkColors.WhitePiece else ChessLightColors.WhitePiece)
val ColorScheme.blackPiece: Color
    @Composable get() = (if (isSystemInDarkTheme()) ChessDarkColors.BlackPiece else ChessLightColors.BlackPiece)

private val ChessDarkColorScheme = darkColorScheme(
    background = ChessDarkColors.BackGround,
)
private val ChessLightColorScheme = lightColorScheme(
    background = ChessLightColors.BackGround,
)

@Composable
fun ChessTheme(isSystemInDarkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colorScheme = if (isSystemInDarkTheme) ChessDarkColorScheme else ChessLightColorScheme
    MaterialTheme(colorScheme, content = content)
}
