package com.example.convertidordeunidades

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.convertidordeunidades.CategoryGrid
import com.example.convertidordeunidades.ConversionResult
import com.example.convertidordeunidades.DarkBackground
import com.example.convertidordeunidades.DarkCard
import com.example.convertidordeunidades.HeaderSection
import com.example.convertidordeunidades.SoftBackground
import com.example.convertidordeunidades.SoftCard
import com.example.convertidordeunidades.TextDark
import com.example.convertidordeunidades.TextMuted
import com.example.convertidordeunidades.UniConverterTheme
import com.example.convertidordeunidades.UnitCategory
import com.example.convertidordeunidades.defaultFromUnit
import com.example.convertidordeunidades.defaultToUnit
import com.example.convertidordeunidades.formatNumber
import com.example.convertidordeunidades.parseAmount
import com.example.convertidordeunidades.resultText
import com.example.convertidordeunidades.unitsFor
import com.example.uniconverter.ConverterPanel
import convert

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
    var isEnglish by remember { mutableStateOf(true) }

    val backgroundColor = if (isDark) DarkBackground else SoftBackground
    val cardColor = if (isDark) DarkCard else SoftCard
    val textColor = if (isDark) Color.White else TextDark
    val mutedColor = if (isDark) Color(0xFFC9C3D8) else TextMuted

    var selectedCategory by remember { mutableStateOf(UnitCategory.LENGTH) }
    var fromValue by remember { mutableStateOf("") }
    var fromUnit by remember { mutableStateOf(defaultFromUnit(UnitCategory.LENGTH)) }
    var toUnit by remember { mutableStateOf(defaultToUnit(UnitCategory.LENGTH)) }

    val favorites = remember { mutableStateListOf<ConversionRecord>() }
    val history = remember { mutableStateListOf<ConversionRecord>() }

    val units = unitsFor(selectedCategory)
    val amount = parseAmount(fromValue)

    val conversionResult = amount?.let { validAmount ->
        convert(
            category = selectedCategory,
            amount = validAmount,
            fromUnit = fromUnit,
            toUnit = toUnit
        )
    }

    val outputValue = resultText(conversionResult, isEnglish)

    UniConverterTheme(isDark = isDark) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor)
                .verticalScroll(rememberScrollState())
                .padding(22.dp)
        ) {
            HeaderSection(
                isDark = isDark,
                isEnglish = isEnglish,
                cardColor = cardColor,
                textColor = textColor,
                mutedColor = mutedColor,
                onToggleDark = { isDark = !isDark },
                onToggleLanguage = { isEnglish = !isEnglish }
            )

            Spacer(modifier = Modifier.height(22.dp))

            CategoryGrid(
                selectedCategory = selectedCategory,
                isEnglish = isEnglish,
                textColor = textColor,
                onSelect = { category ->
                    selectedCategory = category
                    fromUnit = defaultFromUnit(category)
                    toUnit = defaultToUnit(category)
                    fromValue = ""
                }
            )

            Spacer(modifier = Modifier.height(22.dp))

            ConverterPanel(
                isEnglish = isEnglish,
                cardColor = cardColor,
                textColor = textColor,
                mutedColor = mutedColor,
                fromValue = fromValue,
                onFromValueChange = { newValue ->
                    fromValue = newValue
                },
                outputValue = outputValue,
                units = units,
                fromUnit = fromUnit,
                toUnit = toUnit,
                onFromUnitChange = { selectedUnit ->
                    fromUnit = selectedUnit
                },
                onToUnitChange = { selectedUnit ->
                    toUnit = selectedUnit
                },
                onSwap = {
                    val previousFrom = fromUnit
                    fromUnit = toUnit
                    toUnit = previousFrom

                    if (conversionResult is ConversionResult.Success) {
                        fromValue = formatNumber(conversionResult.convertedValue)
                    }
                }
            )

            Spacer(modifier = Modifier.height(22.dp))

            FavoritesSection(
                isEnglish = isEnglish,
                cardColor = cardColor,
                textColor = textColor,
                mutedColor = mutedColor,
                favorites = favorites,
                history = history,
                onAddFavorite = {
                    if (amount != null && conversionResult is ConversionResult.Success) {
                        val record = createConversionRecord(
                            category = selectedCategory,
                            isEnglish = isEnglish,
                            fromUnit = fromUnit,
                            toUnit = toUnit,
                            inputValue = amount,
                            outputValue = conversionResult.convertedValue
                        )

                        favorites.add(0, record)
                        history.add(0, record)
                    }
                }
            )

            Spacer(modifier = Modifier.height(28.dp))
        }
    }
}