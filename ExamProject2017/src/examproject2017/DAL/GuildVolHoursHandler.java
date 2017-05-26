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
        while (rs.next())
          {

            int guildId = rs.getInt("GuildId");
            int volId = rs.getInt("VolId");
            int hour = rs.getInt("TotalHours");
            GuildVolHours guildVolHours = new GuildVolHours(guildId, volId, hour);
            String guildName = rs.getString("GuildName");
            String volName = rs.getString("VolunteerName");
            guildVolHours.setGuildName(guildName);
            guildVolHours.setVolName(volName);
            hours.add(guildVolHours);
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

    public List<GuildVolHours> getVolHours(Volunteer volId)
      {
        try (Connection con = conManager.getConnection())
          {
            String query = "SELECT g.Name AS GuildName, SUM(gvh.Hours) AS TotalHours, g.Guildid AS GuildId, gvh.Volid\n"
                    + "FROM [GuildVolHours] gvh \n"
                    + "JOIN [Guilds] g ON g.Guildid = gvh.Guildid \n"
                    + "WHERE Volid = ?\n"
                    + "GROUP BY g.Name, g.Guildid, gvh.Volid\n"
                    + "ORDER BY g.Name";
            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setInt(1, volId.getId());

            ResultSet rs = pstmt.executeQuery();
            ArrayList<GuildVolHours> hours = new ArrayList();
            while (rs.next())
              {

                int guildId = rs.getInt("GuildId");
                int volunteerId = rs.getInt("VolId");
                int hour = rs.getInt("TotalHours");
                GuildVolHours guildVolHours = new GuildVolHours(guildId, volunteerId, hour);
                String guildName = rs.getString("GuildName");

                guildVolHours.setGuildName(guildName);

                hours.add(guildVolHours);
              }
            return hours;
          } catch (SQLException sqle)
          {
            System.err.println(sqle);
            return null;
          }
      }

    

}
