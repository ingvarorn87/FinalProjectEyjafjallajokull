/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.BLL;

import examproject2017.BE.Person;
import examproject2017.DAL.IAdLogHandler;
import examproject2017.DAL.IVolLogHand;

/**
 *
 * @author gudla
 */
public class LoginManager
{

    
    private IVolLogHand volLoginHandler;
    private IAdLogHandler adLoginHandler;

    public LoginManager(IVolLogHand volLoginHandler, IAdLogHandler adLoginHandler)
      {
        this.adLoginHandler = adLoginHandler;
        this.volLoginHandler = volLoginHandler;
      }

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
