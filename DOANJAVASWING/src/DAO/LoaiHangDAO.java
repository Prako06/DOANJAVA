/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;
import DAO.MyConnect;
import model.LoaiHang;

/**
 *
 * @author nhipr
 */
public class LoaiHangDAO {
    private Connection conn;
    public LoaiHangDAO()
    {
        conn = MyConnect.getConnection();
    }
    public ArrayList<LoaiHang> getLoaiHangs()
    {
        
        
        ArrayList<LoaiHang> llh = new ArrayList<LoaiHang>();
        
        try {
            String sql = "SELECT * FROM chbqa.loaihang";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                LoaiHang lh = new LoaiHang();
                lh.setMalh(rs.getInt(1));
                lh.setTenlh(rs.getString(2));
                
                llh.add(lh);

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return llh;
    }
    
}
