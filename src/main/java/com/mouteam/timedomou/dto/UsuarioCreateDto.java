package com.mouteam.timedomou.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsuarioCreateDto {

    @NotBlank
    @Size(max = 155)
    private String nome;

    @NotBlank
    private String dataNasciemento;

    @NotBlank
    @CPF
    private String cpf;

    @NotBlank
    @Email(regexp = "^[a-z0-9.+-]+@[a-z0-9.-]+\\.[a-z]{2,}$",message = "Formato do e-mail está invalido")
    private String email;

    @Size(min = 8,max = 8)
    private String senha;
}
