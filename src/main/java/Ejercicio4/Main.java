package Ejercicio4;

public class Main {
    public static void main(String[] args) {
        int number = 102;
        int result = sumOfDigits(number);
        System.out.println("La suma de los dígitos de " + number + " es " + result);
    }

    public static int sumOfDigits(int n) {
        if (n < 10) {
            return n;
        } else {
            return n % 10 + sumOfDigits(n / 10);
        }
    }
}