/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.DAL;

import examproject2017.BE.Hours;
import examproject2017.BE.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    
    
    public Hours getHoursBasedOnGuildId(int guildID)
      {
        try (Connection con = conManager.getConnection())
          {
            String query = "SELECT * FROM [GuildVolHours] WHERE guildId = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, guildID);

            return getHoursFromResults(pstmt);
          }
        catch (SQLException sqle)
          {
            System.err.println(sqle);
            return null;
          }
      }
    
    public Hours getHoursBasedOnVolId(int volID)
      {
        try (Connection con = conManager.getConnection())
          {
            String query = "SELECT * FROM [GuildVolHours] WHERE Volid= ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, volID);

            return getHoursFromResults(pstmt);
          }
        catch (SQLException sqle)
          {
            System.err.println(sqle);
            return null;
          }
      }
}
