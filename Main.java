/*Nombre: Leonardo Daniel Martínez Rosas
Grupo: 201
Licenciatura: Ciencia de Datos para Negocios
Practica de listas enlazadas 2.
*/





import java.util.*;


public class Main {
  public static void main (String [] args){
    Lista list = new Lista ();
    String dato = "";
    Scanner sc = new Scanner (System.in);
    while (!dato.equalsIgnoreCase("fin")){
      dato = sc.nextLine();
      if (!dato.equalsIgnoreCase("fin"))
        list.insertar(dato);
    }
    list.visualizar();
  }
}


class Nodo {
  String info;
  Nodo next;

  public Nodo (){
    next = null;
  }

  public Nodo (String info){
    this.info = info;
    next = null;
  }

  public Nodo (String info, Nodo next){
    this.info = info;
    this.next = next;
  }
}


class Lista {
  Nodo primero;

  public Lista (){
    primero = null;
  }
  public void insertar (String dato){
    Nodo temp = new Nodo (dato);
    temp.next = primero;
    primero = temp;
  }

  public void visualuizar () {
    Nodo n;
    n = primero = null;
  }
  public void visualizar (){
    Nodo n;
    n = primero;
    while (n != null){
      System.out.println (n.info);
      n = n.next;
    }
  }
}

