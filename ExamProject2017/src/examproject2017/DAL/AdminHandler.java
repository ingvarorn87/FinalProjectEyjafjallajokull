/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.DAL;

import examproject2017.BE.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author gudla
 */
public class AdminHandler
{
    
    SQLConnectionHandler conManager;
    public AdminHandler()
      {
        conManager = new SQLConnectionHandler();
      }
    
    public ArrayList<String> getAdName()
      {
        try (Connection con = conManager.getConnection())
          {
            String query = "SELECT * FROM [Admins]";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<String> admin = new ArrayList<>();
            while (rs.next())
              {
                String volString = "";
                volString += rs.getString("Name");

                admin.add(volString);
              }
            return admin;
          } catch (SQLException sqle)
          {
            System.err.println(sqle);
            return null;
          }
      }
    
    public Admin getAdminBasedOnName(String name)
      {
        try (Connection con = conManager.getConnection())
          {
            String query = "SELECT * FROM [Admins] WHERE name = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);

            return getAdminFromResults(pstmt);
          }
        catch (SQLException sqle)
          {
            System.err.println(sqle);
            return null;
          }
      }
    
     public Admin getAdminFromResults(PreparedStatement pstmt) throws SQLException
      {
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        
        String name = rs.getString("Name");
        String email = rs.getString("Email");
        int id = rs.getInt("Adminid");
        String phone = rs.getString("PhoneNumber");
        String address = rs.getString("Address");
        
        Admin admin = new Admin(name, email, id, phone, address);
        
        return admin;
      }
     
     public boolean checkRightPassword(String name, String password)
      {
        try (Connection con = conManager.getConnection())
          {
            String query = "SELECT * FROM [Admins] WHERE name = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            rs.next();

            return password.equals(rs.getString("password"));
          }
        catch (SQLException sqle)
          {
            System.err.println(sqle);
            return false;
          }
      }
}
