/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.BE;

import java.awt.image.BufferedImage;

/**
 *
 * @author gudla
 */
public class Volunteer extends Person
{
    
    private String info;
    private BufferedImage volunteerImage;
    
    
    public Volunteer(int id, String name, String email, String address, String phone, String info, BufferedImage img)
      {
        super(name, email, id, phone, address);

        this.info = info;
        

      }

    public String getInfo()
      {
        return info;
      }

    public void setInfo(String info)
      {
        this.info = info;
      }
    public BufferedImage getVolunteerImage()
      {
        return volunteerImage;
      }

    public void setVolunteerImage(BufferedImage studentImage)
      {
        this.volunteerImage = studentImage;
    
      }

    
}
