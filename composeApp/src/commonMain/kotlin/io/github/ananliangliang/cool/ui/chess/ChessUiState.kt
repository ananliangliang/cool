package io.github.ananliangliang.cool.ui.chess

import com.github.bhlangonijr.chesslib.Board
import com.github.bhlangonijr.chesslib.Square


data class ChessUiState(
    val board: Board = Board(),
    val selectedSquare: Square = Square.NONE,
)