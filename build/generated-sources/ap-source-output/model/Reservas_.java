package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-05T15:06:38")
@StaticMetamodel(Reservas.class)
public class Reservas_ { 

    public static volatile SingularAttribute<Reservas, Double> ValorPagado;
    public static volatile SingularAttribute<Reservas, Date> fechaSalida;
    public static volatile SingularAttribute<Reservas, Date> fechaEntrada;
    public static volatile SingularAttribute<Reservas, Integer> id;
    public static volatile SingularAttribute<Reservas, String> formaDePago;

}