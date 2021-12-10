/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

/*
@author Adan Nugraha 202031242
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class KoneksiMySql {
    private Connection connect; 
    private String driverName = "com.mysql.cj.jdbc.Driver";  
    private String jdbc = "jdbc:mysql://"; 
    private String host = "localhost:"; 
    private String port = "3306"; 
    private String database = "/testCRUD"; 
    private String url = jdbc + host + port + database; 
    private String username = "root"; 
    private String password = ""; 
    public Connection getKoneksi() throws SQLException{ 
        if(connect == null){ 
            try{ 
                Class.forName(driverName); 
                System.out.println("Class Driver Ditemukan"); 
                try { 
                 connect = (Connection) DriverManager.getConnection(url, username, password); 
                 System.out.println("Koneksi Database Sukses"); 
                }catch(SQLException se){ 
                System.out.println("Koneksi Database Gagal : "+se); 
                System.exit(0); 
                } 
            }catch (ClassNotFoundException cnfe){ 
                System.out.println("Class Driver Tidak Ditemukan, Terjadi Kesalahan Pada :"+cnfe); 
                System.exit(0); 
            } 
        } 
        return connect; 
    } 
}
