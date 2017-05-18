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
        
        
        hours.add(new GuildVolHours(guildId, volId, hour)) ;
        }
        return hours;
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
    
    

    public List<GuildVolHours> getVolHours(Volunteer volId )
      {
        try (Connection con = conManager.getConnection())
          {
            String query = "SELECT * FROM [GuildVolHours] WHERE Volid = ? ";
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