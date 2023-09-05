/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

/**
 *
 * @author jean torres
 */
import java.util.ArrayList;
import model.Huespedes;
import model.Reservas;
import persistence.controladoraPersistencia;

public class ControllerLogica {

    controladoraPersistencia ctrlPersis = new controladoraPersistencia();

    public void CreateReserva(Reservas reserva) {
        ctrlPersis.createReserva(reserva);
    }

    public void DeleteReserva(int id) {
        ctrlPersis.deleteReserva(id);
    }

    public void EditReserva(Reservas reserva) {
        ctrlPersis.editReserva(reserva);
    }

    public Reservas FindOneReserva(int id) {
        return ctrlPersis.FindOneRegistro(id);
    }

    public ArrayList<Reservas> FindAllReservas() {
        return ctrlPersis.FindAllRegistro();
    }

    public int getIdReserva() {
        return ctrlPersis.getIdRegistro();
    }

    //Huespedes
    public void CreateHuespedes(Huespedes huesped) {
        ctrlPersis.createHuespedes(huesped);
    }

    public void DeleteHuespedes(int id) {
        ctrlPersis.deleteHuespedes(id);
    }

    public void EditHuespedes(Huespedes huesped) {
        ctrlPersis.editHuespedes(huesped);
    }

    public Huespedes FindOneHuespedes(int id) {
        return ctrlPersis.FindOneHuespedes(id);
    }

    public ArrayList<Huespedes> FindAllHuespedes() {
        return ctrlPersis.FindAllHuespedes();
    }

    public int getIdHuesped() {
        return ctrlPersis.getIdHuesped();
    }
}
