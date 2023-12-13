/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author juan7
 */
public class Usuario implements SistemaNotificacion {

    private String nombre;
    private String apellido;
    private int dni;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void pedirDatos() {

        nombre = JOptionPane.showInputDialog(null, "Nombre del usuario");
        apellido = JOptionPane.showInputDialog(null, "Apellido del usuario");
        try {
            dni = (Integer.parseInt(JOptionPane.showInputDialog(null, "DNI del usuario")));
        } catch (HeadlessException | NumberFormatException e) {
            
        }

    }

    public String dato() {

        return "Usuario: " + nombre + " " + apellido + ",DNI " + dni;

    }

    @Override
    public void notificacion() {
        JOptionPane.showMessageDialog(null, "El usuario fue agregado con exito");
    }

    @Override
    public void notificacionError() {
        JOptionPane.showMessageDialog(null, "No puede haber espacios vacios y el DNI tiene que ser mayor a 8 digito");
    }

}
