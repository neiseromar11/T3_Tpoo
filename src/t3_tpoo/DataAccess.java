/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t3_tpoo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NEISER
 */
public class DataAccess {
     private Statement st;
    private Libros libro;
    public DataAccess(Statement st) {
        this.st = st;
    }

    public DataAccess(Statement st, Libros libro) {
        this.st = st;
        this.libro = libro;
    }
    
    public  void eliminarLibro() throws SQLException {
    st.execute("delete from libros where idlibros="+libro.getIdlibros());
    }

    public  void insertarLibro() throws SQLException {
        String nuevoTitulo=libro.getTitulo();
        String nuevoAutor=libro.getAutor();
        int nuevoCantidad=libro.getCantidad();
        
        st.execute("Insert into libros (titulo,autor,cantidad)"
                + " values('"+nuevoTitulo+"','"+nuevoAutor+"','"+nuevoCantidad+"')");
      }
      
  
    public  List <Libros> getListaLibros() throws SQLException {
        ResultSet rs=st.executeQuery("Select * from libros");
        List<Libros> libros=new ArrayList<>();
        while(rs.next()){
            Libros libro = new Libros(rs);
           libros.add(libro);     
        }
        return libros;
    }
}
