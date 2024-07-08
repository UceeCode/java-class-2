import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create UI components
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();

        Label amountLabel = new Label("Amount:");
        TextField amountField = new TextField();

        Button addButton = new Button("Add Expense");

        // Create layout and add components
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(amountLabel, 0, 1);
        grid.add(amountField, 1, 1);
        grid.add(addButton, 1, 2);

        // Event handler for add expense button
        addButton.setOnAction(e -> {
            String name = nameField.getText();
            String amount = amountField.getText();
            // Add logic to handle expense addition
            System.out.println("Added expense: " + name + " - $" + amount);
            // Clear fields after adding expense
            nameField.clear();
            amountField.clear();
        });

        // Set scene and stage
        Scene scene = new Scene(grid, 300, 150);
        primaryStage.setTitle("Budget Tracker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
