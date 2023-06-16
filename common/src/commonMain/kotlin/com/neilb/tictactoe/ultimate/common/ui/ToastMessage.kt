package com.neilb.tictactoe.ultimate.common.ui

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.neilb.tictactoe.ultimate.common.features.UIFeatures

@Composable
fun ToastMessage(modifier: Modifier, state: UIFeatures) {
    val toastMessageWidth by animateDpAsState(
        targetValue = state.toastMessageWidthState.value
    )
    val toastMessageHeight by animateDpAsState(
        targetValue = state.toastMessageHeightState.value
    )

    Box(
        modifier
            .padding(20.dp)
            .width(toastMessageWidth)
            .height(toastMessageHeight)
    ) {
        Card(
            elevation = 4.dp, shape = RoundedCornerShape(24.dp),
            backgroundColor = Color.Blue,
        ) {
            Column(
                Modifier.padding(10.dp)
                    .width(160.dp)
                    .height(50.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(state.toastMessageText, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
        }
    }
}