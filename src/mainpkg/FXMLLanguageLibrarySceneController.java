/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dasay
 */
public class FXMLLanguageLibrarySceneController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void book1OpenOnAction(ActionEvent event) throws IOException {
        Parent fileChooserView = FXMLLoader.load(getClass().getResource("FXMLBook-1.fxml"));
        
        Scene fileChooserView2 = new Scene(fileChooserView);
        
        Stage newWindow = new Stage();
        
        newWindow.setScene(fileChooserView2);
        newWindow.show();
    }

    @FXML
    private void book2OpenOnAction(ActionEvent event) throws IOException {
        Parent fileChooserView = FXMLLoader.load(getClass().getResource("FXMLBook-2.fxml"));
        
        Scene fileChooserView2 = new Scene(fileChooserView);
        
        Stage newWindow = new Stage();
        
        newWindow.setScene(fileChooserView2);
        newWindow.show();
    }

    @FXML
    private void Book3OpenOnAction(ActionEvent event) throws IOException {
        Parent fileChooserView = FXMLLoader.load(getClass().getResource("FXMLBook-3.fxml"));
        
        Scene fileChooserView2 = new Scene(fileChooserView);
        
        Stage newWindow = new Stage();
        
        newWindow.setScene(fileChooserView2);
        newWindow.show();
    }
    
}
