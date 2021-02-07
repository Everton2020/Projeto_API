package com.example.demo.controller;

import com.example.demo.model.Medico;
import com.example.demo.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @GetMapping
    public ResponseEntity<List<Medico>> findAll()
    {
     return ResponseEntity.ok(repository.findAll());
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Medico> findById(@PathVariable Long id)
    {
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Medico>> findAllByNome(@PathVariable String nome)
    {
        return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
    }
    @GetMapping("/crm/{crm}")
    public ResponseEntity<Medico> findByCrm(@PathVariable int crm)
    {
        return ResponseEntity.ok(repository.findByCrm(crm));
    }
    @PostMapping
    public ResponseEntity<Medico> postMedico(@RequestBody Medico medico)
    {
        return  ResponseEntity.status(HttpStatus.CREATED).body(repository.save(medico));
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Medico> putMedico(@RequestBody Medico medico)
    {
        return  ResponseEntity.status(HttpStatus.OK).body(repository.save(medico));
    }
    @DeleteMapping("/delete/{id}")
    public void deleteMedico(@PathVariable Long id)
    {
      repository.deleteById(id);
    }
}
