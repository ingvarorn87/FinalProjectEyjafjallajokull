/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.GUI.Controller;

import examproject2017.GUI.Model.AdminModel;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    private void closeAddAdminWindow(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/examproject2017/GUI/View/AdminWindow.fxml"));
        Parent root = loader.load();
        AdminWindowController gotoAdminWindowController = (AdminWindowController) loader.getController();

        Stage subStage = new Stage();
        subStage.setScene(new Scene(root));

        subStage.show();
        Stage stage = (Stage) btnCloseAddAdmin.getScene().getWindow();
        stage.close();
    }
    
}
