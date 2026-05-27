package com.example.uniconverter

fun defaultFromUnit(category: UnitCategory): String {
    return unitsFor(category).firstOrNull()?.id ?: ""
}

fun defaultToUnit(category: UnitCategory): String {
    val units = unitsFor(category)
    return units.getOrNull(1)?.id ?: units.firstOrNull()?.id ?: ""
}

fun createConversionRecord(
    category: UnitCategory,
    isEnglish: Boolean,
    fromUnit: String,
    toUnit: String,
    inputValue: Double,
    outputValue: Double
): ConversionRecord {
    return ConversionRecord(
        category = labelOf(category, isEnglish),
        fromUnit = fromUnit,
        toUnit = toUnit,
        inputValue = inputValue,
        outputValue = outputValue
    )
}

fun resultText(
    result: ConversionResult?,
    isEnglish: Boolean
): String {
    return when (result) {
        is ConversionResult.Success -> formatNumber(result.convertedValue)
        is ConversionResult.Error -> if (isEnglish) "Invalid unit" else "Unidad inválida"
        null -> "0"
    }
}