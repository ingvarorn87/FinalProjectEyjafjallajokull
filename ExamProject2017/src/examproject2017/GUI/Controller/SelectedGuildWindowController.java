/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.GUI.Controller;


import examproject2017.BE.Volunteer;
import java.awt.image.BufferedImage;
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
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
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
    @FXML
    private Button btnCloseSGW;

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
         try (BufferedWriter bw
                = new BufferedWriter(
                        new FileWriter(file.getAbsoluteFile()))) {
            bw.write("Here we need to print the appropiate infi");
        } catch (IOException ex) {
            //
        }
    }

    @FXML
    private void closeSelectedGuildWindow(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/examproject2017/GUI/View/GuildOverViewWindow.fxml"));
                Parent root = loader.load();
                GuildOverViewWindowController gotoGuildOverViewWindowController = (GuildOverViewWindowController) loader.getController();

                Stage subStage = new Stage();
                subStage.setScene(new Scene(root));


                subStage.show();
                Stage stage = (Stage) btnCloseSGW.getScene().getWindow();
                stage.close();
    }
    
}
