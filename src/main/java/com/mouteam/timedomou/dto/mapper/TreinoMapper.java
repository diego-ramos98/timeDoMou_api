package com.mouteam.timedomou.dto.mapper;


import com.mouteam.timedomou.dto.TreinoResponseDto;
import com.mouteam.timedomou.dto.UsuarioCreateDto;
import com.mouteam.timedomou.entity.Treino;
import com.mouteam.timedomou.entity.Usuario;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;
import java.util.stream.Collectors;

public class TreinoMapper {
    public static Treino ToTreino(UsuarioCreateDto createDto) {
        return new ModelMapper().map(createDto, Treino.class);
    }

    public static TreinoResponseDto ToDto(Treino treino){
        String grupoMuscular = treino.getGrupoMuscular().name().substring("GRUPO_MUSCULAR_".length());

        PropertyMap<Treino, TreinoResponseDto> props = new PropertyMap<Treino, TreinoResponseDto>() {
            @Override
            protected void configure() {
                map().setGrupoMuscular(grupoMuscular);
            }
        };

        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(props);

        return mapper.map(treino,TreinoResponseDto.class);
    }



    public static List<TreinoResponseDto> ToListDto(List<Treino> treinos) {
        return treinos.stream().map(TreinoMapper::ToDto).collect(Collectors.toList());
    }





}
