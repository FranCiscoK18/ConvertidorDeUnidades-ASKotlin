package com.example.convertidordeunidades

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ConverterPanel(
    isEnglish: Boolean,
    cardColor: Color,
    textColor: Color,
    mutedColor: Color,
    fromValue: String,
    onFromValueChange: (String) -> Unit,
    outputValue: String,
    units: List<UnitOption>,
    fromUnit: String,
    toUnit: String,
    onFromUnitChange: (String) -> Unit,
    onToUnitChange: (String) -> Unit,
    onSwap: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(30.dp),
        colors = CardDefaults.cardColors(containerColor = cardColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            UnitInputBox(
                title = if (isEnglish) "FROM UNIT" else "DE UNIDAD",
                value = fromValue,
                onValueChange = onFromValueChange,
                unitId = fromUnit,
                units = units,
                isEnglish = isEnglish,
                readOnly = false,
                textColor = textColor,
                mutedColor = mutedColor,
                onUnitChange = onFromUnitChange
            )

            Spacer(modifier = Modifier.height(22.dp))

            UnitInputBox(
                title = if (isEnglish) "TO UNIT" else "A UNIDAD",
                value = outputValue,
                onValueChange = {},
                unitId = toUnit,
                units = units,
                isEnglish = isEnglish,
                readOnly = true,
                textColor = textColor,
                mutedColor = mutedColor,
                onUnitChange = onToUnitChange
            )
        }
    }
}

@Composable
fun UnitInputBox(
    title: String,
    value: String,
    onValueChange: (String) -> Unit,
    unitId: String,
    units: List<UnitOption>,
    isEnglish: Boolean,
    readOnly: Boolean,
    textColor: Color,
    mutedColor: Color,
    onUnitChange: (String) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF8F6F4)),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Text(
                text = title,
                color = mutedColor,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.5.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = value,
                    onValueChange = onValueChange,
                    readOnly = readOnly,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    modifier = Modifier.weight(1f),
                    textStyle = TextStyle(
                        fontSize = 26.sp,
                        color = textColor,
                        fontWeight = FontWeight.Bold
                    )
                )

                Spacer(modifier = Modifier.width(10.dp))

                UnitDropdown(
                    unitId = unitId,
                    units = units,
                    isEnglish = isEnglish,
                    onUnitChange = onUnitChange
                )
            }
        }
    }
}