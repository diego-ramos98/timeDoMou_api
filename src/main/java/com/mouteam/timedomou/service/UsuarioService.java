package com.mouteam.timedomou.service;

import com.mouteam.timedomou.entity.Usuario;
import com.mouteam.timedomou.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private   UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario criarUsuario(Usuario usuario){
        return  usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    public Usuario buscaUsarioPorId(Long id){
        return usuarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado")
        );
    }

    @Transactional(readOnly = true)
    public List<Usuario> buscaTodos(){
        return usuarioRepository.findAll();
    }


    @Transactional
    public Usuario deletaUsuario(Long id){
        Usuario usuario = buscaUsarioPorId(id);

        usuario.setUsuarioAtivo(false);

        return usuario;
    }

    @Transactional
    public Usuario alteraSenha(Long id,String senhaAtual, String novaSenha, String confirmaSenha){
        if(!novaSenha.equals(confirmaSenha)){
            throw  new RuntimeException("Nova senha não confere com a confirmação de senha");
        }

        Usuario usuario = buscaUsarioPorId(id);

        if(!usuario.getSenha().equals(senhaAtual)){
            throw new RuntimeException("Senha incorreta.");
        }

        return usuario;
    }


}
