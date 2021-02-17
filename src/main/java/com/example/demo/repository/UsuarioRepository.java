package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public List<Usuario> findAllByNomeContainingIgnoreCase (String nome);
	public Optional<Usuario> findByEmailAndSenha(String email, String senha);
	public Optional<Usuario> findByEmail(String email);
}
