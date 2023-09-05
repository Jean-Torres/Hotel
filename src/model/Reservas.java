/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Reservas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String formaDePago;
    @Temporal(TemporalType.DATE)
    private Date fechaEntrada = null;
    @Temporal(TemporalType.DATE)
    private Date fechaSalida = null;
    private double ValorPagado;

    public Reservas() {
    }

    public Reservas(int id, String formaDePago, Date fechaEntrada, Date fechaSalida, double ValorPagado) {
        this.id = id;
        this.formaDePago = formaDePago;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.ValorPagado = ValorPagado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void setValorPagado(double ValorPagado) {
        this.ValorPagado = ValorPagado;
    }

    public int getId() {
        return id;
    }

    public String getFormaDePago() {
        return formaDePago;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public double getValorPagado() {
        return ValorPagado;
    }

    @Override
    public String toString() {
        return "Reservas{" + "id=" + id + ", formaDePago=" + formaDePago + ", fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida + ", ValorPagado=" + ValorPagado + '}';
    }

}
