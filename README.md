## CasoFinalFinal
https://github.com/maritoo17/CasoFinalFinal.git


----- *****Ejercicio 1***** -----
1: b)    Debemos establecer la visibilidad más restrictiva (por ejemplo, privada) en los atributos de una clase. Así, cualquier software que utilice nuestro objeto, sólo accederá al estado de los objetos mediante los     
         métodos que le hayamos permitido utilizar.
2: b)    Falso
3: b)    Herencia
4: a)    O(n)
5: b)    Falso


----- *****Ejercicio 2***** -----
2)
Tabla Hash:
- Las tablas hash están diseñadas para proporcionar acceso, inserción y eliminación de datos en tiempo constante promedio, 𝑂(1)
- Utilizan una función hash para calcular el índice en una matriz donde se almacenará o buscará un elemento.
- Son muy eficientes para operaciones de búsqueda, inserción y eliminación cuando la función hash distribuye bien los elementos, evitando colisiones.
- No mantienen ningún orden entre los elementos almacenados.

Árbol (Árbol binario de búsqueda):
- Los árboles mantienen sus elementos en un orden específico, lo que permite operaciones de búsqueda eficientes, 𝑂(log𝑛), y mantiene los elementos ordenados.
- La inserción y eliminación también tienen una complejidad de tiempo 𝑂(log𝑛) en el caso promedio y mejor, pero pueden degradarse a 𝑂(𝑛) en el peor de los casos si el árbol se desbalancea.
- Son estructuras útiles para aplicaciones donde el orden de los elementos es importante, como en bases de datos y sistemas de gestión de archivos.

Cuándo usar cada una:

- Tabla Hash: Si necesitas inserciones, eliminaciones y accesos muy rápidos y el orden de los elementos no importa. Ideal para cachés, diccionarios, y conjuntos donde las colisiones son manejables.
- Árbol: Cuando el orden de los elementos es importante o se requieren operaciones que dependen del orden, como encontrar el mínimo/máximo, predecesores, sucesores, etc. También son preferibles cuando se quiere evitar el 
         peor de los casos de tiempo constante de las tablas hash debido a colisiones.

3)
- Pila:

Una estructura de datos de tipo LIFO (Last In, First Out), donde el último elemento añadido es el primero en ser eliminado.
Operaciones típicas incluyen push (añadir al tope) y pop (remover del tope).
Utilizada en aplicaciones como el manejo de llamadas recursivas, evaluación de expresiones y algoritmos de marcha atrás.

- Cola:

Una estructura de datos de tipo FIFO (First In, First Out), donde el primer elemento añadido es el primero en ser eliminado.
Operaciones típicas incluyen enqueue (añadir al final) y dequeue (remover del frente).
Utilizada en aplicaciones como simulación de espera, manejo de tareas en sistemas operativos y buffers en la transmisión de datos.

- Orden de complejidad computacional:

Tanto para pilas como para colas, las operaciones básicas (añadir y eliminar) son 𝑂(1), ya que no requieren recorrer la estructura de datos.

- Cuándo usar cada una:

Pila: Útil cuando necesitas acceder a los elementos en orden inverso a su llegada. Ideal para algoritmos que se basan en deshacer la última acción realizada o evaluar expresiones matemáticas.
Cola: Útil cuando los elementos deben ser procesados en el orden en que llegaron. Ideal para simulaciones de cola y manejo de procesos o tareas en orden de llegada.

4)
Método de Ordenación por Inserción
El método de ordenación por inserción trabaja construyendo una sublista ordenada al principio del arreglo. En cada iteración, toma un elemento de la parte no ordenada y lo inserta en el lugar correcto de la parte ordenada.

Conjunto de Datos: 50 20 84 13 22 16 89 85

Iteraciones:

Comienza con 50 como la sublista ordenada.
Inserta 20 en la posición correcta: 20, 50
Inserta 84 en la posición correcta: 20, 50, 84
Inserta 13 en la posición correcta: 13, 20, 50, 84
Inserta 22 en la posición correcta: 13, 20, 22, 50, 84
Inserta 16 en la posición correcta: 13, 16, 20, 22, 50, 84
Inserta 89 en la posición correcta: 13, 16, 20, 22, 50, 84, 89
Inserta 85 en la posición correcta: 13, 16, 20, 22, 50, 84, 85, 89

Comparación de eficiencia entre A y B
Para las funciones:

𝐴 = 1024𝑛
𝐵 = 16𝑛^3
 
Queremos encontrar el valor de 𝑛 a partir del cual 𝐴 es más eficiente que 𝐵:

1024𝑛 < 16𝑛^3
 
64 < 𝑛^2
 
𝑛 > 8
Por lo tanto, 𝐴 es más eficiente que 𝐵 cuando 𝑛 > 8.

----- *****Ejercicio 3***** -----

a) El código dado no compila, la solución y la explicación está en la carpeta "Ejercicio3" que podrás encontrar dentro de este mismo repositorio.
b) Este código es un intento de implementar una función recursiva para calcular potencias, pero requiere ajustes en la lógica para manejar mejor los casos base y el ámbito de las variables. Además, la función no maneja correctamente los exponentes negativos para replicar la funcionalidad matemática estándar de potencias.


