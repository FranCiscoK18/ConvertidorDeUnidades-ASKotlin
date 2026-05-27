package com.example.uniconverter

val lengthUnits = listOf(
    UnitOption("m", "metro", "meter", 1.0),
    UnitOption("km", "kilómetro", "kilometer", 1000.0),
    UnitOption("cm", "centímetro", "centimeter", 0.01),
    UnitOption("mm", "milímetro", "millimeter", 0.001),
    UnitOption("in", "pulgada", "inch", 0.0254),
    UnitOption("ft", "pie", "foot", 0.3048)
)

val weightUnits = listOf(
    UnitOption("kg", "kilogramo", "kilogram", 1.0),
    UnitOption("g", "gramo", "gram", 0.001),
    UnitOption("lb", "libra", "pound", 0.45359237),
    UnitOption("oz", "onza", "ounce", 0.0283495231)
)