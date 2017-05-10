/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
    
    public ArrayList<String> getGuildName()
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
                guildString += rs.getString("Name");

                guilds.add(guildString);
              }
            return guilds;
          } catch (SQLException sqle)
          {
            System.err.println(sqle);
            return null;
          }
      }
//    public ArrayList<String> getGuildHours()
//      {
//        try (Connection con = conManager.getConnection())
//          {
//            String query = "SELECT * FROM [Guilds]";
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//
//            ArrayList<String> hours = new ArrayList<>();
//            while (rs.next())
//              {
//                String hoursString = "";
//                hoursString += rs.getString("Hours");
//
//                hours.add(hoursString);
//              }
//            return hours;
//          } catch (SQLException sqle)
//          {
//            System.err.println(sqle);
//            return null;
//          }
//      }
    
}
