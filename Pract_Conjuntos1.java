/*
Autora: Ruiz Marquez Ariel Megara
Grupo: 201
Licenciatura: Ciencias de Datos para Negocios
Practica de conjuntos.
*/


import java.util.*;

public class Pract_Conjuntos1 {
    public static void main(String[] args) {


      // A
        Set<Character> alfabeto = new HashSet<>();
        
        for (char letra = 'A'; letra <= 'Z'; letra++) {
          alfabeto.add(letra);
        }
        System.out.println("\n\n   >>>   El conjunto A con el alfabeto como elementos: \n\n" + alfabeto);

      
      //B
        Set<Integer> numerosPares1 = new HashSet<>();
        Set<Integer> numerosPares2 = new HashSet<>();
        for (int i = 2; i < 400; i= i+ 2) {
            numerosPares1.add(i);
            numerosPares2.add(i);
        }
        System.out.print("\n\n\n   >>>   El conjunto B de numeros naturales pares menores a 400 es: \n\n" + numerosPares1);


      // C
        Set<Integer> numeros1 = new HashSet<>();
        Set<Integer> numeros2 = new HashSet<>();
        for (int i = -300; i < 100; i++) {
            numeros1.add(i);
            numeros2.add(i);
        }
        System.out.println("\n\n\n   >>>   El conjunto C de numeros enteros mayor o igual a 300 y menores que 100 es: \n\n" + numeros1);

        SortedSet subconjunto = new TreeSet();
    
      
       // B unión C. metodo addAll
        numerosPares1.addAll(numeros1);
        System.out.println("\n\n\n   >>>   Conjunto B unión conjunto C: \n\n" + numerosPares1);

      // B subconjunto de C con SortedSet
        subconjunto.addAll(numeros1);
        subconjunto.addAll(numerosPares1);
        System.out.println("\n\n\n   >>>   B contenido en C: \n\n" + subconjunto.subSet(-300, 400));


      // Conjunto B intersección conjunto C
        numeros2.retainAll(numerosPares2);
        System.out.println("\n\n\n   >>>   Conjunto B intersección conjunto C: \n\n" + numeros2);
    }
}