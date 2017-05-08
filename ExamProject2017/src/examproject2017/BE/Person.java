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
public abstract class Person
{
    private String name;
    private String email;
    private int id;
    private String phone;
    private String address;

    public Person(String name, String email, int id, String phone, String address)
      {
        this.name = name;
        this.email = email;
        this.id = id;
        this.phone = phone;
        this.address = address;
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
    
    
}
