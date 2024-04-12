/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author dasay
 */
public class FXMLMainSceneController implements Initializable {

    
    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private AnchorPane welcomeAnchorePane;
    @FXML
    private Label nurseNameInWelcomePage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mainBorderPane.setCenter(welcomeAnchorePane);
        
    }    

    @FXML
    private void profileButtonOnAction(ActionEvent event) {
        loadPage("FXMLNurseProfileScene");
        
    }

    @FXML
    private void findPatientsOnAction(ActionEvent event) {
        loadPage("FXMLNurseFindPatientScene");
    }

    @FXML
    private void schedulesButtonOnAction(ActionEvent event) {
        loadPage("FXMLNurseSchedulesScene");
    }

    @FXML
    private void assignedPatientButtonOnAction(ActionEvent event) {
        loadPage("FXMLNurseAssignedPatientsScene");
    }

    @FXML
    private void trainingButtonOnAction(ActionEvent event) {
        loadPage("FXMLNurseTraining&CertificationsScene");
    }

    @FXML
    private void exitButtonOnAction(ActionEvent event) {
        System.exit(0);
    }
    
    private void loadPage(String page){
        Parent root = null;
        try{
          root = FXMLLoader.load(getClass().getResource(page+".fxml"));
        }catch(IOException ex){
              Logger.getLogger(FXMLMainSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        mainBorderPane.setCenter(root);      
    }

    void initData(String token) {
        nurseNameInWelcomePage.setText(token);
    }

 
    
}
