/*
Autora: Ruiz Marquez Ariel Megara
Grupo: 201
Licenciatura: Ciencias de Datos para Negocios
Práctica Factorial.
*/


import java.util.*;

public class Pract_Factorial {
    public static void main(String[] args) {
        
        Scanner numero = new Scanner(System.in);
        System.out.print("Ingresa el número entero para saber su factorial: ");
        
        int num = numero.nextInt();
        long factorial = 1L;
        
        for (int i = 2; i <= num; i++) {
            factorial *= i;
        }
        
        System.out.println("El factorial de " + num + " es " + factorial);
    }
}