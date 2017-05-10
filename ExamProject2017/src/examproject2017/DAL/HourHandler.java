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
    
    private GuildHandler guildHandler = new GuildHandler();
    
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
    
    
    public Hours getHoursBasedOnGuildId(int guildID) // gets all hours in one Guild
      {
        try (Connection con = conManager.getConnection())
          {
            String query = "SELECT * FROM [GuildVolHours] WHERE Guildid = ?";
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
    
    public Hours getHoursBasedOnVolId(int volID) //gets Volunteer total hours in all guilds
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
    
    public Hours getVolHours(int hours) //gets Volunteer hours in one guild
      {
        try (Connection con = conManager.getConnection())
          {
            String query = "SELECT * FROM [GuildVolHours] WHERE Guildid = ? && Volid = ?";
            
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, hours);

            return getHoursFromResults(pstmt);
          }
        catch (SQLException sqle)
          {
            System.err.println(sqle);
            return null;
          }
      }
    
    public Hours guildHourChecker(int guildId)// checks the hours that a guild has
      {
        for(int aint : guildHandler.)
          {
            if(aint.equals(guildId))
              {
                
              }
          }
      }
    
//    public Volunteer LoginChecker(String name)
//      {
//        for (String string : volHandler.getVolName())
//          {
//            if (string.equals(name))
//              {
//                return volHandler.getVolunteerBasedOnName(string);
//
//              }
//          }
//        return null;
//      }
}
