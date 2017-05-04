/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.GUI.Model;

import examproject2017.BE.Volunteer;
import examproject2017.BLL.VolLoginManager;
import java.util.ArrayList;

/**
 *
 * @author gudla
 */
public class VolLoginModel
{
    public VolLoginManager volLoginManager = new VolLoginManager();
    
    public ArrayList<String> getVolName(){
        return volLoginManager.getVolName();
    }
    
    public Volunteer LoginChecker(String name)
      {
        return volLoginManager.LoginChecker(name);
      }
}
