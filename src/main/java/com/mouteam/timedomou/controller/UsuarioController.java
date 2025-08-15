package com.mouteam.timedomou.controller;

import com.mouteam.timedomou.dto.UsuarioCreateDto;
import com.mouteam.timedomou.dto.UsuarioResponseDto;
import com.mouteam.timedomou.dto.mapper.UsuarioMapper;
import com.mouteam.timedomou.entity.Usuario;
import com.mouteam.timedomou.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;


    @PostMapping
    public ResponseEntity<UsuarioResponseDto> criarUsuario(@RequestBody UsuarioCreateDto createDto){
        Usuario usuario = usuarioService.criarUsuario(UsuarioMapper.ToUsuario(createDto));

        return ResponseEntity.status(HttpStatus.OK).body(UsuarioMapper.ToDto(usuario));

    }


    @GetMapping
    public ResponseEntity<UsuarioResponseDto> buscaUsuarioPorId(Long id){
        Usuario usuario = usuarioService.buscaUsarioPorId(id);

        return ResponseEntity.status(HttpStatus.OK).body(UsuarioMapper.ToDto(usuario));
    }



}
