package com.example.convertidordeunidades

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.weight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeaderSection(
    isDark: Boolean,
    isEnglish: Boolean,
    cardColor: Color,
    textColor: Color,
    mutedColor: Color,
    onToggleDark: () -> Unit,
    onToggleLanguage: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(28.dp),
        colors = CardDefaults.cardColors(containerColor = cardColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "⚡",
                    fontSize = 26.sp
                )

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = "Uni Converter",
                    color = textColor,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )

                Button(
                    onClick = onToggleDark,
                    colors = ButtonDefaults.buttonColors(containerColor = Purple),
                    shape = RoundedCornerShape(18.dp),
                    modifier = Modifier.size(56.dp)
                ) {
                    Text(text = if (isDark) "☀️" else "🌙")
                }

                Spacer(modifier = Modifier.width(10.dp))

                Button(
                    onClick = onToggleLanguage,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF4F2EF)),
                    shape = RoundedCornerShape(18.dp),
                    modifier = Modifier.size(56.dp)
                ) {
                    Text(text = if (isEnglish) "🇬🇧" else "🇲🇽")
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = if (isEnglish) {
                    "Fast and accurate unit conversions"
                } else {
                    "Conversiones de unidades rápidas y precisas"
                },
                color = mutedColor,
                fontSize = 18.sp
            )
        }
    }
}