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
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.sql.*;

public class PindelMod10DatabaseProgram extends Application {
    // Create all needed variables
    private Statement stmt;
    private TextField userIDEntryDisplay = new TextField();
    private TextField userIDEntryUpdate = new TextField();
    private TextField changeTeamTextField = new TextField(); 
    private Text tableResults1 = new Text("Available IDs are:");
    private Text tableResults2 = new Text("116, 151, and 390");
    private Label idLabel1 = new Label("Please enter a 3-digit ID: ");
    private Label idLabel2 = new Label("Please enter a 3-digit ID: ");
    private Label updateLabel = new Label("Please enter the new team value: ");

    //Override the start method of the Application class
    @Override
    public void start(Stage primaryStage) throws SQLException, ClassNotFoundException {
        initializeDB();
               
        Button displayButton = new Button("Display Record");
        Button updateButton = new Button("Update Record");
       
        // Create and populate VBox containers to hold UI controls
        VBox vBoxDisplay = new VBox(5);
        vBoxDisplay.setAlignment(Pos.TOP_CENTER);
        VBox vBoxUpdate = new VBox(5);
        vBoxUpdate.setAlignment(Pos.TOP_CENTER);
        vBoxDisplay.getChildren().addAll(idLabel1, userIDEntryDisplay, displayButton);
        vBoxUpdate.getChildren().addAll(idLabel2, userIDEntryUpdate, updateLabel, changeTeamTextField, updateButton);
        
        // Create and populate HBox container to UI control containers
        HBox buttonHBox = new HBox(5);
        buttonHBox.setPadding(new Insets(5));
        buttonHBox.setAlignment(Pos.CENTER);
        buttonHBox.getChildren().addAll(vBoxDisplay, vBoxUpdate);
        buttonHBox.setMargin(vBoxDisplay, new Insets(0, 10, 0, 0));
        buttonHBox.setMargin(vBoxUpdate, new Insets(0, 0, 0, 10));
        
        // Create and populate VBox container to server as main scene container
        VBox vBoxMain = new VBox(5);
        vBoxMain.setPadding(new Insets(5));
        vBoxMain.setAlignment(Pos.CENTER);
        vBoxMain.getChildren().addAll(tableResults1, tableResults2, buttonHBox);

        // Set values and actions for UI actions and display
        userIDEntryDisplay.setPrefColumnCount(3);
        userIDEntryUpdate.setPrefColumnCount(3);
        tableResults1.setStyle("-fx-font-weight: bold;");
        tableResults2.setStyle("-fx-font-weight: bold;");
        displayButton.setOnAction(e -> displayFavoriteTeam());
        updateButton.setOnAction(e -> updateFavoriteTeam());
    
        // Set and show the scene
        Scene scene = new Scene(vBoxMain, 400, 200);
        primaryStage.setTitle("Favorite team Database UI");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Create and load database connectiona and default statement object
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

    // Query DB for favorite team based on ID (primary key)
    private void displayFavoriteTeam() {
        String id = userIDEntryDisplay.getText();
        try {
            String displayValueQueryString = "select favoriteteam from Fans " +
                "where id = '" + id + "'";
            System.out.println(displayValueQueryString);
            
            ResultSet resultSet = stmt.executeQuery(displayValueQueryString);

            if (resultSet.next()) {
                String favoriteTeam = resultSet.getString(1);
                tableResults1.setText("The favorite team of ID " + id + " is the " + favoriteTeam + ".");
                tableResults2.setText(null);
            }
            else {
                tableResults1.setText("ID not found.  Please review entered value.");
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Update DB for favorite team based on ID (primary key)
    private void updateFavoriteTeam() {
        String id = userIDEntryUpdate.getText();
        String team = changeTeamTextField.getText();
        try {
            String oldValueQueryString = "select favoriteteam from Fans " +
            "where id = '" + id + "'";
            System.out.println(oldValueQueryString);
            
            ResultSet resultSet = stmt.executeQuery(oldValueQueryString);

            if (resultSet.next()) {
                String favoriteTeam = resultSet.getString(1);
                tableResults1.setText("The current favorite team of ID " + id + " is the " + favoriteTeam + ".");
            }
            else {
                tableResults1.setText("ID not found.  Please review entered value.");
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        try {
            String updateValueQueryString = "update fans \nset favoriteteam = '" + team + "'"
                + "\nwhere id = '" + id + "'";
            System.out.println(updateValueQueryString);

            stmt.executeUpdate(updateValueQueryString);
            System.out.println("Update complete");
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        try {
            String newValueQueryString = "select favoriteteam from Fans " +
            "where id = '" + id + "'";
            System.out.println(newValueQueryString);
            
            ResultSet resultSet = stmt.executeQuery(newValueQueryString);

            while (resultSet.next()) {
                String favoriteTeam = resultSet.getString(1);
                tableResults2.setText("The new favorite team of ID " + id + " is the " + favoriteTeam + ".");
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //Main method since I am using VSCode
    public static void main(String[] args) {
        Application.launch(args);
    }

}