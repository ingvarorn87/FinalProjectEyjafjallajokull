/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.GUI.Controller;

import examproject2017.GUI.Model.VolunteerModel;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ingvar
 */
public class VolunteerEditWindowController implements Initializable {

    @FXML
    private Button btnAddimg;
    @FXML
    private Button btnCloseVEW;
    @FXML
    private TextField setVolName;
    @FXML
    private TextField setVolAddress;
    @FXML
    private TextField SetVolEmail;
    @FXML
    private TextField SetVolPhoneNumber;
    @FXML
    private TextField setVolInfo;
    @FXML
    private Button btnAddNewVolunteer;
    
    public VolunteerModel volunteerModel = new VolunteerModel();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnAddimg(ActionEvent event) {
        //Uses a filechooser to open dialog to load saved files 
        FileChooser fileChooser = new FileChooser();
        Stage primaryStage = (Stage) btnAddimg.getScene().getWindow();
        //Sets extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(" files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        //fileChooser.setInitialDirectory(new File());
        //Shows save file dialog
        File file = fileChooser.showOpenDialog(primaryStage);
        try (BufferedWriter bw
                = new BufferedWriter(
                        new FileWriter(file.getAbsoluteFile()))) {
            bw.write("Here we need to print the appropiate info");
        } catch (IOException ex) {
            //
        }
    }

    @FXML
    private void closeVolunteerEditWindow(ActionEvent event) throws IOException {
        close();
    }


    @FXML
    private void clickToAddNewVolunteer(ActionEvent event) throws IOException {
        
        volunteerModel.addVolunteer(
                
                setVolName.getText(),
                SetVolPhoneNumber.getText(),
                setVolAddress.getText(),
                null,
                SetVolEmail.getText(),
                setVolInfo.getText());
        close();
        
    }
    
    private void close() throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/examproject2017/GUI/View/AdminWindow.fxml"));
                Parent root = loader.load();
                AdminWindowController gotoAdminWindowController = (AdminWindowController) loader.getController();

                Stage subStage = new Stage();
                subStage.setScene(new Scene(root));


                subStage.show();
                Stage stage = (Stage) btnCloseVEW.getScene().getWindow();
                stage.close();
    }
    
    
}
