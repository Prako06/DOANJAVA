/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.lang.reflect.Array;
import java.util.ArrayList;
import model.HangHoa;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import DAO.MyConnect;
import java.sql.*;
/**
 *
 * @author nhipr
 */
public class HangHoaDAO  {

    private Connection conn;

    public HangHoaDAO() {
        conn = MyConnect.getConnection();
    }
    
    public ArrayList<HangHoa> DSHH() {
        ArrayList<HangHoa> dshh = new ArrayList<HangHoa>();
        try {
            String sql = "SELECT * FROM chbqa.hanghoa";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                HangHoa sv = new HangHoa();
                sv.setMaHang(rs.getInt(1));
                sv.setTenHang(rs.getString(2));
                sv.setSLTon(rs.getString(3));
                sv.setDVT(rs.getString(4));
                sv.setDonGia(rs.getString(5));
                sv.setMaLH(rs.getString(6));
                dshh.add(sv);

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return dshh;

    }

    public int remove(HangHoa hh) {
        try {
            String sql = "DELETE FROM `chbqa`.`hanghoa` WHERE (`MaHang` = ?)";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, hh.getMaHang());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    public int add(HangHoa hh)
    {
        int ma = createmh();
        try {
            String sql = "INSERT INTO `chbqa`.`hanghoa` (`MaHang`, `TenHang`, `SLTon`, `DVT`, `DonGia`, `MaLH`) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, ma);
            pre.setString(2, hh.getTenHang());
            pre.setString(3, hh.getSLTon());
            pre.setString(4, hh.getDVT());
            pre.setString(5, hh.getDonGia());
            pre.setString(6, hh.getMaLH());
            pre.executeUpdate();
            return ma;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    private int createmh()
    {
        ArrayList<HangHoa> lhh = this.DSHH();
        int ma = lhh.size();
        while(true)
        {
            if(!checkhh(ma))
            {
                
                break;
                
            }
            ma++;
        }
        
        return ma;
    }
    private boolean checkhh(int ma)
    {
        try {
            String sql = "SELECT * FROM chbqa.hanghoa where hanghoa.maHang = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, ma);
            ResultSet rs = pre.executeQuery();
            return rs.next();
            
        } catch (Exception e) {
            
        }
        
        return true;
    }
    public int update(HangHoa hh)
    {
        try {
            String sql = "UPDATE `chbqa`.`hanghoa` SET `SLTon` = ?, `DonGia` = ? WHERE (`MaHang` = ?)";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(3, hh.getMaHang());
            pre.setString(2, hh.getDonGia());
            pre.setString(1, hh.getSLTon());
            return pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return -1;
    }
    public ArrayList<HangHoa> dshh(String dk)
    {
        String dkm = "%"+dk+"%";
        ArrayList<HangHoa> dshh = new ArrayList<HangHoa>();
        try {
            String sql = "SELECT * FROM chbqa.hanghoa where TenHang Like ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, dkm);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                HangHoa sv = new HangHoa();
                sv.setMaHang(rs.getInt(1));
                sv.setTenHang(rs.getString(2));
                sv.setSLTon(rs.getString(3));
                sv.setDVT(rs.getString(4));
                sv.setDonGia(rs.getString(5));
                sv.setMaLH(rs.getString(6));
                dshh.add(sv);

            }
            
        } catch (Exception e) {
        }
        return dshh;
    }
    public HangHoa getHH(int ma)
    {
        HangHoa hh = new HangHoa();
        try {
            String sql  ="SELECT * FROM chbqa.hanghoa where hanghoa.mahang =?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, ma);
            ResultSet re = pre.executeQuery();
            while(re.next())
            {
                hh.setMaHang(ma);
                hh.setTenHang(re.getString(2));
                hh.setSLTon(re.getString(3));
                hh.setDonGia(re.getString(5));
            }
            
            return hh;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
