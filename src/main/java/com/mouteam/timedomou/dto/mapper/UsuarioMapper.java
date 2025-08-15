package com.mouteam.timedomou.dto.mapper;

import com.mouteam.timedomou.dto.UsuarioCreateDto;
import com.mouteam.timedomou.dto.UsuarioResponseDto;
import com.mouteam.timedomou.entity.Usuario;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioMapper {
    public static Usuario ToUsuario(UsuarioCreateDto createDto){
        return new ModelMapper().map(createDto,Usuario.class);
    }

    public static UsuarioResponseDto ToDto(Usuario usuario){
        String perfil = usuario.getPerfilUsuario().name().substring("Perfil_".length());

        PropertyMap<Usuario,UsuarioResponseDto> props = new PropertyMap<Usuario, UsuarioResponseDto>() {
            @Override
            protected void configure() {
                map().setUsuarioAtivo(perfil);
            }
        };

        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(props);

        return mapper.map(usuario,UsuarioResponseDto.class);

    }


    public static List<UsuarioResponseDto> ToListDto(List<Usuario> usuarios){
        return usuarios.stream().map(UsuarioMapper::ToDto).collect(Collectors.toList());
    }


}
