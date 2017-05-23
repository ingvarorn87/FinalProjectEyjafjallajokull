/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.GUI.Model;

import examproject2017.BE.Volunteer;
import examproject2017.BLL.VolunteerManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Ingvar
 */
public class VolunteerModel {
    
    public VolunteerManager volunteerManager = new VolunteerManager();
    
   public void addVolunteer(String Name, String PhoneNumber, String Address, File file, String Email, String Information)
   {
       volunteerManager.addVolunteer( Name, PhoneNumber, Address, file, Email, Information);
   }
   
   public List<Volunteer> getAllVolunteers()
       {
         return volunteerManager.getAllVolunteers();
       }
    
          
}
