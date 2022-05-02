/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import model.HoaDon;
import java.util.ArrayList;
import model.HangHoa;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import java.text.SimpleDateFormat;  
import java.util.Date; 
import model.CTHD;
import java.sql.*;
import DAO.MyConnect;
/**
 *
 * @author nhipr
 */
public class HDDAO{
    private Connection conn;

    public HDDAO() {
        conn = MyConnect.getConnection();
    }
    
 public int createhd(HoaDon hd)   
 {
     String SQL = "INSERT INTO `chbqa`.`hoadon` (`MaHD`, `NgayLap`, `TongTien`, `MaNV`, `MaKH`) VALUES (?, ?, ?, ?, ?)";
     int ma = mahd();
     try {
         PreparedStatement pre = conn.prepareStatement(SQL);
         
         pre.setInt(1, ma);
         LocalDate localDate = LocalDate.now();
         pre.setString(2, localDate.toString());
         pre.setInt(3, hd.getTT());
         pre.setInt(4, hd.getMaNV());
         pre.setInt(5, hd.getMaKH());
         pre.executeUpdate();
     } catch (Exception e) {
         e.printStackTrace();
     }
     return ma;
     
 }
 public int mahd()
 {
     int ma;
     ArrayList<HoaDon> dshd = getdshd();
     ma = dshd.size();
     boolean c = true;
     try {
         do { 
             ma++;
              String check = "SELECT * FROM chbqa.hoadon where hoadon.MaHd = ?";
              PreparedStatement pre = conn.prepareStatement(check);
              pre.setInt(1, ma);
              ResultSet rs = pre.executeQuery();
              c = rs.isFirst();
         } while (c);
        
         
     } catch (Exception e) {
     }
     return ma;
     
 }
 public ArrayList<HoaDon> getdshd()
 {
     ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
     try {
         String sql = "SELECT * FROM chbqa.hoadon";
         Statement stm = conn.createStatement();
         ResultSet rs = stm.executeQuery(sql);
         while(rs.next())
         {
             HoaDon hd = new HoaDon();
             hd.setMaHD(rs.getInt(1));
             String date = rs.getString(2);
             hd.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
             hd.setMaKH(rs.getInt(4));
             hd.setMaNV(rs.getInt(3));
             dshd.add(hd);
         }
         
     } catch (Exception e) {
         e.printStackTrace();
     }
     return dshd;
 }
    public void createCTHD(CTHD cthd)
    {
       try {
           String sql = "INSERT INTO `chbqa`.`cthd` (`MaHD`, `SoLuong`, `DonGIa`, `MaHang`) VALUES (?, ?, ?, ?)";
           PreparedStatement pre = conn.prepareStatement(sql);
           pre.setInt(1, cthd.getMahd());
           pre.setInt(2, cthd.getSl());
           pre.setInt(3, cthd.getDongia());
           pre.setInt(4, cthd.getMahh());
           pre.executeUpdate();
       } catch (Exception e) {
           e.printStackTrace();
       }


}
    
}
