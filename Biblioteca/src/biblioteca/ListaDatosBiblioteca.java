package biblioteca;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class ListaDatosBiblioteca implements SistemaNotificacion {

    List<Usuario> listaUsuario = new ArrayList<>();
    List<Libro> listaLibro = new ArrayList<>();
    List<Alquiler> listaAlquiler = new ArrayList<>();
    SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");

    public ListaDatosBiblioteca() {
    }

    public void crearLista() {
        listaLibro = new ArrayList();
        listaUsuario = new ArrayList();
        listaAlquiler = new ArrayList();
    }

    public void agregarAlquiler(Alquiler alquiler, int posicion1, boolean estado) {
        listaAlquiler.add(alquiler);
        listaLibro.get(posicion1).setEstado(estado);

    }

    public void agregarLibro(Libro libro) {
        listaLibro.add(libro);
    }

    public void agregarUsuario(Usuario usuario) {
        listaUsuario.add(usuario);
    }

    public int mostrarLista() {
        String mostrar = "";
        for (Libro lib : listaLibro) {

            mostrar += lib.dato() + "\n";
        }
        String libro = JOptionPane.showInputDialog(null, "Ingrese nombre,autor o genero del libro\n\n" + mostrar).toLowerCase();

        int pos = -1;
        for (int i = 0; i < listaLibro.size(); i++) {
            if (listaLibro.get(i).getTitulo().toLowerCase().equals(libro)) {
                pos = i;
            }
        }

        for (int i = 0; i < listaLibro.size(); i++) {
            if (listaLibro.get(i).getAutor().toLowerCase().equals(libro)) {
                pos = i;
            }
        }

        for (int i = 0; i < listaLibro.size(); i++) {
            if (listaLibro.get(i).getGenero().toLowerCase().equals(libro)) {
                pos = i;
            }
        }

        if (pos == -1) {
            notificacionError();
        } else {

            /*
        if (listaLibro.get(pos).isEstado()) {

            JOptionPane.showMessageDialog(null, "No esta disponible");

        } else {
            int confirmado = JOptionPane.showConfirmDialog(null, "¿Deseas alquilar el libro?");
            if (JOptionPane.OK_OPTION == confirmado){JOptionPane.showMessageDialog(null, "alquilado");}
        }*/
        }
        return pos;
    }

    public void borrarLibro(int pos) {
        listaLibro.remove(pos);
        notificacion();
    }

    public int mostrarListaUsuario() {

        String mostrar = "";
        for (Usuario us : listaUsuario) {

            mostrar += us.dato() + "\n";
        }

        String usuario = JOptionPane.showInputDialog(null, "Ingrese DNI del usuario\n\n" + mostrar);
        if (usuario == null) {
            usuario = "0";
        }
        int pos = -1;
        for (int i = 0; i < listaUsuario.size(); i++) {
            try {
                if (listaUsuario.get(i).getDni() == Integer.parseInt(usuario)) {
                    pos = i;
                }
            } catch (Exception e) {
            }
        }
        if (pos == -1) {

            notificacionError();
        }

        return pos;

    }

    public void borrarUsuario(int pos) {
        listaUsuario.remove(pos);
        notificacion();
    }

    public void buscarAlquiler(int posicion1) throws ParseException {
        int pos = -1;

        for (int i = 0; i < listaAlquiler.size(); i++) {
            if (listaAlquiler.get(i).getTituloLibro().equals(listaLibro.get(posicion1).getTitulo())) {
                pos = i;
            }
        }
        if (pos != -1) {
            try {

                Date entrega = fecha.parse(JOptionPane.showInputDialog(null, "Ingresar fecha de prestam formato dd/MM/yyyy"));

                listaAlquiler.get(pos).setEstadoAlquiler(false);
                listaLibro.get(posicion1).setEstado(false);
                if (entrega.after(listaAlquiler.get(pos).getFechaEntrega())) {
                    JOptionPane.showMessageDialog(null, "Se devolvio con retraso");

                } else {
                    JOptionPane.showMessageDialog(null, "Se devolvio en tiempo y forma");

                }
            } catch (Exception e) {

            }
            //listaAlquiler.remove(pos);

        } else {
            //notificacionError();
        }

    }

    public void listaAlquileres() {

        String mostrar = "";
        for (Alquiler al : listaAlquiler) {

            mostrar += al.dato() + "\n";
        }
        JOptionPane.showMessageDialog(null, "Lista de alquileres\n\n" + mostrar);

    }

    @Override
    public void notificacion() {
        JOptionPane.showMessageDialog(null, "operacion exitosa");

    }

    @Override
    public void notificacionError() {
        JOptionPane.showMessageDialog(null, "No se encontro la busqueda");

    
    }
}
