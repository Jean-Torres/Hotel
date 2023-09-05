/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utiles;

import javax.persistence.*;

public class EstablecerConexion {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("Hotel_Alura");

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
}
