package com.example.composestudy.data.models

import androidx.compose.ui.graphics.Color
import com.example.composestudy.ui.theme.HighPriorityColor
import com.example.composestudy.ui.theme.LowPriorityColor
import com.example.composestudy.ui.theme.MediumPriorityColor
import com.example.composestudy.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}