package com.andronnix.kompot

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TreeView(items: List<TreeItem>) {
    val checkedState = remember { items.mapIndexed { idx, _ -> (idx to true) }.toMutableStateMap() }
    val visibilityState = remember { items.mapIndexed { idx, _ -> (idx to true) }.toMutableStateMap() }

    Column {
        for (currentIdx in items.indices) {
            val item = items[currentIdx]
            if (visibilityState[currentIdx] != true) continue

            Row {
                Spacer(Modifier.width((item.level * 30).dp).background(Color.Red))
                TreeNode(item.content, checkedState[currentIdx]!!) { isChecked ->
                    checkedState[currentIdx] = isChecked

                    val level = items[currentIdx].level
                    var childrenIdx = currentIdx + 1
                    while (childrenIdx < items.size && items[childrenIdx].level > level) {
                        visibilityState[childrenIdx] = isChecked
                        childrenIdx++
                    }
                }
            }
        }
    }
}

@Composable
fun TreeNode(item: @Composable () -> Unit, checked: Boolean, onCheckboxToggle: (newValue: Boolean) -> Unit) {
    Row {
        Checkbox(checked, { onCheckboxToggle(!checked) })
        item()
    }
}

data class TreeItem(val level: Int, val content: @Composable () -> Unit)