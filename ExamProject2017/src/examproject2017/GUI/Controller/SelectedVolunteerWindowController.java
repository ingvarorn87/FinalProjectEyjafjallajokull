/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.GUI.Controller;


import examproject2017.BE.Volunteer;
import examproject2017.GUI.Model.VolLoginModel;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;

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
    private Label lblInfo;

    private Button btnCloseSVW;

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
      {
        // TODO
        //lblName.setText(volunteer.getName());
       
      }    

    @FXML
    private void closeSelectedVolunteerWindow(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/examproject2017/GUI/View/LoginWindow.fxml"));
                Parent root = loader.load();
                LoginWindowController gotoLoginWindowController = (LoginWindowController) loader.getController();

                Stage subStage = new Stage();
                subStage.setScene(new Scene(root));


                subStage.show();
                Stage stage = (Stage) btnCloseSVW.getScene().getWindow();
                stage.close();
    }
    
    public void populateFields (Volunteer selectedVolunteer)
      {
       lblName.setText(selectedVolunteer.getName());
       lblAddress.setText(selectedVolunteer.getAddress());
       lblEmail.setText(selectedVolunteer.getEmail());
       lblInfo.setText(selectedVolunteer.getInfo());
       lblID.setText(Integer.toString(selectedVolunteer.getId()));
       lblPhone.setText(selectedVolunteer.getPhone());
       
      }
    
}
