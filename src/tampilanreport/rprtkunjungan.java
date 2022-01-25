/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilanreport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Akbar
 */
public class rprtkunjungan extends javax.swing.JFrame {
    public final Connection conn = new koneksi(). connect();
    DefaultTableModel tabmodel = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    /**
     * Creates new form rprttamu
     */
    
    public void datatable(){
         Object[] Baris = {"No Visit","NIK","Nama Tamu","Jenis Kelamin","Keperluan","Tanggal Datang","Keterangan"};
         tabmodel = new DefaultTableModel(null, Baris){
         public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
         tblkunjungan.setModel(tabmodel);
         String sql ="SELECT * FROM kunjungan ORDER BY novisit ASC";
         try{
             java.sql.Statement stat = conn.createStatement();
             ResultSet hasil = stat.executeQuery(sql);
             while (hasil.next()){
                 String novisit = hasil.getString("novisit");
                 String nik = hasil.getString("nik");
                 String nm_tamu = hasil.getString("nm_tamu");
                 String jk_tamu = hasil.getString("jk_tamu");
                 String keperluan = hasil.getString("keperluan");
                 String tgldtg = hasil.getString("tgldtg");
                 String keterangan = hasil.getString("keterangan");
                 
                 String[] data = {novisit, nik, nm_tamu, jk_tamu, keperluan, tgldtg, keterangan};
                 tabmodel.addRow(data);
//                 noTable();
//                 lebarKolom();
             }
         }catch(Exception e){
     }
     }
    
    public void Pencarian(String sql){
        Object[] Baris = {"No Visit","NIK","Nama Tamu","Jenis Kelamin","Keperluan","Tanggal Datang","Keterangan"};
         tabmodel = new DefaultTableModel(null, Baris);
         tblkunjungan.setModel(tabmodel);
         int brs = tblkunjungan.getRowCount();
         for (int i = 0; 1 < brs; i++){
            tabmodel.removeRow(1);
        }
         try{
             java.sql.Statement stat = conn.createStatement();
             ResultSet hasil = stat.executeQuery(sql);
             while (hasil.next()){
                 String novisit = hasil.getString("novisit");
                 String nik = hasil.getString("nik");
                 String nm_tamu = hasil.getString("nm_tamu");
                 String jk_tamu = hasil.getString("jk_tamu");
                 String keperluan = hasil.getString("keperluan");
                 String tgldtg = hasil.getString("tgldtg");
                 String keterangan = hasil.getString("keterangan");
                 
                 String[] data = {novisit, nik, nm_tamu, jk_tamu, keperluan, tgldtg, keterangan};
                 tabmodel.addRow(data);
//                 noTable();
//                 lebarKolom();
             }
         }catch(Exception e){
             
         }  
}
    public rprtkunjungan() {
        initComponents();
        datatable();
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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tanggal1 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        tanggal2 = new com.toedter.calendar.JDateChooser();
        btncetakpertanggal = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtcari = new placeholder.caritamu();
        btnsearch = new javax.swing.JButton();
        btnprint = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblkunjungan = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuutama = new javax.swing.JMenuItem();
        logout = new javax.swing.JMenuItem();
        pendataan = new javax.swing.JMenu();
        tamu = new javax.swing.JMenuItem();
        siswa = new javax.swing.JMenuItem();
        guru = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        kunjungan = new javax.swing.JMenuItem();
        izinsiswa = new javax.swing.JMenuItem();
        izinguru = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        lapparameter = new javax.swing.JMenuItem();
        rekapanlap = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        jLabel2.setFont(new java.awt.Font("Gobold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/SMK_Negeri_8_Jakarta (2).png"))); // NOI18N
        jLabel2.setText("LAPORAN PARAMETER KUNJUNGAN SMKN 8 JAKARTA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "CETAK LAPORAN PER TANGGAL", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1.setText("DARI TANGGAL ");

        tanggal1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setText("SAMPAI TANGGAL");

        tanggal2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        btncetakpertanggal.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btncetakpertanggal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/printing.png"))); // NOI18N
        btncetakpertanggal.setText("PRINT");
        btncetakpertanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncetakpertanggalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(tanggal1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(tanggal2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btncetakpertanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btncetakpertanggal)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tanggal1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tanggal2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "CETAK LAPORAN BERDASARKAN KOLOM", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 14))); // NOI18N

