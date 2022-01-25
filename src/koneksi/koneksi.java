/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Akbar
 */
public class koneksi {
    static Connection mysqlconfig;
    static Statement mysqlstm;
    
    public Connection connect(){
        try {
            String url = "jdbc:mysql://localhost:3306/db_resepsionis8jkt";
            String user = "root";
            String pass = "";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            mysqlconfig = DriverManager.getConnection(url, user, pass);
            mysqlstm = mysqlconfig.createStatement();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Koneksi GAGAL!\n"+e);
        }
        return mysqlconfig;
    }
}
