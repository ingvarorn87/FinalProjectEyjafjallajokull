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
    private String hours;
    
    

    public Volunteer(String name, String email, int id, String info, String phone, String address, String hours ) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.info = info;
        this.phone = phone;
        this.address = address;
        this.hours = hours;
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

    public String getHours()
      {
        return hours;
      }

    public void setHours(String hours)
      {
        this.hours = hours;
      }

    
}
