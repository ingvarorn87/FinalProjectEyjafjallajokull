/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.BE;

/**
 *
 * @author gudla
 */
public class Volunteer extends Person
{
    
    private String info;
    private int hours;
    
    
    public Volunteer(int id, String name, String email, String address, String phone, int hours, String info)
      {
        super(name, email, id, phone, address);

        this.hours = hours;
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

    public int getHours()
      {
        return hours;
      }

    public void setHours(int hours)
      {
        this.hours = hours;
      }

    

    
}
