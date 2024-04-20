package com.proyecto.inventario.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoServicio {
    List <Producto> mostrarTodos() throws Exception;
    Producto agregarProducto(Producto producto)throws Exception;
    Producto actualizarProducto(Integer id, Producto producto)throws Exception;
    boolean eliminarProducto(Integer id)throws Exception;
    List<Producto> buscarProducto(String nombre) throws Exception;
    Optional<Producto> buscarProductoPorId(Integer id);
    boolean existById(Integer id);
} 
