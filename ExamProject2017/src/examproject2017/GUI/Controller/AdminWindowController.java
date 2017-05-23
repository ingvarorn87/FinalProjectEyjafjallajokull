/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.GUI.Controller;

import examproject2017.BE.GuildVolHours;
import examproject2017.BE.Volunteer;
import examproject2017.GUI.Model.GuildVolHoursModel;
import examproject2017.GUI.Model.VolunteerModel;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gudla
 */
public class AdminWindowController implements Initializable
{

    
    
    @FXML
    private Button btnViewGuild;
    @FXML
    private Button btnAddVolunteer;
    @FXML
    private Button btnCloseAW;
    public GuildVolHoursModel guildVolHoursModel = new GuildVolHoursModel();
    @FXML
    private Insets x1;
    @FXML
    private TableColumn<Volunteer, String> clmVolName;
    @FXML
    private TableColumn<GuildVolHours, String> clmGuildName;
    @FXML
    private TableColumn<GuildVolHours, String> clmHours;
    @FXML
    private TableView<Volunteer> tblAdminTable;
    
    public VolunteerModel volunteerModel = new VolunteerModel();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
      {
        // TODO
        
        
        volunteerModel.setObservableAllVolunteers();
        clmVolName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        tblAdminTable.setItems(volunteerModel.getObservableAllVolunteers());
        
      }    

    @FXML
    private void guildOverviewWindowLoader(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("/examproject2017/GUI/View/GuildOverViewWindow.fxml"));
                Parent root = loader.load();
                GuildOverViewWindowController guildoverController = (GuildOverViewWindowController) loader.getController();

                Stage subStage = new Stage();
                subStage.setScene(new Scene(root));


                subStage.show();
                Stage stage = (Stage) btnViewGuild.getScene().getWindow();
                stage.close();
    }

    @FXML
    private void addVolunteerWindowLoader(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/examproject2017/GUI/View/VolunteerEditWindow.fxml"));
                Parent root = loader.load();
                VolunteerEditWindowController volunController = (VolunteerEditWindowController) loader.getController();

                Stage subStage = new Stage();
                subStage.setScene(new Scene(root));


                subStage.show();
                Stage stage = (Stage) btnAddVolunteer.getScene().getWindow();
                stage.close();
    }

    @FXML
    private void closeAdminWindow(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/examproject2017/GUI/View/LoginWindow.fxml"));
                Parent root = loader.load();
                LoginWindowController goToLoginWindowController = (LoginWindowController) loader.getController();

                Stage subStage = new Stage();
                subStage.setScene(new Scene(root));


                subStage.show();
                Stage stage = (Stage) btnCloseAW.getScene().getWindow();
                stage.close();
    }
    
}
