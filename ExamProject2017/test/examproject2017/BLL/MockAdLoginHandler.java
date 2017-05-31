/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.BLL;

import examproject2017.BE.Admin;
import examproject2017.DAL.IAdLogHandler;

/**
 *
 * @author gudla
 */
public class MockAdLoginHandler implements IAdLogHandler
{

    @Override
    public Admin LoginChecker(String name, String password)
      {
        if (name.equals("Per") && password.equals("1234"))
          {
            return new Admin("Per", "", 0, "", "");
          } else
          {
            return null;
          }
      }

}
