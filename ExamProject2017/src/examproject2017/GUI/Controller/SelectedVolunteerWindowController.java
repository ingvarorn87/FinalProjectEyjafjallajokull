/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examproject2017.GUI.Controller;

import examproject2017.BE.Guild;
import examproject2017.BE.GuildVolHours;
import examproject2017.BE.Volunteer;
import examproject2017.DAL.GuildHandler;
import examproject2017.GUI.Model.GuildModel;
import examproject2017.GUI.Model.GuildVolHoursModel;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gudla
 */
public class SelectedVolunteerWindowController implements Initializable
{

    @FXML
    private Button btnRegister;
    @FXML

    private Label lblName;

    @FXML
    private Label lblID;
    @FXML
    private Label lblEmail;
    @FXML
    private Label lblAddress;
    @FXML
    private Label lblPhone;

    @FXML
    private Button btnCloseSVW;
   

   
    @FXML
    private TableView<GuildVolHours> tblSeeHours;
    @FXML
    private TableColumn<GuildVolHours, String> clmGuild;
    @FXML
    private TableColumn<GuildVolHours, String> clmHours;
    @FXML
    private TextArea txtInformationInput;
    @FXML
    private ComboBox<Guild> CBselectGuild;

    public GuildModel guildModel = new GuildModel();
    public GuildVolHoursModel guildVolHoursModel = new GuildVolHoursModel();

    ObservableList<Guild> observableGuilds
            = FXCollections.observableArrayList(guildModel.getAllGuilds()
            );

    ObservableList<GuildVolHours> observableHour;
   
    @FXML
    private Label lblInformation;
    @FXML
    private TextField txtAddHours;
    @FXML
    private ImageView imgImageHolder;

    private Volunteer volunteer;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
      {
        // TODO
        
        CBselectGuild.setItems(observableGuilds);

        txtInformationInput.setVisible(true);
        lblInformation.setVisible(false);
        
        lblName.wrapTextProperty().set(true); // sets the label to move to next line if line is full
        lblAddress.wrapTextProperty().set(true); // sets the label to move to next line if line is full
        lblEmail.wrapTextProperty().set(true); // sets the label to move to next line if line is full
        
        clmHours.setCellValueFactory(new PropertyValueFactory<>("hours"));
        clmGuild.setCellValueFactory(new PropertyValueFactory<>("guildName"));
        tblSeeHours.setItems(guildVolHoursModel.getObservableHour());
        
        
        guildVolHoursModel.getSelectedVolunteer().addListener(new ChangeListener<Volunteer>() {
            @Override
            public void changed(ObservableValue<? extends Volunteer> observable, Volunteer oldValue, Volunteer newValue)
              {
                lblName.textProperty().bind(newValue.nameProperty());
                lblEmail.textProperty().bind(newValue.emailProperty());
                lblID.textProperty().bind(newValue.idProperty().asString());
                lblPhone.textProperty().bind(newValue.phoneProperty());
                lblAddress.textProperty().bind(newValue.addressProperty());
                txtInformationInput.textProperty().bind(newValue.infoProperty());
              }
        });
      }

    @FXML
    private void closeSelectedVolunteerWindow(ActionEvent event) throws IOException
      {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/examproject2017/GUI/View/LoginWindow.fxml"));
        Parent root = loader.load();
        LoginWindowController gotoLoginWindowController = (LoginWindowController) loader.getController();

        Stage subStage = new Stage();
        subStage.setScene(new Scene(root));

        subStage.show();
        Stage stage = (Stage) btnCloseSVW.getScene().getWindow();
        stage.close();
      }

    public void populateFields(Volunteer selectedVolunteer) //puts the right information into the lables
      {
        guildVolHoursModel.setSelectedVolunteer(selectedVolunteer);
        

        
      }

    public void altInitialize(Volunteer stud)
      {
       
        if (volunteer.getVolunteerImage() != null)
          {
            BufferedImage bf = stud.getVolunteerImage();
            WritableImage wr = null;
            if (bf != null)
              {
                wr = new WritableImage(bf.getWidth(), bf.getHeight());
                PixelWriter pw = wr.getPixelWriter();
                for (int x = 0; x < bf.getWidth(); x++)
                  {
                    for (int y = 0; y < bf.getHeight(); y++)
                      {
                        pw.setArgb(x, y, bf.getRGB(x, y));
                      }
                  }
              }
            imgImageHolder.setImage(wr);
          }
        else
          {
            Image defAvatar = new Image("file:DATA/defAvatar.png");

            imgImageHolder.setImage(defAvatar);
          }
      }
        
}
