/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.BLL;

import examproject2017.BE.Guild;
import examproject2017.BE.Hour;
import examproject2017.BE.Volunteer;
import examproject2017.DAL.HourHandler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gudla
 */
public class HourManager
{
    private HourHandler hourHandler = new HourHandler();
    
     public ArrayList<String> getHours()
       {
         return hourHandler.getHours();
       }
    
     public List<Hour> getHourFromGuildidAndVol(Guild guildId, Volunteer volId)
       {
         return hourHandler.getHourFromGuildidAndVol(guildId, volId);
       }
     
}
