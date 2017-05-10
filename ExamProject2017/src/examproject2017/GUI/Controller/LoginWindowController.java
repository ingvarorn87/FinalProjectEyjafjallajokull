/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.GUI.Controller;

import examproject2017.BE.Admin;
import examproject2017.BE.Person;
import examproject2017.BE.Volunteer;
import examproject2017.GUI.Model.LoginModel;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

    private Volunteer volunteer;

    private LoginModel loginModel = new LoginModel();
    @FXML
    private Label lblWrong;

    private static final int NOT_LOGGED_IN = 1;
    private static final int LOGGED_IN_VOLUNTEER = 2;
    private static final int LOGGED_IN_ADMIN = 3;
    private static final int WRONG_PASSWORD = 4;

    private int loginState = NOT_LOGGED_IN;
    private Person person = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
      {
        txtPass.setVisible(false);
        lblWrong.setVisible(false);
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
        //volunteer = loginModel.LoginChecker(txtName.getText().trim());

        if (person == null)
          {
            person = loginModel.LoginChecker(txtName.getText().trim(), txtPass.getText().trim());
          }
        if (loginState != LOGGED_IN_VOLUNTEER && person != null)
          {
            if (person.getClass() == Volunteer.class)
              {
                System.out.println(person.getName());
                volunteerWindowLoader();
                loginState = LOGGED_IN_VOLUNTEER;
                activeState();
              } else if (person.getClass() == Admin.class)
              {
                activeState();
                adminWindowLoader();
                
              }
          } else if (loginState != LOGGED_IN_VOLUNTEER && person == null)
          {
            loginState = WRONG_PASSWORD;
            activeState();
          } else if (loginState == LOGGED_IN_VOLUNTEER)
          {

          }

        //volunteerWindowLoader();
        //System.out.println(volunteer.getName());
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
        vController.populateFields((Volunteer) person);
//        vController.populateTables(selectedHours);

        Stage subStage = new Stage();
        subStage.setScene(new Scene(root));

        subStage.show();
        Stage stage = (Stage) btnLogin.getScene().getWindow();
        stage.close();
      }

    public void activeState()
      {
        switch (loginState)
          {
            case NOT_LOGGED_IN:
                break;

            case LOGGED_IN_VOLUNTEER:
                
                break;

            case LOGGED_IN_ADMIN:
                txtPass.setVisible(true);
                break;

            case WRONG_PASSWORD:
                lblWrong.setVisible(true);
                break;

          }
      }

}
