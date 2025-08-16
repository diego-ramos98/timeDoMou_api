package com.mouteam.timedomou.controller;

import com.mouteam.timedomou.dto.UsuarioAlteracaoSenha;
import com.mouteam.timedomou.dto.UsuarioCreateDto;
import com.mouteam.timedomou.dto.UsuarioResponseDto;
import com.mouteam.timedomou.dto.mapper.UsuarioMapper;
import com.mouteam.timedomou.entity.Usuario;
import com.mouteam.timedomou.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> buscaUsuarioPorId(@PathVariable Long id){
        Usuario usuario = usuarioService.buscaUsarioPorId(id);

        return ResponseEntity.status(HttpStatus.OK).body(UsuarioMapper.ToDto(usuario));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> buscaTodosUsuarios(){
        List<Usuario> usuarios = usuarioService.buscaTodos();

        return ResponseEntity.status(HttpStatus.OK).body(UsuarioMapper.ToListDto(usuarios));
    }


    @PatchMapping("/{id}")
    public ResponseEntity<Void> alteraSenha(@PathVariable Long id, @RequestBody UsuarioAlteracaoSenha dto){
        Usuario usuario = usuarioService.alteraSenha(id, dto.getSenhaAtual(), dto.getNovaSenha(), dto.getConfirmacaoSenha());

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaUsuario(@PathVariable Long id){
        Usuario usuario = usuarioService.deletaUsuario(id);

        return ResponseEntity.noContent().build();
    }


}
