/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
/**
 *
 * @author nhipr
 */
public class HoaDon {
    private int maHD;
    private int maKH;
    private int maNV;
    private int TT;
    private Date date;

    public HoaDon(int MaHD, int maKH, int maNV, int TT, Date date) {
        this.maHD = MaHD;
        this.maKH = maKH;
        this.maNV = maNV;
        this.TT = TT;
        this.date = date;
    }

    public HoaDon() {
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int MaHD) {
        this.maHD = MaHD;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public int getTT() {
        return TT;
    }

    public void setTT(int TT) {
        this.TT = TT;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
