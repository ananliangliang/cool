package io.github.ananliangliang.cool.ui.chess

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.github.bhlangonijr.chesslib.Board
import com.github.bhlangonijr.chesslib.Square
import com.github.bhlangonijr.chesslib.move.Move

class ChessViewModel : ViewModel() {

    var uiState by mutableStateOf(ChessUiState())
        private set

    fun selectSquare(square: Square) {
        uiState = uiState.copy(selectedSquare = square)
    }

    fun getBoard() = Board().also { it.loadFromFen(uiState.fen) }

    fun doMove(to: Square) {
        val move = Move(uiState.selectedSquare, to)
        val board = getBoard()
        if (board.isMoveLegal(move, true)) {

            board.doMove(move, true)
            uiState = uiState.copy(fen = board.fen, selectedSquare = Square.NONE)
        } else {
            uiState = uiState.copy(selectedSquare = Square.NONE)
        }
    }

    fun restartGame() {
        uiState = ChessUiState()
    }

}