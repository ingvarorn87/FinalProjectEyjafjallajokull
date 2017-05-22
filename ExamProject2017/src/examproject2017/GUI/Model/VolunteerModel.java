/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.GUI.Model;

import examproject2017.BLL.VolunteerManager;
import java.awt.image.BufferedImage;



/**
 *
 * @author Ingvar
 */
public class VolunteerModel {
    
    public VolunteerManager volunteerManager = new VolunteerManager();
    
   public void addVolunteer(String Name, String PhoneNumber, String Address, BufferedImage Image, String Email, String Information)
   {
       volunteerManager.addVolunteer( Name, PhoneNumber, Address, Image, Email, Information);
   }
    
          
}
