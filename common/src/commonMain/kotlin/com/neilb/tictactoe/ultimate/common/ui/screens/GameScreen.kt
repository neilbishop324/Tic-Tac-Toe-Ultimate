package com.neilb.tictactoe.ultimate.common.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.neilb.tictactoe.ultimate.common.features.Game
import com.neilb.tictactoe.ultimate.common.features.UIFeatures
import com.neilb.tictactoe.ultimate.common.ui.components.Title
import com.neilb.tictactoe.ultimate.common.ui.components.ToastMessage

@Composable
fun GameScreen() {
    val state = remember { Game() }
    val uiFeaturesState = remember { UIFeatures() }

    Box {
        Title(modifier = Modifier.align(Alignment.TopCenter).padding(30.dp))
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Player 1 Score: ${state.player1score}",
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
            )

            Text(
                text = "Player 2 Score: ${state.player2score}",
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
            )

            Column {
                repeat(3) { y ->
                    Row {
                        repeat(3) { x ->
                            Box(
                                modifier = Modifier.align(Alignment.CenterVertically),
                            ) {
                                LazyVerticalGrid(
                                    modifier = Modifier
                                        .fillMaxWidth(
                                            when (x) {
                                                0 -> 0.33333f
                                                1 -> 0.5f
                                                else -> 1f
                                            }
                                        )
                                        .padding(4.dp),
                                    columns = GridCells.Fixed(3),
                                ) {
                                    itemsIndexed(state.board[y][x].flatten()) { i, type ->
                                        TicTacToeButton(
                                            Game.getTextByType(type).toString(),
                                            position = (y to x) to ((i / 3) to i % 3),
                                            state,
                                            uiFeaturesState
                                        )
                                    }
                                }

                                val text = Game.getTextByType(state.mainBoard[y][x]).toString()

                                Text(
                                    modifier = Modifier.align(Alignment.Center).padding(4.dp),
                                    text = text,
                                    style = TextStyle(fontSize = 80.sp, fontWeight = FontWeight.Bold)
                                )
                            }
                        }
                    }
                }
            }

            val player = if (state.player1turn) 1 else 2

            Text(
                text = "Player $player Turn",
                modifier = Modifier
                    .padding(all = 8.dp)
                    .align(Alignment.CenterHorizontally)
            )

        }

        ToastMessage(modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 20.dp), uiFeaturesState)
    }
}

@Composable
fun TicTacToeButton(
    text: String,
    position: Pair<Pair<Int, Int>, Pair<Int, Int>>,
    state: Game,
    uiFeatures: UIFeatures,
) {
    val backgroundColor = if (state.lastCapsule == position.first) Color(0xFFFFD700) else Color.LightGray
    Card(
        modifier = Modifier
            .padding(2.dp)
            .aspectRatio(1f)
            .clickable(onClick = {
                if (text == " ")
                    state.changePositionData(position, uiFeatures)
            }),
        backgroundColor = backgroundColor,
    ) {
        Box {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = text,
                style = TextStyle(color = Color.Black)
            )
        }
    }
}