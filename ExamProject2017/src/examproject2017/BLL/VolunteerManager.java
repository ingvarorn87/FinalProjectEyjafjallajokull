/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.BLL;

import examproject2017.DAL.VolunteerHandler;
import java.awt.image.BufferedImage;

/**
 *
 * @author Ingvar
 */


public class VolunteerManager {
    
    private VolunteerHandler volunteerHandler = new VolunteerHandler();
    
     public void addVolunteer(String Name, String PhoneNumber, String Address, BufferedImage Image, String Email, String Information){
         volunteerHandler.addVolunteer(Name, PhoneNumber, Address, Image, Email, Information);
     }
    
    
}
