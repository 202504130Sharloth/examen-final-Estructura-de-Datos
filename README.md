# Proyecto Final: Estructuras de Datos Arbóreas 🌳
**Universidad Da Vinci de Guatemala**  
**Facultad de Ingeniería en Sistemas**  
**Curso:** Estructuras de Datos  

Este repositorio contiene la fase práctica del proyecto final, centrada en el diseño, análisis e implementación desde cero de un **Árbol Binario de Búsqueda (BST)** en el lenguaje de programación Java, sin utilizar librerías de colecciones nativas.

---

## 📹 Video de Defensa y Sustentación
Puedes ver la explicación del código, la justificación de la complejidad Big O y la demostración del programa en ejecución en el siguiente enlace:

👉 **[Ver Video de la Defensa en YouTube](TU_ENLACE_DE_YOUTUBE_AQUÍ)** *(Reemplaza este texto con tu link real)*

---

## 💻 Características de la Implementación (Java)
La clase principal implementa un BST para almacenar números enteros mediante nodos enlazados de manera dinámica. Incluye los siguientes algoritmos obligatorios:

*   **Inserción (`insert`)**: Ubicación topológica recursiva basada en el valor de la clave.
*   **Búsqueda (`search`)**: Retorno booleano con un enfoque de descarte binario.
*   **Eliminación (`delete`)**: Manejo estructurado de los 3 escenarios lógicos:
    1.  Nodo hoja (sin hijos).
    2.  Nodo con un único hijo (izquierdo o derecho).
    3.  Nodo con dos hijos (búsqueda del sucesor en orden mediante el mínimo del subárbol derecho).
*   **Recorridos de Sistema**:
    *   `In-Order` (Izquierda, Raíz, Derecha) -> Muestra los datos ordenados de forma ascendente.
    *   `Pre-Order` (Raíz, Izquierda, Derecha)
    *   `Post-Order` (Izquierda, Derecha, Raíz)

---

## 🛠️ Estructura del Código fuente
El proyecto está estructurado de forma simple en dos archivos fuente independientes:
*   `Nodo.java`: Define la estructura atómica del nodo con sus apuntadores `izq` y `der`.
*   `BST.java`: Contiene la lógica del árbol, los métodos de manipulación y el método de prueba `main`.

---

## 🚀 Instrucciones para la Ejecución

### Prerrequisitos
*   Tener instalado el **Java Development Kit (JDK)** versión 8 o superior.
*   Una terminal de comandos o un IDE de tu preferencia (NetBeans, IntelliJ, Eclipse, VS Code).

### Pasos para compilar y ejecutar desde la consola:

1.  **Clonar el repositorio:**
    ```bash
    git clone https://github.com
    cd TU_REPOSITORIO
    ```

2.  **Compilar las clases de Java:**
    ```bash
    javac Nodo.java BST.java
    ```

3.  **Ejecutar el programa principal:**
    ```bash
    java BST
    ```

---

## 📊 Resumen de Complejidad Algorítmica (Big O)


| Operación | Caso Promedio | Peor Caso | Justificación Técnica |
| :--- | :--- | :--- | :--- |
| **Búsqueda** | $O(\log n)$ | $O(n)$ | En promedio el árbol divide la búsqueda a la mitad en cada nivel. Si se introduce ordenadamente, se vuelve lineal. |
| **Inserción** | $O(\log n)$ | $O(n)$ | Sigue el mismo camino de exploración que la búsqueda antes de instanciar el nuevo nodo. |
| **Eliminación**| $O(\log n)$ | $O(n)$ | Requiere la localización previa del nodo y, en el peor escenario, buscar el sucesor en ramas desbalanceadas. |
