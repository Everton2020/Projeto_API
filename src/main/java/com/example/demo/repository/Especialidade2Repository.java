package com.example.demo.repository;

import com.example.demo.model.Especialidade;
import com.example.demo.model.Especialidade2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Especialidade2Repository extends JpaRepository<Especialidade2, Long> {
    public List<Especialidade2> findAllByNomeContainingIgnoreCase(String nome);
}