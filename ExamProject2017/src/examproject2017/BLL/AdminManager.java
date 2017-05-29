/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.BLL;

import examproject2017.DAL.AdminHandler;

/**
 *
 * @author Ingvar
 */
public class AdminManager {
    
    private AdminHandler adminhandler = new AdminHandler();
    private static boolean isAdmin;

    public boolean isIsAdmin()
      {
        return isAdmin;
          
      }

    public void setIsAdmin(boolean isAdmin)
      {
        this.isAdmin = isAdmin;
      }
    
    public void addAdmin(String name, String phoneNumber, String address, String email, String password)
    {
        adminhandler.addAdmin(name, phoneNumber, address, email, password);
    }
    
}
