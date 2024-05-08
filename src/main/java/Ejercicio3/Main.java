package Ejercicio3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Asegurarse de que 'a' esté definida en el ámbito correcto
        int a = recursive(1, -2);
        System.out.println(a);
    }

    public static int recursive(int a, int b) {
        if (b == 0) {
            return 1;
        } else if (b < 0) {
            // Manejo de valores negativos para 'b'
            return 0;  // O cualquier otra lógica que sea apropiada para su caso de uso
        } else if (a == 0) {
            return 0;
        } else {
            return a * recursive(a, b - 1);
        }
    }
}
