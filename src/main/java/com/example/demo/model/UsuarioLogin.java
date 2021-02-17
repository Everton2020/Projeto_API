package com.example.demo.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioLogin {
	
	private String nome;
	
	private String email;
	
	private String senha;
	
	private String token;

	
}
