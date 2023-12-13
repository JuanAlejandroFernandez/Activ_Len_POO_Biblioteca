package biblioteca;

import java.awt.HeadlessException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Biblioteca {

    public static void main(String[] args) throws ParseException {

        Libro libro1 = new Libro("La llamada de la tribu", "Mario Vargas Llosa", "autobigrafia", false);
        Libro libro2 = new Libro("la invitada", "Jennifer McMahon", "terror", false);
        Libro libro3 = new Libro("Desarmadero", "Eugenia Almeida", "novela policial", false);
        Libro libro4 = new Libro("Elcastillo de barba azul", "Javier Cercas", "novela policial", false);
        Libro libro5 = new Libro("El moustro de colores", "Anna Llenas", "infantil", false);
        ListaDatosBiblioteca biblioteca = new ListaDatosBiblioteca();
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);
        biblioteca.agregarLibro(libro4);
        biblioteca.agregarLibro(libro5);

        Usuario usuario1 = new Usuario("Pablo", "Flores", 12345671);
        Usuario usuario2 = new Usuario("Maria", "Funez", 12345672);
        Usuario usuario3 = new Usuario("Carlos", "Gonsalez", 12345673);
        Usuario usuario4 = new Usuario("Marta", "Mercado", 12345674);
        Usuario usuario5 = new Usuario("Roberto", "Altavista", 12345675);

        biblioteca.agregarUsuario(usuario1);
        biblioteca.agregarUsuario(usuario2);
        biblioteca.agregarUsuario(usuario3);
        biblioteca.agregarUsuario(usuario4);
        biblioteca.agregarUsuario(usuario5);

        String opcion = "";
        do {

            opcion = JOptionPane.showInputDialog(null, "***BIBLIOTECA***\n\n1.Registrar un usuario\n2.Registrar un libro\n3.Buscar y alquilar un libro\n4.Devolver un libro\n5.Dar de baja un libro\n6.Dar de baja un usuario\n7.Lista de alquileres\n8.Salir\nElija una opccion");
            if(opcion==null){opcion="8";}
            switch (opcion) {
                case "1":
                    Usuario usuario = new Usuario();
                    usuario.pedirDatos();
                    if (usuario.getNombre().trim().length() > 2 && usuario.getApellido().trim().length() > 2 && usuario.getDni() > 10000000) {
                        biblioteca.agregarUsuario(usuario);
                        usuario.notificacion();
                    }else{
                        usuario.notificacionError();
                    }

                    break;
                case "2":
                    Libro libro = new Libro();
                    libro.pedirDatos();
                    if (libro.getTitulo().trim().length() > 2 && libro.getAutor().trim().length() > 2 && libro.getGenero().trim().length() > 3) {                        
                        biblioteca.agregarLibro(libro);
                        libro.notificacion();
                    }else{
                        libro.notificacionError();
                    }
                    break;
                case "3":
                    Alquiler alquiler = new Alquiler();
                    int posicion = biblioteca.mostrarLista();
                    int posicion2 = -1;
                    if (posicion >= 0) {
                        posicion2 = biblioteca.mostrarListaUsuario();
                    }

                    if (posicion >= 0 && posicion2 >= 0 && !biblioteca.listaLibro.get(posicion).isEstado()) {

                        int dni = biblioteca.listaUsuario.get(posicion2).getDni();
                        String lib = biblioteca.listaLibro.get(posicion).getTitulo();

                        alquiler.pedirDatos(dni, lib, true);
                        try {
                            if (alquiler.getFechaEntrega().after(alquiler.getFechaAlquiler())) {
                                biblioteca.agregarAlquiler(alquiler, posicion, true);
                                alquiler.notificacion();
                            } else {
                                alquiler.notificacionError();
                            }
                        } catch (Exception e) {
                        }

                    }

                    break;
                case "4":

                    posicion = biblioteca.mostrarLista();

                    biblioteca.buscarAlquiler(posicion);

                    break;
                case "5":
                    posicion = biblioteca.mostrarLista();
                    if (posicion >= 0) {
                        biblioteca.borrarLibro(posicion);
                    }
                    break;

                case "6":

                    posicion = biblioteca.mostrarListaUsuario();
                    if (posicion >= 0) {
                        biblioteca.borrarUsuario(posicion);
                    }
   
                    break;
                case "7":
                    biblioteca.listaAlquileres();
                    
                    break;

                default:

            }

        } while (!"8".equals(opcion));
    }

}