        txtcari.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcariActionPerformed(evt);
            }
        });
        txtcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcariKeyPressed(evt);
            }
        });

        btnsearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/magnifier.png"))); // NOI18N
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        btnprint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/printing.png"))); // NOI18N
        btnprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprintActionPerformed(evt);
            }
        });

        tblkunjungan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No Visit", "NIK", "Nama Tamu", "Jenis Kelamin", "Keperluan", "Tanggal Datang", "Keterangan Tamu"
            }
        ));
        jScrollPane2.setViewportView(tblkunjungan);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnsearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnprint)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnsearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnprint, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtcari, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuBar1.setFont(new java.awt.Font("Gobold", 0, 14)); // NOI18N

        jMenu1.setText("Main Menu");
        jMenu1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        menuutama.setText("Menu Utama");
        menuutama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuutamaActionPerformed(evt);
            }
        });
        jMenu1.add(menuutama);

        logout.setText("Log Out");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        jMenu1.add(logout);

        jMenuBar1.add(jMenu1);

        pendataan.setText("Pendataan");
        pendataan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tamu.setText("Data Tamu");
        tamu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tamuActionPerformed(evt);
            }
        });
        pendataan.add(tamu);

        siswa.setText("Data Peserta Didik");
        siswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siswaActionPerformed(evt);
            }
        });
        pendataan.add(siswa);

        guru.setText("Data Guru");
        guru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guruActionPerformed(evt);
            }
        });
        pendataan.add(guru);

        jMenuBar1.add(pendataan);

        jMenu3.setText("Pelayanan");
        jMenu3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        kunjungan.setText("Kunjungan");
        kunjungan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kunjunganActionPerformed(evt);
            }
        });
        jMenu3.add(kunjungan);

        izinsiswa.setText("Form Izin Pesdik");
        izinsiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izinsiswaActionPerformed(evt);
            }
        });
        jMenu3.add(izinsiswa);

        izinguru.setText("Form Izin Guru");
        izinguru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izinguruActionPerformed(evt);
            }
        });
        jMenu3.add(izinguru);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Laporan");
        jMenu4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lapparameter.setText("Laporan Parameter");
        lapparameter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lapparameterActionPerformed(evt);
            }
        });
        jMenu4.add(lapparameter);

        rekapanlap.setText("Rekapan Laporan");
        rekapanlap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rekapanlapActionPerformed(evt);
            }
        });
        jMenu4.add(rekapanlap);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(600, 662));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtcariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyPressed
        // TODO add your handling code here:
        String sqlPencarian = "select * from kunjungan where nm_tamu like '%" + txtcari.getText() + "%' or "
        + "keperluan like '%" + txtcari.getText() + "%' or "
        + "novisit like '%" + txtcari.getText() + "%' or "
        + "nik like '%" + txtcari.getText() + "%' or "
        + "jk_tamu like '%" + txtcari.getText() + "%' or "
        + "tgldtg like '%" + txtcari.getText() + "%' or "
        + "keterangan like '%" + txtcari.getText() + "%'";
        Pencarian(sqlPencarian);
    }//GEN-LAST:event_txtcariKeyPressed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        // TODO add your handling code here:
        String sqlPencarian = "select * from kunjungan where nm_tamu like '%" + txtcari.getText() + "%' or "
        + "keperluan like '%" + txtcari.getText() + "%' or "
        + "novisit like '%" + txtcari.getText() + "%' or "
        + "nik like '%" + txtcari.getText() + "%' or "
        + "jk_tamu like '%" + txtcari.getText() + "%' or "
        + "tgldtg like '%" + txtcari.getText() + "%' or "
        + "keterangan like '%" + txtcari.getText() + "%'";
        Pencarian(sqlPencarian);
    }//GEN-LAST:event_btnsearchActionPerformed

    private void txtcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcariActionPerformed

    private void btncetakpertanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncetakpertanggalActionPerformed
        // TODO add your handling code here:
        java.sql.Connection con = null;
        try{
            String tampilan = "dd-MM-yyyy";
            SimpleDateFormat fm = new SimpleDateFormat(tampilan);
            String tanggal = String.valueOf(fm.format(tanggal1.getDate()));
            String tanggal1 = String.valueOf(fm.format(tanggal2.getDate()));
            
            String jdbcDriver = "com.mysql.jdbc.Driver";
            Class.forName(jdbcDriver);
            
            String url = "jdbc:mysql://localhost:3306/db_resepsionis8jkt";
            String user = "root";
            String pass = "";
            
            con = DriverManager.getConnection(url, user, pass);
            Statement stm = con.createStatement();
            try{
                
                String report = ("src/laporan/rprtkunjungan.jrxml");
                HashMap hash = new HashMap();
                //mengambil parameter ireport
                hash.put("tgl1", tanggal.toString());
                hash.put("tgl2", tanggal1.toString());
                JasperReport Jrpt = JasperCompileManager.compileReport(report);
                JasperPrint JPrint = JasperFillManager.fillReport(Jrpt, hash, con);
                JasperViewer.viewReport(JPrint, false);
            }catch (Exception rptexcpt){
                System.out.println("Report can't view because : " + rptexcpt);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_btncetakpertanggalActionPerformed

    private void btnprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprintActionPerformed
        // TODO add your handling code here:
        java.sql.Connection con = null;
        try{
            String jdbcDriver = "com.mysql.jdbc.Driver";
            Class.forName(jdbcDriver);
            
            String url = "jdbc:mysql://localhost:3306/db_resepsionis8jkt";
            String user = "root";
            String pass = "";
            
            con = DriverManager.getConnection(url, user, pass);
            Statement stm = con.createStatement();
            try{
                
                String report = ("src/laporan/kolomkunjungan.jrxml");
                HashMap hash = new HashMap();
                //mengambil parameter ireport
                hash.put("kunjungan", txtcari.getText());
                JasperReport Jrpt = JasperCompileManager.compileReport(report);
                JasperPrint JPrint = JasperFillManager.fillReport(Jrpt, hash, con);
                JasperViewer.viewReport(JPrint, false);
            }catch (Exception rptexcpt){
                System.out.println("Report can't view because : " + rptexcpt);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_btnprintActionPerformed

    private void menuutamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuutamaActionPerformed
        // TODO add your handling code here:
        new tampilan.menuutama().setVisible(true);
        dispose();
    }//GEN-LAST:event_menuutamaActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        new tampilan.login().setVisible(true);
        dispose();
    }//GEN-LAST:event_logoutActionPerformed

    private void tamuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tamuActionPerformed
        // TODO add your handling code here:
        new tampilan.tamu().setVisible(true);
        dispose();
    }//GEN-LAST:event_tamuActionPerformed

    private void siswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siswaActionPerformed
        // TODO add your handling code here:
        new tampilan.pesdik().setVisible(true);
        dispose();
    }//GEN-LAST:event_siswaActionPerformed

    private void guruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guruActionPerformed
        // TODO add your handling code here:
        new tampilan.guru().setVisible(true);
        dispose();
    }//GEN-LAST:event_guruActionPerformed

    private void kunjunganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kunjunganActionPerformed
        // TODO add your handling code here:
        new tampilan.kunjungan().setVisible(true);
        dispose();
    }//GEN-LAST:event_kunjunganActionPerformed

    private void izinsiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izinsiswaActionPerformed
        // TODO add your handling code here:
        new tampilan.izinpesertadidik().setVisible(true);
        dispose();
    }//GEN-LAST:event_izinsiswaActionPerformed

    private void izinguruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izinguruActionPerformed
        // TODO add your handling code here:
        new tampilan.izinguru().setVisible(true);
        dispose();
    }//GEN-LAST:event_izinguruActionPerformed

    private void lapparameterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lapparameterActionPerformed
        // TODO add your handling code here:
        new tampilan.laporanparameter().setVisible(true);
        dispose();
    }//GEN-LAST:event_lapparameterActionPerformed

    private void rekapanlapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rekapanlapActionPerformed
        // TODO add your handling code here:
        new tampilan.rekapanlaporan().setVisible(true);
        dispose();
    }//GEN-LAST:event_rekapanlapActionPerformed

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
            java.util.logging.Logger.getLogger(rprtkunjungan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(rprtkunjungan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(rprtkunjungan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(rprtkunjungan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new rprtkunjungan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncetakpertanggal;
    private javax.swing.JButton btnprint;
    private javax.swing.JButton btnsearch;
    private javax.swing.JMenuItem guru;
    private javax.swing.JMenuItem izinguru;
    private javax.swing.JMenuItem izinsiswa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem kunjungan;
    private javax.swing.JMenuItem lapparameter;
    private javax.swing.JMenuItem logout;
    private javax.swing.JMenuItem menuutama;
    private javax.swing.JMenu pendataan;
    private javax.swing.JMenuItem rekapanlap;
    private javax.swing.JMenuItem siswa;
    private javax.swing.JMenuItem tamu;
    private com.toedter.calendar.JDateChooser tanggal1;
    private com.toedter.calendar.JDateChooser tanggal2;
    private javax.swing.JTable tblkunjungan;
    private javax.swing.JTextField txtcari;
    // End of variables declaration//GEN-END:variables
}
