/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.BE;

/**
 *
 * @author Ingvar
 */
public class Admin extends Person {
    
    private String password;
    

    
    public Admin(String name, String email, int id, String phone, String address) {
        
        super(name, email, id, phone, address);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
    
}
