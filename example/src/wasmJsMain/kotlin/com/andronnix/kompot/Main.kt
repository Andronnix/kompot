import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import com.andronnix.kompot.MyHelloWorld
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.configureWebResources

@OptIn(ExperimentalComposeUiApi::class, ExperimentalResourceApi::class)
private fun main() {
    configureWebResources {
        // same as default - this is not necessary to add here. It's here to show this feature
        resourcePathMapping { path -> "./$path" }
    }
    CanvasBasedWindow("Kompot Sandbox", canvasElementId = "kompotCanvas") {
        MyHelloWorld()
    }
}
