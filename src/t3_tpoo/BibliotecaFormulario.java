/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package t3_tpoo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
/**
 * 
 *
 * @author NEISER
 */

public class BibliotecaFormulario {
    private static ArrayList<String> libros = new ArrayList<>();
    private static DefaultListModel<String> modeloLista = new DefaultListModel<>();
public class T3_Tpoo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
       JFrame pantalla = new JFrame("Biblioteca");
        pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pantalla.setSize(400, 400);
        pantalla.setLayout(null);

        
        JLabel labelID = new JLabel("ID:");
        JLabel labelTitulo = new JLabel("Título:");
        JLabel labelAutor = new JLabel("Autor:");
        JLabel labelCantidad = new JLabel("Cantidad:");

        labelID.setBounds(20, 20, 100, 20);
        labelTitulo.setBounds(20, 60, 100, 20);
        labelAutor.setBounds(20, 100, 100, 20);
        labelCantidad.setBounds(20, 140, 100, 20);

       
        JTextField textFieldID = new JTextField();
        JTextField textFieldTitulo = new JTextField();
        JTextField textFieldAutor = new JTextField();
        JTextField textFieldCantidad = new JTextField();

        textFieldID.setBounds(120, 20, 150, 20);
        textFieldTitulo.setBounds(120, 60, 150, 20);
        textFieldAutor.setBounds(120, 100, 150, 20);
        textFieldCantidad.setBounds(120, 140, 150, 20);

       
        JButton btnRegistrar = new JButton("Registrar");
        JButton btnListar = new JButton("Listar");

        btnRegistrar.setBounds(40, 180, 100, 30);
        btnListar.setBounds(160, 180, 100, 30);

        
        JList<String> listaLibros = new JList<>(modeloLista);
        JScrollPane scrollPane = new JScrollPane(listaLibros);
        scrollPane.setBounds(20, 230, 350, 100);

       
        btnRegistrar.addActionListener(e -> {
           try {
                String titulo = textFieldTitulo.getText();
                String autor = textFieldAutor.getText();
                int cantidad = Integer.parseInt(textFieldCantidad.getText());

                if (!titulo.isEmpty() && !autor.isEmpty()) {
                    Connection conexion = DatabaseConnection.getConnection();
                    Statement st = conexion.createStatement();
                    Libros nuevoLibro = new Libros(titulo, autor, cantidad);
                    DataAccess dao = new DataAccess(st, nuevoLibro);
                    dao.insertarLibro();
                    JOptionPane.showMessageDialog(null, "Libro registrado correctamente.");

                   
                    textFieldID.setText("");
                    textFieldTitulo.setText("");
                    textFieldAutor.setText("");
                    textFieldCantidad.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al registrar el libro.");
            }
        });

        
        btnListar.addActionListener(e -> {
             modeloLista.clear();
            try {
                Connection conexion = DatabaseConnection.getConnection();
                Statement st = conexion.createStatement();
                DataAccess dao = new DataAccess(st);
                List<Libros> libros = dao.getListaLibros();

                for (Libros libro : libros) {
                    modeloLista.addElement(libro.toString());  
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al listar los libros.");
            }
        });

        
        pantalla.add(labelID);
        pantalla.add(labelTitulo);
        pantalla.add(labelAutor);
        pantalla.add(labelCantidad);
        pantalla.add(textFieldID);
        pantalla.add(textFieldTitulo);
        pantalla.add(textFieldAutor);
        pantalla.add(textFieldCantidad);
        pantalla.add(btnRegistrar);
        pantalla.add(btnListar);
        pantalla.add(scrollPane);

        pantalla.setVisible(true);
    } 
        
        
        
    }
    
}
