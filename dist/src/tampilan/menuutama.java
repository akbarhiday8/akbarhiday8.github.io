/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilan;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author Akbar
 */
public class menuutama extends javax.swing.JFrame {

    /**
     * Creates new form menuutama
     */
    public menuutama() {
        initComponents();
        setSize(623,495);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btntamu = new javax.swing.JButton();
        btnguru = new javax.swing.JButton();
        btnpesdik = new javax.swing.JButton();
        btnkunjungan = new javax.swing.JButton();
        btnizinpesdik = new javax.swing.JButton();
        btnizinguru = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnlogout = new javax.swing.JButton();
        btnguru1 = new javax.swing.JButton();
        btnizinguru1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Utama Resepsionis Apk");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/gambar/SMK_Negeri_8_Jakarta (2).png")).getImage());
        setResizable(false);
        setSize(new java.awt.Dimension(623, 495));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        jLabel2.setFont(new java.awt.Font("Gobold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/SMK_Negeri_8_Jakarta (2).png"))); // NOI18N
        jLabel2.setText("SELAMAT DATANG | RESEPSIONIS SMKN 8 JAKARTA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        btntamu.setBackground(new java.awt.Color(51, 153, 255));
        btntamu.setFont(new java.awt.Font("Gobold", 0, 18)); // NOI18N
        btntamu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/guest-list.png"))); // NOI18N
        btntamu.setText("DATA TAMU");
        btntamu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntamuActionPerformed(evt);
            }
        });

        btnguru.setBackground(new java.awt.Color(51, 153, 255));
        btnguru.setFont(new java.awt.Font("Gobold", 0, 18)); // NOI18N
        btnguru.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/teacher.png"))); // NOI18N
        btnguru.setText("DATA GURU");
        btnguru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguruActionPerformed(evt);
            }
        });

        btnpesdik.setBackground(new java.awt.Color(51, 153, 255));
        btnpesdik.setFont(new java.awt.Font("Gobold", 0, 18)); // NOI18N
        btnpesdik.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/graduated (1).png"))); // NOI18N
        btnpesdik.setText("DATA PESERTA DIDIK");
        btnpesdik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpesdikActionPerformed(evt);
            }
        });

        btnkunjungan.setBackground(new java.awt.Color(51, 153, 255));
        btnkunjungan.setFont(new java.awt.Font("Gobold", 0, 18)); // NOI18N
        btnkunjungan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/guest-book-icon-11605 (2).png"))); // NOI18N
        btnkunjungan.setText("KUNJUNGAN");
        btnkunjungan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkunjunganActionPerformed(evt);
            }
        });

        btnizinpesdik.setBackground(new java.awt.Color(51, 153, 255));
        btnizinpesdik.setFont(new java.awt.Font("Gobold", 0, 18)); // NOI18N
        btnizinpesdik.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/writing.png"))); // NOI18N
        btnizinpesdik.setText("IZIN PESERTA DIDIK");
        btnizinpesdik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnizinpesdikActionPerformed(evt);
            }
        });

        btnizinguru.setBackground(new java.awt.Color(51, 153, 255));
        btnizinguru.setFont(new java.awt.Font("Gobold", 0, 18)); // NOI18N
        btnizinguru.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/form.png"))); // NOI18N
        btnizinguru.setText("IZIN GURU");
        btnizinguru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnizinguruActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Gobold", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("~MENU UTAMA~");

        btnlogout.setBackground(new java.awt.Color(51, 153, 255));
        btnlogout.setFont(new java.awt.Font("Gobold", 0, 18)); // NOI18N
        btnlogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/exit (1).png"))); // NOI18N
        btnlogout.setText("LOG OUT");
        btnlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogoutActionPerformed(evt);
            }
        });

        btnguru1.setBackground(new java.awt.Color(51, 153, 255));
        btnguru1.setFont(new java.awt.Font("Gobold", 0, 18)); // NOI18N
        btnguru1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/brackets-grouping-symbol.png"))); // NOI18N
        btnguru1.setText("LAPORAN PARAMETER");
        btnguru1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguru1ActionPerformed(evt);
            }
        });

        btnizinguru1.setBackground(new java.awt.Color(51, 153, 255));
        btnizinguru1.setFont(new java.awt.Font("Gobold", 0, 18)); // NOI18N
        btnizinguru1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/seo-report.png"))); // NOI18N
        btnizinguru1.setText("REKAPAN LAPORAN");
        btnizinguru1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnizinguru1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnlogout)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnpesdik, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnguru, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btntamu, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnguru1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(87, 87, 87)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnkunjungan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnizinpesdik, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnizinguru, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnizinguru1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(76, 76, 76))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btntamu)
                    .addComponent(btnkunjungan))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnpesdik)
                    .addComponent(btnizinpesdik))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguru)
                    .addComponent(btnizinguru))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguru1)
                    .addComponent(btnizinguru1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(btnlogout)
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(639, 534));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btntamuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntamuActionPerformed
        // TODO add your handling code here:
        new tamu().setVisible(true);
        dispose();
    }//GEN-LAST:event_btntamuActionPerformed

    private void btnguruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguruActionPerformed
        // TODO add your handling code here:
        new guru().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnguruActionPerformed

    private void btnpesdikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpesdikActionPerformed
        // TODO add your handling code here:
        new pesdik().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnpesdikActionPerformed

    private void btnkunjunganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkunjunganActionPerformed
        // TODO add your handling code here:
        new kunjungan().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnkunjunganActionPerformed

    private void btnizinpesdikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnizinpesdikActionPerformed
        // TODO add your handling code here:
        new izinpesertadidik().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnizinpesdikActionPerformed

    private void btnizinguruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnizinguruActionPerformed
        // TODO add your handling code here:
        new izinguru().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnizinguruActionPerformed

    private void btnlogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogoutActionPerformed
        // TODO add your handling code here:
        int x = JOptionPane.showConfirmDialog(null, "Anda yakin ingin Logout dari program ini?", "Keluar", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
        if (x == JOptionPane.YES_OPTION) {
            new login().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnlogoutActionPerformed

    private void btnguru1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguru1ActionPerformed
        // TODO add your handling code here:
        new tampilan.laporanparameter().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnguru1ActionPerformed

    private void btnizinguru1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnizinguru1ActionPerformed
        // TODO add your handling code here:
        new tampilan.rekapanlaporan().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnizinguru1ActionPerformed

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
            java.util.logging.Logger.getLogger(menuutama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuutama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuutama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuutama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuutama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnguru;
    private javax.swing.JButton btnguru1;
    private javax.swing.JButton btnizinguru;
    private javax.swing.JButton btnizinguru1;
    private javax.swing.JButton btnizinpesdik;
    private javax.swing.JButton btnkunjungan;
    private javax.swing.JButton btnlogout;
    private javax.swing.JButton btnpesdik;
    private javax.swing.JButton btntamu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
