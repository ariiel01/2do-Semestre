/*
Autora: Ruiz Marquez Ariel Megara
Grupo: 201
Licenciatura: Ciencias de Datos para Negocios
Práctica de Palindromo.
*/

import java.util.*;

public class Pract_Palindromo {

    public static void main(String[] args) {
        Scanner valor = new Scanner(System.in);
        System.out.print("Ingresa el número que quieres saber si es Palindromo: \n");
        int num = valor.nextInt();

        if (esPalindromo(num)) {
            System.out.println("\nEl numero "+ num +" es un palíndromo.");
        } else {
            System.out.println("\nEl numero "+ num +" no es un palíndromo.");
        }
    }

    public static boolean esPalindromo(int num) {
        Deque<Integer> cola = new ArrayDeque<>();
        int temp = num;
        while (temp > 0) {
            cola.addLast(temp % 10);
            temp /= 10;
        }

        while (cola.size() > 1) {
            if (!cola.removeFirst().equals(cola.removeLast())) {
                return false;
            }
        }

        return true;
    }
}