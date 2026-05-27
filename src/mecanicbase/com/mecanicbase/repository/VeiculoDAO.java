/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mecanicbase.com.mecanicbase.repository;

import com.mecanicbase.util.Conexao;
import mecanicbase.com.mecanicbase.model.veiculo.Veiculo;
import mecanicbase.com.mecanicbase.model.cliente.Cliente;
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
public class VeiculoDAO {
    
    Connection conn;
    
    
    public void cadastrarVeiculo(Veiculo veiculo){
 
        conn = Conexao.conectar();
        
        String sql = "insert into veiculo(placa, marca, modelo, ano, cor, cambio, combustivel, id_cliente) values (?, ?, ?, ?, ?, ?, ?, ?)";
        
       try {
           PreparedStatement cadastrar = conn.prepareStatement(sql);
           
           cadastrar.setString(1, veiculo.getPlaca());
           cadastrar.setString(2, veiculo.getMarca());
           cadastrar.setString(3, veiculo.getModelo());
           cadastrar.setInt(4, veiculo.getAno());
           cadastrar.setString(5, veiculo.getCor());
           cadastrar.setString(6, veiculo.getCambio());
           cadastrar.setString(7, veiculo.getCombustivel());
           cadastrar.setInt(8, veiculo.getCliente().getId());
           
           cadastrar.execute();
           cadastrar.close();
       } catch (Exception ex){
           System.out.println("Erro: " + ex.getMessage());
       }                
    }
    
    
    public void excluirVeiculo(Veiculo veiculo){

    conn = Conexao.conectar();
    
    String sql = "delete from veiculo where placa = ?";
    
    try{
        PreparedStatement excluir = conn.prepareStatement(sql);
        
        excluir.setString(1, veiculo.getPlaca());
        
        excluir.execute();
        excluir.close();
        
    } catch (Exception ex){
        System.out.println("Erro: " + ex.getMessage());
    }
    }
    
    public void editarVeiculo(Veiculo veiculo){
        
        conn = Conexao.conectar();
        
        String sql = "update veiculo set marca = ?, modelo = ?, ano = ?, cor = ?, cambio = ?, combustivel = ?, id_cliente = ? where placa = ?";
        
        try {
            
            PreparedStatement editar = conn.prepareStatement(sql);
            
            
            editar.setString(1, veiculo.getMarca());
            editar.setString(2, veiculo.getModelo());
            editar.setInt(3, veiculo.getAno());
            editar.setString(4, veiculo.getCor());
            editar.setString(5, veiculo.getCambio());
            editar.setString(6, veiculo.getCombustivel());
            editar.setInt(7, veiculo.getCliente().getId());
            editar.setString(1, veiculo.getPlaca());
            
            editar.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso");
            
        } catch (Exception ex){
            System.out.println("Erro: " + ex.getMessage());
        }
    }
    
    public List<Veiculo> listarVeiculos(){
        
        List<Veiculo> lista = new ArrayList<>();
        
        conn = Conexao.conectar();
        
        String sql = "select v.placa, v.marca, v.modelo, v.ano, v.cor, v.cambio, v.combustivel, c.nome from veiculo v join cliente c on v.id_cliente = c.id";
        
        try {
            PreparedStatement listar = conn.prepareStatement(sql);
            
            ResultSet rs = listar.executeQuery();
            
            while(rs.next()){
                
                Veiculo v = new Veiculo();
                Cliente c = new Cliente();
                
                v.setPlaca(rs.getString("placa"));
                v.setMarca(rs.getString("marca"));
                v.setModelo(rs.getString("modelo"));
                v.setAno(rs.getInt("ano"));
                v.setCor(rs.getString("cor"));
                v.setCambio(rs.getString("cambio"));
                v.setCombustivel(rs.getString("combustivel"));
                c.setNome(rs.getString("nome"));
                
                v.setCliente(c);
                
                lista.add(v);
            }
            
        } catch (Exception ex){
            System.out.println("Erro: " + ex.getMessage());
        }
        return lista;
    }
    
    public boolean verificarPlaca(String placa){
        
        conn = Conexao.conectar();
        
        String sql = "select * from veiculo where placa = ?";
        
        try{
            PreparedStatement veri = conn.prepareStatement(sql);
            
            veri.setString(1, placa);
            
            ResultSet rs = veri.executeQuery();
            
            if(rs.next()){                
                
                return true;
            }
            
        } catch (Exception ex){
            System.out.println("Erro: " + ex.getMessage());
        }
        return false;
    }
    
    
    
    
}
