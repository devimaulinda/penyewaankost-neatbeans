/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Azura
 */
public class hitung {
    int harga;
    int hari;
    int total;
    int bayar;
    int kembali;
 public int totaal(){
        total = harga * hari;
        return total;
    }
 public int kembalii(){
        kembali = bayar - total;
        return kembali;
    }
 
}
