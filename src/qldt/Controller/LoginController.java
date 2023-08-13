/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qldt.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.ldap.Rdn;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import qldt.Model.Account;
import qldt.View.MenuView;

/**
 *
 * @author ziplo
 */
public class LoginController {

    public Connection connection = new DBConnection().connectDB();

    public int checkAccount(Account account) {
        System.out.println(account.getUsername() + "\t" + account.getPassword());
        String sql = "SELECT `Account`.Status FROM `Account` WHERE Username = '" + account.getUsername() + "' AND Password = '" + account.getPassword() + "';";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getBoolean("Status") == true) return 1; //access true
                return 0; // lock account

            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return -1; // invalid
    }

}
