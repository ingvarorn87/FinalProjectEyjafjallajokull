/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.GUI.Model;

import examproject2017.BE.Guild;
import examproject2017.BE.GuildVolHours;

import examproject2017.BE.Volunteer;
import examproject2017.BLL.GuildVolHoursManager;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author gudla
 */
public class GuildVolHoursModel
{
    
    private GuildVolHoursManager guildVolHoursManager = new GuildVolHoursManager();
    private final ObservableList<GuildVolHours> observableHour;        

    public GuildVolHoursModel()
      {
        this.observableHour = FXCollections.observableArrayList();
      }

    public ObservableList<GuildVolHours> getObservableHour()
      {
        return observableHour;
      }

    public void setSelectedVolunteer(Volunteer selectedVol)
      {
        observableHour.clear();
        observableHour.addAll(guildVolHoursManager.getVolHours(selectedVol));
      }
    
    public ArrayList<String> getHours()
       {
         return guildVolHoursManager.getHours();
       }
    
    public List<GuildVolHours> getVolHours(Volunteer volId)
       {
         return guildVolHoursManager.getVolHours(volId);
       }
}
