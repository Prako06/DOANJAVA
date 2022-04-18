/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.NhanVien;
/**
 *
 * @author PraKo
 */
public class LoadDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public List<NhanVien> getAllNhanViens(){
        String query = "SELECT * FROM chbqa.nhanvien";
        List<NhanVien> list = new ArrayList<>();
        try {
            conn = new MyConnect().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getInt(6), rs.getString(7)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }
}
