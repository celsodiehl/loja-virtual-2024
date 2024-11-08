package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.repository.EstadoRepository;
import com.dev.backend.entity.Estado;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estRepository;
    
    public List<Estado> buscarTodos(){
        return estRepository.findAll();
    }

    public Estado inserir(Estado estado){
        estado.setData_criacao(new Date());
        Estado estadoNovo = estRepository.saveAndFlush(estado);
        return estadoNovo;
    }

    public Estado alterar(Estado estado){
        estado.setData_atualizacao(new Date());
        return estRepository.saveAndFlush(estado);
    }

    public void excluir(Long id){
        Estado estado = estRepository.findById(id).get();
        estRepository.delete(estado);
    }
}
