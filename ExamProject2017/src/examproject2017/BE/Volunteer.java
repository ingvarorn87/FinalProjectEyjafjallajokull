/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.BE;

import java.awt.image.BufferedImage;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author gudla
 */
public class Volunteer extends Person {

    private final StringProperty info = new SimpleStringProperty();

    private BufferedImage volunteerImage;

    public Volunteer(int id, String name, String email, String address, String phone, String info, BufferedImage img) {
        super(name, email, id, phone, address);
        this.volunteerImage = img;
        this.info.set(info);

    }

    public String getInfo() {
        return info.get();
    }

    public void setInfo(String value) {
        info.set(value);
    }

    public StringProperty infoProperty() {
        return info;
    }

    public BufferedImage getVolunteerImage() {
        return volunteerImage;
    }

    public void setVolunteerImage(BufferedImage volunteerImage) {
        this.volunteerImage = volunteerImage;

    }

}
