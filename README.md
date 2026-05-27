# Convertidor de Unidades - Kotlin Android

## 1. Nombre del proyecto y descripción breve

**Convertidor de Unidades** es una aplicación móvil desarrollada en **Kotlin** con **Jetpack Compose** que permite convertir valores entre diferentes tipos de unidades desde una interfaz gráfica sencilla y responsiva. La aplicación incluye categorías como longitud, peso, temperatura, volumen, velocidad, tiempo, área y moneda, además de opciones de idioma, tema visual y registro temporal de conversiones favoritas.

**Integrantes:** Kantún Balam José Francisco, Mendez Cordero Anwar Bahrain, Tovar Perez Carlos Francisco y Rivera Monroy Alan Jair.

---

## 2. Instrucciones de instalación y ejecución

### Requisitos previos

Para ejecutar el proyecto desde cero se necesita:

- Android Studio instalado.
- JDK 17 o superior.
- Android SDK configurado desde Android Studio.
- Un emulador de Android o un teléfono Android conectado por USB con depuración activada.
- Git, si se desea clonar el repositorio desde GitHub.

### Opción A: Ejecutar desde Android Studio

1. Clona el repositorio o descarga el proyecto:

```bash
git clone https://github.com/FranCiscoK18/ConvertidorDeUnidades-ASKotlin.git
```

2. Entra a la carpeta del proyecto:

```bash
cd ConvertidorDeUnidades-ASKotlin
```

3. Abre Android Studio.
4. Selecciona **File > Open** y abre la carpeta del proyecto.
5. Espera a que Gradle sincronice las dependencias.
6. Selecciona un emulador o dispositivo físico.
7. Presiona **Run** para ejecutar la aplicación.

### Opción B: Compilar desde terminal

En Windows:

```bash
gradlew.bat :app:assembleDebug
```

En macOS o Linux:

```bash
chmod +x gradlew
./gradlew :app:assembleDebug
```

El archivo APK de depuración se genera en:

```bash
app/build/outputs/apk/debug/app-debug.apk
```

---

## 3. Funcionalidades principales

- Permite convertir unidades de **longitud**, por ejemplo metros, kilómetros, centímetros, milímetros, pulgadas y pies.
- Permite convertir unidades de **peso**, por ejemplo kilogramos, gramos, libras y onzas.
- Permite convertir unidades de **temperatura** entre Celsius, Fahrenheit y Kelvin.
- Permite convertir unidades de **volumen**, como litros, mililitros, galones y tazas.
- Permite convertir unidades de **velocidad**, como metros por segundo, kilómetros por hora, millas por hora y pies por segundo.
- Permite convertir unidades de **tiempo**, como segundos, minutos, horas y días.
- Permite convertir unidades de **área**, como metros cuadrados, kilómetros cuadrados, centímetros cuadrados y pies cuadrados.
- Permite convertir **monedas** usando tasas fijas de ejemplo definidas en el código.
- Incluye selector de categoría mediante tarjetas visuales.
- Incluye campos para elegir unidad de origen y unidad de destino.
- Incluye botón para intercambiar rápidamente las unidades seleccionadas.
- Permite cambiar entre idioma inglés y español.
- Permite cambiar entre modo claro y modo oscuro.
- Permite agregar conversiones favoritas durante la sesión.
- Muestra un historial temporal de conversiones agrupado por categoría.

> Nota: Las conversiones de moneda usan valores fijos dentro del proyecto.

---

## 4. Conceptos de Kotlin aplicados

