package com.example.demo.controller;

import com.example.demo.model.Especialidade2;
import com.example.demo.repository.Especialidade2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especialidade_2")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Especialidade2Controller {

    @Autowired
    private Especialidade2Repository repository;

    @GetMapping
    public ResponseEntity<List<Especialidade2>> findAll()
    {
        return ResponseEntity.ok(repository.findAll());
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Especialidade2> findById(@PathVariable Long id)
    {
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Especialidade2>> findAllByNome(@PathVariable String nome)
    {
        return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
    }
    @PostMapping
    public ResponseEntity<Especialidade2> postEspecialidade2(@RequestBody Especialidade2 especialidade2)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(especialidade2));
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Especialidade2> putEspecialidade2(@RequestBody Especialidade2 especialidade2)
    {
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(especialidade2));
    }
    @DeleteMapping("/delete/{id}")
    public void deleteEspecialidade2(@PathVariable Long id)
    {
        repository.deleteById(id);
    }
}
