/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Adan Nugraha 202031242
 */
public class Login {
    private Connection koneksi;
    private PreparedStatement psmt;
    private ResultSet dataUser;
    private String query,userID,password,pesan;
    
    public Login(){
        KoneksiMySql connection = new KoneksiMySql();
        try { 
            koneksi = connection.getKoneksi();
        } catch (SQLException ex) {
        }
    }

    public void setUserID(String userID){ 
        this.userID = userID;
    }
    
    public String getUserID() {
        return userID;
    }

    public void setPassword(String password) { 
        this.password = password;
    }

    public String getPassword() { 
        return password;
    }

    public String cekLogin(String userID, String password) { 
        query = "SELECT nama FROM user WHERE id_user=? AND password=md5(?)";
        try { 
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, userID);
            psmt.setString(2, password);
            dataUser = psmt.executeQuery();
            
            if (dataUser.next()){
            Session.setUserID(userID) ;
            Session.setNama (dataUser.getString("nama"));
            Session.setStatusLogin("AKTIF");
            query = "INSERT INTO log_login (id_user) VALUES (?)";
                try { 
                    psmt = koneksi.prepareStatement(query);
                    psmt.setString(1, userID);
                    psmt.executeUpdate();
                    psmt.close();
                } catch (SQLException e) {
                    pesan = "Gagal Simpan Log Login";
                }
            } else {
                pesan = "Gagal Login";
            }
        } catch (SQLException e) {
            pesan = "Gagal Login, Query Error";
        }
    return pesan;
    }

    public void Logout(String userID){
        query = "UPDATE log_login SET waktu_logout=CURRENT_TIMESTAMP() WHERE id_user=? ORDER BY id DESC LIMIT 1";
        try { 
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, userID);
            psmt.executeUpdate();
            psmt.close();
            // memutus koneksi database
            koneksi.close();
            // hapus Session
            Session.setUserID(null);
            Session.setNama(null);
            Session.setStatusLogin(null);
        } catch (SQLException e) { }
    }
}