| Requisito técnico | Archivo o función donde se aplica | Explicación |
|---|---|---|
| Funciones propias con nombres descriptivos | `ConverterEngine.kt` - `convert()` y `convertWithBase()` | La lógica principal de conversión está separada en funciones para evitar poner todo dentro de `MainActivity`. |
| Condicionales con `when` | `ConverterEngine.kt` - `convert()` y `SpecialUnits.kt` - `convertTemperature()` | Se usa `when` para decidir qué fórmula aplicar según la categoría o la unidad seleccionada. |
| Ciclos e iteración | `CategoryGrid.kt`, `UnitDropdown.kt` y `FavoritesSection.kt` | Se recorren categorías, unidades y favoritos usando operaciones como `forEach`, `repeat` y agrupaciones. |
| Colecciones `List` | `BasicUnits.kt`, `ExtraUnits.kt` y `SpecialUnits.kt` | Las unidades disponibles se modelan como listas de objetos `UnitOption`. |
| Operaciones funcionales sobre colecciones | `UnitDropdown.kt`, `FavoritesSection.kt` y `UiStateHelpers.kt` | Se usan operaciones como `firstOrNull`, `forEach`, `take` y `groupBy` para buscar, mostrar y agrupar datos. |
| Null safety | `Utils.kt` - `parseAmount()` y `MainActivity.kt` - `amount?.let { ... }` | La entrada del usuario se convierte a `Double?` usando `toDoubleOrNull()`. Si el valor no es válido, la app evita fallos y no fuerza nulos con `!!`. |
| Elvis operator `?:` | `UiStateHelpers.kt` - `defaultFromUnit()` y `defaultToUnit()` | Se usa `?:` para regresar una cadena vacía o una unidad alternativa cuando no existe una unidad seleccionable. |
| `data class` | `Models.kt` - `UnitOption` y `ConversionRecord` | Se modelan datos del dominio, como unidades y conversiones realizadas, de forma clara y reutilizable. |
| `sealed class` | `Models.kt` - `ConversionResult` | Se representa el resultado de una conversión como éxito o error, lo que ayuda a manejar estados sin depender de valores ambiguos. |
| Separación de responsabilidades | `MainActivity.kt`, `ConverterPanel.kt`, `CategoryGrid.kt`, `FavoritesSection.kt` | La interfaz se divide en componentes reutilizables y la lógica de conversión se mantiene en archivos separados. |
| Estado en Compose | `MainActivity.kt` - `remember`, `mutableStateOf` y `mutableStateListOf` | Se controla el estado de categoría, valor ingresado, unidades, tema, idioma, favoritos e historial. |

---

## 5. Reflexión de proceso

### a) ¿Qué fue lo más difícil de este proyecto y cómo lo resolviste?

Lo más difícil fue organizar la aplicación para que no todo quedara escrito dentro del main. Al principio era fácil mezclar la interfaz, los datos de las unidades y las fórmulas de conversión en un solo lugar, pero eso hacía que el código fuera más difícil de entender y de corregir. Lo resolvimos separando el proyecto por responsabilidades: un archivo para los modelos, otros para las listas de unidades, otro para la lógica de conversión y varios componentes para la interfaz.

### b) ¿Hubo algún concepto de Kotlin que al principio no entendías y que ahora sí comprendes? ¿Cómo llegaste a entenderlo?

Uno de los conceptos que más costó entender fue el manejo seguro de nulos. Al principio parecía más sencillo convertir directamente el texto ingresado por el usuario a número, pero si el campo estaba vacío o tenía letras la aplicación podía fallar. Entendimos que Kotlin obliga a pensar que un dato puede no existir y permite manejar ese caso sin errores inesperados.

### c) Si tuvieras que mejorar o ampliar este proyecto, ¿qué le agregarías y por qué?

Si tuviéramos que ampliar el proyecto, agregaríamos una API real para consultar tasas de cambio actualizadas en la categoría de moneda, porque actualmente los valores están escritos de forma fija en el código. También agregaríamos almacenamiento para guardar favoritos e historial aunque se cierre la aplicación, usando una base de datos.

### d) ¿Qué aprendiste de este proyecto que no aprendiste solo leyendo o viendo videos?

Aprendimos que programar una aplicación funcional no solo consiste en conocer la sintaxis de Kotlin, sino en tomar decisiones sobre organización y validación de datos. Al construir la app nos dimos cuenta de que conceptos como funciones, colecciones, null safety y clases de datos se entienden mejor cuando se usan para resolver problemas concretos. También aprendimos que trabajar con una interfaz gráfica obliga a pensar en el estado de la aplicación: qué categoría está seleccionada, qué valor escribió el usuario, qué unidades se deben mostrar y cómo debe actualizarse el resultado cada vez que cambia algo.
