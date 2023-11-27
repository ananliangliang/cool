import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    MaterialTheme {
        var greetingText by remember { mutableStateOf("Hello World!") }
        var showImage by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Box(Modifier.weight(1f)) {
                Button(onClick = {
                    greetingText = "Compose: ${Greeting().greet()}"
                    showImage = !showImage
                }) {
                    Text(greetingText)
                }

            }
            AnimatedVisibility(showImage) {
                Image(
                    painterResource("compose-multiplatform.xml"),
                    null
                )
            }
            var selectedItem by remember { mutableIntStateOf(0) }

            NavigationBar {
                NavigationBarItem(
                    icon = {
                        Icon(
                            if (selectedItem == 0) Icons.Filled.Home else Icons.Outlined.Home,
                            contentDescription = null
                        )
                    },
                    label = { Text("Home") },
                    selected = selectedItem == 0,
                    onClick = { selectedItem = 0 }
                )
                NavigationBarItem(
                    icon = {
                        Icon(
                            if (selectedItem == 1) Icons.Filled.Person else Icons.Outlined.Person,
                            contentDescription = null
                        )
                    },
                    label = { Text("My") },
                    selected = selectedItem == 1,
                    onClick = { selectedItem = 1 }
                )
            }
        }
    }
}