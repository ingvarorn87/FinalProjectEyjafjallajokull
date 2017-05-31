/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.BLL;


import examproject2017.BE.Person;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gudla
 */
public class LoginManagerTest
{
    
    public LoginManagerTest()
      {
      }

    /**
     * Test of LoginChecker method, of class LoginManager.
     */
    @Test
    public void testVolLoginChecker()
      {
        System.out.println("LoginChecker");
        String name = "Bilbo";
        String password = "";
        LoginManager instance = new LoginManager(new MockVolLoginHandler(), new MockAdLoginHandler());
        
        Person result = instance.LoginChecker(name, password);
        assertNotNull(result);
      }
    
    @Test
    public void testAdLoginChecker()
      {
        System.out.println("LoginChecker");
        String name = "Per";
        String password = "1234";
        LoginManager instance = new LoginManager(new MockVolLoginHandler(), new MockAdLoginHandler());
        
        Person result = instance.LoginChecker(name, password);
        assertNotNull(result);
      }
    
    @Test
    public void testLoginChecker()
      {
        System.out.println("LoginChecker");
        String name = "";
        String password = "";
        LoginManager instance = new LoginManager(new MockVolLoginHandler(), new MockAdLoginHandler());
        
        Person result = instance.LoginChecker(name, password);
        assertNull(result);
      }
    
    @Test
    public void testLoginChecker2()
      {
        System.out.println("LoginChecker");
        String name = "per";
        String password = "1234";
        LoginManager instance = new LoginManager(new MockVolLoginHandler(), new MockAdLoginHandler());
        
        Person result = instance.LoginChecker(name, password);
        assertNull(result);
      }
    
    @Test
    public void testLoginChecker3()
      {
        System.out.println("LoginChecker");
        String name = "";
        String password = "1234";
        LoginManager instance = new LoginManager(new MockVolLoginHandler(), new MockAdLoginHandler());
        
        Person result = instance.LoginChecker(name, password);
        assertNull(result);
      }
    
   @Test
    public void testLoginChecker4()
      {
        System.out.println("LoginChecker");
        String name = "BILBO";
        String password = "";
        LoginManager instance = new LoginManager(new MockVolLoginHandler(), new MockAdLoginHandler());
        
        Person result = instance.LoginChecker(name, password);
        assertNull(result);
      }
    @Test
    public void testLoginChecker5()
      {
        System.out.println("LoginChecker");
        String name = "Per";
        String password = "12,3";
        LoginManager instance = new LoginManager(new MockVolLoginHandler(), new MockAdLoginHandler());
        
        Person result = instance.LoginChecker(name, password);
        assertNull(result);
      }
}
