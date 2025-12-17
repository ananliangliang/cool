package io.github.ananliangliang.cool.ui.chess

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.bhlangonijr.chesslib.Piece
import com.github.bhlangonijr.chesslib.PieceType
import com.github.bhlangonijr.chesslib.Side
import com.github.bhlangonijr.chesslib.Square
import cool.composeapp.generated.resources.Res
import cool.composeapp.generated.resources.chess_black_pawn
import cool.composeapp.generated.resources.chess_white_pawn
import io.github.ananliangliang.cool.ui.legalMoveTo
import io.github.ananliangliang.cool.ui.swing
import io.github.ananliangliang.cool.ui.theme.*
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel


@Preview
@Composable
fun ChessScreen(viewModel: ChessViewModel = koinViewModel()) {
    ChessTheme {
        Box(Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            val board = viewModel.uiState.board
            val pieces = viewModel.uiState.board.boardToArray()
            if (board.legalMoves().isEmpty()) {
                Column {
                    Text(board.sideToMove.name + "lose")
                    Button(onClick = { viewModel.restartGame() }) {
                        Text("Restart Game")
                    }
                }
            }else ChessBoard(pieces)

        }


    }

}

@Composable
fun Room() {

    Row {
        Table()
        Table()
    }
}

@Composable
fun Table(isLocal: Boolean = true) {



}
@Composable
fun Seat() {

}

@Composable
private fun ChessBoard(pieces: Array<Piece>) {
    Column(
        modifier = Modifier
            .size(600.dp)
            .aspectRatio(1f)
    ) {

        // 绘制8行
        for (row in 8 downTo 1) {
            Row(Modifier.weight(1f)) {
                // 绘制8列
                for (col in 'A'..'H') {
                    ChessSquare(
                        row = row,
                        col = col,
                        piece = pieces[(row - 1) * 8 + (col - 'A')],
                        Modifier.weight(1f),
                    )
                }
            }
        }
    }
}

@Composable
private fun ChessSquare(row: Int, col: Char, piece: Piece,
                        modifier: Modifier = Modifier,
                        viewModel: ChessViewModel = koinViewModel()) {
    val currentSquare = Square.valueOf("$col$row")
    val board = viewModel.uiState.board
    val selectedSquare = viewModel.uiState.selectedSquare
    val isSelected = selectedSquare == currentSquare
    val baseBackgroundColor =
        if ((row + (col - 'A')) % 2 == 0) MaterialTheme.colorScheme.darkSquare
        else MaterialTheme.colorScheme.lightSquare
    val backgroundColor = if (isSelected) Color.Yellow.copy(alpha = 0.5f) else baseBackgroundColor

    val canMoveTo = board.legalMoves().filter { it.from == selectedSquare }.any { it.to == currentSquare }
    val isSquareClickable = isSelected || canMoveTo || (selectedSquare == Square.NONE && piece.pieceSide == board.sideToMove)

    val swingPiece = board.getKingSquare(board.sideToMove) == currentSquare && board.isKingAttacked

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .clickable(isSquareClickable) {
                if (viewModel.uiState.selectedSquare == Square.NONE) {
                    if (piece != Piece.NONE) {
                        viewModel.selectSquare(currentSquare)
                    }
                } else {
                    if (viewModel.uiState.selectedSquare == currentSquare) {
                        viewModel.selectSquare(Square.NONE)
                    } else {
                        viewModel.doMove(currentSquare)
                    }
                }
            }.legalMoveTo(canMoveTo),
        contentAlignment = Alignment.Center
    ) {
        if (piece != Piece.NONE) ChessPieceView(piece, swingPiece)
    }
}

@Composable
private fun ChessPieceView(piece: Piece, swing: Boolean = false) {
    val isWhite = piece.pieceSide == Side.WHITE
    val pieceColor = if (isWhite) MaterialTheme.colorScheme.whitePiece else MaterialTheme.colorScheme.blackPiece



    if (piece.pieceSide == Side.BLACK && piece.pieceType == PieceType.PAWN) {
        Image(painterResource(Res.drawable.chess_black_pawn), contentDescription = null)
    } else if(piece.pieceSide == Side.WHITE && piece.pieceType == PieceType.PAWN) {
        Image(painterResource(Res.drawable.chess_white_pawn), null)
    } else {

    Box(
        modifier = Modifier.swing(swing)
            .fillMaxSize()
            .scale(0.8F)
            .clip(CircleShape)
            .background(pieceColor.copy(alpha = 0.9f)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = piece.fanSymbol,
            fontSize = 40.sp,
            color = if (isWhite) MaterialTheme.colorScheme.blackPiece else MaterialTheme.colorScheme.whitePiece,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
    }
}
