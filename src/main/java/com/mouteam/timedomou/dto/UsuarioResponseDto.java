package com.mouteam.timedomou.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsuarioResponseDto {
    private String nome;
    private String email;
    private String usuarioAtivo;
    private String perfilUsuario;
}
