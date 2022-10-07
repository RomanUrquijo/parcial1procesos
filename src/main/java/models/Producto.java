package models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long codigo;
    @Column(length = 100,nullable = false)
    private String nombre;
    @Column(length = 300,nullable = false)
    private String descripcion;
    @Column(length = 1000,nullable = false)
    private String compra;
    @Column(length = 100)
    private String venta;
    @Column(length = 100)
    private Date fechaRegistro;

}


