package com.example.componentfactory.components.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

sealed class Style {
    object Fill : Style()
    object Stroke : Style()
}
