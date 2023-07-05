package com.neilb.tictactoe.ultimate.common.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.neilb.tictactoe.ultimate.common.features.Game.Companion.easyBot
import com.neilb.tictactoe.ultimate.common.features.Game.Companion.twoPlayer
import com.neilb.tictactoe.ultimate.common.ui.components.Title
import com.neilb.tictactoe.ultimate.common.ui.inMenuScreen

var gameType by mutableStateOf(easyBot)

@Composable
fun MenuScreen() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Title()
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {
            inMenuScreen = false
            gameType = easyBot
        }) {
            Text("Easy", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            inMenuScreen = false
            gameType = twoPlayer
        }) {
            Text("2 Player", fontSize = 20.sp)
        }
    }
}