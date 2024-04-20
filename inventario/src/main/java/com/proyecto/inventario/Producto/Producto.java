package com.proyecto.inventario.Producto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="inventario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Producto {
    @Id
    @GeneratedValue
    private Integer id_producto;

    @Column(name = "nombre_producto")
    private String nombre_producto;

    @Column(name = "precio_producto")
    private Float precio_producto;

    @Column(name = "lote_producto")
    private int lote_producto;

    @Column(name = "descripcion_producto")
    private String descripcion_producto;

    @Column(name = "cantidad_producto")
    private Float cantidad_producto;

}
