/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.DAL;

import examproject2017.BE.Volunteer;

/**
 *
 * @author gudla
 */
public class VolunteerLoginHandler implements IVolLogHand
{

    VolunteerHandler volHandler = new VolunteerHandler();

    @Override
    public Volunteer LoginChecker(String name)
      {
        for (String string : volHandler.getVolName())
          {
            if (string.equals(name))
              {
                return volHandler.getVolunteerBasedOnName(string);

              }
          }
        return null;
      }
}
