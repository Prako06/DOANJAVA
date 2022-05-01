/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nhipr
 */
public class HangHoa {
    private int MaHang;
    private String TenHang;
    private String SLTon;
    private String DVT;
    private String DonGia;
    private String MaLH;

    public int getMaHang() {
        return MaHang;
    }

    public void setMaHang(int MaHang) {
        this.MaHang = MaHang;
    }

    public String getTenHang() {
        return TenHang;
    }

    public void setTenHang(String TenHang) {
        this.TenHang = TenHang;
    }

    public String getSLTon() {
        return SLTon;
    }

    public void setSLTon(String SLTon) {
        this.SLTon = SLTon;
    }

    public String getDVT() {
        return DVT;
    }

    public void setDVT(String DVT) {
        this.DVT = DVT;
    }

    public String getDonGia() {
        return DonGia;
    }

    public void setDonGia(String DonGia) {
        this.DonGia = DonGia;
    }

    public String getMaLH() {
        return MaLH;
    }

    public void setMaLH(String MaLH) {
        this.MaLH = MaLH;
    }

    public HangHoa() {
    }

    public HangHoa(int MaHang, String TenHang, String SLTon, String DVT, String DonGia, String MaLH) {
        this.MaHang = MaHang;
        this.TenHang = TenHang;
        this.SLTon = SLTon;
        this.DVT = DVT;
        this.DonGia = DonGia;
        this.MaLH = MaLH;
    }
    
    
}
