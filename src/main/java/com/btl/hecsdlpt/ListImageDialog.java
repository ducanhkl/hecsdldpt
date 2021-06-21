/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.hecsdlpt;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.ImageIcon;

/**
 *
 * @author chudu
 */
public class ListImageDialog extends javax.swing.JDialog {

    /**
     * Creates new form ListImageDialog
     */
    public ListImageDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        btn_truoc = new javax.swing.JButton();
        btl_sau = new javax.swing.JButton();
        img_lbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btn_truoc.setText("Trước");
        btn_truoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_truocActionPerformed(evt);
            }
        });

        btl_sau.setText("Sau");
        btl_sau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btl_sauActionPerformed(evt);
            }
        });

        img_lbl.setText("lbl_image");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_truoc)
                        .addGap(68, 68, 68)
                        .addComponent(btl_sau)))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(img_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_truoc)
                    .addComponent(btl_sau))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_truocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_truocActionPerformed
        // TODO add your handling code here:
        this.pos --;
        showImage();
    }//GEN-LAST:event_btn_truocActionPerformed

    private void btl_sauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btl_sauActionPerformed
        // TODO add your handling code here:
        this.pos ++;
        showImage();
    }//GEN-LAST:event_btl_sauActionPerformed

    /**
     * @param args the command line arguments
     */
    
    private String[] imagePaths;
    private Integer pos = 0;
    
    
    public void showImage(String imagePath) {
        img_lbl.setIcon(new ImageIcon(imagePath));
    }
    
    public void showImage() {
        if (Objects.isNull(imagePaths) || imagePaths.length == 0) {
            return ;
        }
        this.pos = Math.min(this.pos, imagePaths.length-1);
        this.pos = Math.max(0, this.pos);   
        if (imagePaths.length == 0) {
            return;
        }
        showImage(imagePaths[this.pos]);
    }
    
    public void showListImage(String[] imagePaths) {
        pos = 0;
        for (int i = 0; i < imagePaths.length; i++) {
            System.out.println(imagePaths[i]);
        }
        this.imagePaths = imagePaths;
        showImage();
    }
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btl_sau;
    private javax.swing.JButton btn_truoc;
    private javax.swing.JLabel img_lbl;
    // End of variables declaration//GEN-END:variables
}
