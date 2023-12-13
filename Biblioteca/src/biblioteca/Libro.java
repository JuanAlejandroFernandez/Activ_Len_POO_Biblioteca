/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

import javax.swing.JOptionPane;

/**
 *
 * @author juan7
 */
public class Libro implements SistemaNotificacion {
    private String titulo;
    private String autor;
    private String genero;
    private boolean estado;

    public Libro(){};
    public Libro(String titulo, String autor, String genero, boolean devuelto) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.estado = devuelto;

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean devuelto) {
        this.estado = devuelto;
    }

  public void pedirDatos(){
      
     titulo=(JOptionPane.showInputDialog(null, "Titulo del libro"));
     autor=(JOptionPane.showInputDialog(null, "Autor del libro"));
     genero=(JOptionPane.showInputDialog(null, "Genero del libro"));
     estado=(false);
      
  }

  public String dato(){
      
      String estadoLibro="";
      
      if(estado){estadoLibro="alquilado";}else{
          estadoLibro="disponible";
      }
      
      return "Libro: "+titulo+", "+autor+", "+genero+", "+estadoLibro;
      
  }  

    @Override
    public void notificacion() {
                    JOptionPane.showMessageDialog(null, "El libro fue agregado con exito");

    }

    @Override
    public void notificacionError() {
                    JOptionPane.showMessageDialog(null, "Tiene que ingresar una palabra de 3 o mas letras ");

    }
  
  
  
}
