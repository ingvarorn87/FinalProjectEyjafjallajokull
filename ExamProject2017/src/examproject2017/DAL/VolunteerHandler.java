/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author gudla
 */
public class VolunteerHandler
{

    SQLConnectionHandler conManager;

    public VolunteerHandler()
      {
        conManager = new SQLConnectionHandler();
      }

    public ArrayList<String> getVolName()
      {
        try (Connection con = conManager.getConnection())
          {
            String query = "SELECT * FROM [Volunteers]";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<String> volunteers = new ArrayList<>();
            while (rs.next())
              {
                String volString = "";
                volString += rs.getString("Name");

                volunteers.add(volString);
              }
            return volunteers;
          } catch (SQLException sqle)
          {
            System.err.println(sqle);
            return null;
          }
      }

    public ArrayList<String> getHours()
      {
        try (Connection con = conManager.getConnection())
          {
            String query = "SELECT * FROM [Volunteers]";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<String> volunteers = new ArrayList<>();
            while (rs.next())
              {
                String volString = "";
                volString += rs.getString("Hours");

                volunteers.add(volString);
              }
            return volunteers;
          } catch (SQLException sqle)
          {
            System.err.println(sqle);
            return null;
          }
      }

    public ArrayList<String> getVolEmail()
      {
        try (Connection con = conManager.getConnection())
          {
            String query = "SELECT * FROM [Volunteers]";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<String> volunteers = new ArrayList<>();
            while (rs.next())
              {
                String volString = "";
                volString += rs.getString("Email");

                volunteers.add(volString);
              }
            return volunteers;
          } catch (SQLException sqle)
          {
            System.err.println(sqle);
            return null;
          }
      }

    public ArrayList<String> getVolAddress()
      {
        try (Connection con = conManager.getConnection())
          {
            String query = "SELECT * FROM [Volunteers]";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<String> volunteers = new ArrayList<>();
            while (rs.next())
              {
                String volString = "";
                volString += rs.getString("Address");

                volunteers.add(volString);
              }
            return volunteers;
          } catch (SQLException sqle)
          {
            System.err.println(sqle);
            return null;
          }
      }

    public ArrayList<String> getVolID()
      {
        try (Connection con = conManager.getConnection())
          {
            String query = "SELECT * FROM [Volunteers]";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ArrayList<String> volunteers = new ArrayList<>();
            while (rs.next())
              {
                String volString = "";
                volString += rs.getString("ID");

                volunteers.add(volString);
              }
            return volunteers;
          } catch (SQLException sqle)
          {
            System.err.println(sqle);
            return null;
          }
      }

}
