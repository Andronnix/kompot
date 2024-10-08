package com.andronnix.kompot

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyHelloWorld() {
    var checked by remember { mutableStateOf(false) }
    Card(modifier = Modifier.padding(2.dp)) {
        Row {
            Checkbox(checked = checked, onCheckedChange = { checked = it })
            Text("${if (checked) "Hello" else "Goodbye"} World!")
            Placeholder()
        }
    }
}