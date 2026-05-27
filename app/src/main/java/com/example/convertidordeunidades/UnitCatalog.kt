package com.example.convertidordeunidades

fun unitsFor(category: UnitCategory): List<UnitOption> {
    return when (category) {
        UnitCategory.LENGTH -> lengthUnits
        UnitCategory.WEIGHT -> weightUnits
        UnitCategory.TEMPERATURE -> temperatureUnits
        UnitCategory.CURRENCY -> currencyUnits
        UnitCategory.VOLUME -> emptyList()
        UnitCategory.SPEED -> emptyList()
        UnitCategory.TIME -> emptyList()
        UnitCategory.AREA -> emptyList()
    }
}