/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author juan7
 */
public class Alquiler implements SistemaNotificacion{

    private int dniUsuario;
    private String tituloLibro;
    private Date fechaAlquiler;
    private Date fechaEntrega;
    private boolean estadoAlquiler;
    SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");

    public Alquiler() {
    }

    public Alquiler(int dniUsuario, String tituloLibro, Date fechaAlquiler, Date fechaEntrega, boolean estadoAlquiler) {
        this.dniUsuario = dniUsuario;
        this.tituloLibro = tituloLibro;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaEntrega = fechaEntrega;
        this.estadoAlquiler = estadoAlquiler;
    }

    public int getDniUsuario() {
        return dniUsuario;
    }

    public void setDniUsuario(int dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public Date getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(Date fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public boolean isEstadoAlquiler() {
        return estadoAlquiler;
    }

    public void setEstadoAlquiler(boolean EstadoAlquiler) {
        this.estadoAlquiler = EstadoAlquiler;
    }

    public void pedirDatos(int dni, String libro, boolean estado) throws ParseException {

        try {
            dniUsuario = dni;
            tituloLibro = libro;
            fechaAlquiler = fecha.parse(JOptionPane.showInputDialog(null, "Ingresar fecha de prestamo formato dd/MM/yyyy"));
            fechaEntrega = fecha.parse(JOptionPane.showInputDialog(null, "Ingresar fecha de devolucion formato dd/MM/yyyy"));
            estadoAlquiler = estado;
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto");
        }
    }

    public String dato()  {
        String estado="";
        if(estadoAlquiler){
            estado="en curso";
        }else{
            estado="devuelto";
        }
 
        return "Tit. lib: " + tituloLibro + ", DNI us: " + dniUsuario + ", fech. al: " + fecha.format(fechaAlquiler) + ", fech ent:  " + fecha.format(fechaEntrega)+", est: "+estado;

    }

    @Override
    public void notificacion() {
        JOptionPane.showMessageDialog(null, "El alquiler fue realisado con exito");   
    
    }

    @Override
    public void notificacionError() {
        JOptionPane.showMessageDialog(null, "No se pudo completar la operacion");   

    }

    }

