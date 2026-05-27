package com.example.convertidordeunidades

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UniConverterApp()
        }
    }
}

@Composable
fun UniConverterApp() {
    var isDark by remember { mutableStateOf(false) }

    UniConverterTheme(isDark = isDark) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(if (isDark) DarkBackground else SoftBackground)
                .padding(24.dp)
        ) {
            Text(
                text = "⚡ Uni Converter",
                fontSize = 30.sp,
                color = if (isDark) androidx.compose.ui.graphics.Color.White else TextDark
            )
        }
    }
}