/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.BLL;

import examproject2017.BE.Guild;
import examproject2017.BE.GuildVolHours;
import examproject2017.BE.Volunteer;
import examproject2017.DAL.GuildVolHoursHandler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gudla
 */
public class GuildVolHoursManager
{
    private GuildVolHoursHandler guildVolHoursHandler = new GuildVolHoursHandler();
    
     public ArrayList<String> getHours()
       {
         return guildVolHoursHandler.getHours();
       }
    
     public List<GuildVolHours> getVolHours(Volunteer volId)
       {
         return guildVolHoursHandler.getVolHours(volId);
       }
     
}