/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Codigo.Bd;
import Codigo.Conta;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author vinicius
 */
public class Todascontas extends javax.swing.JFrame {
MaskFormatter mascaraData;
    /**
     * Creates new form Todascontas
     */
    public Todascontas() {
        initComponents();
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Desc_text = new javax.swing.JTextField();
        Valor_text = new javax.swing.JTextField();
        Novo = new javax.swing.JButton();
        Adicionar = new javax.swing.JButton();
        Remover = new javax.swing.JButton();
        Editar = new javax.swing.JButton();
        Fechar = new javax.swing.JButton();
        Salvar = new javax.swing.JButton();
        data_erro = new javax.swing.JLabel();
        desc_erro = new javax.swing.JLabel();
        valor_erro = new javax.swing.JLabel();
        Data_text = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        Tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Descrição", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabela);

        jLabel1.setText("Data");

        jLabel2.setText("Descrição");

        jLabel3.setText("Valor R$");

        Desc_text.setEnabled(false);
        Desc_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Desc_textActionPerformed(evt);
            }
        });

        Valor_text.setEnabled(false);

        Novo.setText("Novo");
        Novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NovoActionPerformed(evt);
            }
        });

        Adicionar.setText("Adicionar");
        Adicionar.setEnabled(false);
        Adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarActionPerformed(evt);
            }
        });

        Remover.setText("Remover");
        Remover.setEnabled(false);
        Remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoverActionPerformed(evt);
            }
        });

        Editar.setText("Editar");
        Editar.setEnabled(false);
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });

        Fechar.setText("Fechar");
        Fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FecharActionPerformed(evt);
            }
        });

        Salvar.setText("Salvar");
        Salvar.setEnabled(false);
        Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarActionPerformed(evt);
            }
        });

        try{
            mascaraData = new MaskFormatter("##/##/####");
            mascaraData.setPlaceholderCharacter('_');
        }
        catch(ParseException excp){}

        Data_text  = new JFormattedTextField(mascaraData);
        Data_text.setCaretPosition(0);
        Data_text.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Data_text, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(102, 102, 102)
                                .addComponent(data_erro))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Desc_text, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(desc_erro))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Valor_text, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(valor_erro))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(Novo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Adicionar)
                        .addGap(18, 18, 18)
                        .addComponent(Remover)
                        .addGap(18, 18, 18)
                        .addComponent(Editar)
                        .addGap(18, 18, 18)
                        .addComponent(Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(Fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Adicionar, Editar, Novo, Remover, Salvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(data_erro)
                    .addComponent(Data_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Desc_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(desc_erro)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Valor_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(valor_erro)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Novo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Adicionar)
                    .addComponent(Remover)
                    .addComponent(Editar)
                    .addComponent(Fechar)
                    .addComponent(Salvar))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Adicionar, Editar, Novo, Remover, Salvar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FecharActionPerformed
        dispose();      // TODO add your handling code here:
    }//GEN-LAST:event_FecharActionPerformed

    private void NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovoActionPerformed
        Adicionar.setEnabled(true);
        Remover.setEnabled(false);
        Editar.setEnabled(false);
        Data_text.setEnabled(true);
        Desc_text.setEnabled(true);
        Valor_text.setEnabled(true);
        Data_text.setText("");
        Valor_text.setText("");
        Desc_text.setText("");
        Data_text.requestFocus();
        valor_erro.setText("*Campo Obrigatório");
        desc_erro.setText("*Campo Obrigatório");
        data_erro.setText("*Campo Obrigatório");
       
        // TODO add your handling code here:
    }//GEN-LAST:event_NovoActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
           Salvar.setEnabled(true);     
           Data_text.setEnabled(true);
           Desc_text.setEnabled(true);
           Valor_text.setEnabled(true);
            // TODO add your handling code here:
    }//GEN-LAST:event_EditarActionPerformed

    private void TabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaMouseClicked
        if(Tabela.getSelectedRow()>-1){
            Remover.setEnabled(true);
            Editar.setEnabled(true);
            Object test =   Tabela.getValueAt(Tabela.getSelectedRow(),0);
            Data_text.setText((String) test);
            Object test2 =   Tabela.getValueAt(Tabela.getSelectedRow(),1);
            Desc_text.setText((String) test2);
            Object test3 =   Tabela.getValueAt(Tabela.getSelectedRow(),2);
            Valor_text.setText(test3.toString());
        }
    }//GEN-LAST:event_TabelaMouseClicked

    private void RemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoverActionPerformed
        Bd bd = new Bd();
        try {
            bd.deleta(Tabela.getSelectedRow());
            this.pegatudo();
            Remover.setEnabled(false);
            Editar.setEnabled(false);
            Data_text.setText("");
            Desc_text.setText("");
            Valor_text.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(Todascontas.class.getName()).log(Level.SEVERE, null, ex);
        }       // TODO add your handling code here:
    }//GEN-LAST:event_RemoverActionPerformed

    private void AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarActionPerformed
        if(Data_text.getText().isEmpty()|| Desc_text.getText().isEmpty()||Valor_text.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Preencha os campos corretamente!","Erro",JOptionPane.ERROR_MESSAGE);
       }else{
            Conta conta = new Conta();
            conta.setData(Data_text.getText());
            conta.setDescricao(Desc_text.getText());
            String str = Valor_text.getText();
            if(str.contains(",")){
                str = str.replace(",",".");
            }
        conta.setValor(Float.parseFloat(str));
        Bd bd = new Bd();
        try {
            bd.inserir(conta);
        } catch (ParseException ex) {
            Logger.getLogger(Todascontas.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.pegatudo();
        Adicionar.setEnabled(false);
        Data_text.setText("");
        Desc_text.setText("");
        Valor_text.setText("");
        Data_text.setEnabled(false);
        Desc_text.setEnabled(false);
        Valor_text.setEnabled(false);
       }
        
        
// TODO add your handling code here:
    }//GEN-LAST:event_AdicionarActionPerformed

    private void SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarActionPerformed
        Conta conta = new Conta();
        conta.setId(Tabela.getSelectedRow());
        conta.setData(Data_text.getText());
        conta.setDescricao(Desc_text.getText());
        String str = Valor_text.getText();
        if(str.contains(",")){
            str = str.replace(",",".");
        }
        conta.setValor(Float.parseFloat(str));
        Bd bd = new Bd();
        try {
            bd.atualizar(conta);
        } catch (SQLException ex) {
            Logger.getLogger(Todascontas.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.pegatudo();
        Salvar.setEnabled(false);
        Editar.setEnabled(false);
        Remover.setEnabled(false);
        Data_text.setEnabled(false);
        Desc_text.setEnabled(false);
        Valor_text.setEnabled(false);
        Data_text.setText("");
        Desc_text.setText("");
        Valor_text.setText("");


        // TODO add your handling code here:
    }//GEN-LAST:event_SalvarActionPerformed

    private void Desc_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Desc_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Desc_textActionPerformed

            
        
        
     /* @param args the command line arguments
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Todascontas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
              Todascontas conta =   new Todascontas();
              conta.setVisible(true);
              
            }
        });
    }
    public void pegatudo(){
        Bd bd = new Bd();
        bd.getConnection();
        ArrayList<Conta> array = new ArrayList();
        try {
            array = bd.select_allconta();
        }catch (SQLException ex) {
            Logger.getLogger(Todascontas.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) this.Tabela.getModel();
        model.setNumRows(0);
        for(int i = 0;i<array.size();i++){
            Conta contas = new Conta();
            contas = array.get(i);
            model.addRow(new Object[]{contas.getData(),contas.getDescricao(),contas.getValor()});
        }
        this.Tabela.setModel(model);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Adicionar;
    private javax.swing.JTextField Data_text;
    private javax.swing.JTextField Desc_text;
    private javax.swing.JButton Editar;
    private javax.swing.JButton Fechar;
    private javax.swing.JButton Novo;
    private javax.swing.JButton Remover;
    private javax.swing.JButton Salvar;
    private javax.swing.JTable Tabela;
    private javax.swing.JTextField Valor_text;
    private javax.swing.JLabel data_erro;
    private javax.swing.JLabel desc_erro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel valor_erro;
    // End of variables declaration//GEN-END:variables

   
  
}
