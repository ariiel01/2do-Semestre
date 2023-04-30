/*
Autora: Ruiz Marquez Ariel Megara
Grupo: 201
Licenciatura: Ciencias de Datos para Negocios
Practica Tokens
*/


import java.util.*;

public class Pract_Token {

   public static void main (String[] args){
     Token token = new Token();
     System.out.println(token.obtenerAlfabeto());
     System.out.println(token.generarToken());
     
      ArrayDeque<String> cola = new ArrayDeque<>();
        for (int i =0;i<=10;i++) {
            cola.add(token.generarToken());
        }
        System.out.println(cola);
        Iterator tokenGuardados = cola.iterator();
        System.out.println("Los valores de la lista de tokens es: ");
        while (tokenGuardados.hasNext()) {
            System.out.println(tokenGuardados.next());

        }
   }//fin de main
  

}//fin clase Myclass


class Token{

  public String obtenerAlfabeto(){
    
    String alfabeto ="";
     char x = 'A';
    for (int i =0;i<=25;i++){
      String charToString =String.valueOf(x++);
      System.out.println(charToString);
      //iteramos caracter y concatenamos en alfabeto
      alfabeto=alfabeto.concat(charToString);      
    }// fin de while
    return alfabeto;
  }//
  public String generarToken(){
    String token="";
    Random random = new Random();
     //Caracter de token
    String alfabeto = obtenerAlfabeto();
    for(int i=0;i<=3;i++){
    	char c = alfabeto.charAt(random.nextInt(alfabeto.length()));
      String charToString =String.valueOf(c);
      token = token.concat(charToString);
    }    
   return token;
  }
}
