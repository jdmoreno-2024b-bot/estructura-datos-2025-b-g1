# Implementación Básica de Tabla Hash en Java

## Propósito
Este proyecto implementa una tabla hash genérica `<K,V>` con encadenamiento para resolver colisiones, siguiendo las especificaciones proporcionadas. Facilita operaciones eficientes como inserción, búsqueda y eliminación.

## Estructura del Proyecto
- `HashTable.java`: Clase principal con operaciones `put`, `get`, `remove`, `containsKey`, `size`, `isEmpty`.
- `Entry.java`: Clase interna para nodos (estática en HashTable).
- `Exercise1.java`: Diccionario simple (usuario → rol) con menú interactivo.
- `Exercise2.java`: Contador de palabras usando HashTable<String, Integer>.
- `Exercise3.java`: Prueba de colisiones insertando claves con mismo índice.
- `Exercise4.java`: Prueba de inserción múltiple y verificación de tamaño.
- `COMPLEJIDAD.md`: Análisis de complejidad.

## Análisis y Resultados
- **Función de Dispersión**: Usa `key.hashCode() % capacity` (capacity=16, primo para distribución uniforme). Maneja null keys.
- **Resolución de Colisiones**: Encadenamiento (listas enlazadas por bucket). Nueva entrada se prepende para O(1).
- **Resultados de Ejercicios**:
    1. **Diccionario**: Menú funciona; e.g., agregar "alice"->"admin", consultar devuelve "admin", eliminar reduce size.
    2. **Contador**: Procesa texto; e.g., "hello world hello" → hello:2, world:1. Tamaño = palabras únicas.
    3. **Colisiones**: Insertar claves con mismo índice (e.g., hash%16==0) crea cadena: (key0,0)->(key16,1)->null en bucket 0.
    4. **Tamaño**: Inserta 20, size=20; remove uno, size=19. isEmpty=false.
- **Limitaciones**: Sin redimensionamiento (básico). No maneja load factor. Pruebas manuales confirman O(1) promedio.
- **Compilación y Ejecución**: `javac *.java`, luego `java Exercise1` (etc.).

## Instrucciones de Git
Proyecto inicializado con `git init`. Commits incluyen implementación core y ejercicios.