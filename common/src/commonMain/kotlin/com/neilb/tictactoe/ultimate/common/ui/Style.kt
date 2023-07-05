package com.neilb.tictactoe.ultimate.common.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

class Fonts {
    companion object {
        @Composable
        fun getLibreBaskerville() : FontFamily = FontFamily(
            fontResources("libre_baskerville_regular.ttf", FontWeight.Normal, FontStyle.Normal),
            fontResources("libre_baskerville_bold.ttf", FontWeight.Bold, FontStyle.Normal)
        )
    }
}