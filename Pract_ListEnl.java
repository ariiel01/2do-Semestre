/*
Autora: Ruiz Marquez Ariel Megara
Grupo: 201
Licenciatura: Ciencias de Datos para Negocios
Práctica Listas enlazadas.
*/

import java.time.DayOfWeek;
import java.util.*;


public class Pract_ListEnl {
    public static void main(String args[]) {
        
        LinkedList <AgendaT> agenda = new LinkedList  <AgendaT>();

        agenda.add(new AgendaT("Palillo", "55-50415522"));
        agenda.add(new AgendaT("Juancho", "55-89784512"));
        agenda.add(new AgendaT("Juano", "55-23568941"));
        agenda.add(new AgendaT("Nene", "55-12213256"));
        agenda.add(new AgendaT("Juana","55-45788965"));
        agenda.add(new AgendaT("Juanchisco", "55-41258596"));
        

        Iterator<AgendaT> recorrido = agenda.iterator();
        AgendaT et;
        System.out.println("Itera o muestra la lista en " + "direcci\u00a2n normal:");
        while (recorrido.hasNext()) {
            et = recorrido.next();
            System.out.println(et.nombre + ": " + et.numero);
        }
        System.out.println();

        ListIterator<AgendaT> litr
                = agenda.listIterator(agenda.size());
        System.out.println("Itera o muestra la lista en "+ "direcci\u00a2n inversa:");
        while (litr.hasPrevious()) {
            et = litr.previous();
            System.out.println(et.nombre + ": " + et.numero);
        }
    }
}
