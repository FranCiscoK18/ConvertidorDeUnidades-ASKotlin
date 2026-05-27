package com.example.uniconverter

import java.text.DecimalFormat

fun parseAmount(input: String): Double? {
    val cleanInput = input.trim().replace(",", ".")
    return cleanInput.toDoubleOrNull()
}

fun formatNumber(value: Double): String {
    val formatter = DecimalFormat("#,##0.####")
    return formatter.format(value)
}

fun labelOf(category: UnitCategory, isEnglish: Boolean): String {
    return if (isEnglish) category.titleEn else category.titleEs
}

fun unitName(unit: UnitOption, isEnglish: Boolean): String {
    return if (isEnglish) unit.nameEn else unit.nameEs
}

fun normalizeUnitId(unitId: String): String {
    return unitId.trim()
}