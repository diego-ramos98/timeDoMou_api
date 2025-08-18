package com.mouteam.timedomou.service;

import com.mouteam.timedomou.entity.Treino;
import com.mouteam.timedomou.entity.Usuario;
import com.mouteam.timedomou.repository.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TreinoService {

    @Autowired
    private TreinoRepository  treinoRepository;


    @Transactional
    public Treino criarTreino(Treino treino){
        return treinoRepository.save(treino);
    }

    @Transactional(readOnly = true)
    public Treino buscaTreinoPorId(Long id){
        return treinoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Treino não encontrado com o id: " + id)
        );
    }


    @Transactional(readOnly = true)
    public List<Treino> buscaTodos(){
        return treinoRepository.findAll();
    }


    @Transactional
    public void deletaTreino(Long id){

        Treino treino = buscaTreinoPorId(id);

        treinoRepository.deleteById(id);
    }


}
