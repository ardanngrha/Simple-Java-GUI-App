/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;

/**
 *
 * @author Adan Nugraha 202031242
 */
public class BentukJajarGenjang extends Bentuk {
    @Override
    protected void set_C() {
        c = a * b;
    }
    
    @Override
    protected String cetak() {
        luas = "Luas Jajar Genjang : " + get_A() + " * " + get_B() + " = " + get_C();
        return luas;
    }
}
