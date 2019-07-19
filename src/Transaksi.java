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
public class Transaksi extends javax.swing.JFrame {

    /**
     * Creates new form Transaksi
     */
    private DefaultTableModel model;
       
    String idtransaksi,idpenyewa,idkamar, idjenissewa;
    int hargaa,hari,total,bayaar,kembali;
    
    public Transaksi() {
        initComponents();
       tampil_idkamar();
       tampil_idpenyewa();
       tampil_idjenissewa();
         
        model = new DefaultTableModel();
        
        //memberi nama header pada tabel
        table1.setModel(model);
        model.addColumn("ID TRANSAKSI");
        model.addColumn("ID PENYEWA ");
        model.addColumn("ID KAMAR");
        model.addColumn("ID JENIS SEWA");
        model.addColumn("TOTAL ");
        model.addColumn("BAYAR");
        model.addColumn("KEMBALIAN");
    
        
        //fungsi ambil data
        getDataTransaksi();
 
    }
     public void getDataTransaksi(){
        //kosongkan tabel
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        //eksekusi koneksi dan kirimkan query ke database
        try{
            //tes koneksi
            Statement stat = (Statement) Koneksi.getKoneksi().createStatement();
            
            //perintah sql untuk membaca data dari tabel gaji        
            String sql = "SELECT * FROM tb_transaksi";
            ResultSet res = stat.executeQuery(sql);
            
            //baca data
            while(res.next()){
                //membuat obyek berjenis array
                Object[] obj = new Object[7];
                obj[0]=res.getString("id_transaksi");
                obj[1]=res.getString("id_penyewa");
                obj[2]=res.getString("id_kamar");
                obj[3]=res.getString("id_jenissewa");
                obj[4]=res.getString("total");
                obj[5]=res.getString("bayar");
                obj[6]=res.getString("kembalian");
                model.addRow(obj);
            }
        }catch(SQLException err){
           JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
     public void dataidpenyewa(){   
         try{
            //tes koneksi
            Statement stat = (Statement) Koneksi.getKoneksi().createStatement();
           
            //perintah sql untuk membaca data dari tabel 
            String sql = "SELECT * FROM tb_penyewa WHERE id_penyewa  = '"+ tidp.getSelectedItem() +"'";
            ResultSet res = stat.executeQuery(sql);
                        
            //baca data dan tampilkan pada text produk dan harga
        }catch(SQLException err){
           JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
     public void tampil_idpenyewa()
    {
        try {
            Connection con = Koneksi.getKoneksi();
            Statement stt = con.createStatement();
            String sql = "select id_penyewa from tb_penyewa order by id_penyewa asc";
            ResultSet res = stt.executeQuery(sql);
            
            while(res.next()){
                Object[] ob = new Object[2];
                ob[1] = res.getString("id_penyewa");
                
                tidp.addItem(res.getString(1));
            }
            res.close(); stt.close();
        } catch (Exception e) {
                System.out.println(e.getMessage());
        }
    }
     
    public void dataidkamar(){   
         try{
            //tes koneksi
            Statement stat = (Statement) Koneksi.getKoneksi().createStatement();
           
            //perintah sql untuk membaca data dari tabel 
            String sql = "SELECT * FROM tb_kamar WHERE id_kamar  = '"+ tidk.getSelectedItem() +"'";
            ResultSet res = stat.executeQuery(sql);
                        
            //baca data dan tampilkan pada text produk dan 
        }catch(SQLException err){
           JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
     public void tampil_idkamar()
    {
        try {
            Connection con = Koneksi.getKoneksi();
            Statement stt = con.createStatement();
            String sql = "select id_kamar from tb_kamar order by id_kamar asc";
            ResultSet res = stt.executeQuery(sql);
            
            while(res.next()){
                Object[] ob = new Object[2];
                ob[1] = res.getString("id_kamar");
                
                tidk.addItem(res.getString(1));
            }
            res.close(); stt.close();
        } catch (Exception e) {
                System.out.println(e.getMessage());
        }
    }
    public void tampilidkamar()
    {
        try {
            Connection con = Koneksi.getKoneksi();
            Statement stt = con.createStatement();
            String sql = "select harga from tb_kamar where id_kamar= '"+tidk.getSelectedItem()+"'";
            ResultSet res = stt.executeQuery(sql);
            
            while(res.next()){
                Object[] ob = new Object[2];
                ob[0] = res.getString("harga");
                
                
                tharga.setText((String) ob[0]);
               
            }
        res.close(); stt.close();
        
    } catch (Exception e) {
            System.out.println(e.getMessage());
    }
        
    }
    public void dataidjenissewa(){   
         try{
            //tes koneksi
            Statement stat = (Statement) Koneksi.getKoneksi().createStatement();
           
            //perintah sql untuk membaca data dari tabel 
            String sql = "SELECT * FROM tb_jenissewa WHERE id_jenissewa  = '"+ tidj.getSelectedItem() +"'";
            ResultSet res = stat.executeQuery(sql);
                        
            //baca data dan tampilkan pada text produk dan harga
        }catch(SQLException err){
           JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
     public void tampil_idjenissewa()
    {
        try {
            Connection con = Koneksi.getKoneksi();
            Statement stt = con.createStatement();
            String sql = "select id_jenissewa from tb_jenissewa order by id_jenissewa asc";
            ResultSet res = stt.executeQuery(sql);
            
            while(res.next()){
                Object[] ob = new Object[2];
                ob[1] = res.getString("id_jenissewa");
                
                tidj.addItem(res.getString(1));
            }
            res.close(); stt.close();
        } catch (Exception e) {
                System.out.println(e.getMessage());
        }
    }
     public void tampilidjenis()
    {
        try {
            Connection con = Koneksi.getKoneksi();
            Statement stt = con.createStatement();
            String sql = "select hari from tb_jenissewa where id_jenissewa= '"+tidj.getSelectedItem()+"'";
            ResultSet res = stt.executeQuery(sql);
            
            while(res.next()){
                Object[] ob = new Object[2];
                ob[0] = res.getString("hari");
                
                
                thari.setText((String) ob[0]);
               
            }
        res.close(); stt.close();
        
    } catch (Exception e) {
            System.out.println(e.getMessage());
    }
        
    }
      public void loadDataTransaksi(){
        //mengambil data dari textbox dan menyimpan nilainya pada variabel
        idtransaksi=tidt.getText();
        idpenyewa = (String)tidj.getSelectedItem();
        idkamar = (String) tidk.getSelectedItem();
        idjenissewa =(String) tidj.getSelectedItem();
        total=Integer.parseInt(ttotal.getText());
        bayaar=Integer.parseInt(tbayar.getText());
        kembali=Integer.parseInt(tkembalian.getText());
      }
    public void dataSelect(){
        //deklarasi variabel
        int i = table1.getSelectedRow();
        
        //uji adakah data di tabel?
        if(i == -1){
            //tidak ada yang terpilih atau dipilih.
            return;
        }
        tidt.setText(""+model.getValueAt(i,0));
        tidp.setSelectedItem(""+model.getValueAt(i,2));
        tidk.setSelectedItem(""+model.getValueAt(i,3));
        tidj.setSelectedItem(""+model.getValueAt(i,4));
        ttotal.setText(""+model.getValueAt(i,5));
        tbayar.setText(""+model.getValueAt(i,6));
        tkembalian.setText(""+model.getValueAt(i,7));}
        
    public void reset(){
        idtransaksi = "";
        idpenyewa = "";
        idkamar = "";
        idjenissewa   = "";
        String hargaa="0";
        String hari="0";
        String total="0";
        String bayaar="0";
        String kembali="0";
      
        tidt.setText(idtransaksi);
        tidp.setSelectedItem(idpenyewa);
        tidk.setSelectedItem(idkamar);
        tidj.setSelectedItem(idjenissewa);
        tharga.setText(hargaa);
        thari.setText(hargaa);
        ttotal.setText(hargaa);
        tbayar.setText(bayaar);
        tkembalian.setText(kembali);
        
    }
    public void simpan(){
         //panggil fungsi load data
        loadDataTransaksi();
        
        //uji koneksi dan eksekusi perintah
           try{
            //test koneksi
            Statement stat = (Statement) Koneksi.getKoneksi().createStatement();
            
            //perintah sql untuk simpan data
            String  sql =   "INSERT INTO tb_transaksi(id_transaksi,id_penyewa,id_kamar, id_jenissewa,total,bayar,kembalian)"
                            + "VALUES('"+ tidt.getText() +"','"+ tidp.getSelectedItem() +"','"+tidk.getSelectedItem()+"','"+tidj.getSelectedItem()+"','"+ ttotal.getText() +"','"+ tbayar.getText() +"','"+ tkembalian.getText() +"')";
            PreparedStatement p = (PreparedStatement) Koneksi.getKoneksi().prepareStatement(sql);
            p.executeUpdate();
            
            //ambil data
            getDataTransaksi();
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    public void rubah(){
          //panggil fungsi load data
        loadDataTransaksi();
        
        //uji koneksi dan eksekusi perintah
        try{
            //test koneksi
            Statement stat = (Statement) Koneksi.getKoneksi().createStatement();
            
            //perintah sql untuk simpan data
            String sql  =   "UPDATE tb_transaksi SET id_penyewa = '"+ idpenyewa +"',"
                            + "id_kamar  = '"+ idkamar +"',"
                            + "id_jenissewa  = '"+ idjenissewa +"',"
                            + "total  = '"+ total +"',"
                            + "bayar  = '"+ bayaar +"',"
                            + "kembalian  = '"+ kembali +"'"
                            + "WHERE id_transaksi = '" + idtransaksi +"'";
            PreparedStatement p = (PreparedStatement) Koneksi.getKoneksi().prepareStatement(sql);
            p.executeUpdate();
            
            //ambil data
            getDataTransaksi();
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    public void hapus(){
        //panggil fungsi ambil data
        loadDataTransaksi(); 
        
        //Beri peringatan sebelum melakukan penghapusan data        int pesan = JOptionPane.showConfirmDialog(null, "HAPUS DATA"+ idfasilitas +"?","KONFIRMASI", JOptionPane.OK_CANCEL_OPTION);

        int pesan = JOptionPane.showConfirmDialog(null, "HAPUS DATA"+ idtransaksi +"?","KONFIRMASI", JOptionPane.OK_CANCEL_OPTION);
        
        //jika pengguna memilih OK lanjutkan proses hapus data
        if(pesan == JOptionPane.OK_OPTION){
            //uji koneksi
            try{
                //buka koneksi ke database
                Statement stat = (Statement) Koneksi.getKoneksi().createStatement();
                
                //perintah hapus data
                String sql = "DELETE FROM tb_transaksi WHERE id_transaksi='"+ idtransaksi +"'";
                PreparedStatement p =(PreparedStatement)Koneksi.getKoneksi().prepareStatement(sql);
                p.executeUpdate();
                
                //fungsi ambil data
                getDataTransaksi();
                
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tidp = new javax.swing.JComboBox<>();
        tidk = new javax.swing.JComboBox<>();
        tidj = new javax.swing.JComboBox<>();
        tidt = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tharga = new javax.swing.JTextField();
        tbayar = new javax.swing.JTextField();
        tkembalian = new javax.swing.JTextField();
        thari = new javax.swing.JTextField();
        ttotal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btot = new javax.swing.JButton();
        bkem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel1.setText("TRANSAKSI SEWA KOST");

        jLabel2.setText("Id_transaksi");

        jLabel3.setText("Id_Penyewa");

        jLabel4.setText("Id_kamar");

        jLabel5.setText("Id_jenissewa");

        tidp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-pilih-" }));
        tidp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tidpActionPerformed(evt);
            }
        });

        tidk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-pilih-" }));
        tidk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tidkActionPerformed(evt);
            }
        });

        tidj.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-pilih-" }));
        tidj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tidjActionPerformed(evt);
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
        jScrollPane1.setViewportView(table1);

        jLabel6.setText("HARGA");

        jLabel7.setText("BAYAR");

        jLabel8.setText("KEMBALIAN");

        tharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thargaActionPerformed(evt);
            }
        });

        tbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbayarActionPerformed(evt);
            }
        });

        tkembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkembalianActionPerformed(evt);
            }
        });

