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
import java.sql.*;

public class PindelMod10DatabaseProgram extends Application {
    private Statement stmt;
    TextField userIDEntryDisplay = new TextField();
    TextField userIDEntryUpdate = new TextField();
    TextField changeTeamTextField = new TextField(); 
    private Label tableResults1 = new Label();
    private Label tableResults2 = new Label();
    private Label idLabel1 = new Label("Please enter a 3-digit ID: ");
    private Label idLabel2 = new Label("Please enter a 3-digit ID: ");
    private Label updateLabel = new Label("Please enter the new team value: ");

    //Override the start method of the Application class
    @Override
    public void start(Stage primaryStage) throws SQLException, ClassNotFoundException {
        initializeDB();
               
        Button displayButton = new Button("Display Record");
        Button updateButton = new Button("Update Record");
       
        VBox vBoxDisplay = new VBox(5);
        VBox vBoxUpdate = new VBox(5);
        vBoxDisplay.getChildren().addAll(idLabel1, userIDEntryDisplay, displayButton);
        vBoxUpdate.getChildren().addAll(idLabel2, userIDEntryUpdate, updateLabel, changeTeamTextField, updateButton);
        
        HBox buttonHBox = new HBox(5);
        buttonHBox.setPadding(new Insets(5));
        buttonHBox.getChildren().addAll(vBoxDisplay, vBoxUpdate);
        
        VBox vBoxMain = new VBox(5);
        vBoxMain.setPadding(new Insets(5));
        vBoxMain.getChildren().addAll(tableResults1, tableResults2, buttonHBox);

        userIDEntryDisplay.setPrefColumnCount(3);
        userIDEntryUpdate.setPrefColumnCount(3);
        tableResults1.setStyle("-fx-font-weight: bold;");
        tableResults2.setStyle("-fx-font-weight: bold;");
        displayButton.setOnAction(e -> displayFavoriteTeam());
        updateButton.setOnAction(e -> updateFavoriteTeam());
    
        Scene scene = new Scene(vBoxMain, 400, 200);
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
        String id = userIDEntryDisplay.getText();
        try {
            String displayValueQueryString = "select favoriteteam from Fans " +
                "where id = '" + id + "'";
            System.out.println(displayValueQueryString);
            
            ResultSet resultSet = stmt.executeQuery(displayValueQueryString);

            if (resultSet.next()) {
                String favoriteTeam = resultSet.getString(1);
                tableResults1.setText("The favorite team of ID: " + id + " is the " + favoriteTeam + ".");
            }
            else {
                tableResults1.setText("ID not found.  Please review entered value.");
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

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
                tableResults1.setText("The current favorite team of ID: " + id + " is the " + favoriteTeam + ".");
                tableResults2.setText(null);
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
                tableResults2.setText("The new favorite team of ID: " + id + " is the " + favoriteTeam + ".");
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