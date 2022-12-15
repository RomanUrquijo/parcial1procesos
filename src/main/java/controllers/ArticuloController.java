package controllers;

import models.Articulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.ArticuloRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class ArticuloController {
    @Autowired
    private ArticuloRepository articuloRepository;

    @PostMapping("/articulo")
    public ResponseEntity crearArticulo(@RequestBody Articulo articulo){
        try {
            articuloRepository.save(articulo);
            return new ResponseEntity(articulo, HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();

        }



    }
    @GetMapping("/articulo/{codigo}")
    public ResponseEntity listaPorCodigo(@PathVariable String codigo){
        Optional<Articulo> articulos= articuloRepository.findByCodigo(codigo);
        if(!articulos.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity(articulos,HttpStatus.OK);
    }

    @PutMapping("/articulo/{codigo}")
    public ResponseEntity modificarArticulo(@PathVariable String codigo, @RequestBody Articulo articulo) {
        Optional<Articulo> articuloBD= articuloRepository.findByCodigo(codigo);
        if (articuloBD.isPresent()) {
            try {
                articuloBD.get().setCodigo(articulo.getCodigo());
                articuloBD.get().setNombre(articulo.getNombre());
                articuloBD.get().setDescripcion(articulo.getDescripcion());
                articuloBD.get().setFecha_registro(articulo.getFecha_registro());
                articuloBD.get().setStock(articulo.getStock());
                articuloBD.get().setCategoria(articulo.getCategoria());
                articuloBD.get().setPrecio_venta(articulo.getPrecio_venta());
                articuloBD.get().setPrecio_compra(articulo.getPrecio_compra());

                articuloRepository.save(articuloBD.get());
                return new ResponseEntity(articuloBD, HttpStatus.OK);

            } catch (Exception e) {
                return ResponseEntity.badRequest().build();

            }




        }
        return ResponseEntity.notFound().build();


    }

    @DeleteMapping("/articulo/{codigo}")
    public ResponseEntity eliminarArticulo(@PathVariable String codigo){
        Optional<Articulo> articuloBD = articuloRepository.findByCodigo(codigo);
        if(articuloBD.isPresent()){
            articuloRepository.delete(articuloBD.get());
            return  ResponseEntity.noContent().build();

        }


        return ResponseEntity.notFound().build();
    }
    @GetMapping("/articulos")
    public ResponseEntity listarArticulo(){

        List<Articulo> articulos= articuloRepository.findAll();
        if(articulos.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity(articulos,HttpStatus.OK);


    }




}
