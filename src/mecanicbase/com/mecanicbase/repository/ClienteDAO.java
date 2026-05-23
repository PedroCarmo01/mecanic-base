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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
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
            
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso");
            
        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        
    }


    public void editarCliente(Cliente cliente){
        
        String sql = "update cliente set cpf = ?, nome = ?, telefone = ?, email = ? where id = ?";
        conn = Conexao.conectar();
        
        try {
            PreparedStatement banco_stmt = conn.prepareStatement(sql);
            
            banco_stmt.setString(1, cliente.getCpf());
            banco_stmt.setString(2, cliente.getNome());
            banco_stmt.setString(3, cliente.getTelefone());
            banco_stmt.setString(4, cliente.getEmail());
            banco_stmt.setInt(5, cliente.getId());
            
            banco_stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso");
            
        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
        }              
    }
    
    public List<Cliente> listarClientes(){
        
        List<Cliente> lista = new ArrayList<>();
        
        
        String sql = "select * from cliente";
        
        conn = Conexao.conectar();
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Cliente c = new Cliente();
                
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("email"));
                
                lista.add(c);
            }
        } catch (Exception ex){
            System.out.println("Erro: " + ex.getMessage());
        }
        return lista;
    }
    
    public boolean cpfExiste(String cpf){
        
        String sql = "select * from cliente where cpf = ?";
        
        conn = Conexao.conectar();
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, cpf);
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){                
                
                return true;
            }
            
        } catch(Exception ex){
            
            System.out.println("Erro: " + ex.getMessage());
        }
        
        return false;
    }
}