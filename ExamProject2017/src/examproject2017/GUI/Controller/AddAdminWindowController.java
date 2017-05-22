/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.GUI.Controller;

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
    private TextField btnAdminName;
    @FXML
    private TextField btnAdminAddress;
    @FXML
    private TextField btnAdminPhone;
    @FXML
    private TextField btnAdminEmail;
    @FXML
    private TextField btnAdminPass;
    @FXML
    private Button btnAddAdmin;
    @FXML
    private Button btnCloseAddAdmin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickToAddNewAdmin(ActionEvent event) {
    }

    @FXML
    private void closeAddAdminWindow(ActionEvent event) {
    }
    
}
