package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArticuloController {
    @Autowired
    private ArticuloRepository articuloRepository;
    @PostMapping("/articulo")
    public ResponseEntity crearArticulo(@RequestBody Articulo articulo ){
        try{
            articuloRepository.save(articulo);
            return new ResponseEntity(articulo, HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

    }
    @GetMapping("/articulo/{codigo}")
    public ResponseEntity ListarPorCodigo(@PathVariable String codigo){
        Optional<Articulo> articulos= articuloRepository.findByCodigo(codigo);
        if(!articulos.isPresent()){
            return ResponseEntity.not
        }

    }

}
