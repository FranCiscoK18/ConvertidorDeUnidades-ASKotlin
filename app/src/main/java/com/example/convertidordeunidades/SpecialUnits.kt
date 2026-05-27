import com.example.convertidordeunidades.ConversionResult
import com.example.convertidordeunidades.UnitOption

val temperatureUnits = listOf(
    UnitOption("C", "Celsius", "Celsius", 1.0),
    UnitOption("F", "Fahrenheit", "Fahrenheit", 1.0),
    UnitOption("K", "Kelvin", "Kelvin", 1.0)
)

val currencyUnits = listOf(
    UnitOption("MXN", "peso mexicano", "mexican peso", 1.0),
    UnitOption("USD", "dólar estadounidense", "US dollar", 18.50),
    UnitOption("EUR", "euro", "euro", 20.10),
    UnitOption("CAD", "dólar canadiense", "canadian dollar", 13.50),
    UnitOption("JPY", "yen japonés", "japanese yen", 0.12)
)

fun convertTemperature(
    amount: Double,
    fromUnit: String,
    toUnit: String
): ConversionResult {
    val celsius = when (fromUnit) {
        "C" -> amount
        "F" -> (amount - 32) * 5 / 9
        "K" -> amount - 273.15
        else -> return ConversionResult.Error("Unidad de temperatura no válida.")
    }

    val result = when (toUnit) {
        "C" -> celsius
        "F" -> (celsius * 9 / 5) + 32
        "K" -> celsius + 273.15
        else -> return ConversionResult.Error("Unidad de temperatura no válida.")
    }

    return ConversionResult.Success(result)
}