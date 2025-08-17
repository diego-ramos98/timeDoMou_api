package com.mouteam.timedomou.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.asm.SpringAsmInfo;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "treinos")
public class Treino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_treino")
    private Long id;

    @JoinColumn(name = "id_usuario")
    @OneToMany
    private Usuario usuario;

    @Column(name = "nome")
    private String nomeTreino;

    @Column(name = "descicao")
    private String descricao;

    @Column(name = "grupo_muscular")
    private GrupoMuscular grupoMuscular;

    @Column(name = "numero_repeticoes_min")
    private int numeroRepeticoesMin;

    @Column(name = "numero_repeticoes_max")
    private int numeroRepeticoesMax;




    public enum GrupoMuscular{
        GRUPO_MUSCULAR_PEITO,
        GRUPO_MUSCULAR_COSTAS,
        GRUPO_MUSCULAR_OMBROS,
        GRUPO_MUSCULAR_BICEPS,
        GRUPO_MUSCULAR_TRICEPS,
        GRUPO_MUSCULAR_COXAS,
        GRUPO_MUSCULAR_GLUTEOS,
        GRUPO_MUSCULAR_ABDOMEN
    }


}
