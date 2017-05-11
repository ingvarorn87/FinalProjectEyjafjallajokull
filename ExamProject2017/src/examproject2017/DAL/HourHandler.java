/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.DAL;

import examproject2017.BE.Hours;

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
public class HourHandler
{
    
    
    SQLConnectionHandler conManager;
    public HourHandler()
      {
        conManager = new SQLConnectionHandler();
      }
    
    public Hours getHoursFromResults(PreparedStatement pstmt) throws SQLException
      {
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        
        int guildId = rs.getInt("Guildid");
        int volId = rs.getInt("Volid");
        int hours = rs.getInt("Hours");
        
        
        Hours ahours = new Hours(guildId, volId, hours);
        
        return ahours;
      }
    
    
    public ArrayList<String> getHours()
      {
        try (Connection con = conManager.getConnection())
          {
            String query = "SELECT * FROM [GuildVolHours]";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<String> hours = new ArrayList<>();
            while (rs.next())
              {
                String volString = "";
                volString += rs.getString("Hours");

                hours.add(volString);
              }
            return hours;
          } catch (SQLException sqle)
          {
            System.err.println(sqle);
            return null;
          }
      }
    
    

    public Hours getHoursBasedOnGuildId(String guildId)
      {
        try (Connection con = conManager.getConnection())
          {
            String query = "SELECT * FROM [GuildVolHours] WHERE Guildid = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, guildId);

            return getHoursFromResults(pstmt);
          }
        catch (SQLException sqle)
          {
            System.err.println(sqle);
            return null;
          }
      }

}
