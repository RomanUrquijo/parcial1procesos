package models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "articulos")
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (length = 20, nullable = false, unique = true)
    private String codigo;
    @Column (length = 50,nullable = false)
    private String nombre;
    @Column (length = 100,nullable = false)
    private String descripcion;
    private Date fecha_registro;
    private Number stock;
    @ManyToOne
    private Categoria categoria;
    @Column(nullable = false)
    private Float precio_venta;
    @Column(nullable = false)
    private Float precio_compra;



}


