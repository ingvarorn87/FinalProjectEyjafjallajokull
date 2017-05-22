/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.GUI.View;

import examproject2017.GUI.Model.AdminModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Ingvar
 */
public class AddAdminWindowController implements Initializable {

    @FXML
    private TextField txtAdminName;
    @FXML
    private TextField txtAdminAddress;
    @FXML
    private TextField txtAdminPhone;
    @FXML
    private TextField txtAdminEmail;
    @FXML
    private TextField txtAdminPass;
    @FXML
    private Button btnAddAdmin;
    @FXML
    private Button btnCloseAddAdmin;
    
    public AdminModel adminModel = new AdminModel();
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickToAddNewAdmin(ActionEvent event) {
        adminModel.addAdmin(
                txtAdminName.getText(),
                txtAdminPhone.getText(),
                txtAdminAddress.getText(),
                txtAdminEmail.getText(),
                txtAdminPass.getText());
    }

    @FXML
    private void closeAddAdminWindow(ActionEvent event) {
    }
    
}
