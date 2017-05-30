/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.BLL;

import examproject2017.BE.Person;
import examproject2017.BE.Volunteer;
import examproject2017.DAL.AdminLoginHandler;
import examproject2017.DAL.VolunteerHandler;
import examproject2017.DAL.VolunteerLoginHandler;
import java.util.ArrayList;

/**
 *
 * @author gudla
 */
public class LoginManager
{

    
    private VolunteerLoginHandler volLoginHandler = new VolunteerLoginHandler();
    private AdminLoginHandler adLoginHandler = new AdminLoginHandler();




    public Person LoginChecker(String name, String password)
      {
        if (volLoginHandler.LoginChecker(name) != null)
          {
            return volLoginHandler.LoginChecker(name);
          }else
          {
            return adLoginHandler.LoginChecker(name, password);
          }
      }


}
