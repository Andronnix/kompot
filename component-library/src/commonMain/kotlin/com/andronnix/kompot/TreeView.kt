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
    val expandedState = remember { items.mapIndexed { idx, _ -> (idx to true) }.toMutableStateMap() }
    val visibilityState = remember { items.mapIndexed { idx, _ -> (idx to true) }.toMutableStateMap() }

    Column {
        for (currentIdx in items.indices) {
            val item = items[currentIdx]
            if (visibilityState[currentIdx] != true) continue

            Row {
                Spacer(Modifier.width((item.level * 30).dp).background(Color.Red))
                TreeNode(item.content, expandedState[currentIdx]!!) { isExpandedNew ->
                    expandedState[currentIdx] = isExpandedNew

                    val level = items[currentIdx].level
                    var childrenIdx = currentIdx + 1
                    while (childrenIdx < items.size && items[childrenIdx].level > level) {
                        visibilityState[childrenIdx] = isExpandedNew
                        childrenIdx++
                    }
                }
            }
        }
    }
}

@Composable
fun TreeNode(item: @Composable () -> Unit, expanded: Boolean, onExpandedChange: (newExpandedValue: Boolean) -> Unit) {
    Row {
        Checkbox(expanded, { onExpandedChange(!expanded) })
        item()
    }
}

data class TreeItem(val level: Int, val content: @Composable () -> Unit)