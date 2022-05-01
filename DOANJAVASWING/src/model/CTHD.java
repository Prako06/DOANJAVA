/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nhipr
 */
public class CTHD {
    private int mahd;
    private int mahh;
    private int sl;
    private int dongia;

    public CTHD(int mahd, int mahh, int sl, int dongia) {
        this.mahd = mahd;
        this.mahh = mahh;
        this.sl = sl;
        this.dongia = dongia;
    }

    public CTHD() {
    }

    public int getMahd() {
        return mahd;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

    public int getMahh() {
        return mahh;
    }

    public void setMahh(int mahh) {
        this.mahh = mahh;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }
}
