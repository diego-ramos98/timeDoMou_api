package com.mouteam.timedomou.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TreinoResponseDto {
    private Long id;
    private String nome;
    private String descricao;
    private String grupoMuscular;
}
