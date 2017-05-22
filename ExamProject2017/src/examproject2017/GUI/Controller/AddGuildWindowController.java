/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.GUI.Controller;

import examproject2017.GUI.Model.GuildModel;
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
public class AddGuildWindowController implements Initializable {

    @FXML
    private Button btnCloseAGW;
    @FXML
    private TextField setNewGuildName;
    @FXML
    private TextField SetNewGuildAdmin;
    @FXML
    private Button btnAddnewGuild;
    public GuildModel guildModel = new GuildModel();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void closeAddGuildWindow(ActionEvent event) throws IOException {
        close();
    }

    @FXML
    private void addNewGuildbyClick(ActionEvent event) throws IOException {
       

       
       guildModel.addGuild(
       setNewGuildName.getText(),
       Integer.parseInt(SetNewGuildAdmin.getText()));
       close();
      


               
        
    }
    
    private void close() throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/examproject2017/GUI/View/GuildOverViewWindow.fxml"));
                Parent root = loader.load();
                GuildOverViewWindowController goToGuildoverview = (GuildOverViewWindowController) loader.getController();

                Stage subStage = new Stage();
                subStage.setScene(new Scene(root));


                subStage.show();
                Stage stage = (Stage) btnCloseAGW.getScene().getWindow();
                stage.close();
    }
}
