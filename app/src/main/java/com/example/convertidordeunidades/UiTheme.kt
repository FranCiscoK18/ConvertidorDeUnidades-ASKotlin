package com.example.convertidordeunidades

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple = Color(0xFF9188AA)
val SoftBackground = Color(0xFFF1EEE9)
val SoftCard = Color(0xFFFCFAF7)
val DarkBackground = Color(0xFF191720)
val DarkCard = Color(0xFF282431)
val TextDark = Color(0xFF343238)
val TextMuted = Color(0xFF77737D)

@Composable
fun UniConverterTheme(
    isDark: Boolean,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (isDark) darkColorScheme() else lightColorScheme(),
        content = content
    )
}