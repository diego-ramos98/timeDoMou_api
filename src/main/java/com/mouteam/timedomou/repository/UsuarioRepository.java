package com.mouteam.timedomou.repository;


import com.mouteam.timedomou.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
