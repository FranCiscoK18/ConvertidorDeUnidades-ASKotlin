package com.example.convertidordeunidades

enum class UnitCategory(
    val titleEs: String,
    val titleEn: String,
    val icon: String
) {
    LENGTH("Longitud", "Length", "📏"),
    WEIGHT("Peso", "Weight", "⚖️"),
    TEMPERATURE("Temperatura", "Temp.", "🌡️"),
    VOLUME("Volumen", "Volume", "🧪"),
    SPEED("Velocidad", "Speed", "🚀"),
    TIME("Tiempo", "Time", "⏱️"),
    AREA("Área", "Area", "📐"),
    CURRENCY("Moneda", "Currency", "💱")
}

data class UnitOption(
    val id: String,
    val nameEs: String,
    val nameEn: String,
    val factorToBase: Double
)

data class ConversionRecord(
    val category: String,
    val fromUnit: String,
    val toUnit: String,
    val inputValue: Double,
    val outputValue: Double
)

sealed class ConversionResult {
    data class Success(val convertedValue: Double) : ConversionResult()
    data class Error(val message: String) : ConversionResult()
}