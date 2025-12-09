package io.github.ananliangliang.cool.ui.chess

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.bhlangonijr.chesslib.Piece
import com.github.bhlangonijr.chesslib.Side
import com.github.bhlangonijr.chesslib.Square
import io.github.ananliangliang.cool.ui.theme.ChessTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel


@Preview
@Composable
fun ChessScreen(modifier: Modifier = Modifier.fillMaxSize(), viewModel: ChessViewModel = koinViewModel()) {
    ChessTheme {
        val pieces = viewModel.uiState.board.boardToArray()

        Column(
            modifier = modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            // 绘制8行
            for (row in 8 downTo 1) {
                Row {
                    // 绘制8列
                    for (col in 'A'..'G') {
                        ChessSquare(
                            row = row,
                            col = col,
                            piece = pieces[(row - 1) * 8 + (col - 'A')]
                        )
                    }
                }
            }
        }
    }

}


@Composable
private fun ChessSquare(row: Int, col: Char, piece: Piece, viewModel: ChessViewModel = koinViewModel()) {
    val square = Square.valueOf("$col$row")
    val isSelected = viewModel.uiState.selectedSquare == square
    val baseBackgroundColor =
        if ((row + (col - 'A')) % 2 == 0) MaterialTheme.colorScheme.surfaceVariant
        else MaterialTheme.colorScheme.surface
    val backgroundColor = if (isSelected) Color.Yellow.copy(alpha = 0.5f) else baseBackgroundColor

    Box(
        modifier = Modifier
            .size(60.dp)
            .background(backgroundColor)
            .border(0.5.dp, Color.Black.copy(alpha = 0.1f))
            .clickable {
                if (viewModel.uiState.selectedSquare == Square.NONE) {
                    if (piece != Piece.NONE) {
                        viewModel.selectSquare(square)
                    }
                } else {
                    if (viewModel.uiState.selectedSquare == square) {
                        viewModel.selectSquare(Square.NONE)
                    } else {
                        viewModel.doMove(square)
                    }
                }
            },
        contentAlignment = Alignment.Center
    ) {
        if (piece != Piece.NONE) ChessPieceView(piece)
    }
}

@Composable
private fun ChessPieceView(piece: Piece) {
    val isWhite = piece.pieceSide == Side.WHITE
    val pieceColor = if (isWhite) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary

    Box(
        modifier = Modifier
            .size(48.dp)
            .clip(CircleShape)
            .background(pieceColor.copy(alpha = 0.9f)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = piece.fanSymbol,
            fontSize = 40.sp,
            color = if (isWhite) MaterialTheme.colorScheme.surfaceVariant else MaterialTheme.colorScheme.surface,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}
