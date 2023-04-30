/*
Autora: Ruiz Marquez Ariel Megara
Grupo: 201
Licenciatura: Ciencias de Datos para Negocios
Práctica de Conjunto 2.
*/

import java.util.*;


public class Pract_Conjuntos2 {
    public static void main(String[] args) {

        Set<Integer> conjuntob = new HashSet<>();
        Set<Integer> conjuntoc = new HashSet<>();

        Set<Integer> union = new HashSet<>();
        Set<Integer> interseccion = new HashSet<>(); 

        Set<Integer> conjuntob2 = new HashSet<>();
        Set<Integer> conjuntoc2 = new HashSet<>();


        for (int i = 1; i <= 1000; i++) { 
            if ((i % 3) == 0) {
                conjuntob.add(i);
                conjuntob2.add(i);
                
            }
            
            if ((i % 5) == 0) {
                conjuntoc.add(i);
                conjuntoc2.add(i);
            }
        }
        

        System.out.println("\n>>> Conjunto B de números divisibles entre 3: \n" + conjuntob +"\n");
        System.out.println("\n>>> Conjunto C de números divisibles entre 5: \n" + conjuntoc + "\n");

        
        // INTERSECCION DE B Y C 
        conjuntob.retainAll(conjuntoc);
        System.out.println("\n>>> La interseccion de los conjuntos B y C es: \n" + conjuntob + "\n");
        
        
        // UNION DE B Y C
        conjuntob2.addAll(conjuntoc2);
        System.out.println("\n>>> La union de los conjuntos B y C es: \n" + conjuntob2 + "\n");

        
        //(B u C)- (B n C) 

        union.addAll(conjuntob2);
        interseccion.addAll(conjuntob);
        union.removeAll(interseccion);
        System.out.println("\n>>> B+C = <B u C> - <B n C> es igual a: \n" + union);         
    }
}  