/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.GUI.Controller;

import examproject2017.BE.Guild;
import examproject2017.BE.GuildVolHours;
import examproject2017.BE.Volunteer;
import examproject2017.GUI.Model.AdminModel;
import examproject2017.GUI.Model.GuildModel;
import examproject2017.GUI.Model.GuildVolHoursModel;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gudla
 */
public class SelectedVolunteerWindowController implements Initializable
{

    @FXML
    private Button btnRegister;
    @FXML
    private Label lblName;
    @FXML
    private Label lblID;
    @FXML
    private Label lblEmail;
    @FXML
    private Label lblAddress;
    @FXML
    private Label lblPhone;
    @FXML
    private Button btnCloseSVW;
    @FXML
    private TableView<GuildVolHours> tblSeeHours;
    @FXML
    private TableColumn<GuildVolHours, String> clmGuild;
    @FXML
    private TableColumn<GuildVolHours, String> clmHours;

    @FXML
    private ComboBox<Guild> CBselectGuild;
    @FXML
    private Label lblInformation;
    @FXML
    private TextField txtAddHours;
    @FXML
    private ImageView imgImageHolder;

    public GuildModel guildModel = new GuildModel();
    public GuildVolHoursModel guildVolHoursModel = new GuildVolHoursModel();
    public AdminModel adminModel = new AdminModel();
    @FXML
    private Label lblInformationOutput;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
      {
        // TODO

        CBselectGuild.setItems(guildModel.observableGuilds);//populates the Combobox

        /**
         * Checks if an admin has logged in to the view through the admin
         * window. if true it should show the information of the selected
         * volunteer if false a volunteer has logged in and the view should not
         * show the information text field which is only for the admins.
         */
        if (adminModel.isAdmin() == false)
          {
            lblInformationOutput.setVisible(false);
            lblInformation.setVisible(false);
          } else if (adminModel.isAdmin() == true)
          {
            lblInformationOutput.setVisible(true);
            lblInformation.setVisible(true);
          }

        lblName.wrapTextProperty().set(true); // sets the label to move to next line if line is full
        lblAddress.wrapTextProperty().set(true); // sets the label to move to next line if line is full
        lblEmail.wrapTextProperty().set(true); // sets the label to move to next line if line is full
        lblInformationOutput.wrapTextProperty().set(true);// sets the label to move to next line if line is full

        clmHours.setCellValueFactory(new PropertyValueFactory<>("Hours"));
        clmGuild.setCellValueFactory(new PropertyValueFactory<>("GuildName"));
        tblSeeHours.setItems(guildVolHoursModel.getObservableHour());

        /**
         * Sets a change listener to the Volunteer Binds each label with the new
         * value from the new selected Volunteer Then populates the labels with
         * the right information based on the logged in volunteer
         */
        guildVolHoursModel.getSelectedVolunteer().addListener(new ChangeListener<Volunteer>()
        {
            @Override
            public void changed(ObservableValue<? extends Volunteer> observable, Volunteer oldValue, Volunteer newValue)
              {
                lblName.textProperty().bind(newValue.nameProperty());
                lblEmail.textProperty().bind(newValue.emailProperty());
                lblID.textProperty().bind(newValue.idProperty().asString());
                lblPhone.textProperty().bind(newValue.phoneProperty());
                lblAddress.textProperty().bind(newValue.addressProperty());
                lblInformationOutput.textProperty().bind(newValue.infoProperty());
                
                //Gets the image from the Volunteer in the BE as a buffered image.
                BufferedImage bf = newValue.getVolunteerImage();
                WritableImage wr = null;
                if (bf != null)
                  {
                      /**
                       * Reads the buffered Image as a Two-Dimensional Array of x and y 
                       * Sets each pixel according to the buffered image in the new variable wr as a Writable image
                       */
                              

                    wr = new WritableImage(bf.getWidth(), bf.getHeight());
                    PixelWriter pw = wr.getPixelWriter();
                    for (int x = 0; x < bf.getWidth(); x++)
                      {
                        for (int y = 0; y < bf.getHeight(); y++)
                          {
                            pw.setArgb(x, y, bf.getRGB(x, y));
                          }
                      }
                  }
                /**
                 * places the image in the imageview named imgImageHolder
                 */
                
                imgImageHolder.setImage(wr);
              }
        });

        /**
         * Adds a listener to the combobox Makes it possible to get the selected
         * item.
         */
        CBselectGuild.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>()
        {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
              {
                CBselectGuild.getSelectionModel().select(newValue.intValue());
                System.out.println(newValue.intValue());

              }
        });

        txtAddHours.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
              {
                try
                  {
                    if (newValue.matches("\\d*") && newValue.length() < 3)
                      {
                        int value = Integer.parseInt(newValue);
                      } else
                      {
                        txtAddHours.setText(oldValue);
                      }
                  } catch (NumberFormatException ex)
                  {
                    //do nothing
                  }
              }
        });

      }

    /**
     * Checks if a admin has logged in to the view through the admin window if
     * true it should close and go back to the admin view if false it should
     * close and go to the login view
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void closeSelectedVolunteerWindow(ActionEvent event) throws IOException
      {
        if (adminModel.isAdmin() == false)
          {
            goToLoginWindow();
          } else if (adminModel.isAdmin() == true)
          {
            goToAdminWindow();
          }

      }

    public void setSelectedVolunteer(Volunteer selectedVolunteer) //lets know which volunteer is selected
      {
        guildVolHoursModel.setSelectedVolunteer(selectedVolunteer);
      }

    /**
     * When the register button is pressed it calls the method addHours from the
     * guildVolHoursModel That method needs the GuildId, volId and hours The
     * hours are taken from the textfield the user puts in The Guildid comes
     * from the selected guild in the combo box. It uses the listener in the
     * initilize method. The VolId comes from the label that is bound to the
     * volId in the listener from the initialize method.
     *
     * @param event
     */
    @FXML
    private void registerHours(ActionEvent event) throws IOException
      {
        guildVolHoursModel.addHours(
                CBselectGuild.getSelectionModel().getSelectedItem().getId(),
                Integer.parseInt(lblID.getText()),
                Integer.parseInt(txtAddHours.getText())
        );
        txtAddHours.clear();
        closeSelectedVolunteerWindow(event);
      }

    private void goToLoginWindow() throws IOException
      {
        adminModel.setIsAdminToFalse();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/examproject2017/GUI/View/LoginWindow.fxml"));
        Parent root = loader.load();
        LoginWindowController gotoLoginWindowController = (LoginWindowController) loader.getController();

        Stage subStage = new Stage();
        subStage.setScene(new Scene(root));

        subStage.show();
        Stage stage = (Stage) btnCloseSVW.getScene().getWindow();
        stage.close();
      }

    private void goToAdminWindow() throws IOException
      {
        adminModel.setIsAdminToFalse();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/examproject2017/GUI/View/AdminWindow.fxml"));
        Parent root = loader.load();
        AdminWindowController aController = (AdminWindowController) loader.getController();

        Stage subStage = new Stage();
        subStage.setScene(new Scene(root));

        subStage.show();
        Stage stage = (Stage) btnCloseSVW.getScene().getWindow();
        stage.close();
      }

}
