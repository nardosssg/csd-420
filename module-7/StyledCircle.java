/**
 * Nardos Gebremdhin
 * 4/26/2025
 * M7: Programming Assignment
 *
 * program that displays four circles and uses the style class and ID.
 * */


package com.example.m7javafxcircle;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class StyledCircle extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        // creating circles
        Circle circle1 = new Circle(60, 100, 30);
        circle1.getStyleClass().add("plaincircle");

        Circle circle2 = new Circle(140, 100, 30);
        circle2.getStyleClass().add("plaincircle");

        Circle circle3 = new Circle(220, 100, 30);
        circle3.setId("redcircle");

        Circle circle4 = new Circle(300, 100, 30);
        circle4.setId("greencircle");

        // creating rectangle
        Rectangle rectangle = new Rectangle(10, 50, 99, 120);
        rectangle.getStyleClass().add("border");

        // putting the shapes on the pane
        pane.getChildren().addAll(rectangle, circle1, circle2, circle3, circle4);

        Scene scene = new Scene(pane, 400, 200);
        // loading the css
        scene.getStylesheets().add("style.css");

        primaryStage.setTitle("Circle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}