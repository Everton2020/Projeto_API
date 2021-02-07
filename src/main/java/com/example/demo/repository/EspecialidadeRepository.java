package com.example.demo.repository;

import com.example.demo.model.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long> {
    public List<Especialidade> findAllByNomeContainingIgnoreCase(String nome);
}
