/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mecanicbase.com.mecanicbase.view.veiculo;

import javax.swing.JOptionPane;
import mecanicbase.com.mecanicbase.model.veiculo.Veiculo;
import mecanicbase.com.mecanicbase.repository.VeiculoDAO;
import mecanicbase.com.mecanicbase.model.cliente.Cliente;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Pedro Carmo
 */
public class TelaVeiculo extends javax.swing.JFrame {


    /**
     * Creates new form TelaVeiculo1
     */
    public TelaVeiculo() {
        initComponents();
        
        setLocationRelativeTo(null);
        listarVeiculos();
        
        Id_cliente.setEnabled(false);
        Id_cliente.setEditable(false);
        Id_cliente.setVisible(false);
        txtResponsavel.setEditable(false);
        
    }
    
    public void setClienteSelecionado(int id, String nome) {
        Id_cliente.setText(String.valueOf(id)); // oculto
        txtResponsavel.setText(nome); // visível
    }
    
    public void salvarVeiculo(){
        Cliente cliente = new Cliente();
        Veiculo veiculo = new Veiculo();
        
        veiculo.setPlaca(txtPlaca.getText().trim().toUpperCase());
        veiculo.setMarca(txtMarca.getText());
        veiculo.setModelo(txtModelo.getText());
        veiculo.setAno(Integer.parseInt(txtAno.getText()));
        veiculo.setCor(txtCor.getText());
        veiculo.setCambio(txtCambio.getSelectedItem().toString());
        veiculo.setCombustivel(txtCombustivel.getSelectedItem().toString());
        cliente.setId(Integer.parseInt(Id_cliente.getText()));
        
        veiculo.setCliente(cliente);
        VeiculoDAO dao = new VeiculoDAO();
        
        dao.cadastrarVeiculo(veiculo);
        JOptionPane.showMessageDialog(null, "Veículo cadastrado com sucesso!");
        
    }
    
