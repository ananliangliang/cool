package io.github.ananliangliang.cool.ui.chess

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.bhlangonijr.chesslib.Board
import com.github.bhlangonijr.chesslib.Piece
import com.github.bhlangonijr.chesslib.PieceType
import com.github.bhlangonijr.chesslib.Side

private val DarkSquare = Color(0xFF2C3E50)
private val LightSquare = Color(0xFF34495E)
private val BoardBackground = Color(0xFF1A252F)
private val WhitePiece = Color(0xFFE8E8E8)
private val BlackPiece = Color(0xFF6B7D8F)

private val pieceSymbols = mapOf(
    PieceType.KING to "♔",
    PieceType.QUEEN to "♕",
    PieceType.ROOK to "♖",
    PieceType.BISHOP to "♗",
    PieceType.KNIGHT to "♘",
    PieceType.PAWN to "♙"
)

@Composable
fun ChessScreen(modifier: Modifier = Modifier) {
    val pieces = remember { Board().boardToArray() }


    Column(
        modifier = modifier
            .background(BoardBackground)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // 绘制8行
        for (row in 7 downTo 0) {
            Row {
                // 绘制8列
                for (col in 0..7) {
                    ChessSquare(
                        row = row,
                        col = col,
                        piece = pieces[row * 8 + col]
                    )
                }
            }
        }
    }
}

@Composable
private fun ChessSquare(row: Int, col: Int, piece: Piece) {
    val backgroundColor = if ((row + col) % 2 == 1) DarkSquare else LightSquare

    Box(
        modifier = Modifier
            .size(80.dp)
            .background(backgroundColor)
            .border(0.5.dp, Color.Black.copy(alpha = 0.1f)),
        contentAlignment = Alignment.Center
    ) {
        if (piece != Piece.NONE) {
            ChessPieceView(piece)
        }
    }
}

@Composable
private fun ChessPieceView(piece: Piece) {
    val isWhite = piece.pieceSide == Side.WHITE
    val pieceColor = if (isWhite) WhitePiece else BlackPiece

    Box(
        modifier = Modifier
            .size(64.dp)
            .clip(CircleShape)
            .background(pieceColor.copy(alpha = 0.9f)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = pieceSymbols[piece.pieceType].orEmpty(),
            fontSize = 40.sp,
            color = if (isWhite) DarkSquare else LightSquare,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}
