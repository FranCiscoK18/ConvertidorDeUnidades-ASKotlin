package com.example.convertidordeunidades

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.height
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
fun FavoritesSection(
    isEnglish: Boolean,
    cardColor: Color,
    textColor: Color,
    mutedColor: Color,
    favorites: List<ConversionRecord>,
    history: List<ConversionRecord>,
    onAddFavorite: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(28.dp),
        colors = CardDefaults.cardColors(containerColor = cardColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(22.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "⭐",
                    fontSize = 28.sp
                )

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = if (isEnglish) "Favorite conversions" else "Conversiones favoritas",
                    color = textColor,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )

                Button(
                    onClick = onAddFavorite,
                    colors = ButtonDefaults.buttonColors(containerColor = Purple),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Text(
                        text = if (isEnglish) "+ Add" else "+ Agregar",
                        color = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (favorites.isEmpty()) {
                Text(
                    text = if (isEnglish) {
                        "No favorite conversions yet."
                    } else {
                        "Todavía no hay conversiones favoritas."
                    },
                    color = mutedColor,
                    fontSize = 15.sp
                )
            } else {
                favorites.take(5).forEach { record ->
                    Text(
                        text = "${formatNumber(record.inputValue)} ${record.fromUnit} = ${formatNumber(record.outputValue)} ${record.toUnit}",
                        color = textColor,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = if (isEnglish) {
                    "Session history: ${history.size} conversions"
                } else {
                    "Historial de sesión: ${history.size} conversiones"
                },
                color = mutedColor,
                fontSize = 14.sp
            )

            if (history.isNotEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))

                val groupedHistory = history.groupBy { record ->
                    record.category
                }

                groupedHistory.forEach { (category, records) ->
                    Text(
                        text = "$category: ${records.size}",
                        color = mutedColor,
                        fontSize = 13.sp
                    )
                }
            }
        }
    }
}