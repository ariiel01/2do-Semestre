/*
Autora: Ruiz Marquez Ariel Megara
Grupo: 201
Licenciatura: Ciencias de Datos para Negocios
Práctica Capicua
*/

class Pract_Capicuas {
  public static void main(String[] args) {
    long valor = 543780323087345L;
    long faltante, alReves, restante;
    while(valor <= 0);
    faltante = valor;
    alReves = 0;
    restante =0;
      while(faltante != 0)
    {
     restante = faltante % 10;
     alReves = alReves * 10 + restante;
     faltante = faltante / 10;
    }
  if(alReves == valor)
    System.out.println("\nEl numero "+ valor + " es capicua\n");
  else
     System.out.println("\nEl numero "+ valor + " no es capicua\n");
  }  
}