import java.util.Scanner;
/*
Ruiz Marquez Ariel Megara
Grupo: LCDN - 201
GAM - OCE
Agenda con listas enlazadas

Explicación:
El programa representa una agenda de contactos utilizando una lista enlazada. Permite agregar, buscar, editar y eliminar contactos. 
Los contactos estan formados por: nombre, teléfono, dirección, correo electrónico, parentesco y categoría. 

Método main: se encarga de llamar a los métodos correspondientes de la clase Agenda de acuerdo a la opción elegida por el usuario.

Se crean distintas clases:
 - Agenda: utiliza la lista enlazada para administrar los contactos. Además tiene métodos que ayudan a agregar, buscar, editar y eliminar contactos.
 - Contacto: es la que da las propiedades de los contactos. Esta formada por nombre, teléfono, dirección, correo electrónico, parentesco y categoría. Se le agregan métosoas para que se pueda acceder al contacto asi como modificarlo.
 - NodoContacto: Es para hacer psoible guardar los contactos en la agenda.

Scanner: lee cadenas de texto y elementos númericos ingresados por el usuario.

System.out.println: manda mensajes en la pantalla para ser visualizados por el usuario.

*/

// Clase para representar un contacto
class Contacto {
    String nombre;
    Integer telefono;
    String direccion;
    String correo;
    String parentesco;
    String categoria;
    Contacto siguiente;

    // Constructor
    public Contacto(String nombre, Integer telefono, String direccion, String correo, String parentesco, String categoria) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.parentesco = parentesco;
        this.categoria = categoria;
        this.siguiente = null;
    }
}

// Clase para representar la agenda
class Agenda {
    Contacto cabeza; // Primer contacto en la lista

    // Constructor
    public Agenda() {
        cabeza = null;
    }

    // Método para agregar un contacto a la agenda
    public void agregarContacto(Contacto nuevoContacto) {
        if (cabeza == null) {
            // Si la lista está vacía, el nuevo contacto será la cabeza
            cabeza = nuevoContacto;
        } else {
            // Si la lista no está vacía, agregamos el nuevo contacto al final
            Contacto actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoContacto;
        }
        System.out.println("Contacto agregado: " + nuevoContacto.nombre);
    }

    // Método para eliminar un contacto de la agenda
    public void eliminarContacto(String nombre) {
        if (cabeza == null) {
            // Si la lista está vacía, no hay contactos para eliminar
            System.out.println("La agenda está vacía.");
            return;
        }

        if (cabeza.nombre.equals(nombre)) {
            // Si el primer contacto es el que se desea eliminar
            Contacto eliminado = cabeza;
            cabeza = cabeza.siguiente;
            eliminado.siguiente = null;
            System.out.println("Contacto eliminado: " + eliminado.nombre);
            return;
        }

        // Buscamos el contacto a eliminar
        Contacto actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.nombre.equals(nombre)) {
            actual = actual.siguiente;
        }

        if (actual.siguiente == null) {
            // El contacto no fue encontrado
            System.out.println("No se encontró el contacto: " + nombre);
        } else {
            // Eliminamos el contacto
            Contacto eliminado = actual.siguiente;
            actual.siguiente = actual.siguiente.siguiente;
            eliminado.siguiente = null;
            System.out.println("Se ha eliminado el contacto: " + eliminado.nombre);
        }
    }

    // Método para buscar un contacto por nombre
    public void buscarContacto(String nombre) {
        if (cabeza == null) {
            // Si la lista está vacía, no hay contactos para buscar
            System.out.println("No hay contactos en la agenda.");
            return;
        }

        Contacto actual = cabeza;
        while (actual != null) {
            if (actual.nombre.equals(nombre)) {
                // Se encontró el contacto
                System.out.println("👤 Nombre: " + actual.nombre);
                if (actual.telefono != null) {
                    System.out.println("📞 Teléfono: " + actual.telefono);
                }
                if (actual.direccion != null) {
                    System.out.println("🏡 Dirección: " + actual.direccion);
                }
                if (actual.correo != null) {
                    System.out.println("✉️  Correo electrónico: " + actual.correo);
                }
                if (actual.parentesco != null) {
                    System.out.println("👥 Parentesco: " + actual.parentesco);
                }
                if (actual.categoria != null) {
                    System.out.println("🏷️  Categoría: " + actual.categoria);
                }
                return;
            }
            actual = actual.siguiente;
        }

        // El contacto no fue encontrado
        System.out.println("No se encontró el contacto: " + nombre);
    }

    // Método para editar un contacto
    public void editarContacto(String nombre) {
        if (cabeza == null) {
            // Si la lista está vacía, no hay contactos para editar
            System.out.println("No hay contactos en la agenda.");
            return;
        }
    
        Contacto actual = cabeza;
        while (actual != null) {
            if (actual.nombre.equals(nombre)) {
                // Se encontró el contacto, permitir la edición de sus campos
                Scanner scanner = new Scanner(System.in);
    
                System.out.println("👤 Nuevo nombre (" + actual.nombre + "):");
                String nuevoNombre = scanner.nextLine();
                if (!nuevoNombre.isEmpty()) {
                    actual.nombre = nuevoNombre;
                }
    
                System.out.println("📞 Nuevo teléfono (" + actual.telefono + "):");
                String telefonoStr = scanner.nextLine();
                if (!telefonoStr.isEmpty()) {
                    try {
                        Integer nuevoTelefono = Integer.parseInt(telefonoStr);
                        actual.telefono = nuevoTelefono;
                    } catch (NumberFormatException e) {
                        System.out.println("Ingresa sólo números para el teléfono");
                        return;
                    }
                }
    
                System.out.println("🏡 Nueva dirección (" + actual.direccion + "):");
                String nuevaDireccion = scanner.nextLine();
                if (!nuevaDireccion.isEmpty()) {
                    actual.direccion = nuevaDireccion;
                }
    
                System.out.println("✉️  Nuevo correo electrónico (" + actual.correo + "):");
                String nuevoCorreo = scanner.nextLine();
                if (!nuevoCorreo.isEmpty()) {
                    actual.correo = nuevoCorreo;
                }
    
                System.out.println("👥 Nuevo parentesco (" + actual.parentesco + "):");
                String[] parentescos = {"Madre", "Padre", "Herman@", "Otro"};
                for (int i = 0; i < parentescos.length; i++) {
                    System.out.println((i + 1) + ". " + parentescos[i]);
                }
                String parentescoStr = scanner.nextLine();
                if (!parentescoStr.isEmpty()) {
                    int opcionParentesco = Integer.parseInt(parentescoStr);
                    if (opcionParentesco >= 1 && opcionParentesco <= parentescos.length) {
                        actual.parentesco = parentescos[opcionParentesco - 1];
                    } else {
                        System.out.println("Opción de parentesco inválida");
                        return;
                    }
                }
    
                System.out.println("🏷️  Nueva categoría (" + actual.categoria + "):");
                String[] categorias = {"Empresa", "Trabajo", "Casa", "Oficina", "Personal", "Celular", "Otro"};
                for (int i = 0; i < categorias.length; i++) {
                    System.out.println((i + 1) + ". " + categorias[i]);
                }
                String categoriaStr = scanner.nextLine();
                if (!categoriaStr.isEmpty()) {
                    int opcionCategoria = Integer.parseInt(categoriaStr);
                    if (opcionCategoria >= 1 && opcionCategoria <= categorias.length) {
                        actual.categoria = categorias[opcionCategoria - 1];
                    } else {
                        System.out.println("Opción de categoría inválida");
                        return;
                    }
                }
    
                System.out.println("Contacto editado: " + actual.nombre);
                return;
            }
            actual = actual.siguiente;
        }
    
        // El contacto no fue encontrado
        System.out.println("No se encontró el contacto: " + nombre);
    }

}

