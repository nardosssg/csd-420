//Nardos Gebremedhin
//03/22/2025
//Module 1 Programming Assignment

//program that displays four images randomly selected from a deck of 52 cards

package com.example.m1javafxcards;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Objects;

public class CardDisplay extends Application {

    // path to the folder that has the card imgs
    private static final String CARD_PATH = "cards";
    //storing the 4 cards
    private final ImageView[] cardViews = new ImageView[4];

    @Override
    public void start(Stage primStage)  {
        //HBOX to display imgs
        HBox cardBox = new HBox(20);
        cardBox.setAlignment(Pos.CENTER);
        cardBox.setPadding(new Insets(20));


        // initl imgViews and use lambda expression
        IntStream.range(0,4).forEach(i -> {
            cardViews[i] = new ImageView();
            cardViews[i].setFitWidth(140);
            cardViews[i].setFitHeight(200);
            cardBox.getChildren().add(cardViews[i]);

        });

        //button to refresh cards
        Button refreshButton = new Button("Refresh Cards");
        refreshButton.setStyle(
                "-fx-background-color: #336699;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 5px;"
        );
        refreshButton.setPrefWidth(160);
        refreshButton.setPrefHeight(45);
        refreshButton.setOnAction(e -> shuffleDisplayCards());



        // VBox to hold cards
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(25));
        root.getChildren().addAll(cardBox, refreshButton);

        // set background color
        root.setBackground(new Background(new BackgroundFill(
                Color.LIGHTPINK, null, null)));

        // shuffle and display cards init
        shuffleDisplayCards();

        // create and show scene
        Scene scene = new Scene(root, 750, 500);
        primStage.setTitle("Card Display");
        primStage.setScene(scene);
        primStage.show();
    }

    private void shuffleDisplayCards() {
        File cardFolder = new File(CARD_PATH);
        if (!cardFolder.exists() || !cardFolder.isDirectory()) {
            showAlert("ERROR!", "Card directory not found!", "Make sure 'cards' folder exists.");
            return;
        }

        // lambda to filter out valid card numbers 1 through 52
        List<String> validCards = Arrays.stream(Objects.requireNonNull(cardFolder.listFiles((dir, name) -> name.endsWith(".png"))))
                .map(File::getName)
                .filter(name -> {
                    try {
                        int num = Integer.parseInt(name.replace(".png", ""));
                        return num >= 1 && num <= 52;
                    } catch (NumberFormatException e) {
                        return false;
                    }
                })
                .map(name -> new File(cardFolder, name).getPath())
                .collect(Collectors.toList());

        if (validCards.size() < 4) {
            showAlert("EEROR!", "Not enough card images!", "Make sure there is 4 valid card images in the 'cards' folder.");
            return;
        }

        // select 4 random images and shuffle
        Collections.shuffle(validCards);
        List<String> chosenCards = validCards.subList(0, 4);

        IntStream.range(0, 4).forEach(i ->
                cardViews[i].setImage(new Image("file:" + chosenCards.get(i)))
        );
    }

    private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}