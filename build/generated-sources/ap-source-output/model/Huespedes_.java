package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Reservas;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-05T15:06:38")
@StaticMetamodel(Huespedes.class)
public class Huespedes_ { 

    public static volatile SingularAttribute<Huespedes, String> apellidos;
    public static volatile SingularAttribute<Huespedes, Date> fechaNacimiento;
    public static volatile SingularAttribute<Huespedes, Integer> id;
    public static volatile SingularAttribute<Huespedes, String> telefono;
    public static volatile SingularAttribute<Huespedes, Reservas> reserva;
    public static volatile SingularAttribute<Huespedes, String> nombres;
    public static volatile SingularAttribute<Huespedes, String> nacionalidad;

}