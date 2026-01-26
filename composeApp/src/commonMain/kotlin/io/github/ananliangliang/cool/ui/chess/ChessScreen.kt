package io.github.ananliangliang.cool.ui.chess

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.bhlangonijr.chesslib.Piece
import com.github.bhlangonijr.chesslib.PieceType
import com.github.bhlangonijr.chesslib.Side
import com.github.bhlangonijr.chesslib.Square
import cool.composeapp.generated.resources.*
import io.github.ananliangliang.cool.ui.legalMoveTo
import io.github.ananliangliang.cool.ui.swing
import io.github.ananliangliang.cool.ui.theme.*
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel


@Preview
@Composable
fun ChessScreen(viewModel: ChessViewModel = koinViewModel()) {
    ChessTheme {
        Box(
            Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            val board = viewModel.getBoard()
            val pieces = board.boardToArray()
            if (board.legalMoves().isEmpty()) {
                Column {
                    Text(board.sideToMove.name + "lose")
                    Button(onClick = { viewModel.restartGame() }) {
                        Text("Restart Game")
                    }
                }
            } else ChessBoard(pieces, viewModel.uiState.fen)

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

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
private fun ChessBoard(pieces: Array<Piece>, fen: String) {
    SharedTransitionLayout {
        AnimatedContent(fen) {


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
                    val piece = pieces[(row - 1) * 8 + (col - 'A')]
                    ChessSquare(
                        row = row,
                        col = col,
                        piece = piece,
                        Modifier.weight(1f)
                            .sharedElement(rememberSharedContentState((row - 1) * 8 + (col - 'A')),
                                this@AnimatedContent)
                        ,
                    )
                }
            }
        }
    }
        }
    }
}

@Composable
private fun ChessSquare(
    row: Int, col: Char, piece: Piece,
    modifier: Modifier = Modifier,
    viewModel: ChessViewModel = koinViewModel()
) {
    val currentSquare = Square.valueOf("$col$row")
    val board = viewModel.getBoard()
    val selectedSquare = viewModel.uiState.selectedSquare
    val isSelected = selectedSquare == currentSquare
    val baseBackgroundColor =
        if ((row + (col - 'A')) % 2 == 0) MaterialTheme.colorScheme.darkSquare
        else MaterialTheme.colorScheme.lightSquare

    val canMoveTo = board.legalMoves().filter { it.from == selectedSquare }.any { it.to == currentSquare }
    val isSquareClickable =
        isSelected || canMoveTo || (selectedSquare == Square.NONE && piece.pieceSide == board.sideToMove)

    val swingPiece = board.getKingSquare(board.sideToMove) == currentSquare && board.isKingAttacked

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(baseBackgroundColor)
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
        if (piece != Piece.NONE) ChessPieceView(piece, isSelected,  swingPiece)
    }
}

@Composable
private fun ChessPieceView(piece: Piece, isSelected: Boolean, swing: Boolean = false) {
    val isWhite = piece.pieceSide == Side.WHITE
    val pieceColor = if (isWhite) MaterialTheme.colorScheme.whitePiece else MaterialTheme.colorScheme.blackPiece

    val painter = when (piece) {
        Piece.BLACK_KING -> painterResource(Res.drawable.chess_king_black)
        Piece.BLACK_KNIGHT -> painterResource(Res.drawable.chess_knight_black)
        Piece.BLACK_PAWN -> painterResource(Res.drawable.chess_pawn_black)
        Piece.BLACK_QUEEN -> painterResource(Res.drawable.chess_queen_black)
        Piece.BLACK_ROOK -> painterResource(Res.drawable.chess_rook_black)
        Piece.WHITE_KING -> painterResource(Res.drawable.chess_king_white)
        Piece.WHITE_KNIGHT -> painterResource(Res.drawable.chess_knight_white)
        Piece.WHITE_PAWN -> painterResource(Res.drawable.chess_pawn_white)
        Piece.WHITE_QUEEN -> painterResource(Res.drawable.chess_queen_white)
        Piece.WHITE_ROOK -> painterResource(Res.drawable.chess_rook_white)
        else -> null
    }

    if (painter == null)
        Box(
            modifier = Modifier.swing(swing)
                .fillMaxSize()
                .scale(0.8F)
                .clip(CircleShape)
                .background(pieceColor.copy(alpha = 0.9f))
                .apply { if (isSelected) scale(1.1F) }
            ,
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = piece.fenSymbol,
                fontSize = 40.sp,
                color = if (isWhite) MaterialTheme.colorScheme.blackPiece else MaterialTheme.colorScheme.whitePiece,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    else Image(painter, contentDescription = piece.fenSymbol, Modifier.swing(true)                .apply { if (isSelected) scale(1.1F) })

}
