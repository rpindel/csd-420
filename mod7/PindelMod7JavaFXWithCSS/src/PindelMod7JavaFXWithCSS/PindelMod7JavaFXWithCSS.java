package PindelMod7JavaFXWithCSS;

import javafx.application.Application;
import javafx.scene.*;
import javafx.geometry.Insets;
import javafx.geometry.Insets.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.shape.*;

public class PindelMod7JavaFXWithCSS extends Application {
    //Override the start method of the Application class
    @Override
    public void start(Stage primaryStage) {
        HBox hBox = new HBox(5);
        hBox.setPadding(new Insets(5));
        Scene scene = new Scene(hBox, 425, 110);
        scene.getStylesheets().add("PindelMod7JavaFXWithCSS.css");
        System.out.println(getClass().getResource("PindelMod7JavaFXWithCSS.css").toExternalForm());

        
        StackPane stackPane1 = new StackPane();
        stackPane1.getStyleClass().add("border");
        StackPane stackPane2 = new StackPane();
        StackPane stackPane3 = new StackPane();
        StackPane stackPane4 = new StackPane();

        Circle circle1 = new Circle(50);
        circle1.getStyleClass().add("plaincircle");
        Circle circle2 = new Circle(50);
        circle2.getStyleClass().add("plaincircle");
        Circle circle3 = new Circle(50);
        circle3.setId("redcircle");
        Circle circle4 = new Circle(50);
        circle4.setId("greencircle");

        stackPane1.getChildren().add(circle1);
        stackPane2.getChildren().add(circle2);
        stackPane3.getChildren().add(circle3);
        stackPane4.getChildren().add(circle4);

        hBox.getChildren().addAll(stackPane1, stackPane2, stackPane3, stackPane4);

        primaryStage.setTitle("Circles with JavaFX CSS");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    //Main method since I am using VSCode
    public static void main(String[] args) {
        Application.launch(args);
    }
}
