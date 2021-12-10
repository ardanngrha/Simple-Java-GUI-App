/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;

/**
 *
 * @author Adan Nugraha 202031242
 */
public class BentukLayangLayang extends Bentuk{
    @Override
    protected void set_C() {
        c = a * b * 0.5;
    }
    
    @Override
    protected String cetak() {
        luas = "Luas Layang - Layang : " + get_A() + " * " + get_B() + " 0.5 = " + get_C();
        return luas;
    }
}
