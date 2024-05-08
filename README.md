## CasoFinalFinal
https://github.com/maritoo17/CasoFinalFinal.git


#### ----- Ejercicio 1 -----
1: b)    Debemos establecer la visibilidad más restrictiva (por ejemplo, privada) en los atributos de una clase. Así, cualquier software que utilice nuestro objeto, sólo accederá al estado de los objetos mediante los     
         métodos que le hayamos permitido utilizar.
2: b)    Falso
3: b)    Herencia
4: a)    O(n)
5: b)    Falso


#### ----- Ejercicio 2 -----
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

