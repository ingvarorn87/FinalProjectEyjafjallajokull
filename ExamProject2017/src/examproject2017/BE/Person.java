/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.BE;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author gudla
 */
public abstract class Person
{

    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty email = new SimpleStringProperty();
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty phone = new SimpleStringProperty();
    private final StringProperty address = new SimpleStringProperty();



    public Person(String name, String email, int id, String phone, String address)
      {
        this.name.set(name);
        this.email.set(email);
        this.id.set(id);
        this.phone.set(phone);
        this.address.set(address);
      }

    public String getName()
      {
        return name.get();
      }

    public void setName(String value)
      {
        name.set(value);
      }

    public StringProperty nameProperty()
      {
        return name;
      }

    public String getEmail()
      {
        return email.get();
      }

    public void setEmail(String value)
      {
        email.set(value);
      }

    public StringProperty emailProperty()
      {
        return email;
      }

    public int getId()
      {
        return id.get();
      }

    public void setId(int value)
      {
        id.set(value);
      }

    public IntegerProperty idProperty()
      {
        return id;
      }

    public String getPhone()
      {
        return phone.get();
      }

    public void setPhone(String value)
      {
        phone.set(value);
      }

    public StringProperty phoneProperty()
      {
        return phone;
      }

    
    public String getAddress()
      {
        return address.get();
      }

    public void setAddress(String value)
      {
        address.set(value);
      }

    public StringProperty addressProperty()
      {
        return address;
      }

}
