/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author jean torres
 */
@Entity
public class Huespedes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombres;
    private String apellidos;
    private String nacionalidad;
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    private String telefono;
    @ManyToOne
    private Reservas reserva;

    public Huespedes() {
    }

    public Huespedes(int id, String nombres, String apellidos, String nacionalidad, Date fechaNacimiento, String telefono, Reservas reserva) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.reserva = reserva;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setReserva(Reservas reservas) {
        this.reserva = reservas;
    }

    public int getId() {
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public Reservas getReserva() {
        return reserva;
    }

    @Override
    public String toString() {
        return "Huespedes{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", nacionalidad=" + nacionalidad + ", fechaNacimiento=" + fechaNacimiento + ", telefono=" + telefono + ", reserva=" + reserva + '}';
    }
}
