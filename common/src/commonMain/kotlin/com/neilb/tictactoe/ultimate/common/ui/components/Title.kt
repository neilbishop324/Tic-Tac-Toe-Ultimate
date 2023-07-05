package com.neilb.tictactoe.ultimate.common.ui.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.neilb.tictactoe.ultimate.common.ui.Fonts

@Composable
fun Title(modifier: Modifier = Modifier) {
    Text(
        "Tic-Tac-Toe\nUltimate",
        textAlign = TextAlign.Center,
        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 30.sp, fontFamily = Fonts.getLibreBaskerville()),
        modifier = modifier,
    )
}