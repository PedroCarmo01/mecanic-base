/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mecanicbase.com.mecanicbase.view.cliente;

import mecanicbase.com.mecanicbase.model.cliente.Cliente;
import mecanicbase.com.mecanicbase.repository.cliente.ClienteDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Pedro Carmo
 */
public class TelaCliente extends javax.swing.JFrame {

    /**
     * Creates new form view
     */
    public TelaCliente() {
        initComponents();
        tabelaCliente.setDefaultEditor(Object.class, null);
        
        setLocationRelativeTo(null);
        listarClientes();
        txtID.setVisible(false);
    }

    public void listarClientes(){
        DefaultTableModel modelo = (DefaultTableModel) tabelaCliente.getModel();
        
        modelo.setNumRows(0);
        
        ClienteDAO dao = new ClienteDAO();
        
        for(Cliente c : dao.listarClientes()){
            
            modelo.addRow(new Object[]{
                c.getId(),
                c.getNome(),
                c.getCpf(),
                c.getTelefone(),
                c.getEmail()
            });
        }
    }
    
    public void limparCampos(){
        
        txtNome.setText("");
        txtCpf.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");
        txtID.setText("");
        
        txtCpf.setEditable(true);
        txtCpf.setEnabled(true);
    }
    
    public void salvarCliente(){
        Cliente cliente = new Cliente();
        
        cliente.setNome(txtNome.getText());
        cliente.setCpf(txtCpf.getText().replaceAll("\\D", ""));
        cliente.setTelefone(txtTelefone.getText().replaceAll("\\D", ""));
        cliente.setEmail(txtEmail.getText());
        
        ClienteDAO dao = new ClienteDAO();
        
        dao.cadastrarCliente(cliente);
        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");    
    }
    
    public void alterarCliente(){
        Cliente cliente = new Cliente();
       
        cliente.setId(Integer.parseInt(txtID.getText()));
        cliente.setNome(txtNome.getText());
        cliente.setTelefone(txtTelefone.getText().replaceAll("\\D", ""));
        cliente.setEmail(txtEmail.getText());
        cliente.setCpf(txtCpf.getText().replaceAll("\\D", ""));
        
        ClienteDAO dao = new ClienteDAO();
        dao.editarCliente(cliente);
        JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
    }
    
    public boolean validarCliente(){
        
        String cpf = txtCpf.getText().replace(".", "").replace("-", "");
        String nome = txtNome.getText();
        String telefone = txtTelefone.getText().replace("(", "").replace(")", "").replace("-", "").replace(" ", "");
        String email = txtEmail.getText();
        ClienteDAO dao = new ClienteDAO();
        
        if(telefone.length() <= 10 || telefone.length() > 11){
            
            JOptionPane.showMessageDialog(null, "Telefone Inválido");
            
            return false;
        }
        
        if(!telefone.matches("\\d+")){
            
            JOptionPane.showMessageDialog(null, "Telefone deve conter apenas números");
            
            return false;
        }
       
        if(nome.trim().isEmpty()){
            
            JOptionPane.showMessageDialog(null, "Digite o nome do cliente");
            
            return false;
        }
        
        if(!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")){
            
            JOptionPane.showMessageDialog(null, "Email inválido");
            
            return false;
        }
        
        if(cpf.isEmpty()){
            
            JOptionPane.showMessageDialog(null, "Digite o CPF");
            
            return false;
        }
        
        if(dao.cpfExiste(cpf)){
            
            JOptionPane.showMessageDialog(null, "CPF já existe");
            
            return false;
        }
        
        if(!cpf.matches("\\d+")){
            
            JOptionPane.showMessageDialog(null, "CPF deve conter apenas números");
            
            return false;
        }
        
        if(cpf.length() != 11){
            
            JOptionPane.showMessageDialog(null, "CPF inválido");
            
            return false;
        }
        
        return true;
    }
    
    public boolean validarClienteAlterado(){
        
        String cpf = txtCpf.getText().replace(".", "").replace("-", "");
        String nome = txtNome.getText();
        String telefone = txtTelefone.getText().replace("(", "").replace(")", "").replace("-", "").replace(" ", "");
        String email = txtEmail.getText();
        ClienteDAO dao = new ClienteDAO();
        
        if(telefone.length() <= 10 || telefone.length() > 11){
            
            JOptionPane.showMessageDialog(null, "Telefone Inválido");
            
            return false;
        }
        
        if(!telefone.matches("\\d+")){
            
            JOptionPane.showMessageDialog(null, "Telefone deve conter apenas números");
            
            return false;
        }
       
        if(nome.trim().isEmpty()){
            
            JOptionPane.showMessageDialog(null, "Digite o nome do cliente");
            
            return false;
        }
        
        if(!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")){
            
            JOptionPane.showMessageDialog(null, "Email inválido");
            
            return false;
        }
        
        if(cpf.isEmpty()){
            
            JOptionPane.showMessageDialog(null, "Digite o CPF");
            
            return false;
        }
       
        if(!cpf.matches("\\d+")){
            
            JOptionPane.showMessageDialog(null, "CPF deve conter apenas números");
            
            return false;
        }
        
        if(cpf.length() != 11){
            
            JOptionPane.showMessageDialog(null, "CPF inválido");
            
            return false;
        }
        
        return true;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCpf = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaCliente = new javax.swing.JTable();
        btnAlterar = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        btnExcluir = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome");

        jLabel2.setText("CPF");

        jLabel3.setText("Telefone");

        jLabel4.setText("Email");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        txtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfActionPerformed(evt);
            }
        });

        txtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneActionPerformed(evt);
            }
        });

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        tabelaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "CPF", "Telefone", "Email"
            }
        ));
        tabelaCliente.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tabelaClienteAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tabelaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClienteMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelaCliente);

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        txtID.setText("txtID");
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtEmail)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                .addGap(41, 41, 41)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(63, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        if(validarCliente()){
            salvarCliente();
            listarClientes();
            limparCampos();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    
    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneActionPerformed

    private void tabelaClienteAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tabelaClienteAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaClienteAncestorAdded

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
        
            if(validarClienteAlterado()){
            alterarCliente();
            listarClientes();
            limparCampos();
            }
        
        
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void tabelaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClienteMouseClicked

        int linha = tabelaCliente.getSelectedRow();
        
        txtID.setText(tabelaCliente.getValueAt(linha, 0).toString());
        txtNome.setText(tabelaCliente.getValueAt(linha, 1).toString());
        txtTelefone.setText(tabelaCliente.getValueAt(linha, 3).toString());
        txtEmail.setText(tabelaCliente.getValueAt(linha, 4).toString());
        txtCpf.setText(tabelaCliente.getValueAt(linha, 2).toString());
        
        txtCpf.setEditable(false);
        txtCpf.setEnabled(false);
    }//GEN-LAST:event_tabelaClienteMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        
        if(txtID.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Selecione um cliente para excluir");
            
            return;
        }
        
        Cliente cliente = new Cliente();
       
        
        cliente.setId(Integer.parseInt(txtID.getText()));
        cliente.setNome(txtNome.getText());
        cliente.setTelefone(txtTelefone.getText());
        cliente.setEmail(txtEmail.getText());
        cliente.setCpf(txtCpf.getText());
        
        
        ClienteDAO dao = new ClienteDAO();

        int conf = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esse cliente?", "Confirmar", JOptionPane.YES_NO_OPTION);
        
        if (conf == JOptionPane.YES_OPTION){
            
            dao.excluirCliente(cliente);
        
            listarClientes();
            limparCampos();
            
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
        }
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tabelaCliente;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
