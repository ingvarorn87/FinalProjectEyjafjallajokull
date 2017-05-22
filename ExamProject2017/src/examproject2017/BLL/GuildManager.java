/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.BLL;

import examproject2017.BE.Guild;
import examproject2017.DAL.GuildHandler;
import java.util.ArrayList;

/**
 *
 * @author Ingvar
 */
public class GuildManager {
    
   private GuildHandler guildHandler = new GuildHandler();
   
   public ArrayList<Guild> getAllGuilds()
   {
       return guildHandler.getAllGuilds();
   }
   
//   public ArrayList<String> getGuildHours()
//   {
//       return guildHandler.getGuildHours();
//   }
    
   public void addGuild (String Name, int Adminid)
   {
       guildHandler.addGuild(Name, Adminid);
   }
}
