/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dasay
 */
public class FXMLLoginSceneController implements Initializable {

    @FXML
    private TextField idTextField;
    @FXML
    private PasswordField passwordTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginButtonOnAction(ActionEvent event) throws IOException {
                //use BufferedReader OR Scanner
        File file = new File("registerText.txt");
        Scanner sc; String str=null;
        try {
            sc = new Scanner(file);
            //outputTxtArea.setText(null);
            while(sc.hasNextLine()){
                str=sc.nextLine();
                String[] tokens;
                tokens = str.split(",");
                //str = "Id="+tokens[0]+", Name="+tokens[1]
                //        +", Cgpa="+tokens[2];
                //outputTxtArea.appendText(str+"\n");
                //outputTxtArea.appendText("\n");
                
                if((idTextField.getText().equals(tokens[0]))&&(passwordTextField.getText().equals(tokens[1]))){
                    System.out.println("Hello "+tokens[2]+" "+tokens[3]);
                    
                    if("Nurse".equals(tokens[2])){
//                            Parent mainSceneParent = FXMLLoader.load(getClass().getResource("FXMLMainScene.fxml"));
//        
//                            Scene scene = new Scene(mainSceneParent);
//
//                            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//                            window.setScene(scene);
//                            window.show();
                            
                            
                            
                                    FXMLLoader loader = new FXMLLoader();
                                    loader.setLocation(getClass().getResource("FXMLMainScene.fxml"));
                                    Parent personViewParent = loader.load();

                                    //Parent personViewParent = FXMLLoader.load(getClass().getResource("FXMLScene2.fxml"));
                                    Scene personViewScene = new Scene(personViewParent);

                                    //access the controller
                                    FXMLMainSceneController controller = loader.getController();
                                    //PersonViewSceneController controller = new PersonViewSceneController();
                                    //Person rahim = new Person();
                                    //controller.initData(rahim);
//                                    controller.initData(tableView.getSelectionModel().getSelectedItem());
                                      


                                    controller.initData(tokens[3]);

                                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                                    window.setScene(personViewScene);
                                    window.show();
                            
                            
                            
                            
                            
                            
                            
                    }
                    if("Interpreter".equals(tokens[2])){
                            Parent mainSceneParent = FXMLLoader.load(getClass().getResource("FXMLInterpreterMainScene.fxml"));
        
                            Scene scene = new Scene(mainSceneParent);

                            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                            window.setScene(scene);
                            window.show();
                    }
                
                
                }
                
                
                
                
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLLoginSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }

    @FXML
    private void singupLableOnMouseClick(MouseEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("FXMLSingupScene.fxml"));
        
        Scene scene = new Scene(mainSceneParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
}
