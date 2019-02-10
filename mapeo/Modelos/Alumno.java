/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Esteban
 */
//@Entity
//@Table(name = "Alumno")
public class Alumno implements Serializable{
    //@Id
    //@GeneratedValue
    //@Column(name = "idAlumno")
    private int idAlumno;

    //@Column(name = "Nombre")
    private String nombre;

    //@Column(name = "Sexo")
    private String sexo;

    //@Column(name = "edad")
    private int edad;

    //@Column(name = "idCiudad")
    private int idCiudad;

    //@ManyToOne
    Ciudad ciudad;

    public Alumno() {
    }

    public Alumno(String nombre, String sexo, int edad, int idCiudad) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.idCiudad = idCiudad;
    }
    
    public Alumno(int idAlumno, String nombre, String sexo, int edad, int idCiudad) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.idCiudad = idCiudad;
    }

    public Alumno(int idAlumno, String nombre, String sexo, int edad) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
    }

    public int getIdAlumno() {
            return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
            this.idAlumno = idAlumno;
    }


    public String getNombre() {
            return nombre;
    }

    public void setNombre(String Nombre) {
            this.nombre = Nombre;
    }

    public String getSexo() {
            return sexo;
    }

    public void setSexo(String Sexo) {
            this.sexo = Sexo;
    }

    public int getEdad() {
            return edad;
    }

    public void setEdad(int edad) {
            this.edad = edad;
    }

    public int getIdCiudad() {
            return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
            this.idCiudad = idCiudad;
    }

    public Ciudad getCiudad(){
            return this.ciudad;
    }

    public void setCiudad(Ciudad ciudad){
            this.ciudad = ciudad;
    }

    @Override
    public String toString(){
            return "idAlumno: "+this.idAlumno+", Nombre: "+this.nombre+"\n";
    }
}
