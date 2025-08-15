package com.mouteam.timedomou.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "noem")
    private String nome;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "email")
    private String email;
    @Column(name = "senha")
    private String senha;
    @Column(name = "perfil_usuario")
    private Perfil perfilUsuario = Perfil.PERFIL_CLIENTE;
    @Column(name = "usuario_ativo")
    private boolean usuarioAtivo = true;
    @Column(name = "data_inclusao")
    private LocalDate dataInclusao;
    @Column(name = "data_alteracao")
    private LocalDate dataAlteracao;
    @Column(name = "alterado_por")
    private String  alteradoPor;


    public enum Perfil{
        PERFIL_ADMINISTRADOR,
        PERFIL_CLIENTE
    }



}
