/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilan;

import java.util.Calendar;
import java.util.Date;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.Dialog;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JFrame;

import koneksi.koneksi;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Akbar
 */
public class izinguru extends javax.swing.JFrame {
    public final Connection conn = new koneksi().connect();
    
    DefaultTableModel tabmodel = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    DefaultTableModel tbl1 = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    private void aktif(){
        txtnoizinguru.setEnabled(true);
        txtnip.setEnabled(false);
        txtnmguru.setEnabled(false);
        laki.setEnabled(false);
        perempuan.setEnabled(false);
        txttelpguru.setEnabled(false);
        alasanbox.setEnabled(true);
        jamizinbox.setEnabled(true);
        jamkembalibox.setEnabled(true);
        txtket.setEnabled(true);
        txtcari.setEnabled(true);
    }
    
    protected void kosong(){
        txtnip.setText(null);;
        txtnmguru.setText(null);
        jkel.clearSelection();
        txttelpguru.setText(null);
        alasanbox.setSelectedIndex(0);
        jamizinbox.setSelectedIndex(0);
        jamkembalibox.setSelectedIndex(0);
        tanggalizin.setCalendar(null);
        txtket.setText(null);
    }
    
    public void tanggal(){
        Date tgl = new Date();
        tanggalizin.setDate(tgl);
//        tglprint.setDate(tgl);
    }
    
    public void datatable(){
         Object[] Baris = {"No Izin Guru","NIP","Nama Guru","Jenis Kelamin","Telpon","Alasan","Tanggal Izin","Jam Izin","Jam Kembali","Keterangan"};
         tabmodel = new DefaultTableModel(null, Baris){
         public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
         tblizinguru.setModel(tabmodel);
         String sql ="SELECT * FROM izinkeluarguru ORDER BY noizinguru ASC";
         try{
             java.sql.Statement stat = conn.createStatement();
             ResultSet hasil = stat.executeQuery(sql);
             while (hasil.next()){
                 String noizinguru = hasil.getString("noizinguru");
                 String nip = hasil.getString("nip");
                 String nm_guru = hasil.getString("nm_guru");
                 String jk_guru = hasil.getString("jk_guru");
                 String telp_guru = hasil.getString("telp_guru");
                 String alasan_guru = hasil.getString("alasan_guru");
                 String tglizin = hasil.getString("tglizin_guru");
                 String jamizin = hasil.getString("jamizin_guru");
                 String jamkembali = hasil.getString("jamkem_guru");
                 String keterangan = hasil.getString("ket_guru");
                 
                 String[] data = {noizinguru, nip, nm_guru, jk_guru, telp_guru ,alasan_guru, tglizin, jamizin, jamkembali, keterangan};
                 tabmodel.addRow(data);
//                 noTable();
//                 lebarKolom();
                }
            }catch(Exception e){
            
            }
    }
    
    public void pencarian(String sql){
        Object[] Baris = {"No Izin Guru","NIP","Nama Guru","Jenis Kelamin","Telpon","Alasan","Tanggal Izin","Jam Izin","Jam Kembali","Keterangan"};
         tabmodel = new DefaultTableModel(null, Baris);
         tblizinguru.setModel(tabmodel);
         int brs = tblizinguru.getRowCount();
         for (int i = 0; 1 < brs; i++){
            tabmodel.removeRow(1);
        }
         try{
             java.sql.Statement stat = conn.createStatement();
             ResultSet hasil = stat.executeQuery(sql);
             while (hasil.next()){
                 String noizinguru = hasil.getString("noizinguru");
                 String nip = hasil.getString("nip");
                 String nm_guru = hasil.getString("nm_guru");
                 String jk_guru = hasil.getString("jk_guru");
                 String telp_guru = hasil.getString("telp_guru");
                 String alasan_guru = hasil.getString("alasan_guru");
                 String tglizin = hasil.getString("tglizin_guru");
                 String jamizin = hasil.getString("jamizin_guru");
                 String jamkembali = hasil.getString("jamkem_guru");
                 String keterangan = hasil.getString("ket_guru");
                 
                 String[] data = {noizinguru, nip, nm_guru, jk_guru, telp_guru ,alasan_guru, tglizin, jamizin, jamkembali, keterangan};
                 tabmodel.addRow(data);
//                 noTable();
//                 lebarKolom();
             }
         }catch(Exception e){
             
         }  
}
    
    private void otomatis(){
    try{
    String sql = "SELECT MAX(RIGHT(noizinguru,4)) AS NO FROM izinkeluarguru";
    Statement st=conn.createStatement();
    ResultSet visit = st.executeQuery(sql);
    while(visit.next()){
        if(visit.first() == false){
            txtnoizinguru.setText("IZINGURU0001");
        }else{
            visit.last();
            int auto_id = visit.getInt(1) + 1;
            String no = String.valueOf(auto_id);
            int NomorJual = no.length();
            for(int j=0; j<4-NomorJual; j++){
                no = "0" + no;
            }
            txtnoizinguru.setText("IZINGURU" + no);
        }
    }
    visit.close();
    st.close();
    }catch (Exception e){
        JOptionPane.showMessageDialog(this, "ERROR: \n" + e.toString(),
                                    "Kesalahan", JOptionPane.WARNING_MESSAGE);
    }
}
   
    /**
     * Creates new form izinguru
     */
    public izinguru() {
        initComponents();
        tampil_guru();
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        timenow();
        copyright();
        datatable();
        aktif();
        otomatis();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tblpesdikview = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblguruadd = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        txtcariguru = new placeholder.caridata();
        btncariguru = new javax.swing.JButton();
        jkel = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        now = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtnoizinguru = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnsave = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        btnhome = new javax.swing.JButton();
        txtnip = new javax.swing.JTextField();
        txtnmguru = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        laki = new javax.swing.JRadioButton();
        perempuan = new javax.swing.JRadioButton();
        alasanbox = new javax.swing.JComboBox<>();
        tanggalizin = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtket = new javax.swing.JTextArea();
        btntblguru = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txttelpguru = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jamizinbox = new javax.swing.JComboBox<>();
        jamkembalibox = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblizinguru = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        txtcari = new placeholder.cariizinguru();
        btnprint = new javax.swing.JButton();
        btnsearch = new javax.swing.JButton();
        txtprint = new placeholder.cetakizinguru();
        btnhome1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        copyright = new javax.swing.JLabel();
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

        tblpesdikview.setSize(new java.awt.Dimension(650, 406));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Gobold", 0, 24)); // NOI18N
        jLabel13.setText("DATA GURU SMKN 8 JAKARTA");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addContainerGap())
        );

