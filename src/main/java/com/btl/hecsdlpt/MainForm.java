/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.hecsdlpt;

import com.btl.hecsdlpt.imageSearch.FindImageSimilarApp;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author chudu
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    
    public String imageFolder = null;
    private String imageQuery;
    private FindImageSimilarApp findImageSimilarApp = new FindImageSimilarApp();
    public MainForm() {
        initComponents();
        
        this.setTitle("Tìm kiếm");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_open_image = new javax.swing.JButton();
        btn_search = new javax.swing.JButton();
        lbl_image = new javax.swing.JLabel();
        chooseFolderButton = new javax.swing.JButton();
        imageFolderLbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_open_image.setText("Open Image");
        btn_open_image.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_open_imageActionPerformed(evt);
            }
        });

        btn_search.setText("Perform");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        lbl_image.setText("______");

        chooseFolderButton.setText("Open Folder");
        chooseFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseFolderButtonActionPerformed(evt);
            }
        });

        imageFolderLbl.setText("D:\\");

            jLabel2.setText("Image Folder");

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(53, 53, 53)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(49, 49, 49)
                            .addComponent(imageFolderLbl)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btn_search)
                                .addComponent(btn_open_image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(chooseFolderButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                            .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(58, 58, 58))))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(imageFolderLbl)
                                .addComponent(jLabel2))
                            .addGap(73, 73, 73)
                            .addComponent(chooseFolderButton)
                            .addGap(38, 38, 38)
                            .addComponent(btn_open_image)
                            .addGap(60, 60, 60)
                            .addComponent(btn_search))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(56, 56, 56)
                            .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(137, Short.MAX_VALUE))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    
    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:
        if (Objects.isNull(imageQuery)) {
            JOptionPane.showMessageDialog(null, "Not choose image");
            return ;
        }
        
        if (Objects.isNull(imageFolder)) {
            JOptionPane.showConfirmDialog(null, "Not choose image folder");
        }
        
        ListImageDialog listImageDialog = new ListImageDialog(this, true);
        listImageDialog.setTitle("Danh sách ảnh tương tự");
        try {
            String[] imagePaths = findImageSimilarApp.getSimilar(imageQuery);
            listImageDialog.showListImage(imagePaths);
            listImageDialog.setVisible(true);
        } catch (Exception e) {
           e.printStackTrace();
        }
    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_open_imageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_open_imageActionPerformed
        // TODO add your handling code here:
        final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            lbl_image.setIcon(new ImageIcon(file.getAbsolutePath()));
            imageQuery = file.getAbsolutePath();
        }
    }//GEN-LAST:event_btn_open_imageActionPerformed

    private void chooseFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseFolderButtonActionPerformed
        // TODO add your handling code here:
        final JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            imageFolder = file.getAbsolutePath();
            imageFolderLbl.setText(imageFolder);
            try {
                findImageSimilarApp.addToDataSet(imageFolder);
            } catch (Exception ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_chooseFolderButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_open_image;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton chooseFolderButton;
    private javax.swing.JLabel imageFolderLbl;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbl_image;
    // End of variables declaration//GEN-END:variables
}
