package com.mouteam.timedomou.dto.mapper;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsuarioCreateDto {
    private String nome;
    private String dataNasciemento;
    private String cpf;
    private String email;
    private String senha;
}
