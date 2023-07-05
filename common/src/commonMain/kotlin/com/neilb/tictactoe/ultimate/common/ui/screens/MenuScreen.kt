package com.neilb.tictactoe.ultimate.common.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.neilb.tictactoe.ultimate.common.ui.Fonts
import com.neilb.tictactoe.ultimate.common.ui.components.Title
import com.neilb.tictactoe.ultimate.common.ui.inMenuScreen

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
        }) {
            Text("Easy", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            inMenuScreen = false
        }) {
            Text("2 Player", fontSize = 20.sp)
        }
    }
}