    public boolean validarVeiculo(){
        
        String placa = txtPlaca.getText().replace("(", "").replace(")", "").replace("-", "").replace(" ", "");
        String marca = txtMarca.getText();
        String modelo = txtModelo.getText();
        String cor = txtCor.getText();
        String anoT = txtAno.getText().trim();
        String cambio = txtCambio.getSelectedItem().toString().replace(" ", "");
        String combustivel = txtCombustivel.getSelectedItem().toString().replace(" ", "");
        
        
        VeiculoDAO dao = new VeiculoDAO();
        
        if (placa.trim().isEmpty()){
            
            JOptionPane.showMessageDialog(null, "Placa precisa ser preenchida");
            
            return false;
        }
        
        if (combustivel.isEmpty()){
            
            JOptionPane.showMessageDialog(null, "Selecione um tipo de combustível");
            
            return false;
        }
        
        if (cambio.isEmpty()){
            
            JOptionPane.showMessageDialog(null, "Selecione o tipo de câmbio");
            
            return false;
        }
        
        if (dao.verificarPlaca(placa)) {
            
            JOptionPane.showMessageDialog(null, "Já existe carro cadastrado com essa placa");
            
            return false;
        }
        
        if(anoT.isEmpty()){
            
            JOptionPane.showMessageDialog(null, "Ano do carro precisa ser preenchido");
            
            return false;
        }
        
        int ano = Integer.parseInt(anoT);
        
        if (ano < 1900 || ano > 2030){
            
            JOptionPane.showMessageDialog(null, "Ano do carro inválido");
            
            return false;
        }
        
        if (txtResponsavel.getText().trim().isEmpty()) {
            
                JOptionPane.showMessageDialog(null, "Selecione o cliente responsável pelo carro");
                
                return false;
        }
        
        if (marca.trim().isEmpty()){
            
            JOptionPane.showMessageDialog(null, "Marca do carro precisa ser preenchido");
            
            return false;
        }
        
        if (modelo.trim().isEmpty()){
            
            JOptionPane.showMessageDialog(null, "Modelo do carro precisa ser preenchido");
            
            return false;
        }
        
        if (cor.isEmpty()){
            
            JOptionPane.showMessageDialog(null, "Cor do carro precisa ser preenchido");
            
            return false;
        }
        
        if (placa.length() != 7){
            
            JOptionPane.showMessageDialog(null, "Placa inválida");
            
            return false;
        }
        
        return true;
    }
    
    
    public void limparCampos(){
        
        txtPlaca.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtAno.setText("");
        txtCor.setText("");
        txtResponsavel.setText("");
        Id_cliente.setText("");
        
        txtPlaca.setEditable(true);
    }
    
    
    public void listarVeiculos(){
        DefaultTableModel modelo = (DefaultTableModel) tabelaVeiculos.getModel();
        
        modelo.setNumRows(0);
        
        VeiculoDAO dao = new VeiculoDAO();
        
        for(Veiculo v : dao.listarVeiculos()){
            
            modelo.addRow(new Object[]{
                v.getPlaca(),
                v.getMarca(),
                v.getModelo(),
                v.getAno(),
                v.getCor(),
                v.getCliente().getNome(),
                v.getCambio(),
                v.getCombustivel()
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        txtResponsavel = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtAno = new javax.swing.JTextField();
        btnCadastro = new javax.swing.JButton();
        txtCor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaVeiculos = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtCambio = new javax.swing.JComboBox<>();
        txtCombustivel = new javax.swing.JComboBox<>();
        Id_cliente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Placa");

        jLabel2.setText("Marca");

        jLabel3.setText("Modelo");

        jLabel4.setText("Ano");

        txtPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlacaActionPerformed(evt);
            }
        });
        txtPlaca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPlacaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPlacaKeyTyped(evt);
            }
        });

        btnBuscar.setText("Buscar Responsável");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel5.setText("Cor");

        txtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaActionPerformed(evt);
            }
        });

        jLabel6.setText("Cambio");

        jLabel7.setText("Combustivel");

        txtAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnoActionPerformed(evt);
            }
        });
        txtAno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnoKeyTyped(evt);
            }
        });

        btnCadastro.setText("Cadastrar");
        btnCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroActionPerformed(evt);
            }
        });

        tabelaVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Placa", "Marca", "Modelo", "Ano", "Cor", "Proprietário", "Câmbio", "Combustível"
            }
        ));
        jScrollPane1.setViewportView(tabelaVeiculos);
        if (tabelaVeiculos.getColumnModel().getColumnCount() > 0) {
            tabelaVeiculos.getColumnModel().getColumn(6).setHeaderValue("Câmbio");
            tabelaVeiculos.getColumnModel().getColumn(7).setHeaderValue("Combustível");
        }

        jLabel8.setText("Responsável pelo veículo");

        txtCambio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Manual", "Automático", "CVT" }));
        txtCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCambioActionPerformed(evt);
            }
        });

        txtCombustivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Gasolina", "Flex", "Diesel", "Etanol", "Elétrico", "Híbrido" }));
        txtCombustivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCombustivelActionPerformed(evt);
            }
        });

        Id_cliente.setText("ID Cliente");
        Id_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Id_clienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtCor, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                        .addComponent(txtAno)
                        .addComponent(txtModelo)
                        .addComponent(txtMarca)
                        .addComponent(txtPlaca))
                    .addComponent(txtCombustivel, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(txtResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Id_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCadastro)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(6, 6, 6)
                                .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addGap(5, 5, 5)
                                .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addGap(2, 2, 2)
                                .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addGap(2, 2, 2)
                                .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel7)
                                .addGap(3, 3, 3)
                                .addComponent(txtCombustivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Id_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCadastro)
                                .addGap(8, 8, 8)))))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlacaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

            TelaListaClientes tela = new TelaListaClientes(this);

            tela.setVisible(true);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaActionPerformed

    private void txtAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnoActionPerformed

    private void btnCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroActionPerformed
        // TODO add your handling code here:
        
        if(validarVeiculo()){
            salvarVeiculo();
            listarVeiculos();
            limparCampos();
        }
        
    }//GEN-LAST:event_btnCadastroActionPerformed

    private void txtCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCambioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCambioActionPerformed

    private void txtCombustivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCombustivelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCombustivelActionPerformed

    private void Id_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Id_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Id_clienteActionPerformed

    private void txtAnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnoKeyTyped
        // TODO add your handling code here:
        
        char c = evt.getKeyChar();
        
        if(!Character.isDigit(c)){
            evt.consume();
        }
        
        if(txtAno.getText().length() >= 4){
            evt.consume();
        }
    }//GEN-LAST:event_txtAnoKeyTyped

    private void txtPlacaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlacaKeyReleased
        // TODO add your handling code here
        
        if (txtPlaca.getText().length() >= 7){
            evt.consume();
        }
        
        txtPlaca.setText(txtPlaca.getText().toUpperCase());
    }//GEN-LAST:event_txtPlacaKeyReleased

    private void txtPlacaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlacaKeyTyped
        // TODO add your handling code here:
        
        char c = evt.getKeyChar();
        
        if(!Character.isLetterOrDigit(c)){
            evt.consume();
        }
        
        if(txtPlaca.getText().length() >= 7){
            evt.consume();
        }
    }//GEN-LAST:event_txtPlacaKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaVeiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Id_cliente;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCadastro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaVeiculos;
    private javax.swing.JTextField txtAno;
    private javax.swing.JComboBox<String> txtCambio;
    private javax.swing.JComboBox<String> txtCombustivel;
    private javax.swing.JTextField txtCor;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtResponsavel;
    // End of variables declaration//GEN-END:variables
}
