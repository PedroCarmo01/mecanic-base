/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mecanicbase.repository;
import com.mecanicbase.util.Conexao;
import com.mecanicbase.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Pedro Carmo
 */
public class ClienteDAO {
    
    Connection conn;
    
    public void cadastrarCliente(Cliente cliente){
        
        String sql = "insert into cliente(cpf, nome, telefone, email) values (?, ?, ?, ?)";
        
        conn = Conexao.conectar();
        
        try {
            PreparedStatement banco_stmt = conn.prepareStatement(sql);
            
            banco_stmt.setString(1, cliente.getCpf());
            banco_stmt.setString(2, cliente.getNome());
            banco_stmt.setString(3, cliente.getTelefone());
            banco_stmt.setString(4, cliente.getEmail());
            
            banco_stmt.execute();
            banco_stmt.close();
            
            System.out.println("Contato Cadastrado com Sucesso!");
            
        } catch (Exception ex) {
            
            System.out.println("Erro: " + ex.getMessage());
        }
    }

    
    public void excluirCliente(Cliente cliente){
        
        String sql = "delete from cliente where id = ?";
        
        conn = Conexao.conectar();
        
        try {
            PreparedStatement banco_stmt = conn.prepareStatement(sql);
            
            banco_stmt.setInt(1, cliente.getId());
            
            banco_stmt.execute();
            banco_stmt.close();
            
        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        
    }


    public void editarCliente(Cliente cliente){
        
        String cpf = cliente.getCpf();
        String nome = cliente.getNome();
        String telefone = cliente.getTelefone();
        String email = cliente.getEmail();
        
        String sql = "update cliente set cpf = ?, nome = ?, telefone = ?, email = ? where id = ?";
        
        try {
            PreparedStatement banco_stmt = conn.prepareStatement(sql);
            
            banco_stmt.setString(1, cpf);
            banco_stmt.setString(2, nome);
            banco_stmt.setString(3, telefone);
            banco_stmt.setString(4, email);
            banco_stmt.setInt(5, cliente.getId());
            
            banco_stmt.execute();
            banco_stmt.close();
        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
               
    }
}