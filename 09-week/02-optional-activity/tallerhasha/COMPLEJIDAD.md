# Análisis de Complejidad — Tabla Hash

## Operaciones implementadas
- `put(K, V)` → inserta o actualiza un elemento.
- `get(K)` → obtiene el valor asociado a una clave.
- `remove(K)` → elimina un elemento.
- `containsKey(K)` → verifica si existe una clave.
- `size()` y `isEmpty()` → información del estado de la tabla.

---

##  Tabla de complejidad

| Operación  | Complejidad Promedio | Peor Caso |
|-------------|----------------------|-----------|
| **Insertar (`put`)** | O(1) | O(n)      |
| **Buscar (`get`)** | O(1) | O(n)      |
| **Eliminar (`remove`)** | O(1) | O(n)      |
| **Contiene clave (`containsKey`)** | O(1) | O(n)      |
| **Tamaño (`size`)** | O(1) | O(1)      |
| **Vacía (`isEmpty`)** | O(1) | O(1)      |

---

##  Explicación
- En promedio, las operaciones son **O(1)** porque las claves se distribuyen uniformemente entre los buckets (índices del arreglo).
- En el **peor caso**, todas las claves colisionan (caen en el mismo bucket) y las operaciones deben recorrer una lista completa de tamaño *n* → **O(n)**.
- El rendimiento depende directamente de la **calidad del método `hashCode()`** y del **tamaño del arreglo**.
- Si se implementara *rehashing* (no requerido en este taller), podría mantenerse un tiempo promedio estable incluso con grandes volúmenes de datos.

---

##  Conclusión
> La tabla hash ofrece un excelente rendimiento promedio **O(1)** en la mayoría de los casos.  
> Es ideal para búsquedas rápidas, siempre que las funciones hash estén bien diseñadas.