        tblguruadd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "NIP", "Nama Guru", "Jenis Kelamin", "Telp Guru", "Alamat Guru"
            }
        ));
        tblguruadd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblguruaddMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblguruadd);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "SEARCH DATA GURU", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        txtcariguru.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcariguruKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcariguruKeyTyped(evt);
            }
        });

        btncariguru.setFont(new java.awt.Font("Gobold", 0, 14)); // NOI18N
        btncariguru.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/magnifier.png"))); // NOI18N
        btncariguru.setText("SEARCH");
        btncariguru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariguruActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(txtcariguru)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncariguru)
                .addGap(19, 19, 19))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btncariguru)
                    .addComponent(txtcariguru, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tblpesdikviewLayout = new javax.swing.GroupLayout(tblpesdikview.getContentPane());
        tblpesdikview.getContentPane().setLayout(tblpesdikviewLayout);
        tblpesdikviewLayout.setHorizontalGroup(
            tblpesdikviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tblpesdikviewLayout.setVerticalGroup(
            tblpesdikviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DATA IZIN GURU SMKN 8 JAKARTA");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/gambar/SMK_Negeri_8_Jakarta (2).png")).getImage());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        jLabel6.setFont(new java.awt.Font("Gobold", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/SMK_Negeri_8_Jakarta (2).png"))); // NOI18N
        jLabel6.setText("FORM IZIN GURU SMKN 8 JAKARTA");

        now.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        now.setText("now");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(now, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(now))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "FORM IZIN GURU", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 0, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Gobold", 0, 18)); // NOI18N
        jLabel1.setText("NO IZIN GURU");

        txtnoizinguru.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Gobold", 0, 18)); // NOI18N
        jLabel2.setText("NIP");

        jLabel3.setFont(new java.awt.Font("Gobold", 0, 18)); // NOI18N
        jLabel3.setText("NAMA GURU");

        jLabel4.setFont(new java.awt.Font("Gobold", 0, 18)); // NOI18N
        jLabel4.setText("ALASAN GURU");

        jLabel5.setFont(new java.awt.Font("Gobold", 0, 18)); // NOI18N
        jLabel5.setText("TANGGAL IZIN");

        btnsave.setBackground(new java.awt.Color(51, 153, 255));
        btnsave.setFont(new java.awt.Font("Gobold", 0, 14)); // NOI18N
        btnsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/floppy-disk.png"))); // NOI18N
        btnsave.setText("SAVE");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        btnedit.setBackground(new java.awt.Color(51, 153, 255));
        btnedit.setFont(new java.awt.Font("Gobold", 0, 14)); // NOI18N
        btnedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/edit.png"))); // NOI18N
        btnedit.setText("EDIT");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        btndelete.setBackground(new java.awt.Color(51, 153, 255));
        btndelete.setFont(new java.awt.Font("Gobold", 0, 14)); // NOI18N
        btndelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8-trash-24.png"))); // NOI18N
        btndelete.setText("DELETE");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        btnclear.setBackground(new java.awt.Color(51, 153, 255));
        btnclear.setFont(new java.awt.Font("Gobold", 0, 14)); // NOI18N
        btnclear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8-minus-24.png"))); // NOI18N
        btnclear.setText("CLEAR");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });

        btnhome.setBackground(new java.awt.Color(51, 153, 255));
        btnhome.setFont(new java.awt.Font("Gobold", 0, 14)); // NOI18N
        btnhome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8-home-24.png"))); // NOI18N
        btnhome.setText("HOME");
        btnhome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhomeActionPerformed(evt);
            }
        });

        txtnip.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        txtnmguru.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Gobold", 0, 18)); // NOI18N
        jLabel7.setText("JENIS KELAMIN");

        laki.setBackground(new java.awt.Color(255, 255, 255));
        jkel.add(laki);
        laki.setFont(new java.awt.Font("Gobold", 0, 14)); // NOI18N
        laki.setText("LAKI - LAKI");

        perempuan.setBackground(new java.awt.Color(255, 255, 255));
        jkel.add(perempuan);
        perempuan.setFont(new java.awt.Font("Gobold", 0, 14)); // NOI18N
        perempuan.setText("PEREMPUAN");

        alasanbox.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        alasanbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--SILAHKAN PILIH ALASAN--", "SAKIT", "TEKNIKAL MEETING", "LOMBA", "DINAS", "LATIHAN PRA LOMBA", "URUSAN PRIBADI/KELUARGA", "LAINNYA" }));

        tanggalizin.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Gobold", 0, 18)); // NOI18N
        jLabel9.setText("KETERANGAN");

        txtket.setColumns(20);
        txtket.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtket.setRows(5);
        jScrollPane1.setViewportView(txtket);

        btntblguru.setBackground(new java.awt.Color(51, 153, 255));
        btntblguru.setFont(new java.awt.Font("Gobold", 0, 14)); // NOI18N
        btntblguru.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/cells.png"))); // NOI18N
        btntblguru.setText("LIHAT TABLE DATA GURU");
        btntblguru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntblguruActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Gobold", 0, 18)); // NOI18N
        jLabel10.setText("TELP GURU");

        txttelpguru.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Gobold", 0, 18)); // NOI18N
        jLabel11.setText("JAM IZIN");

        jLabel12.setFont(new java.awt.Font("Gobold", 0, 18)); // NOI18N
        jLabel12.setText("JAM KEMBALI");

        jamizinbox.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jamizinbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--SILAHKAN PILIH JAM PELAJARAN--", "JAM KE 0 (06:30 - 06:45)", "JAM KE 1 (06:45 - 07:30)", "JAM KE 2 (07:30 - 08:15)", "JAM KE 3 (08:15 - 09:00)", "JAM KE 4 (09:00 - 09:45)", "ISTIRAHAT 1 (09:45 - 10:05)", "JAM KE 5 (10:05 - 10:50)", "JAM KE 6 (10:50 - 11:35)", "JAM KE 7 (11:35 - 12:20)", "ISTIRAHAT 2 (12:20 - 12 :50)", "JAM KE 8 (12:50 - 13:35)", "JAM KE 9 (13:35 - 14:20)", "JAM KE 10 (14:20 - 15:05)" }));

        jamkembalibox.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jamkembalibox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--SILAHKAN PILIH JAM PELAJARAN--", "JAM KE 0 (06:30 - 06:45)", "JAM KE 1 (06:45 - 07:30)", "JAM KE 2 (07:30 - 08:15)", "JAM KE 3 (08:15 - 09:00)", "JAM KE 4 (09:00 - 09:45)", "ISTIRAHAT 1 (09:45 - 10:05)", "JAM KE 5 (10:05 - 10:50)", "JAM KE 6 (10:50 - 11:35)", "JAM KE 7 (11:35 - 12:20)", "ISTIRAHAT 2 (12:20 - 12 :50)", "JAM KE 8 (12:50 - 13:35)", "JAM KE 9 (13:35 - 14:20)", "JAM KE 10 (14:20 - 15:05)" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(laki)
                                .addGap(18, 18, 18)
                                .addComponent(perempuan))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                    .addComponent(txttelpguru, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel1))
                                    .addGap(27, 27, 27)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtnmguru, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                                        .addComponent(txtnip, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtnoizinguru, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel9))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tanggalizin, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(alasanbox, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jamizinbox, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jamkembalibox, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btntblguru))))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnsave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnedit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btndelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnclear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnhome)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtnoizinguru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtnip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtnmguru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(laki)
                    .addComponent(perempuan)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txttelpguru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alasanbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(tanggalizin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jamizinbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jamkembalibox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btntblguru)
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsave)
                    .addComponent(btnedit)
                    .addComponent(btndelete)
                    .addComponent(btnclear)
                    .addComponent(btnhome))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "TABEL IZIN GURU"));

        tblizinguru.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No Izin Guru", "NIP", "Nama Guru", "Jenis Kelamin", "Telpon", "Alasan", "Tanggal Izin", "Jam Izin ", "Jam Kembali", "Keterangan"
            }
        ));
        tblizinguru.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblizinguruMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblizinguru);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "SEARCH DATA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N

        txtcari.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcariKeyPressed(evt);
            }
        });

        btnprint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/printing.png"))); // NOI18N
        btnprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprintActionPerformed(evt);
            }
        });

        btnsearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/magnifier.png"))); // NOI18N
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        txtprint.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtprint.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtprintKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtcari)
                    .addComponent(txtprint))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnsearch, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnprint, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnprint)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtprint, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnsearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtcari))
                .addContainerGap())
        );

        btnhome1.setBackground(new java.awt.Color(51, 153, 255));
        btnhome1.setFont(new java.awt.Font("Gobold", 0, 14)); // NOI18N
        btnhome1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/refresh.png"))); // NOI18N
        btnhome1.setText("REFRESH");
        btnhome1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhome1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnhome1)
                .addGap(18, 18, 18))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnhome1)
                .addGap(31, 31, 31))
        );

        jPanel6.setBackground(new java.awt.Color(51, 153, 255));

        copyright.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        copyright.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        copyright.setText("© year Tugas Akhir. All Right Reserved.");
        copyright.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(copyright, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(copyright, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        if(txtnoizinguru.getText().equals("")){
            JOptionPane.showMessageDialog(null, "No Izin Keluar Siswa Tidak Boleh Kosong");

        }else{
            int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Ingin Menyimpan Data ini?", "Konfirmasi Dialog", JOptionPane.YES_NO_OPTION);
            if (ok == JOptionPane.YES_OPTION){
                String sql = "insert into izinkeluarguru values (?,?,?,?,?,?,?,?,?,?)";
                String tampilan = "dd-MM-yyyy";
                SimpleDateFormat fm = new SimpleDateFormat(tampilan);
                String tanggal = String.valueOf(fm.format(tanggalizin.getDate()));

                try{
                    PreparedStatement stat = conn.prepareStatement(sql);
                    stat.setString(1, txtnoizinguru.getText());
                    stat.setString(2, txtnip.getText());
                    stat.setString(3, txtnmguru.getText());
                    String jkel="";
                    if(laki.isSelected()) jkel="Laki-Laki";
                    else jkel="Perempuan";
                    stat.setString(4, jkel);
                    stat.setString(5, txttelpguru.getText());
                    stat.setString(6, alasanbox.getSelectedItem().toString());
                    stat.setString(7, tanggal.toString());
                    stat.setString(8, jamizinbox.getSelectedItem().toString());
                    stat.setString(9, jamkembalibox.getSelectedItem().toString());
                    stat.setString(10, txtket.getText());
                    stat.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
                    kosong();
                    datatable();
                    otomatis();
                    //                    lebarKolom();
                    txtnoizinguru.requestFocus();
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Data Gagal Disimpan " + e);
                }
            }
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
        int baris = tblizinguru.getSelectedRow();
        if(baris >= 0 ){
            String nip = tblizinguru.getValueAt(baris, 1).toString();
            String  nm_guru = tblizinguru.getValueAt(baris, 2).toString();

            int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Ingin Mengubah Data ini?", "Konfirmasi Dialog", JOptionPane.YES_NO_OPTION);
            if (ok == JOptionPane.YES_OPTION){
                try{
                    Connection con = new koneksi().connect();
                    String sql = "update izinkeluarguru set noizinguru=?, nip=?, nm_guru=?, jk_guru=?, "
                    + "telp_guru=?, alasan_guru=?, tglizin_guru=?, jamizin_guru=?, jamkem_guru=?, ket_guru=? where noizinguru='" + txtnoizinguru.getText()+"'";
                    PreparedStatement stat = conn.prepareStatement(sql);
                    String tampilan = "dd-MM-yyyy";
                    SimpleDateFormat fm = new SimpleDateFormat(tampilan);
                    String tanggal = String.valueOf(fm.format(tanggalizin.getDate()));

                    stat.setString(1, txtnoizinguru.getText());
                    stat.setString(2, txtnip.getText());
                    stat.setString(3, txtnmguru.getText());
                    String jkel="";
                    if(laki.isSelected()) jkel="Laki-Laki";
                    else jkel="Perempuan";
                    stat.setString(4, jkel);
                    stat.setString(5, txttelpguru.getText());
                    stat.setString(6, alasanbox.getSelectedItem().toString());
                    stat.setString(7, tanggal.toString());
                    stat.setString(8, jamizinbox.getSelectedItem().toString());
                    stat.setString(9, jamkembalibox.getSelectedItem().toString());
                    stat.setString(10, txtket.getText());

                    stat.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
                    kosong();
                    datatable();
                    //                    lebarKolom();
                    txtnoizinguru.requestFocus();
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Data Gagal Diubah"+e);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"Anda belum memilih data yang akan diubah!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btneditActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
        int baris = tblizinguru.getSelectedRow();
        if(baris >= 0 ){
            String nip = tblizinguru.getValueAt(baris, 1).toString();
            String  nm_guru = tblizinguru.getValueAt(baris, 2).toString();

            int ok = JOptionPane.showConfirmDialog(null, "Data Izin Keluar Guru dengan \n\nNIP : "+nip+"\nNama Guru : "+nm_guru+ "\nAkan Anda Hapus, Yakin? ", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if(ok == JOptionPane.YES_OPTION){
                String sql = "delete from izinkeluarguru where noizinguru ='" + txtnoizinguru.getText()+"'";
                try{
                    PreparedStatement stat = conn.prepareStatement(sql);
                    stat.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                    kosong();
                    datatable();
                    //                    lebarKolom();
                    txtnoizinguru.requestFocus();
                }catch (SQLException e){
                    JOptionPane.showMessageDialog(null, "Data Gagal Dihapus" + e);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"Anda belum memilih data yang akan diubah!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        // TODO add your handling code here:
        kosong();
        datatable();
    }//GEN-LAST:event_btnclearActionPerformed

    private void btnhomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhomeActionPerformed
        // TODO add your handling code here:
        new menuutama().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnhomeActionPerformed

    private void btntblguruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntblguruActionPerformed
        // TODO add your handling code here:
        tblpesdikview.setLocationRelativeTo(this);
        tblpesdikview.setVisible(true);
    }//GEN-LAST:event_btntblguruActionPerformed

    private void tblizinguruMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblizinguruMouseClicked
        // TODO add your handling code here:
        int bar = tblizinguru.getSelectedRow();
        String a = tabmodel.getValueAt(bar, 0).toString();
        String b = tabmodel.getValueAt(bar, 1).toString();
        String c = tabmodel.getValueAt(bar, 2).toString();
        String d = tabmodel.getValueAt(bar, 3).toString();
        String e = tabmodel.getValueAt(bar, 4).toString();
        String f = tabmodel.getValueAt(bar, 5).toString();
        String g = tabmodel.getValueAt(bar, 6).toString();
        String h = tabmodel.getValueAt(bar, 7).toString();
        String i = tabmodel.getValueAt(bar, 8).toString();
        String j = tabmodel.getValueAt(bar, 9).toString();

        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        Date dateValue = null;
        try{
            dateValue = date.parse((String) tblizinguru.getValueAt(bar, 6));
        }catch (ParseException ex){
            Logger.getLogger(kunjungan.class.getName()).log(Level.SEVERE, null, ex);
        }

        txtnoizinguru.setText(a);
        txtnip.setText(b);
        txtnmguru.setText(c);
        if(d.equals("Laki-Laki")) {laki.setSelected(true); perempuan.setSelected(false);}
        else {laki.setSelected(false); perempuan.setSelected(true);}
        txttelpguru.setText(e);
        alasanbox.setSelectedItem(f);
        tanggalizin.setDate(dateValue);
        jamizinbox.setSelectedItem(h);
        jamkembalibox.setSelectedItem(i);
        txtket.setText(j);
    }//GEN-LAST:event_tblizinguruMouseClicked

    private void txtcariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyPressed
        // TODO add your handling code here:
        String sqlPencarian = "select * from izinkeluarguru where nm_guru like '%" + txtcari.getText() + "%' or "
        + "alasan_guru like '%" + txtcari.getText() + "%' or "
        + "noizinguru like '%" + txtcari.getText() + "%' or "
        + "nip like '%" + txtcari.getText() + "%' or "
        + "jamkem_guru like '%" + txtcari.getText() + "%' or "
        + "jk_guru like '%" + txtcari.getText() + "%' or "
        + "telp_guru like '%" + txtcari.getText() + "%' or "
        + "tglizin_guru like '%" + txtcari.getText() + "%' or "
        + "jamizin_guru like '%" + txtcari.getText() + "%' or "
        + "ket_guru like '%" + txtcari.getText() + "%'";
        pencarian(sqlPencarian);
    }//GEN-LAST:event_txtcariKeyPressed

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
                
                String report = ("src/tandabukti/izinkeluarguru.jrxml");
                HashMap hash = new HashMap();
                //mengambil parameter ireport
                hash.put("No_Izin_Guru", txtprint.getText());
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

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        // TODO add your handling code here:
        String sqlPencarian = "select * from izinkeluarguru where nm_guru like '%" + txtcari.getText() + "%' or "
        + "alasan_guru like '%" + txtcari.getText() + "%' or "
        + "noizinguru like '%" + txtcari.getText() + "%' or "
        + "nip like '%" + txtcari.getText() + "%' or "
        + "jamkem_guru like '%" + txtcari.getText() + "%' or "
        + "jk_guru like '%" + txtcari.getText() + "%' or "
        + "telp_guru like '%" + txtcari.getText() + "%' or "
        + "tglizin_guru like '%" + txtcari.getText() + "%' or "
        + "jamizin_guru like '%" + txtcari.getText() + "%' or "
        + "ket_guru like '%" + txtcari.getText() + "%'";
        pencarian(sqlPencarian);
    }//GEN-LAST:event_btnsearchActionPerformed

    private void tblguruaddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblguruaddMouseClicked
        // TODO add your handling code here:
        clicktbl_guru();
    }//GEN-LAST:event_tblguruaddMouseClicked

    private void txtcariguruKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariguruKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            search_guru();
        }
    }//GEN-LAST:event_txtcariguruKeyPressed

    private void txtcariguruKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariguruKeyTyped
        // TODO add your handling code here:
        search_guru();
    }//GEN-LAST:event_txtcariguruKeyTyped

    private void btncariguruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariguruActionPerformed
        // TODO add your handling code here:
        search_guru();
    }//GEN-LAST:event_btncariguruActionPerformed

    private void txtprintKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprintKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprintKeyPressed

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

    private void btnhome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhome1ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)tblizinguru.getModel();
        model.setRowCount(0);
        datatable();
        otomatis();
        kosong();
    }//GEN-LAST:event_btnhome1ActionPerformed

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
            java.util.logging.Logger.getLogger(izinguru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(izinguru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(izinguru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(izinguru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new izinguru().setVisible(true);
            }
        });
    }
    
    private void timenow() {
    // ActionListener untuk Keperluan Timer
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String nol_jam = "";
                String nol_menit = "";
                String nol_detik = "";
                // Membuat Date
                java.util.Date dt = new java.util.Date();
                // Membuat date format
                java.text.SimpleDateFormat kal = new java.text.SimpleDateFormat ("EEEE, dd MMMMM yyyy") ;
                // Mengambil nilaj JAM, MENIT, dan DETIK Sekarang
                int nilai_jam = dt.getHours();
                int nilai_menit = dt.getMinutes();
                int nilai_detik = dt.getSeconds();
                // Jika nilai JAM lebih kecil dari 10 (hanya 1 digit)
                if (nilai_jam <= 9) {
                    // Tambahkan "0" didepannya
                    nol_jam = "0";
                }
                // Jika nilai MENIT lebih kecil dari 10 (hanya 1 digit)
                if (nilai_menit <= 9) {
                    // Tambahkan "0" didepannya
                    nol_menit = "0";
                }
                // Jika nilai DETIK lebih kecil dari 10 (hanya 1 digit)
                if (nilai_detik <= 9) {
                    // Tambahkan "0" didepannya
                    nol_detik = "0";
                }
                // Membuat String JAM, MENIT, DETIK
                String jam = nol_jam + Integer.toString(nilai_jam);
                String menit = nol_menit + Integer.toString(nilai_menit);
                String detik = nol_detik + Integer.toString(nilai_detik);
                // Menampilkan pada Layar
                now.setText(kal.format(dt)+"     "+jam + ":" + menit + ":" + detik+"                                   ");
            }
        };
        // Timer
        new javax.swing.Timer(1000, taskPerformer).start();
    }
    
    private void copyright() {
        java.util.Date sekarang = new java.util.Date();
        java.text.SimpleDateFormat kal = new java.text.SimpleDateFormat("yyyy") ;
        copyright.setText("© "+kal.format(sekarang)+" Tugas Akhir. All Right Reserved.");
    }
    
    private void tampil_guru() {
        Object []baris = {"NIP","Nama Guru","Jenis Kelamin","Telp Guru","Alamat Guru"};
        tbl1 = new DefaultTableModel(null, baris) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblguruadd.setModel(tbl1);
        String sql = "SELECT * FROM guru ORDER BY nip ASC";
        try {
            
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            
            while (hasil.next()) {
                String nip = hasil.getString("nip");
                String nm_guru = hasil.getString("nm_guru");
                String jk_guru = hasil.getString("jk_guru");
                String telp_guru = hasil.getString("telp_guru");
                String almt_guru = hasil.getString("almt_guru");
                
                String[] data = {nip,nm_guru,jk_guru,telp_guru,almt_guru};
                tbl1.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Menampilkan DATA!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            this.setVisible(false);
        }
    }
    
    private void search_guru(){
        String query = txtcariguru.getText();
        
        Object []baris = {"NIP","Nama Guru","Jenis Kelamin","Telp Guru","Alamat Guru"};
        tbl1 = new DefaultTableModel(null, baris) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblguruadd.setModel(tbl1);
        
        try {
             String sql = "SELECT * FROM guru WHERE BINARY "
                    + "nip LIKE '%"+query+"%' "
                    + "OR nm_guru LIKE '%"+query+"%' "
                    + "OR jk_guru LIKE '%"+query+"%' "
                    + "OR telp_guru LIKE '%"+query+"%' "
                    + "OR almt_guru LIKE '%"+query+"&' "
                    + "ORDER BY nip ASC";
            java.sql.Statement stat = conn.createStatement();
            java.sql.ResultSet hasil = stat.executeQuery(sql);
            
            while (hasil.next()) {
                String nip = hasil.getString("nip");
                String nm_guru = hasil.getString("nm_guru");
                String jk_guru = hasil.getString("jk_guru");
                String telp_guru = hasil.getString("telp_guru");
                String almt_guru = hasil.getString("almt_guru");
                
                String[] data = {nip,nm_guru,jk_guru,telp_guru,almt_guru};
                tbl1.addRow(data);
            }
            
        }catch(Exception e) {}
    }
    
    private void clicktbl_guru() {
        int baris = tblguruadd.getSelectedRow();
        
        String d = tbl1.getValueAt(baris, 2).toString();
        
        txtnip.setText((String)tbl1.getValueAt(baris, 0));
        txtnmguru.setText((String)tbl1.getValueAt(baris, 1));
        txttelpguru.setText((String)tbl1.getValueAt(baris, 3));
        
        if(d.equals("Laki-Laki")) {laki.setSelected(true); perempuan.setSelected(false);}
        else {laki.setSelected(false); perempuan.setSelected(true);}
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> alasanbox;
    private javax.swing.JButton btncariguru;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnhome;
    private javax.swing.JButton btnhome1;
    private javax.swing.JButton btnprint;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnsearch;
    private javax.swing.JButton btntblguru;
    private javax.swing.JLabel copyright;
    private javax.swing.JMenuItem guru;
    private javax.swing.JMenuItem izinguru;
    private javax.swing.JMenuItem izinsiswa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox<String> jamizinbox;
    private javax.swing.JComboBox<String> jamkembalibox;
    private javax.swing.ButtonGroup jkel;
    private javax.swing.JMenuItem kunjungan;
    private javax.swing.JRadioButton laki;
    private javax.swing.JMenuItem lapparameter;
    private javax.swing.JMenuItem logout;
    private javax.swing.JMenuItem menuutama;
    private javax.swing.JLabel now;
    private javax.swing.JMenu pendataan;
    private javax.swing.JRadioButton perempuan;
    private javax.swing.JMenuItem rekapanlap;
    private javax.swing.JMenuItem siswa;
    private javax.swing.JMenuItem tamu;
    private com.toedter.calendar.JDateChooser tanggalizin;
    private javax.swing.JTable tblguruadd;
    private javax.swing.JTable tblizinguru;
    private javax.swing.JDialog tblpesdikview;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtcariguru;
    private javax.swing.JTextArea txtket;
    private javax.swing.JTextField txtnip;
    private javax.swing.JTextField txtnmguru;
    private javax.swing.JTextField txtnoizinguru;
    private javax.swing.JTextField txtprint;
    private javax.swing.JTextField txttelpguru;
    // End of variables declaration//GEN-END:variables
}