// Clase principal que contiene el método main
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();

        while (true) {
            System.out.println("¿Qué quieres realizar?");
            System.out.println("1. Agregar contacto ⭐️");
            System.out.println("2. Buscar contacto 🔍");
            System.out.println("3. Editar contacto ✏️");  // Opción agregada
            System.out.println("4. Eliminar contacto ❌");
            System.out.println("5. Salir 🔼");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            if (opcion == 1) {
                System.out.println("👤 Nombre:");
                String nombre = scanner.nextLine();
                System.out.println("📞 Teléfono:");
                String telefonoStr = scanner.nextLine();
                Integer telefono = null;
                if (!telefonoStr.isEmpty()) {
                    try {
                        telefono = Integer.parseInt(telefonoStr);
                    } catch (NumberFormatException e) {
                        System.out.println("Ingresa sólo números para el teléfono");
                        continue;
                    }
                }
                System.out.println("🏡 Dirección:");
                String direccion = scanner.nextLine();
                System.out.println("✉️  Correo electrónico:");
                String correo = scanner.nextLine();
                System.out.println("👥 Parentesco:");
                String[] parentescos = {"Madre", "Padre", "Herman@", "Otro"};
                for (int i = 0; i < parentescos.length; i++) {
                    System.out.println((i + 1) + ". " + parentescos[i]);
                }
                String parentescoStr = scanner.nextLine();
                String parentesco = null;
                if (!parentescoStr.isEmpty()) {
                    int opcionParentesco = Integer.parseInt(parentescoStr);
                    if (opcionParentesco >= 1 && opcionParentesco <= parentescos.length) {
                        parentesco = parentescos[opcionParentesco - 1];
                    } else {
                        System.out.println("Opción de parentesco inválida");
                        continue;
                    }
                }
                System.out.println("🏷️  Categoría:");
                String[] categorias = {"Empresa", "Trabajo", "Casa", "Oficina", "Personal", "Celular", "Otro"};
                for (int i = 0; i < categorias.length; i++) {
                    System.out.println((i + 1) + ". " + categorias[i]);
                }
                String categoriaStr = scanner.nextLine();
                String categoria = null;
                if (!categoriaStr.isEmpty()) {
                    int opcionCategoria = Integer.parseInt(categoriaStr);
                    if (opcionCategoria >= 1 && opcionCategoria <= categorias.length) {
                        categoria = categorias[opcionCategoria - 1];
                    } else {
                        System.out.println("Opción de categoría inválida");
                        continue;
                    }
                }

                Contacto nuevoContacto = new Contacto(nombre, telefono, direccion, correo, parentesco, categoria);
                agenda.agregarContacto(nuevoContacto);
            } else if (opcion == 2) {
                System.out.println("Contacto a buscar:");
                String nombre = scanner.nextLine();
                agenda.buscarContacto(nombre);
            } else if (opcion == 3) {
                System.out.println("Contacto a editar:");
                String nombre = scanner.nextLine();
                agenda.editarContacto(nombre);
            } else if (opcion == 4) {
                System.out.println("Contacto a eliminar:");
                String nombre = scanner.nextLine();
                agenda.eliminarContacto(nombre);
            } else if (opcion == 5) {
                System.out.println("✨¡Adiós!😸");
                break;
            } else {
                System.out.println("Intenta una opción válida.");
            }
        }
    }
}
