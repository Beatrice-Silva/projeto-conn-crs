/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.connenergy.gerenciamento.controller;


import com.connenergy.gerenciamento.model.FuncionarioDTO;
import com.connenergy.gerenciamento.service.FuncionarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Aluno
 */
@Controller
public class FuncionarioController {
    
    @Autowired
    private FuncionarioService service;
    
    @GetMapping("/funcionarios")
    public String getFuncionarios(Model model){
        List<FuncionarioDTO> lista = service.lerTodos(); 
        model.addAttribute("lista",lista);
        return "funcionarios";
    }
    
    @GetMapping("/perfil")
    public String perfil(@RequestParam int id, Model model){
        FuncionarioDTO funcionario = service.lerPorId(id);
        model.addAttribute("funcionario", funcionario);
        return "perfil";
    }
    
    @PutMapping("/adicionar-novo")
    public String adicionarNovo(Model model){
        FuncionarioDTO funcionario = new FuncionarioDTO();
        model.addAttribute("funcionario", funcionario);
        return "/adicionar-novo";  
    }
    
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute FuncionarioDTO funcionario){
        service.editarFuncionario(funcionario);
        return "redirect:/funcionarios";        
    }

    @PutMapping("/adciionar")
    public String adicionar(@ModelAttribute FuncionarioDTO funcionario){
        service.adicionar(funcionario);
        return "redirect:/funcionarios";  
    }
    
    

}
