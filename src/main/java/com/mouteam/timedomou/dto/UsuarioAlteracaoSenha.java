package com.mouteam.timedomou.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsuarioAlteracaoSenha {
    private String senhaAtual;
    private String novaSenha;
    private String confirmacaoSenha;
}
