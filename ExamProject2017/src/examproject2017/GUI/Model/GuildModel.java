/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.GUI.Model;

import examproject2017.BLL.GuildManager;
import java.util.ArrayList;


/**
 *
 * @author Ingvar
 */
public class GuildModel {
    
      public GuildManager guildManager = new GuildManager();
      
      public ArrayList<String> getGuildName()
      {
          return guildManager.getGuildNames();
      }
    
      public ArrayList<String> getGuildHours()
      {
          return guildManager.getGuildHours();
      }
      
}
