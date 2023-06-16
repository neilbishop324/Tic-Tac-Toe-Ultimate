package com.neilb.tictactoe.ultimate.common.features

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.neilb.tictactoe.ultimate.common.util.x
import com.neilb.tictactoe.ultimate.common.util.y

class Game {

    private var player1turn = true
    private var lastCapsule = -1 to -1

    var player1score by mutableStateOf(0)
    var player2score by mutableStateOf(0)

    private var roundCount = 0

    companion object {
        const val empty = 0
        const val player1 = 1
        const val player2 = 2

        fun getTextByType(type: Int): Char {
            return when (type) {
                empty -> ' '
                player1 -> 'X'
                else -> 'O'
            }
        }
    }

    var board = create4DList()
    var mainBoard = create2DList()

    private fun create2DList(): SnapshotStateList<SnapshotStateList<Int>> {
        val innerList1 = mutableStateListOf<SnapshotStateList<Int>>()
        for (j in 0 until 3) {
            val innerList2 = mutableStateListOf<Int>()
            for (l in 0 until 3) {
                innerList2.add(empty)
            }
            innerList1.add(innerList2)
        }
        return innerList1
    }

    private fun create4DList(): SnapshotStateList<SnapshotStateList<SnapshotStateList<SnapshotStateList<Int>>>> {
        val list = mutableStateListOf<SnapshotStateList<SnapshotStateList<SnapshotStateList<Int>>>>()
        for (i in 0 until 3) {
            val insideList = mutableStateListOf<SnapshotStateList<SnapshotStateList<Int>>>()
            for (j in 0 until 3) {
                insideList.add(create2DList())
            }
            list.add(insideList)
        }
        return list
    }

    fun changePositionData(position: Pair<Pair<Int, Int>, Pair<Int, Int>>, uiFeatures: UIFeatures) {
        if (mainBoard[position.first.y()][position.first.x()] == empty && (lastCapsule == -1 to -1 ||
            position.first == lastCapsule)
        ) {
            val winPiece = if (player1turn) player1 else player2

            board[position.first.y()][position.first.x()][position.second.y()][position.second.x()] =
                winPiece

            if (isWin(board[position.first.y()][position.first.x()])) {
                mainBoard[position.first.y()][position.first.x()] = winPiece
                if (isWin(mainBoard)) {
                    if (player1turn)
                        player1score++
                    else
                        player2score++

                    val winnerPlayer = if (player1turn) 1 else 2

                    uiFeatures.toastMessageText = "Player $winnerPlayer Wins"

                    uiFeatures.showToastMessage()

                    playAgain()
                } else if (roundCount == 9) {
                    uiFeatures.toastMessageText = "Draw"
                }
                roundCount++
            }

            player1turn = !player1turn
            lastCapsule = position.second
            if (mainBoard[lastCapsule.y()][lastCapsule.x()] != empty) {
                lastCapsule = -1 to -1
            }
        }
    }

    private fun playAgain() {
        mainBoard = create2DList()
        board = create4DList()
        player1turn = true
        lastCapsule = -1 to -1
        roundCount = 0
    }

    private fun isWin(list: SnapshotStateList<SnapshotStateList<Int>>): Boolean {
        for (i in 0..2) {
            if (list[i][0] == list[i][1]
                && list[i][0] == list[i][2]
                && list[i][0] != empty
            ) {
                return true
            }
        }
        for (i in 0..2) {
            if (list[0][i] == list[1][i]
                && list[0][i] == list[2][i]
                && list[0][i] != empty
            ) {
                return true
            }
        }
        if (list[0][0] == list[1][1]
            && list[0][0] == list[2][2]
            && list[0][0] != empty
        ) {
            return true
        }
        if (list[0][2] == list[1][1]
            && list[0][2] == list[2][0]
            && list[0][2] != empty
        ) {
            return true
        }
        return false
    }

}