package com.andronnix.kompot

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.*

@Composable
fun MyHelloWorld() {
    var checked by remember { mutableStateOf(false) }
    Card {
        Row {
            Checkbox(checked = checked, onCheckedChange = { checked = it })
            Text("${if (checked) "Hello" else "Goodbye"} World!")
        }
    }
}