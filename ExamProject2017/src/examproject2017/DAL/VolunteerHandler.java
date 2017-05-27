/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.DAL;

import examproject2017.BE.Volunteer;
import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

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

    public List<Volunteer> getAllVolunteers()
      {
        try (Connection con = conManager.getConnection())
          {
            String query = "SELECT *\n"
                    + "FROM [Volunteers]\n"
                    + "ORDER BY Volunteers.Name";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<Volunteer> volu = new ArrayList<>();
            while (rs.next())
              {

                int id = rs.getInt("Volid");
                String name = rs.getString("Name");
                String email = rs.getString("Email");

                String address = rs.getString("Address");
                String phone = rs.getString("PhoneNumber");
                String info = rs.getString("Information");

                byte[] bytes = rs.getBytes("image");
                BufferedImage newImage;
                if (bytes != null)
                  {
                    try
                      {
                        ByteArrayInputStream bais;
                        bais = new ByteArrayInputStream(bytes);

                        newImage = ImageIO.read(bais);
                      } catch (IOException ex)
                      {
                        Logger.getLogger(VolunteerHandler.class.getName()).log(Level.SEVERE, null, ex);
                        newImage = null;
                      }
                  } else
                  {
                    newImage = null;
                  }
                volu.add(new Volunteer(id, name, email, address, phone, info, newImage));
              }
            return volu;
          } catch (SQLException sqle)
          {
            System.err.println(sqle);
            return null;
          }
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

    public ArrayList<String> getVolId()
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
                volString += rs.getString("Volid");

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

    public Volunteer getVolunteerBasedOnName(String name)
      {
        try (Connection con = conManager.getConnection())
          {
            String query = "SELECT * FROM [Volunteers] WHERE name = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);

            return getVolunteerFromResults(pstmt);
          } catch (SQLException sqle)
          {
            System.err.println(sqle);
            return null;
          }
      }

    public Volunteer getVolunteerFromResults(PreparedStatement pstmt) throws SQLException
      {
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        int id = rs.getInt("Volid");
        String name = rs.getString("Name");
        String email = rs.getString("Email");

        String address = rs.getString("Address");
        String phone = rs.getString("PhoneNumber");
        String info = rs.getString("Information");

        byte[] bytes = rs.getBytes("image");
        BufferedImage newImage;
        if (bytes != null)
          {
            try
              {
                ByteArrayInputStream bais;
                bais = new ByteArrayInputStream(bytes);

                newImage = ImageIO.read(bais);
              } catch (IOException ex)
              {
                Logger.getLogger(VolunteerHandler.class.getName()).log(Level.SEVERE, null, ex);
                newImage = null;
              }
          } else
          {
            newImage = null;
          }
        Volunteer volunteer = new Volunteer(id, name, email, address, phone, info, newImage);
        return volunteer;
      }

    public void addVolunteer(String name, String phoneNumber, String address, File file, String email, String information)
      {
        try (Connection con = conManager.getConnection())
          {
            String sqlCommand = "INSERT INTO Volunteers(Name,PhoneNumber,Address,Image,Email,Information) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement pstat = con.prepareStatement(sqlCommand);

            pstat.setString(1, name);
            pstat.setString(2, phoneNumber);
            pstat.setString(3, address);
            pstat.setBytes(4, getAImageAsBytes(file));
            pstat.setString(5, email);
            pstat.setString(6, information);

            pstat.executeUpdate();
          } catch (SQLException sqle)
          {
            System.err.println(sqle);
          }
      }

    public static BufferedImage createRGBImage(byte[] bytes, int width, int height)
      {
        DataBufferByte buffer = new DataBufferByte(bytes, bytes.length);
        ColorModel cm = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB), new int[]
          {
            8, 8, 8
          }, false, false, Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
        return new BufferedImage(cm, Raster.createInterleavedRaster(buffer, (width - 1), (height - 1), (width - 1) * 3, 3, new int[]
          {
            0, 1, 2
          }, null), false, null);
      }

    public static byte[] getAImageAsBytes(File file)
      {
        try
          {

            BufferedImage originalImage
                    = ImageIO.read(file);

            ByteArrayOutputStream baos = new ByteArrayOutputStream(64000);
            ImageIO.write(originalImage, "jpg", baos);
            baos.flush();
            byte[] imageInByte = baos.toByteArray();
            baos.close();
            return imageInByte;

          } catch (IOException e)
          {
            System.out.println(e.getMessage());
          }
        return null;
      }
}
