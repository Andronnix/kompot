package com.andronnix.kompot

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.singleWindowApplication

fun main() = singleWindowApplication {
    MainView()
}

@Preview
@Composable
fun MainView() {
    MyHelloWorld()
}