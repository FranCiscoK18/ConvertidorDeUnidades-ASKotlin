package com.example.convertidordeunidades

val volumeUnits = listOf(
    UnitOption("L", "litro", "liter", 1.0),
    UnitOption("mL", "mililitro", "milliliter", 0.001),
    UnitOption("gal", "galón", "gallon", 3.78541),
    UnitOption("cup", "taza", "cup", 0.236588)
)

val speedUnits = listOf(
    UnitOption("m/s", "metro por segundo", "meter per second", 1.0),
    UnitOption("km/h", "kilómetro por hora", "kilometer per hour", 0.277777778),
    UnitOption("mph", "milla por hora", "mile per hour", 0.44704),
    UnitOption("ft/s", "pie por segundo", "foot per second", 0.3048)
)

val timeUnits = listOf(
    UnitOption("s", "segundo", "second", 1.0),
    UnitOption("min", "minuto", "minute", 60.0),
    UnitOption("h", "hora", "hour", 3600.0),
    UnitOption("d", "día", "day", 86400.0)
)

val areaUnits = listOf(
    UnitOption("m²", "metro cuadrado", "square meter", 1.0),
    UnitOption("km²", "kilómetro cuadrado", "square kilometer", 1_000_000.0),
    UnitOption("cm²", "centímetro cuadrado", "square centimeter", 0.0001),
    UnitOption("ft²", "pie cuadrado", "square foot", 0.092903)
)