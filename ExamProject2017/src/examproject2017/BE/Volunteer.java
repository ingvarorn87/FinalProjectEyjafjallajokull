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
public class Volunteer
{
    private String name;
    private String email;
    private int id;
    private String info;
    private String phone;
    private String address;
    private int hours;
    
    

   

    public Volunteer(int idVol, String nameVol, String emailVol, String addressVol, String phoneVol, int hoursVol, String infoVol)
      {
        this.id = idVol;
        this.name = nameVol;
        this.email = emailVol;
        this.address = addressVol;
        this.phone = phoneVol;
        this.hours = hoursVol;
        this.info = infoVol;
        

      }

    public String getName()
      {
        return name;
      }

    public void setName(String name)
      {
        this.name = name;
      }

    public String getEmail()
      {
        return email;
      }

    public void setEmail(String email)
      {
        this.email = email;
      }

    public int getId()
      {
        return id;
      }

    public void setId(int id)
      {
        this.id = id;
      }

    public String getInfo()
      {
        return info;
      }

    public void setInfo(String info)
      {
        this.info = info;
      }

    public String getPhone()
      {
        return phone;
      }

    public void setPhone(String phone)
      {
        this.phone = phone;
      }

    public String getAddress()
      {
        return address;
      }

    public void setAddress(String address)
      {
        this.address = address;
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
