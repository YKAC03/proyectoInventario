package com.proyecto.inventario.Producto;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;






@RestController
@RequestMapping("/api")

public class ProductoControlador {
    @Autowired
    private ProductoServicio productServicio;

    @GetMapping("/vertodos")
    public ResponseEntity<?> list(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(productServicio.mostrarTodos());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error");
        }    
    }


    @GetMapping("/verPorNombre/{nombre}")
    public ResponseEntity<?> getByName(@PathVariable("nombre") String nombre){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(productServicio.buscarProducto(nombre));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error");
        }  
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(productServicio.eliminarProducto(id));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error");
        }  
    }
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody Producto product){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(productServicio.agregarProducto(product));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Producto producto) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(productServicio.actualizarProducto(id, producto));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
        }
    }

    // @RequestMapping("/")
    // public String paginaDeInicio(Model modelo) {
    //     List<Producto> listaProducto=productServicio.mostrarTodos();
    //     modelo.addAttribute("listaProducto", listaProducto);
    //     return "index";
    // }
    
    
}
