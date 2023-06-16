package com.neilb.tictactoe.ultimate.common.features

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class UIFeatures {
    var toastMessageText by mutableStateOf("")
    var toastMessageWidthState = mutableStateOf(0.dp)
    var toastMessageHeightState = mutableStateOf(0.dp)

    @OptIn(DelicateCoroutinesApi::class)
    fun showToastMessage() {
        GlobalScope.launch {
            toastMessageWidthState.value = 160.dp
            toastMessageHeightState.value = 50.dp
            delay(3000)
            toastMessageWidthState.value = 0.dp
            toastMessageHeightState.value = 0.dp
        }
    }

}