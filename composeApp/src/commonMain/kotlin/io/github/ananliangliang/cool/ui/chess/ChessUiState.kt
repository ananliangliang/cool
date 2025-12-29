package io.github.ananliangliang.cool.ui.chess

import com.github.bhlangonijr.chesslib.Board
import com.github.bhlangonijr.chesslib.Square


data class ChessUiState(
    val fen: String = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1",
    val selectedSquare: Square = Square.NONE,
)