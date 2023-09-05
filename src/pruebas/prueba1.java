/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import controllers.ControllerLogica;
import java.util.ArrayList;
import java.util.Date;
import model.Huespedes;
import model.Reservas;

/**
 *
 * @author jean torres
 */
public class prueba1 {

    public static void main(String[] args) {

        ControllerLogica ctrlLogica = new ControllerLogica();

        /* 
        Reservas rnewReserva = new Reservas(3,"Debito",  new Date(), new Date(), 8);
        ctrlLogica.CreateReserva(rnewReserva);
        /*
       // ctrlLogica.DeleteReserva(2);
       
       reserva.setValorPagado(35000);
       ctrlLogica.EditReserva(reserva);
        

        Reservas reserva = ctrlLogica.FindOneRegistro(2);
        System.out.println("//////////////////////////");
        System.out.println(reserva.toString());
        System.out.println("///////////////////////////");

        ArrayList<Reservas> listReservas = ctrlLogica.FindAllRegistros();
        listReservas.forEach(res -> System.out.print(
                "\n---------------------------------------------------- \n"
                + res.toString()));
         */
        /*Reservas newReserva = new Reservas(1, "Debito", new Date(), new Date(), 15000);
        ctrlLogica.CreateReserva(newReserva);

        Huespedes husped = new Huespedes(1, "Prueba", "prueba", "prueba", new Date(),"3233570846", newReserva);
        ctrlLogica.CreateHuespedes(husped);*/
        
        System.out.println("//////////////////////////////////////////////////////////////////");
        System.out.println("Datos huesped");
        ArrayList<Huespedes> huesped = ctrlLogica.FindAllHuespedes();

        for (Huespedes hd : huesped) {
            System.out.println(hd.getNombres());
        }
    }
}
