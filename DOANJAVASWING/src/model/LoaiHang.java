/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nhipr
 */
public class LoaiHang {
    private int malh;
    private String Tenlh;

    public LoaiHang(int malh, String Tenlh) {
        this.malh = malh;
        this.Tenlh = Tenlh;
    }

    public LoaiHang() {
    }

    public int getMalh() {
        return malh;
    }

    public void setMalh(int malh) {
        this.malh = malh;
    }

    public String getTenlh() {
        return Tenlh;
    }

    public void setTenlh(String Tenlh) {
        this.Tenlh = Tenlh;
    }
    @Override
    public String toString()
    {
        return this.Tenlh;
    }
}
