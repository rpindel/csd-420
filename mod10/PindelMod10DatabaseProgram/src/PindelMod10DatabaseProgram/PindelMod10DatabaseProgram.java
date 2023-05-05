/* Robin Pindel
 * Module 10 Programming Assignment
 * 5/4/2023
 * 
 * This program displays a UI accessing a local DB regarding user's and their 
 * favorite sports team.  The UI allows to view or update a record.
 */

package PindelMod10DatabaseProgram;

import javafx.application.Application;
import javafx.scene.*;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.shape.*;

public class PindelMod10DatabaseProgram extends Application {
    //Override the start method of the Application class
    @Override
    public void start(Stage primaryStage) {
        HBox hBox = new HBox(5);
        hBox.setPadding(new Insets(5));
        Scene scene = new Scene(hBox, 500, 500);    
    
        primaryStage.setTitle("Database UI");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //Main method since I am using VSCode
    public static void main(String[] args) {
        Application.launch(args);
    }
}
