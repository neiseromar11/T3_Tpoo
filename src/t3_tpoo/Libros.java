/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t3_tpoo;

import java.sql.ResultSet;

/**
 *
 * @author NEISER
 */
public class Libros {
   private int idlibros;
   private String titulo;
   private String autor;
   private int cantidad;

    public Libros(int idlibros, String titulo, String autor, int cantidad) {
        this.idlibros = idlibros;
        this.titulo = titulo;
        this.autor = autor;
        this.cantidad = cantidad;
    }
    
     public Libros (ResultSet rs){
    try{
    this.idlibros= rs.getInt(1);
    this.titulo=rs.getString(2);
    this.autor= rs.getString(3);
    this.cantidad=rs.getInt(4);
    
    }catch (Exception s){
    }}
    public String getLibroText(){
     return("ID: "+ idlibros +" TITULO: "+ titulo + " AUTOR: "+ autor+"CANTIDAD: "+ cantidad);
     
     }

    public Libros(int idlibros) {
        this.idlibros = idlibros;
    }
     
    public void imprimirDatos(){
      System.out.println("ID: "+ idlibros +" TITULO: "+ titulo + " AUTOR: "+ autor+"CANTIDAD: "+ cantidad);
       
    }
    
     
    public Libros(String titulo, String autor, int cantidad) {
        this.titulo = titulo;
        this.autor = autor;
        this.cantidad = cantidad;
    }

    public int getIdlibros() {
        return idlibros;
    }

    public void setIdlibros(int idlibros) {
        this.idlibros = idlibros;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