        thari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thariActionPerformed(evt);
            }
        });

        ttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ttotalActionPerformed(evt);
            }
        });

        jLabel9.setText("HARI");

        jLabel10.setText("TOTAL");

        btot.setText("HITUNG");
        btot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btotActionPerformed(evt);
            }
        });

        bkem.setText("HITUNG");
        bkem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(222, 222, 222))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tkembalian)
                                    .addComponent(tbayar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel6))
                                    .addGap(54, 54, 54)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tidk, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tidp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tidj, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tharga, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel9))
                                    .addGap(85, 85, 85)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(btot)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(ttotal, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(thari, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(58, 58, 58)
                                    .addComponent(tidt, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(bkem)))
                        .addGap(32, 32, 32))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tidt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tidp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tidk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tidj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(thari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addComponent(btot)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel7))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tbayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bkem)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tkembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(44, 44, 44)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        simpan();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        hapus();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void thargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thargaActionPerformed

    private void tbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbayarActionPerformed

    private void tkembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tkembalianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tkembalianActionPerformed

    private void thariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thariActionPerformed
        // TODO add your handling code here:
        total=hargaa * hari;   
        ttotal.setText(Integer.toString(total));
        
    }//GEN-LAST:event_thariActionPerformed

    private void ttotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ttotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ttotalActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        // TODO add your handling code here:
        dataSelect();
    }//GEN-LAST:event_table1MouseClicked

    private void tidpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tidpActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tidpActionPerformed

    private void tidkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tidkActionPerformed
        // TODO add your handling code here:
        tampilidkamar();
    }//GEN-LAST:event_tidkActionPerformed

    private void tidjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tidjActionPerformed
        // TODO add your handling code here:
        tampilidjenis();
    }//GEN-LAST:event_tidjActionPerformed

    private void btotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btotActionPerformed
        // TODO add your handling code here:
        hitung B= new hitung();
        B.harga = Integer.parseInt(tharga.getText());
        B.hari = Integer.parseInt(thari.getText());
        ttotal.setText(Integer.toString(B.totaal()));
    }//GEN-LAST:event_btotActionPerformed

    private void bkemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkemActionPerformed
        // TODO add your handling code here:
        
        hitung B= new hitung();
        B.total = Integer.parseInt(ttotal.getText());
        B.bayar = Integer.parseInt(tbayar.getText());
        tkembalian.setText(Integer.toString(B.kembalii()));
    }//GEN-LAST:event_bkemActionPerformed

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
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bkem;
    private javax.swing.JButton btot;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table1;
    private javax.swing.JTextField tbayar;
    private javax.swing.JTextField tharga;
    private javax.swing.JTextField thari;
    private javax.swing.JComboBox<String> tidj;
    private javax.swing.JComboBox<String> tidk;
    private javax.swing.JComboBox<String> tidp;
    private javax.swing.JTextField tidt;
    private javax.swing.JTextField tkembalian;
    private javax.swing.JTextField ttotal;
    // End of variables declaration//GEN-END:variables
}
