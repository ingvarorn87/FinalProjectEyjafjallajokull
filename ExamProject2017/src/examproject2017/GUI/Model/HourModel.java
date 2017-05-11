/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.GUI.Model;

import examproject2017.BE.Guild;
import examproject2017.BE.Hour;
import examproject2017.BE.Volunteer;
import examproject2017.BLL.HourManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gudla
 */
public class HourModel
{
    private HourManager hourManager = new HourManager();
    
    
    public ArrayList<String> getHours()
       {
         return hourManager.getHours();
       }
    
    public List<Hour> getHourFromGuildidAndVol(Guild guildId, Volunteer volId)
       {
         return hourManager.getHourFromGuildidAndVol(guildId, volId);
       }
}
