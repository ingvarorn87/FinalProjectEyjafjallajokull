/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.GUI.Controller;

import examproject2017.BE.Guild;
import examproject2017.BE.Hour;
import examproject2017.BE.Volunteer;
import examproject2017.DAL.GuildHandler;
import examproject2017.GUI.Model.GuildModel;
import examproject2017.GUI.Model.HourModel;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableView<Hour> tblSeeHours;
    @FXML
    private TableColumn<?, ?> clmGuild;
    @FXML
    private TableColumn<Hour, String> clmHours;
    @FXML
    private TextArea txtInformationInput;
    @FXML
    private ComboBox<Guild> CBselectGuild;

    public GuildModel guildModel = new GuildModel();
    public HourModel hourModel = new HourModel();

    ObservableList<Guild> observableGuilds
            = FXCollections.observableArrayList(guildModel.getAllGuilds()
            );

//    ObservableList<Hour> observableHour
//            = FXCollections.observableArrayList(hourModel.getHourFromGuildidAndVol(guildId, volId));
    @FXML
    private Label lblInformation;
    @FXML
    private TextField txtAddHours;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
      {
        // TODO
        //lblName.setText(volunteer.getName());

        addTexListener();
        CBselectGuild.setItems(observableGuilds);

//        tblSeeHours.setItems(observableHour);
//        clmHours.setCellValueFactory(
//                new PropertyValueFactory(getHours));
        txtInformationInput.setVisible(false);
        lblInformation.setVisible(false);
        

      }

    @FXML
    private void closeSelectedVolunteerWindow(ActionEvent event) throws IOException
      {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/examproject2017/GUI/View/LoginWindow.fxml"));
        Parent root = loader.load();
        LoginWindowController gotoLoginWindowController = (LoginWindowController) loader.getController();

        Stage subStage = new Stage();
        subStage.setScene(new Scene(root));

        subStage.show();
        Stage stage = (Stage) btnCloseSVW.getScene().getWindow();
        stage.close();
      }

    public void populateFields(Volunteer selectedVolunteer) //puts the right information into the lables
      {
        lblName.setText(selectedVolunteer.getName());
        lblName.wrapTextProperty().set(true); // sets the label to move to next line if line is full
        lblAddress.setText(selectedVolunteer.getAddress());
        lblAddress.wrapTextProperty().set(true); // sets the label to move to next line if line is full
        lblEmail.setText(selectedVolunteer.getEmail());
        lblEmail.wrapTextProperty().set(true); // sets the label to move to next line if line is full
        lblID.setText(Integer.toString(selectedVolunteer.getId()));
        lblPhone.setText(selectedVolunteer.getPhone());
        txtInformationInput.setText(selectedVolunteer.getInfo());
        addListener();

      }

    public void addListener()
      {
        tblSeeHours.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Hour>()
        {
            @Override
            public void changed(ObservableValue<? extends Hour> observable,
                    Hour oldValue, Hour newValue)
              {

                System.out.println("LISTENER CHANGING");
              }
        });
      }

    public void addTexListener()
      {
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
}
