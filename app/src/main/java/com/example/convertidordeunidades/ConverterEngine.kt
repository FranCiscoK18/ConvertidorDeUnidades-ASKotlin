fun convert(
    category: UnitCategory,
    amount: Double,
    fromUnit: String,
    toUnit: String
): ConversionResult {
    if (amount.isNaN() || amount.isInfinite()) {
        return ConversionResult.Error("Cantidad no válida.")
    }

    return when (category) {
        UnitCategory.TEMPERATURE -> convertTemperature(amount, fromUnit, toUnit)

        UnitCategory.LENGTH,
        UnitCategory.WEIGHT,
        UnitCategory.VOLUME,
        UnitCategory.SPEED,
        UnitCategory.TIME,
        UnitCategory.AREA,
        UnitCategory.CURRENCY -> {
            convertWithBase(
                amount = amount,
                fromUnit = fromUnit,
                toUnit = toUnit,
                units = unitsFor(category)
            )
        }
    }
}

private fun convertWithBase(
    amount: Double,
    fromUnit: String,
    toUnit: String,
    units: List<UnitOption>
): ConversionResult {
    val fromFactor = units.firstOrNull { unit ->
        unit.id == fromUnit
    }?.factorToBase ?: return ConversionResult.Error("Unidad de origen no válida.")

    val toFactor = units.firstOrNull { unit ->
        unit.id == toUnit
    }?.factorToBase ?: return ConversionResult.Error("Unidad de destino no válida.")

    val result = amount * fromFactor / toFactor
    return ConversionResult.Success(result)
}