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
import javafx.beans.property.SimpleObjectProperty;
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
    private final SimpleObjectProperty<Volunteer> selectedVolunteer;
    private final ObservableList<GuildVolHours> observableAllGuildVolHours;

    public GuildVolHoursModel()
      {
        this.observableHour = FXCollections.observableArrayList();
        this.selectedVolunteer = new SimpleObjectProperty<>();
        this.observableAllGuildVolHours = FXCollections.observableArrayList();
        
      }

    public GuildVolHoursManager getGuildVolHoursManager()
      {
        return guildVolHoursManager;
      }

    public void setGuildVolHoursManager(GuildVolHoursManager guildVolHoursManager)
      {
        this.guildVolHoursManager = guildVolHoursManager;
      }

    public ObservableList<GuildVolHours> getObservableHour()
      {
        return observableHour;
      }
    
    public ObservableList<GuildVolHours> getObservableAllGuildVolHours()
      {
        return observableAllGuildVolHours;
      }

   
    public void setSelectedVolunteer(Volunteer selectedVol)
      {
        selectedVolunteer.set(selectedVol);
        observableHour.clear();
        observableHour.addAll(guildVolHoursManager.getVolHours(selectedVol));
      }
    
    public void setObservableAllGuildVolHour()
      {
        observableAllGuildVolHours.clear();
        observableAllGuildVolHours.addAll(guildVolHoursManager.getAllGuildsVolHours());
      }
    
    public SimpleObjectProperty<Volunteer> getSelectedVolunteer()
      {
        return selectedVolunteer;
      }

    public List<GuildVolHours> getVolHours(Volunteer volId)
      {
        return guildVolHoursManager.getVolHours(volId);
      }

    public void addHours(int guildId, int volId, int hours)
      {
        guildVolHoursManager.addHours(guildId, volId, hours);
      }
    
    public List<GuildVolHours> getAllGuildsVolHours()
      {
        return guildVolHoursManager.getAllGuildsVolHours();
      }
            

}
