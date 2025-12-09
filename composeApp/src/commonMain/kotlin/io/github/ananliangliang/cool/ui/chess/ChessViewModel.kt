package io.github.ananliangliang.cool.ui.chess

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.github.bhlangonijr.chesslib.Square
import com.github.bhlangonijr.chesslib.move.Move

class ChessViewModel : ViewModel() {

    var uiState by mutableStateOf(ChessUiState())
        private set

    fun selectSquare(square: Square) {
        uiState = uiState.copy(selectedSquare = square)
    }

    fun doMove(to: Square) {
        val move = Move(uiState.selectedSquare, to)
        if (uiState.board.isMoveLegal(move, true)) {
            val newBoard = uiState.board.clone()
            newBoard.doMove(move, true)
            uiState = uiState.copy(board = newBoard, selectedSquare = Square.NONE)
        } else {
            uiState = uiState.copy(selectedSquare = Square.NONE)
        }
    }

}