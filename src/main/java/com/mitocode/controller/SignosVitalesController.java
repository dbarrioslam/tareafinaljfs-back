package com.mitocode.controller;

import com.mitocode.exception.ModeloNotFoundException;
import com.mitocode.model.SignosVitales;
import com.mitocode.repo.ISignosVitalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/signos-vitales")
public class SignosVitalesController {

    @Autowired
    private ISignosVitalesService service;

    @PostMapping
    public ResponseEntity<Void> registrar(@Valid @RequestBody SignosVitales signosVitales) throws Exception{
        SignosVitales obj = service.registrar(signosVitales);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getIdSignoVital()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<SignosVitales> modificar(@Valid @RequestBody SignosVitales signosVitales) throws Exception{
        SignosVitales obj = service.modificar(signosVitales);
        return new ResponseEntity<SignosVitales>(obj, HttpStatus.OK);
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<SignosVitales>> listarPageable(Pageable pageable) throws Exception{
        Page<SignosVitales> signosVitales = service.listarPageable(pageable);
        return new ResponseEntity<Page<SignosVitales>>(signosVitales, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SignosVitales> listarPorId(@PathVariable("id") Integer id) throws Exception{
        SignosVitales obj = service.listarPorId(id);
        if(obj == null ) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }
        return new ResponseEntity<SignosVitales>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
        SignosVitales obj = service.listarPorId(id);
        if(obj.getIdSignoVital() == null ) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }
        service.eliminar(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
