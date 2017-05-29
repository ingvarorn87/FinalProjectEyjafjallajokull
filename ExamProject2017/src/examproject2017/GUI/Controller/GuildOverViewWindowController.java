/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.GUI.Controller;

import examproject2017.BE.Guild;
import examproject2017.BE.GuildVolHours;
import examproject2017.GUI.Model.GuildModel;
import examproject2017.GUI.Model.GuildVolHoursModel;
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
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ingvar
 */
public class GuildOverViewWindowController implements Initializable
{

    @FXML
    private Button btnexportguild;
    @FXML
    private Insets x1;
    @FXML
    private Button btnaddguild;
    @FXML
    private TableColumn<GuildVolHours, String> clmGuild;
    @FXML
    private TableColumn<GuildVolHours, String> clmHours;
    @FXML
    private Button btnCloseGOW;
    @FXML
    private TableView<GuildVolHours> tblGuildOverview;
    
    private GuildVolHoursModel gvhModel = new GuildVolHoursModel();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
      {
        // TODO
        clmGuild.setCellValueFactory(new PropertyValueFactory<>("guildId"));
        clmHours.setCellValueFactory(new PropertyValueFactory<>("Hours"));
        tblGuildOverview.setItems(gvhModel.getObservableAllGuildHours());
      }

    @FXML
    private void btnexportguild(ActionEvent event)
      {
        //Uses a filechooser to save dialog to load saved files 
        FileChooser fileChooser = new FileChooser();
        Stage primaryStage = (Stage) btnexportguild.getScene().getWindow();
        //Sets extension filter        
	FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(" file (*.xls)", "*.xls");
        fileChooser.getExtensionFilters().add(extFilter);        
	File file = fileChooser.showSaveDialog(primaryStage);
        try (BufferedWriter bw
               = new BufferedWriter(
               new FileWriter(file.getAbsoluteFile()))) {
            bw.write("");
        } catch (IOException ex) {
            //
        }

      }

    @FXML
    private void addGuildWindowLoader(ActionEvent event) throws IOException
      {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/examproject2017/GUI/View/AddGuildWindow.fxml"));
        Parent root = loader.load();
        AddGuildWindowController addguildController = (AddGuildWindowController) loader.getController();

        Stage subStage = new Stage();
        subStage.setScene(new Scene(root));

        subStage.show();
        Stage stage = (Stage) btnaddguild.getScene().getWindow();
        stage.close();
      }

    @FXML
    private void CloseAndGoBackToAdmin(ActionEvent event) throws IOException
      {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/examproject2017/GUI/View/AdminWindow.fxml"));
        Parent root = loader.load();
        AdminWindowController addAdminWindowController = (AdminWindowController) loader.getController();

        Stage subStage = new Stage();
        subStage.setScene(new Scene(root));

        subStage.show();
        Stage stage = (Stage) btnCloseGOW.getScene().getWindow();
        stage.close();
      }

}
