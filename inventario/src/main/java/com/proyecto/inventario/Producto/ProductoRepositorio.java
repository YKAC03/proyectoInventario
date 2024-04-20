package com.proyecto.inventario.Producto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;






@Repository
public interface ProductoRepositorio extends JpaRepository<Producto,Integer>{
    //@Query("SELECT p FROM Producto p WHERE" +"CONCAT (p.id_producto,p.precio_producto,p.nombre_producto,p.descripcion_producto,p.cantidad_producto"+"LIKE %?1?")
    @Query("SELECT p FROM Producto p WHERE p.nombre_producto LIKE %?1%")
    List<Producto> findByNombre(String name);
} 