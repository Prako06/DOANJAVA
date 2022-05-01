/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author PraKo
 */
public class MyConnect {
        public Connection conn = null;

    public MyConnect() {
        try {           
            conn = DriverManager.getConnection("jdbc:mysql://localhost/chbqa", "root", "nhitu1den6");
            System.out.println("Ket noi thanh cong");
        } catch (SQLException e) {
            System.out.println("Ket noi that bai");
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        MyConnect a = new MyConnect();
    }
}
