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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author gudla
 */
public class LoginWindowController implements Initializable
{

    @FXML
    private Button btnAdminLogin;
    @FXML
    private TextField txtName;
    @FXML
    private PasswordField txtPass;
    @FXML
    private Button btnLogin;
    
    private Volunteer volunteer = null;
    
    
    
    private VolLoginModel volLoginModel = new VolLoginModel();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
      {
        txtPass.setVisible(false);
        // TODO
      }    

    @FXML
    private void adminLogin(ActionEvent event)
      {
        txtPass.setVisible(true);
      }

    @FXML
    private void login(ActionEvent event) throws IOException
      {
        //txtName.getText().trim();
        //volunteer = volLoginModel.getVolName(txtName.getText().trim());
        
       volunteerWindowLoader();
       
          System.out.println(volLoginModel.getVolName());
          //System.out.println(volLoginModel.getHours());
        
      }
    
    
    private void adminWindowLoader() throws IOException
      {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/examproject2017/GUI/View/AdminWindow.fxml"));
                Parent root = loader.load();
                AdminWindowController aController = (AdminWindowController) loader.getController();

                Stage subStage = new Stage();
                subStage.setScene(new Scene(root));


                subStage.show();
                Stage stage = (Stage) btnLogin.getScene().getWindow();
                stage.close();
      }
    
    private void volunteerWindowLoader() throws IOException
      {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/examproject2017/GUI/View/SelectedVolunteerWindow.fxml"));
                Parent root = loader.load();
                SelectedVolunteerWindowController vController = (SelectedVolunteerWindowController) loader.getController();
                

                Stage subStage = new Stage();
                subStage.setScene(new Scene(root));


                subStage.show();
                Stage stage = (Stage) btnLogin.getScene().getWindow();
                stage.close();
      }
    
}
