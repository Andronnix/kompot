package com.andronnix.kompot

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyHelloWorld() {
    val texts = (0 until 100).map {
        val level =
            if (it % 10 == 0)
                0
            else if (it % 10 in setOf(1,4,7))
                1
            else
                2

        TreeItem(level) {
            Placeholder(it.toString())
        }
    }


    var checked by remember { mutableStateOf(false) }
    Column {
        Card(modifier = Modifier.padding(2.dp)) {
            Row {
                Checkbox(checked = checked, onCheckedChange = { checked = it })
                Placeholder("${if (checked) "Hello" else "Goodbye"} World!")
            }
        }

        Card(modifier = Modifier.padding(2.dp)) {
            TreeView(texts)
        }
    }
}
