package com.proyecto.inventario.Producto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ProductoServicioImplementacion implements ProductoServicio {
    @Autowired
    private ProductoRepositorio productRepo;
    @Override
    @Transactional(readOnly = true)
    public List<Producto> mostrarTodos()throws Exception{
        try{
            return productRepo.findAll();
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        // return productRepo.findAll();
    }

    @Override
    @Transactional
    public Producto agregarProducto(Producto producto)throws Exception{
        try{
            return productRepo.save(producto);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }

        // return productRepo.save(producto);
    }

    @Override
    @Transactional
    public boolean eliminarProducto(Integer id)throws Exception{
        try{
            if(productRepo.existsById(id)){
                productRepo.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        // if(productRepo.existsById(id)){
        //     productRepo.deleteById(id);
        //     return true;
        // }else{
        //     return false;
        // }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> buscarProducto(String nombre)throws Exception {
        try{
            return productRepo.findByNombre(nombre);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }

        // return productRepo.findByNombre(nombre);
       
    }
    public Producto actualizarProducto(Integer id, Producto producto)throws Exception{
        try{
            Optional<Producto> product=productRepo.findById(id);
            
            Producto producto2=product.get();
            producto2=productRepo.save(producto);
            return producto2;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }

        // Optional<Producto> product=productRepo.findById(id);
        // Producto producto2=product.get();
        // producto2=productRepo.save(producto);
        // return producto2;
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<Producto> buscarProductoPorId(Integer id){
        return productRepo.findById(id);
    }
    @Override
    public boolean existById(Integer id){
        return productRepo.existsById(id);
    }
}
