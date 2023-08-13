/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qldt.Controller;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author ziplo
 */
public class DBConnection {
    public Connection connection;
    public String classDB = "com.mysql.jdbc.Driver";
    public String url = "jdbc:mysql://localhost:3306/qldt?characterEncoding=utf-8";
    public String username = "root";
    public String password = "o8651o2o23";
    public Connection connectDB() {
        try{
            Class.forName(classDB);
            connection =  DriverManager.getConnection(url, username, password);
        }catch(Exception e){
            e.printStackTrace();
        }
        return connection;
    }
//    public static void main(String[] args) {
//        
//                System.out.println(new DBConnection().connectDB());
//    }
}
