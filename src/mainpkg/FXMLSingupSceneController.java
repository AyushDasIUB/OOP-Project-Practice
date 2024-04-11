
package mainpkg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dasay
 */
public class FXMLSingupSceneController implements Initializable {

    @FXML
    private TextField idTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private PasswordField confirmPasswordTextField;
    @FXML
    private ComboBox<String> userCategoryComboBox;

    /**
     * Initializes the controller class.
     */
    ArrayList<User> userList;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userList = new ArrayList<User>();
        
        userCategoryComboBox.getItems().addAll("Diagnostic Representative",
                                                "Scribe",
                                                "Patient",
                                                "Doctor",
                                                "Nurse",
                                                "Interpreter",
                                                "Pharmaceutical Representative",
                                                "Delivery Guy"
        );
        
        
    }    

    @FXML
    private void registerButtonOnAction(ActionEvent event) throws IOException {
        
        if((passwordTextField.getText().equals(confirmPasswordTextField.getText()))||(confirmPasswordTextField.getText().equals(passwordTextField.getText()))){
        


                userList.add(
                        new User(
                                nameTextField.getText(),
                                Integer.parseInt(idTextField.getText()),
                                userCategoryComboBox.getValue(),
                                passwordTextField.getText()


                        )

                );


                    FileWriter fw=null;
                    try {
                        //write code to dump studArr in Stud.txt
                        //use FileWriter
                        File f = new File("registerText.txt");

                        //FileWriter fw = new FileWriter(f);
                        if(f.exists())
                            //fw = new FileWriter("studText.txt",true);
                            fw = new FileWriter(f,true);
                        else 
                            //fw = new FileWriter(f);
                            fw = new FileWriter("registerText.txt"); 
                        String str="";
                        for(User s: userList){
                            str += s.getId()+","+s.getPassword()+","+s.getCategory()+","+s.getName()+"\n";
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


                    userList.clear();
                    
                    Parent mainSceneParent = FXMLLoader.load(getClass().getResource("FXMLLoginScene.fxml"));
        
                    Scene scene = new Scene(mainSceneParent);
        
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(scene);
                    window.show();
                    
                    
        }else{
            Alert a = new Alert(AlertType.WARNING);
            a.setContentText("Oops! Passwords are not matching.");
            a.showAndWait();
            return;
        }

            }
    
}
