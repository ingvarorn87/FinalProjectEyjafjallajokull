/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.BLL;

import examproject2017.BE.Volunteer;
import examproject2017.DAL.VolunteerHandler;
import examproject2017.DAL.VolunteerLoginHandler;
import java.util.ArrayList;

/**
 *
 * @author gudla
 */
public class VolLoginManager
{
    private VolunteerHandler volHandler = new VolunteerHandler();
    private VolunteerLoginHandler volLoginHandler = new VolunteerLoginHandler();
    
    public ArrayList<String> getVolName(){
        return volHandler.getVolName();
    }
    
    public Volunteer LoginChecker(String name)
      {
        return volLoginHandler.LoginChecker(name);
      }
}
