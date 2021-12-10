/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Adan Nugraha 202031242
 */

public class Bentuk implements InterfaceLogAktifitas {
    protected double a,b,c;
    private Connection koneksi;
    private PreparedStatement psmt;
    protected String query, luas, UserID, aktifitas, keterangan;

    public Bentuk() {
        KoneksiMySql connection = new KoneksiMySql();
        try { 
            koneksi = connection.getKoneksi();
        } catch (SQLException ex) {
        }
    }
    public String getLuas() {
        return luas;
    }

    public void setLuas(String luas) {
        this.luas = luas;
    }

    public String getAktifitas() {
        return aktifitas;
    }

    public void setAktifitas(String aktifitas) {
        this.aktifitas = aktifitas;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    
    protected void set_A(double a) {
        this.a = a;
    }
    
    protected double get_A() {
        return a;
    }
    
    protected void set_B(double b) {
        this.b = b;
    }
    
    protected double get_B() {
        return b;
    }
    
    protected void set_C() {
        
    }
    
    protected double get_C() {
        return c;
    }
    
    protected String cetak() {
        return luas;
    }

    
    @Override
    public void LogAktifitas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void LogAktifitas(String UserID, String aktifitas, String keterangan) {
        //To change body of generated methods, choose Tools | Templates.
        query = "insert into log_aktifitas(id_user, aktifitas, keterangan) values(?, ?, ?)";
        try {
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, UserID);
            psmt.setString(2, aktifitas);
            psmt.setString(3, keterangan);
            psmt.executeUpdate();
            psmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
}
