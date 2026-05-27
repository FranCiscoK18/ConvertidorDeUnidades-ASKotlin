package com.example.uniconverter

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UnitDropdown(
    unitId: String,
    units: List<UnitOption>,
    isEnglish: Boolean,
    onUnitChange: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    val selectedUnit = units.firstOrNull { unit ->
        unit.id == unitId
    }

    val selectedText = selectedUnit?.let { unit ->
        unitName(unit, isEnglish)
    } ?: unitId

    Box {
        Button(
            onClick = { expanded = true },
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            shape = RoundedCornerShape(18.dp)
        ) {
            Text(
                text = selectedText,
                color = TextDark,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            units.forEach { unit ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = "${unitName(unit, isEnglish)} (${unit.id})"
                        )
                    },
                    onClick = {
                        onUnitChange(unit.id)
                        expanded = false
                    }
                )
            }
        }
    }
}