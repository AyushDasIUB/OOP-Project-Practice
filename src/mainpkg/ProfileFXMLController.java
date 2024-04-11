/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author dasay
 */
public class ProfileFXMLController implements Initializable {

    @FXML
    private AnchorPane profileAnchorePane;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField idTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField genderTextField;
    @FXML
    private TextField phoneNumberTextField;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private DatePicker dobDatePicker;

    /**
     * Initializes the controller class.
     */
    
    ArrayList<Nurse> nurseInfoList;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nurseInfoList = new ArrayList<Nurse>();     
        
    }    

    @FXML
    private void saveButtonOnAction(ActionEvent event) {
        if(emailTextField.getText().isEmpty() || 
           genderTextField.getText().isEmpty() || 
           phoneNumberTextField.getText().isEmpty() || 
           dobDatePicker.getValue() == null || 
           nameTextField.getText().isEmpty() || 
           idTextField.getText().isEmpty() || 
           passwordPasswordField.getText().isEmpty()) {

           
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("Some fields are empty. Please fill in all fields.");
            alert.showAndWait();
            return; 
        }
        else{

            nurseInfoList.add(
                    new Nurse(
                            emailTextField.getText(),
                            genderTextField.getText(),
                            Integer.parseInt(phoneNumberTextField.getText()),
                            dobDatePicker.getValue().format(DateTimeFormatter.ISO_DATE),
                            nameTextField.getText(),
                            Integer.parseInt(idTextField.getText()),
                            "Nurse",
                            passwordPasswordField.getText()


                    )

            );
            
        

            FileWriter fw=null;
            try {
                //write code to dump studArr in Stud.txt
                //use FileWriter
                File f = new File("nurseInfoText.txt");
                 
                //FileWriter fw = new FileWriter(f);
                if(f.exists())
                    //fw = new FileWriter("studText.txt",true);
                    fw = new FileWriter(f,true);
                else 
                    //fw = new FileWriter(f);
                    fw = new FileWriter("nurseInfoText.txt"); 
                String str="";
                for(Nurse s: nurseInfoList){
                    str += s.getId()+","+s.getPassword()+","+s.getCategory()+","+s.getName()+","+s.getEmail()+","+s.getGender()+","+s.getDob()+","+s.getPhoneNumber()+"\n";
                    //str += s; 
                    //if toString is overridden to return
                    //return id+","+name+","+cgpa+"\n"
                }
                fw.write(str);  //fw.write(s.toString());
                fw.close();
            } catch (IOException ex) {
                //fw.close();
                //SHOW ex.toString() IN AN ALERT
            }        

            nurseInfoList.clear();
        }
        

            
    
        
        
        
         

        
        
    }
    
}
