/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

/**
 *
 * @author Esteban
 */
//@Entity
//@Table(name = "Ciudad")
public class Ciudad implements Serializable{ 
    
    //@Id
    //@GeneratedValue
    //@Column(name = "idCiudad")
    private int idCiudad;

    //@Column(name = "Nombre")
    private String nombre;

    //@OneToMany
    List<Alumno> alumnos = new ArrayList<Alumno>();

    public Ciudad() {
    }

    public Ciudad(String nombre) {
        this.nombre = nombre;
    }

    public Ciudad(int idCiudad, String nombre) {
            this.idCiudad = idCiudad;
            this.nombre = nombre;
    }
    
    public Ciudad(int idCiudad, String nombre, ArrayList<Alumno> alumnos) {
            this.idCiudad = idCiudad;
            this.nombre = nombre;
            this.alumnos = alumnos;
    }

    public int getIdCiudad() {
            return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
            this.idCiudad = idCiudad;
    }


    public String getNombre() {
            return nombre;
    }

    public void setNombre(String Nombre) {
            this.nombre = Nombre;
    }

    public List<Alumno> getAlumnos(){
            return this.alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos){
            this.alumnos = (List<Alumno>) alumnos;
    }

    @Override
    public String toString(){
            return "idCiudad: "+idCiudad+", Ciudad: "+nombre+"\n";
    } 
}