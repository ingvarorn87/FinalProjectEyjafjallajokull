/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.DAL;

import examproject2017.BE.Volunteer;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author gudla
 */
public class VolunteerHandler
{

    SQLConnectionHandler conManager;

    public VolunteerHandler()
      {
        conManager = new SQLConnectionHandler();
      }

    public ArrayList<String> getVolName()
      {
        try (Connection con = conManager.getConnection())
          {
            String query = "SELECT * FROM [Volunteers]";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<String> volunteers = new ArrayList<>();
            while (rs.next())
              {
                String volString = "";
                volString += rs.getString("Name");

                volunteers.add(volString);
              }
            return volunteers;
          } catch (SQLException sqle)
          {
            System.err.println(sqle);
            return null;
          }
      }

//    public ArrayList<String> getHours()
//      {
//        try (Connection con = conManager.getConnection())
//          {
//            String query = "SELECT * FROM [Volunteers]";
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//
//            ArrayList<String> volunteers = new ArrayList<>();
//            while (rs.next())
//              {
//                String volString = "";
//                volString += rs.getString("Hours");
//
//                volunteers.add(volString);
//              }
//            return volunteers;
//          } catch (SQLException sqle)
//          {
//            System.err.println(sqle);
//            return null;
//          }
//      }

    public ArrayList<String> getVolEmail()
      {
        try (Connection con = conManager.getConnection())
          {
            String query = "SELECT * FROM [Volunteers]";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<String> volunteers = new ArrayList<>();
            while (rs.next())
              {
                String volString = "";
                volString += rs.getString("Email");

                volunteers.add(volString);
              }
            return volunteers;
          } catch (SQLException sqle)
          {
            System.err.println(sqle);
            return null;
          }
      }

    public ArrayList<String> getVolAddress()
      {
        try (Connection con = conManager.getConnection())
          {
            String query = "SELECT * FROM [Volunteers]";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<String> volunteers = new ArrayList<>();
            while (rs.next())
              {
                String volString = "";
                volString += rs.getString("Address");

                volunteers.add(volString);
              }
            return volunteers;
          } catch (SQLException sqle)
          {
            System.err.println(sqle);
            return null;
          }
      }

    public ArrayList<String> getVolID()
      {
        try (Connection con = conManager.getConnection())
          {
            String query = "SELECT * FROM [Volunteers]";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<String> volunteers = new ArrayList<>();
            while (rs.next())
              {
                String volString = "";
                volString += rs.getString("ID");

                volunteers.add(volString);
              }
            return volunteers;
          } catch (SQLException sqle)
          {
            System.err.println(sqle);
            return null;
          }
      }
    
    public Volunteer getVolunteerBasedOnName(String name)
      {
        try (Connection con = conManager.getConnection())
          {
            String query = "SELECT * FROM [Volunteers] WHERE name = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);

            return getVolunteerFromResults(pstmt);
          }
        catch (SQLException sqle)
          {
            System.err.println(sqle);
            return null;
          }
      }
    
    public Volunteer getVolunteerFromResults(PreparedStatement pstmt) throws SQLException
      {
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        int id = rs.getInt("Volid");
        String name = rs.getString("Name");
        String email = rs.getString("Email");
        String address = rs.getString("Address");
        String phone = rs.getString("PhoneNumber");
        String info = rs.getString("Information");
        
        //byte[] bytes = rs.getBytes("image");
//        BufferedImage newImage;
//        if (bytes != null)
//          {
//            try
//              {
//                ByteArrayInputStream bais;
//                bais = new ByteArrayInputStream(rs.getBytes("image"));
//
//                newImage = ImageIO.read(bais);
//              }
//            catch (IOException ex)
//              {
//                Logger.getLogger(StudentHandler.class.getName()).log(Level.SEVERE, null, ex);
//                newImage = null;
//              }
//          }
//        else
//          {
//            newImage = null;
//          }
        Volunteer volunteer = new Volunteer(id, name, email, address, phone, info);
        return volunteer;
      }

}
