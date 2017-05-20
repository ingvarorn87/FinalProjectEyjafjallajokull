/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.DAL;

import examproject2017.BE.Guild;
import examproject2017.BE.GuildVolHours;
import examproject2017.BE.Volunteer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gudla
 */
public class GuildVolHoursHandler
{
    
    
    SQLConnectionHandler conManager;
    public GuildVolHoursHandler()
      {
        conManager = new SQLConnectionHandler();
      }
    
    public List<GuildVolHours> getHoursFromResults(PreparedStatement pstmt) throws SQLException
      {
        ResultSet rs = pstmt.executeQuery();
        ArrayList<GuildVolHours> hours = new ArrayList();
                while(rs.next()){
        
        int guildId = rs.getInt("Guildid");
        int volId = rs.getInt("Volid");
        int hour = rs.getInt("Hours");
        GuildVolHours guildVolHours = new GuildVolHours(guildId, volId, hour);
        String guildName = rs.getString("Name");
        guildVolHours.setGuildName(guildName);
        
        hours.add(guildVolHours) ;
        }
        return hours;
      }
    
    
    public void addHours(int guildId, int volId, int hours)
      {
        try (Connection con = conManager.getConnection())
          {
            String sqlCommand = "INSERT INTO GuildVolHours(guildid, volid, hours) VALUES(?, ?, ?)";
            PreparedStatement pstat = con.prepareStatement(sqlCommand);
            pstat.setInt(1, guildId);
            pstat.setInt(2, volId);
            pstat.setInt(3, hours);
            
            pstat.executeUpdate();
          } catch (SQLException sqle)
          {
            System.err.println(sqle);
          }
      }
    
    

    public List<GuildVolHours> getVolHours(Volunteer volId )
      {
        try (Connection con = conManager.getConnection())
          {
            String query = "SELECT * FROM [GuildVolHours] JOIN [Guilds] ON Guilds.Guildid = GuildVolHours.Guildid WHERE Volid = ? ";
            PreparedStatement pstmt = con.prepareStatement(query);
            
            pstmt.setInt(1, volId.getId());
            

            return getHoursFromResults(pstmt);
          }
        catch (SQLException sqle)
          {
            System.err.println(sqle);
            return null;
          }
      }
    
    

}
