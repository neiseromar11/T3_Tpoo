/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t3_tpoo;

/**
 *
 * @author NEISER
 */
public class Estudiante {
    private int id;
    private String nombreCompleto;
    private String carrera;

    public Estudiante(String nombreCompleto, String carrera) {
        this.nombreCompleto = nombreCompleto;
        this.carrera = carrera;
    }

    public Estudiante(int id, String nombreCompleto, String carrera) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.carrera = carrera;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
}
