/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.connenergy.gerenciamento.service;

import com.connenergy.gerenciamento.model.FuncionarioDTO;
import com.connenergy.gerenciamento.respository.FuncionarioDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aluno
 */
@Service
public class FuncionarioService {
    
    @Autowired
    private FuncionarioDAO repository;
    
    public List<FuncionarioDTO> lerTodos() {
        return repository.lerTodos();
    }
    
    public FuncionarioDTO lerPorId(int id){
        return repository.lerPorId(id);
    }
    
    public void adicionar(FuncionarioDTO funcionario){
        repository.adicionar(funcionario);
    }
    
      public void editarFuncionario(FuncionarioDTO funcionario) {
        repository.editar(funcionario);
    }
      

    public void atualizar(FuncionarioDTO funcionario){
        repository.atualizar(funcionario);
    }
  
    
  
    
}
