package com.example;

import java.io.FileWriter;
import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        // ==========================
        // STEP 1: Create the layout
        // ==========================
        // TODO 1: Create and configure a GridPane
        // - Center align
        // - Add padding (12)
        // - Add horizontal and vertical gaps (5)
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(12));
        pane.setHgap(5);
        pane.setVgap(5);

        // ==========================
        // STEP 2: Add Labels and TextFields
        // ==========================
        // TODO 2: Add the following:
        // Label + TextField for:
        //     - Number
        //     - Description
        //     - Price
        //
        // Example (uncomment and complete):
        Label lblTitle = new Label("Enter product information:");
        pane.add(lblTitle, 0, 0);

        Label lblNumber = new Label("Number:");
        TextField tfNumber = new TextField();
        pane.add(lblNumber, 0, 1);
        pane.add(tfNumber, 1, 1);

        Label lblDescription = new Label("Description:");
        TextField tfDescription = new TextField();
        pane.add(lblDescription, 0, 2);
        pane.add(tfDescription, 1, 2);

        Label lblPrice = new Label("Price:");
        TextField tfPrice = new TextField();
        pane.add(lblPrice, 0, 3);
        pane.add(tfPrice, 1, 3);

        // ==========================
        // STEP 3: Add Buttons
        // ==========================
        // TODO 3: Add two buttons: "Save" and "Quit" put the buttons at the bottom as shown on the lab diagram
        Button btQuit = new Button("Quit");
        Button btSave = new Button("Save");
        pane.add(btQuit, 0, 4);
        pane.add(btSave, 1, 4);

        // ==========================
        // STEP 4: Add Button Functionality using the setOnAction method
        // ==========================
        // (a) Save Button:
        //     - Collect input from text fields
        //     - Call writeToFile(text)
        //     - Clear all fields
        btSave.setOnAction(e -> {
            String text = tfNumber.getText() + ", " + tfDescription.getText() + ", " + tfPrice.getText();

            writeToFile(text);
            tfNumber.clear();
            tfDescription.clear();
            tfPrice.clear();
        });

        // (b) Quit Button:
        //     - Exit application using Platform.exit()
        //
        btQuit.setOnAction(e -> {
            Platform.exit();
        });

        // TODO 4a: Implement btSave.setOnAction(...)
        // TODO 4b: Implement btQuit.setOnAction(...)
        //
    

        // ==========================
        // STEP 5: Create and Show Scene
        // ==========================
        // TODO 5: Create a Scene, set the title, and display the stage
        Scene scene = new Scene(pane, 350, 250);
        stage.setTitle("Inventory Manager");
        stage.setScene(scene);
        stage.show();
    }

    // ==========================
    // STEP 6: Method for writing to file
    // ==========================
    // This method will handle opening, writing, and closing the file.
    // The file name should be "Products.txt".
    //
    // TODO 6: Implement file writing logic.
    private void writeToFile(String text) {
        try (FileWriter writer = new FileWriter("Products.txt", true)) {
            writer.write(text + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}