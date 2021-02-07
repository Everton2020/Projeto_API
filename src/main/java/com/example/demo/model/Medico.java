package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_medico")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 120)
    private String nome;

    @NotNull
    @Size(min = 7, max = 7)
    private int crm;

    @Size(min=13, max =14)
    private String telefone;

    @Size(min = 14, max=14)
    private String celular;

    private String imagem;

    @ManyToOne
    @JsonIgnoreProperties("medico")
    private Especialidade especialidade;

    @ManyToOne
    @JsonIgnoreProperties("medico")
    private Especialidade2 especialidade2;
}
