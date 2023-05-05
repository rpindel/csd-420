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
import javafx.scene.control.*;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import java.sql.*;

import javax.swing.plaf.synth.SynthStyleFactory;

public class PindelMod10DatabaseProgram extends Application {
    private Statement stmt;
    private TextField userIDEntry = new TextField();
    private Label tableResults = new Label();

    //Override the start method of the Application class
    @Override
    public void start(Stage primaryStage) throws SQLException, ClassNotFoundException {
        initializeDB();
               
        Button displayButton = new Button("Display Record");
        Button updateButton = new Button("Update Record");
        HBox buttonHBox = new HBox(5);
        buttonHBox.setPadding(new Insets(5));
        buttonHBox.getChildren().addAll(new Label ("Please enter a 3-digit ID"), userIDEntry, displayButton, updateButton);
        
        VBox vBox = new VBox(5);
        vBox.setPadding(new Insets(5));
        vBox.getChildren().addAll(buttonHBox, tableResults);

        userIDEntry.setPrefColumnCount(3);
        displayButton.setOnAction(e -> displayFavoriteTeam());
        updateButton.setOnAction(e -> updateFavoriteTeam());
    
        Scene scene = new Scene(vBox, 450, 100);
        primaryStage.setTitle("Database UI");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initializeDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost/databasedb", "student1", "pass");
            System.out.println("Database connected");
            stmt = connection.createStatement();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        } 
    }

    private void displayFavoriteTeam() {
        String id = userIDEntry.getText();
        try {
            String queryString = "select favoriteteam from Fans " +
                "where id = '" + id + "'";
            System.out.println(queryString);
            
            ResultSet resultSet = stmt.executeQuery(queryString);

            if (resultSet.next()) {
                String favoriteTeam = resultSet.getString(1);
                tableResults.setText("The favorite team of ID: " + id + " is the " + favoriteTeam + ".");
            }
            else {
                tableResults.setText("ID not found.");
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void updateFavoriteTeam() {
        String id = userIDEntry.getText();
    }

    //Main method since I am using VSCode
    public static void main(String[] args) {
        Application.launch(args);
    }

}