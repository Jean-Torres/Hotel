/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Huespedes;
import model.Reservas;
import persistence.exceptions.NonexistentEntityException;

/**
 *
 * @author jean torres
 */
public class controladoraPersistencia {

    HuespedesJpaController husJpa = new HuespedesJpaController();
    ReservasJpaController resJpa = new ReservasJpaController();

    public void createReserva(Reservas reserva) {
        resJpa.create(reserva);
    }

    public void deleteReserva(int id) {
        try {
            resJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(controladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editReserva(Reservas reserva) {
        try {
            resJpa.edit(reserva);
        } catch (Exception ex) {
            Logger.getLogger(controladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Reservas FindOneRegistro(int id) {
        return resJpa.findReservas(id);
    }

    public ArrayList<Reservas> FindAllRegistro() {
        List<Reservas> reserva = resJpa.findReservasEntities();
        ArrayList<Reservas> reservas = new ArrayList<>(reserva);
        return reservas;
    }

    public int getIdRegistro() {
        int id = resJpa.getReservasCount();
        return id;
    }

    //Huespedes
    public void createHuespedes(Huespedes huesped) {
        husJpa.create(huesped);
    }

    public void deleteHuespedes(int id) {
        try {
            husJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(controladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editHuespedes(Huespedes huesped) {
        try {
            husJpa.edit(huesped);
        } catch (Exception ex) {
            Logger.getLogger(controladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Huespedes FindOneHuespedes(int id) {
        return husJpa.findHuespedes(id);
    }

    public ArrayList<Huespedes> FindAllHuespedes() {
        List<Huespedes> huesped = husJpa.findHuespedesEntities();
        ArrayList<Huespedes> reservas = new ArrayList<>(huesped);
        return reservas;
    }

    public int getIdHuesped() {
        int id = husJpa.getHuespedesCount();
        return id;
    }
}
