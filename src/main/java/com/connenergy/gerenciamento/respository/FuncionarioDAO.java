/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.connenergy.gerenciamento.respository;

import com.connenergy.gerenciamento.model.FuncionarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aluno
 */
//DAO = repository
@Repository
public class FuncionarioDAO {
    
    
    public List<FuncionarioDTO> lerTodos(){
        List<FuncionarioDTO> dados = new ArrayList();
        
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("Select * from funcionario");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                FuncionarioDTO funcionario = new FuncionarioDTO();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setDepartamento(rs.getString("departamento"));
                funcionario.setEmail(rs.getString("email"));
                
                funcionario.setData_contratacao(rs.getDate("data_contratacao"));
                
                dados.add(funcionario);
                
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }

        return dados;
    }
    
   
      public FuncionarioDTO lerPorId(int id){
        FuncionarioDTO funcionario = new FuncionarioDTO();
        
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("SELECT * FROM funcionario WHERE id = ?");
            
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            if(rs.next()){

                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setDepartamento(rs.getString("departamento"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setData_contratacao(rs.getDate("data_contratacao"));
            }
            }catch (SQLException e){
                e.printStackTrace();
            }
        
        return funcionario;

    }
 
         public void atualizar(FuncionarioDTO funcionario){
            try{
            Connection conn =Conexao.conectar();
            PreparedStatement stmt = null;            
           
            stmt = conn.prepareStatement("UPDATE funcionario SET nome= ?, cargo=?, departamento=?, email=?, data_contratacao=? WHERE id=?");
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo());
            stmt.setString(3, funcionario.getDepartamento());
            stmt.setString(4, funcionario.getEmail());
            stmt.setDate(5, funcionario.getData_contratacao());
            stmt.setInt(6, funcionario.getId());
            stmt.executeUpdate();
           
        }catch(SQLException e){
            e.printStackTrace();
        }    
    } 
 
    public void adicionar(FuncionarioDTO funcionario){
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conn.prepareStatement("INSERT INTO funcionarios (nome, cargo, departamento, email, data_contratacao)"
                    + "VALUES (?,?,?,?,?)");
            stmt.setString(1,funcionario.getNome());
            stmt.setString(2,funcionario.getCargo());
            stmt.setString(3,funcionario.getDepartamento());
            stmt.setString(4,funcionario.getEmail());
            stmt.setDate(5,funcionario.getData_contratacao());
            
            stmt.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    
    }
              
}
   