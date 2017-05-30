/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.DAL;

import examproject2017.BE.Guild;
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
public class GuildHandler
{

    SQLConnectionHandler conManager;

    public GuildHandler()
      {
        conManager = new SQLConnectionHandler();
      }

    public ArrayList<Guild> getAllGuilds()
      {
        try (Connection con = conManager.getConnection())
          {
            String query = "SELECT * FROM [Guilds]";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<Guild> guilds = new ArrayList<>();
            while (rs.next())
              {
                guilds.add(new Guild(rs.getInt("Guildid"), rs.getString("Name")));
              }
            return guilds;
          } catch (SQLException sqle)
          {
            System.err.println(sqle);
            return null;
          }
      }

    public ArrayList<String> getGuildId()
      {
        try (Connection con = conManager.getConnection())
          {
            String query = "SELECT * FROM [Guilds]";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<String> guilds = new ArrayList<>();
            while (rs.next())
              {
                String guildString = "";
                guildString += rs.getString("Guildid");

                guilds.add(guildString);
              }
            return guilds;
          } catch (SQLException sqle)
          {
            System.err.println(sqle);
            return null;
          }
      }

    public void addGuild(String Name, int Adminid)
      {
        try (Connection con = conManager.getConnection())
          {
            String sqlCommand = "INSERT INTO Guilds(Name, Adminid) VALUES(?, ?)";
            PreparedStatement pstat = con.prepareStatement(sqlCommand);
            pstat.setString(1, Name);
            pstat.setInt(2, Adminid);

            pstat.executeUpdate();
          } catch (SQLException sqle)
          {
            System.err.println(sqle);
          }
      }

    
}
