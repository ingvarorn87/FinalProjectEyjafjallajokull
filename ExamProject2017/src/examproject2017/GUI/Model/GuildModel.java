/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.GUI.Model;

import examproject2017.BE.Guild;
import examproject2017.BLL.GuildManager;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author Ingvar
 */
public class GuildModel {
    
      public GuildManager guildManager = new GuildManager();
      public ObservableList<Guild> observableGuilds = FXCollections.observableArrayList(getAllGuilds());
      
      public ArrayList<Guild> getAllGuilds()
      {
          return guildManager.getAllGuilds();
      }
      
      public void addGuild(String Name, int Adminid)
      {
          guildManager.addGuild(Name, Adminid);
      }
      
    
      
      
}
