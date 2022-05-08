/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Admin
 */
public class KhachHang {
    public int MaKH;
    public String TenKH;
    public int Sdt;
    public String Email;
    public String Diachi;

    public KhachHang() {
    }

    public KhachHang(int MaKH, String TenKH, int Sdt, String Email, String Diachi) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.Sdt = Sdt;
        this.Email = Email;
        this.Diachi = Diachi;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "MaKH=" + MaKH + ", TenKH=" + TenKH + ", Sdt=" + Sdt + ", Email=" + Email + ", Diachi=" + Diachi + '}';
    }
    
    
}
