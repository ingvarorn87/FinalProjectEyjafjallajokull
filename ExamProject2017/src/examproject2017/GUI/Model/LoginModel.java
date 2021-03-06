/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.GUI.Model;

import examproject2017.BE.Person;
import examproject2017.BE.Volunteer;
import examproject2017.BLL.LoginManager;
import examproject2017.DAL.AdminLoginHandler;
import examproject2017.DAL.VolunteerLoginHandler;
import java.util.ArrayList;

/**
 *
 * @author gudla
 */
public class LoginModel
{
    public LoginManager loginManager = new LoginManager(new VolunteerLoginHandler(), new AdminLoginHandler());
    private static final LoginModel volLoginModel = new LoginModel();

    public Person LoginChecker(String name, String password)
      {
        return loginManager.LoginChecker(name, password);
      }

    public static LoginModel getVolLoginModel()
      {
        return volLoginModel;
      }
}
