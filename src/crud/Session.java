/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;

/**
 *
 * @author Adan Nugraha 202031242
 */
public class Session {
    private static String UserID, Nama, StatusLogin;
    
    public static void setUserID(String UserID) {
        Session.UserID = UserID;
    }
    
    public static String getUserID() {
        return UserID;
    }
    
    public static void setNama(String Nama) {
        Session.Nama = Nama;
    }
    
    public static String getNama() {
        return Nama;
    }
    
    public static void setStatusLogin(String StatusLogin) {
        Session.StatusLogin = StatusLogin;
    }
    
    public static String getStatusLogin() {
        return StatusLogin;
    }
}
