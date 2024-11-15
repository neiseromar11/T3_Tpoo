/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t3_tpoo;

/**
 *
 * @author NEISER
 */
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class DatabaseConnection {
    
     private static final String URL="jdbc:mysql://localhost:3306/biblioteca";
    private static final String USER="root";
    private static final String PASSWORD="admin";
    
    
    public static Connection getConnection(){
    Connection connection=null;
    
    try{
        connection= DriverManager.getConnection(URL,USER,PASSWORD);
        System.out.println("Connection established successfully.");
        
    }catch (SQLException e){
        e.printStackTrace();
    
    }
    return connection;
    }
    
      public static void main(String[] args) {
       Connection conexion= getConnection();
      try{
          Statement st=conexion.createStatement();
          DataAccess dao =new DataAccess(st);
          
          //ResultSet rs=st.executeQuery("Select * from usuario");
          List<Libros> libros = dao.getListaLibros();
          //iterarResultado(st);
             /*********************************/
          Libros nuevoLibro =new Libros("Cien Años de Soledad", "Gabriel García Márquez", 10);
          DataAccess dao2=new DataAccess(st,nuevoLibro);
            dao2.insertarLibro();
             /*************************************************/
          Libros libroEliminar = new Libros (6);
          DataAccess dao3=new DataAccess(st,libroEliminar);
            dao3.eliminarLibro();
      
      }catch(Exception s){
      }
      }

    
}
