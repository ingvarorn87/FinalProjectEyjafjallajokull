/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.BLL;

import examproject2017.BE.Volunteer;
import examproject2017.DAL.IVolLogHand;

/**
 *
 * @author gudla
 */
public class MockVolLoginHandler implements IVolLogHand
{

    @Override
    public Volunteer LoginChecker(String name)
      {
        if (name.equals("Bilbo"))
          {
            return new Volunteer(0, "Bilbo", "", "", "", "", null);
          } else
          {
            return null;
          }
      }

}
