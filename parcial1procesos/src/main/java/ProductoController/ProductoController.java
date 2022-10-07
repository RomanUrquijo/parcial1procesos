package ProductoController;

import models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping(value = "/producto/{id}")
    public ResponseEntity getProducto(@PathVariable Long id) {
        Optional<Producto> producto = productoRepository.findById(id);
        if (producto.isPresent()) {
            return new ResponseEntity(producto, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping("/usuario")
    public ResponseEntity crearUsuario(@RequestBody Producto producto){
        try {
            ProductoRepository.save(producto);
            return new ResponseEntity(producto,HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }