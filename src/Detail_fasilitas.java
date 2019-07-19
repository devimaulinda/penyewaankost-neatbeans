/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
import Koneksi.Koneksi;
import java.sql.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Detail_fasilitas extends javax.swing.JFrame {

    /**
     * Creates new form Detail_fasilitas
     */
    private DefaultTableModel model;
       
    String iddtfasilitas, nmfasilitas, fasilitas;
    public Detail_fasilitas() {
        initComponents();
         tampil_idfasilitas();
        model = new DefaultTableModel();
        
        //memberi nama header pada tabel
        table1.setModel(model);
        model.addColumn("ID DETAIL_FASILITAS");
        model.addColumn("NAMA FASILITAS");
        model.addColumn("FASILITAS");
        
        //fungsi ambil data
        getDataDetail_fasilitas();
 
         tampil_idfasilitas();
        model = new DefaultTableModel();
        
        //memberi nama header pada tabel
        table1.setModel(model);
        model.addColumn("ID DETAIL_FASILITAS");
        model.addColumn("NAMA FASILITAS");
        model.addColumn("FASILITAS");
        
        //fungsi ambil data
        getDataDetail_fasilitas();
 
    }
     public void getDataDetail_fasilitas(){
        //kosongkan tabel
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        //eksekusi koneksi dan kirimkan query ke database
        try{
            //tes koneksi
            Statement stat = (Statement) Koneksi.getKoneksi().createStatement();
            
            //perintah sql untuk membaca data dari tabel gaji        
            String sql = "SELECT * FROM tb_dtfasilitas";
            ResultSet res = stat.executeQuery(sql);
            
            //baca data
            while(res.next()){
                //membuat obyek berjenis array
                Object[] obj = new Object[3];
                obj[0]=res.getString("id_dtfasilitas");
                obj[1]=res.getString("nm_fasilitas");
                obj[2]=res.getString("fasilitas");
                model.addRow(obj);
            }
        }catch(SQLException err){
           JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
     public void dataidfasilitas(){   
         try{
            //tes koneksi
            Statement stat = (Statement) Koneksi.getKoneksi().createStatement();
           
            //perintah sql untuk membaca data dari tabel 
            String sql = "SELECT * FROM Fasilitas WHERE id_fasilitas  = '"+ tidf.getSelectedItem() +"'";
            ResultSet res = stat.executeQuery(sql);
                        
            //baca data dan tampilkan pada text produk dan harga
        }catch(SQLException err){
           JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
     public void tampil_idfasilitas()
    {
        try {
            Connection con = Koneksi.getKoneksi();
            Statement stt = con.createStatement();
            String sql = "select id_dtfasilitas from tb_dtfasilitas order by id_dtfasilitas asc";
            ResultSet res = stt.executeQuery(sql);
            
            while(res.next()){
                Object[] ob = new Object[2];
                ob[1] = res.getString("id_dtfasilitas");
                
                tidf.addItem(res.getString(1));
            }
            res.close(); stt.close();
        } catch (Exception e) {
                System.out.println(e.getMessage());
        }
    }
     public void tampilidfasilitas()
    {
        try {
            Connection con = Koneksi.getKoneksi();
            Statement stt = con.createStatement();
            String sql = "select nm_fasilitas from tb_dtfasilitas where id_dtfasilitas= '"+tidf.getSelectedItem()+"'";
            ResultSet res = stt.executeQuery(sql);
            
            while(res.next()){
                Object[] ob = new Object[2];
                ob[0] = res.getString("nm_fasilitas");
                
                
                tnm.setText((String) ob[0]);
               
            }
        res.close(); stt.close();
        
    } catch (Exception e) {
            System.out.println(e.getMessage());
    }
        
    }
      public void loadDataDetail_fasilitas(){
        //mengambil data dari textbox dan menyimpan nilainya pada variabel
        iddtfasilitas = (String)tidf.getSelectedItem();
        nmfasilitas = tnm.getText();
        fasilitas =(String) tfas.getSelectedItem();
    }
    public void dataSelect(){
        //deklarasi variabel
        int i = table1.getSelectedRow();
        
        //uji adakah data di tabel?
        if(i == -1){
            //tidak ada yang terpilih atau dipilih.
            return;
        }
         tidf.setSelectedItem(""+model.getValueAt(i,0));
         tnm.setText(""+model.getValueAt(i,1));
         tfas.setSelectedItem(""+model.getValueAt(i,2));}

    public void reset(){
        iddtfasilitas = "";
        nmfasilitas = "";
        fasilitas   = "";
        
        tidf.setSelectedItem(iddtfasilitas);
        tnm.setText(nmfasilitas);
        tfas.setSelectedItem(fasilitas);
        }
    public void simpan(){
         //panggil fungsi load data
        loadDataDetail_fasilitas();
        
        //uji koneksi dan eksekusi perintah
        try{
            //test koneksi
            Statement stat = (Statement) Koneksi.getKoneksi().createStatement();
            
            //perintah sql untuk simpan data
            String  sql =   "INSERT INTO tb_dtfasilitas(id_fasilitas, nm_fasilitas,fasilitas)"
                            + "VALUES('"+ iddtfasilitas +"','"+ nmfasilitas +"','"+fasilitas+"')";
            PreparedStatement p = (PreparedStatement) Koneksi.getKoneksi().prepareStatement(sql);
            p.executeUpdate();
            
            //ambil data
            getDataDetail_fasilitas();
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    public void rubah(){
          //panggil fungsi load data
        loadDataDetail_fasilitas();
        
        //uji koneksi dan eksekusi perintah
        try{
            //test koneksi
            Statement stat = (Statement) Koneksi.getKoneksi().createStatement();
            
            //perintah sql untuk simpan data
            String sql  =   "UPDATE tb_dtfasilitas SET nm_fasilitas = '"+ tnm +"',"
                            + "fasilitas  = '"+ tfas +"'"  
                            + "WHERE id_fasilitas = '" + tidf +"'";
            PreparedStatement p = (PreparedStatement) Koneksi.getKoneksi().prepareStatement(sql);
            p.executeUpdate();
            
            //ambil data
            getDataDetail_fasilitas();
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    public void hapus(){
        //panggil fungsi ambil data
        loadDataDetail_fasilitas(); 
        
        //Beri peringatan sebelum melakukan penghapusan data        int pesan = JOptionPane.showConfirmDialog(null, "HAPUS DATA"+ idfasilitas +"?","KONFIRMASI", JOptionPane.OK_CANCEL_OPTION);

        int pesan = JOptionPane.showConfirmDialog(null, "HAPUS DATA"+ iddtfasilitas +"?","KONFIRMASI", JOptionPane.OK_CANCEL_OPTION);
        
        //jika pengguna memilih OK lanjutkan proses hapus data
        if(pesan == JOptionPane.OK_OPTION){
            //uji koneksi
            try{
                //buka koneksi ke database
                Statement stat = (Statement) Koneksi.getKoneksi().createStatement();
                
                //perintah hapus data
                String sql = "DELETE FROM tb_dtfasilitas WHERE id_dtfasilitas='"+ iddtfasilitas +"'";
                PreparedStatement p =(PreparedStatement)Koneksi.getKoneksi().prepareStatement(sql);
                p.executeUpdate();
                
                //fungsi ambil data
                getDataDetail_fasilitas();
                
                //fungsi reset data
                reset();
                JOptionPane.showMessageDialog(null, "BERHASIL DIHAPUS");
            }catch(SQLException err){
                JOptionPane.showMessageDialog(null, err.getMessage());
            }
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
        tidf = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        tnm = new javax.swing.JTextField();
        tfas = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("FORM DETAIL FASILITAS");

        jLabel2.setText("Id Detail Fasilitas");

        jLabel3.setText("Fasilitas");

        tidf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pilih" }));
        tidf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tidfActionPerformed(evt);
            }
        });

        jLabel4.setText("Nama Fasilitas");

        tnm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnmActionPerformed(evt);
            }
        });

        tfas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 spring bed, kipas angin, kamar mandi luar", "1 spring bed, AC, kamar mandi dalam", "2 spring bed, AC, kamar mandi dalam" }));

        jButton3.setText("SIMPAN");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("HAPUS");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("KELUAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton1.setText("RESET");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("RUBAH");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        table1.setModel(new javax.swing.table.DefaultTableModel(
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
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        table1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                table1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tidf, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfas, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tnm, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tidf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tnm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1)
                            .addComponent(jButton3)
                            .addComponent(jButton4)
                            .addComponent(jButton5))))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tnmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnmActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        simpan();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        hapus();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        rubah();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void table1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table1KeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_table1KeyReleased

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        // TODO add your handling code here:
       dataSelect();
    }//GEN-LAST:event_table1MouseClicked

    private void tidfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tidfActionPerformed
        // TODO add your handling code here:
        tampilidfasilitas();
    }//GEN-LAST:event_tidfActionPerformed

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
            java.util.logging.Logger.getLogger(Detail_fasilitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Detail_fasilitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Detail_fasilitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Detail_fasilitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Detail_fasilitas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table1;
    private javax.swing.JComboBox<String> tfas;
    private javax.swing.JComboBox<String> tidf;
    private javax.swing.JTextField tnm;
    // End of variables declaration//GEN-END:variables
}
