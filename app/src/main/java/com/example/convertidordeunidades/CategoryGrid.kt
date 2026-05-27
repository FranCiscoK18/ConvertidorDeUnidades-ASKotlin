package com.example.convertidordeunidades

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.weight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CategoryGrid(
    selectedCategory: UnitCategory,
    isEnglish: Boolean,
    textColor: Color,
    onSelect: (UnitCategory) -> Unit
) {
    val categories = UnitCategory.values().toList()

    BoxWithConstraints {
        val columns = if (maxWidth < 430.dp) 2 else 4

        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            categories.chunked(columns).forEach { rowItems ->
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    rowItems.forEach { category ->
                        CategoryTile(
                            category = category,
                            selected = selectedCategory == category,
                            isEnglish = isEnglish,
                            textColor = textColor,
                            modifier = Modifier.weight(1f),
                            onClick = { onSelect(category) }
                        )
                    }

                    repeat(columns - rowItems.size) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

@Composable
fun CategoryTile(
    category: UnitCategory,
    selected: Boolean,
    isEnglish: Boolean,
    textColor: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val backgroundColor = if (selected) Purple else SoftCard
    val contentColor = if (selected) Color.White else textColor

    Button(
        onClick = onClick,
        shape = RoundedCornerShape(22.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        ),
        modifier = modifier.height(92.dp),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = category.icon,
                fontSize = 25.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = labelOf(category, isEnglish),
                color = contentColor,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}