/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.GUI.Controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ingvar
 */
public class SelectedGuildWindowController implements Initializable {

    @FXML
    private Button btnexport;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void exportsingleguild(ActionEvent event) {
        //Uses a filechooser to save dialog to load saved files 
        FileChooser fileChooser = new FileChooser();
        Stage primaryStage = (Stage) btnexport.getScene().getWindow();
        //Sets extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(" files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        //fileChooser.setInitialDirectory(new File());
        //Shows save file dialog
        File file = fileChooser.showSaveDialog(primaryStage);
    }
    
}
