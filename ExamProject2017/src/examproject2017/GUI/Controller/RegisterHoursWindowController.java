/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.GUI.Controller;

import examproject2017.BE.Guild;
import examproject2017.BE.Volunteer;
import examproject2017.GUI.Model.GuildModel;
import examproject2017.GUI.Model.GuildVolHoursModel;
import examproject2017.DAL.GuildVolHoursHandler;
import examproject2017.DAL.GuildHandler;
        
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ingvar
 */
public class RegisterHoursWindowController implements Initializable {

    @FXML
    private Button btnRegisterHours;
    @FXML
    private Button btnCloseRegisterhours;
    @FXML
    private TextField txtInputHours;
    @FXML
    private ComboBox<Guild> cbSelectGuild;
    @FXML
    private Label lblID;
    
    private Volunteer volunteer;
    //public GuildModel guildModel = new GuildModel();
    //public GuildVolHoursModel guildVolHoursModel = new GuildVolHoursModel();
    
    public GuildModel guildModel = new GuildModel();
    public GuildVolHoursModel guildVolHoursModel = new GuildVolHoursModel();
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         cbSelectGuild.setItems(guildModel.observableGuilds);//populates the Combobox
         


       

        
        /**
         * Sets a change listener to the Volunteer Binds each label with the new
         * value from the new selected Volunteer Then populates the labels with
         * the right information based on the logged in volunteer
         */
        guildVolHoursModel.getSelectedVolunteer().addListener(new ChangeListener<Volunteer>() {
            @Override
            public void changed(ObservableValue<? extends Volunteer> observable, Volunteer oldValue, Volunteer newValue) {
                
                lblID.textProperty().bind(newValue.idProperty().asString());

                
            }
        });

        /**
         * Adds a listener to the combobox Makes it possible to get the selected
         * item.
         */
        cbSelectGuild.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                cbSelectGuild.getSelectionModel().select(newValue.intValue());
                System.out.println(newValue.intValue());

            }
        });
        
    }    

    @FXML
    private void onClickRegisterHours(ActionEvent event) {
        
                guildVolHoursModel.addHours(
                cbSelectGuild.getSelectionModel().getSelectedItem().getId(),
                Integer.parseInt(lblID.getText()),
                Integer.parseInt(txtInputHours.getText())
        );
        txtInputHours.clear();
    }

    @FXML
    private void closeRegisterHoursWindow(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/examproject2017/GUI/View/SelectedVolunteerWindow.fxml"));
        Parent root = loader.load();
        SelectedVolunteerWindowController vController = (SelectedVolunteerWindowController) loader.getController();


        Stage subStage = new Stage();
        subStage.setScene(new Scene(root));
        
        subStage.show();
        Stage stage = (Stage) btnCloseRegisterhours.getScene().getWindow();
        stage.close();
    }
    
    public void setSelectedVolunteer(Volunteer selectedVolunteer) //lets know which volunteer is selected
    {
        guildVolHoursModel.setSelectedVolunteer(selectedVolunteer);
    }
    
    
}
