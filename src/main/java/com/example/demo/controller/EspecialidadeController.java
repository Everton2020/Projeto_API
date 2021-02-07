package com.example.demo.controller;

import com.example.demo.model.Especialidade;
import com.example.demo.model.Especialidade2;
import com.example.demo.repository.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especialidade_1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EspecialidadeController {

    @Autowired
    private EspecialidadeRepository repository;

    @GetMapping
    private ResponseEntity<List<Especialidade>> findAll()
    {
        return ResponseEntity.ok(repository.findAll());
    }
    @GetMapping("/id/{id}")
    private ResponseEntity<Especialidade> findById(@PathVariable Long id)
    {
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/nome/{nome}")
    private ResponseEntity<List<Especialidade>> findByNome(@PathVariable String nome)
    {
        return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
    }
    @PostMapping
    private ResponseEntity<Especialidade> postEspecialidade(@RequestBody Especialidade especialidade)
    {
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(especialidade));
    }
    @PutMapping("/edit/{id}")
    private ResponseEntity<Especialidade> putEspecialidade(@RequestBody Especialidade especialidade)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(especialidade));
    }
    @DeleteMapping("/delete/{id}")
    public void deleteEspecialidade(@PathVariable Long id)
    {
        repository.deleteById(id);
    }
}
