/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.GUI.Model;

import examproject2017.BE.Admin;
import examproject2017.BLL.AdminManager;

/**
 *
 * @author Ingvar
 */
public class AdminModel {
    
    public AdminManager adminManager = new AdminManager();
    
    
    public void addAdmin(String name, String phoneNumber, String address, String email, String password)
    {
        adminManager.addAdmin(name, phoneNumber, address, email, password);
    }
    
    public boolean isAdmin()
      {
        return adminManager.isIsAdmin();
      }
    
    public void setIsAdminToTrue()
    {
      adminManager.setIsAdmin(true);
      
    }
    public void setIsAdminToFalse()
      {
        adminManager.setIsAdmin(false);
      }
    
}
