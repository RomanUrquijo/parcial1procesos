package controllers;

import models.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import repository.CategoriaRepository;

import java.util.List;

@RestController
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping("/categoria")
    public ResponseEntity crearCategoria(@RequestBody Categoria categoria){
        try {
            categoriaRepository.save(categoria);
            return new ResponseEntity(categoria, HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();

        }



    }
    @GetMapping("/categorias")
    public ResponseEntity listarCategoria(){

        List<Categoria> categorias= categoriaRepository.findAll();
        if(categorias.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity(categorias,HttpStatus.OK);


    }

}


