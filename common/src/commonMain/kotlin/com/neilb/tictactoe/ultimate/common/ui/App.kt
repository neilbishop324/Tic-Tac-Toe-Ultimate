package com.neilb.tictactoe.ultimate.common.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.neilb.tictactoe.ultimate.common.ui.screens.GameScreen
import com.neilb.tictactoe.ultimate.common.ui.screens.MenuScreen

var inMenuScreen by mutableStateOf(true)

@Composable
fun App() {
    if (inMenuScreen) {
        MenuScreen()
    } else {
        GameScreen()
    }
}