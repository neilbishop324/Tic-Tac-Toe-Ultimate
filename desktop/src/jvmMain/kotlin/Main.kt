import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.neilb.tictactoe.ultimate.common.ui.App

fun main() = application {
    val windowState = rememberWindowState(width = 450.dp, height = 700.dp, position = WindowPosition(Alignment.Center))
    Window(
        onCloseRequest = ::exitApplication,
        state = windowState
    ) {
        App()
    }
}
