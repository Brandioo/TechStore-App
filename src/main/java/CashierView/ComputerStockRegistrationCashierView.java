package CashierView;

import AdministratorViews.AdministratorHomeView;
import ComputerManagementFunctionFactory.ComputerFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Employee;

import java.time.LocalDateTime;

public class ComputerStockRegistrationCashierView {
    private Employee currentUser;
    public Scene execute(Stage stage) {
        GridPane root1 = new GridPane();
        root1.setHgap(10);
        root1.setVgap(10);
        root1.setPadding(new Insets(10, 10, 10, 10));

        Label computerNameLabel = new Label("Computer Name:    ");
        computerNameLabel.setTextFill(Color.WHITE);
        computerNameLabel.setStyle("-fx-font-weight: bold;");
        TextField computerNameField = new TextField();
        root1.add(computerNameLabel, 1, 1);
        root1.add(computerNameField, 4, 1);

        Label computerTypeLabel = new Label("Type:    ");
        computerTypeLabel.setTextFill(Color.WHITE);
        computerTypeLabel.setStyle("-fx-font-weight: bold;");
        TextField computerTypeField = new TextField();
        root1.add(computerTypeLabel, 1, 3);
        root1.add(computerTypeField, 4, 3);

        Label isbnLabel = new Label("ISBN:    ");
        isbnLabel.setTextFill(Color.WHITE);
        isbnLabel.setStyle("-fx-font-weight: bold;");
        TextField isbnField = new TextField();
        root1.add(isbnLabel, 1, 5);
        root1.add(isbnField, 4, 5);

        Label supplierLabel = new Label("Supplier:    ");
        supplierLabel.setTextFill(Color.WHITE);
        supplierLabel.setStyle("-fx-font-weight: bold;");
        root1.add(supplierLabel, 1, 7);
        TextField supplierField = new TextField();
        root1.add(supplierField, 4, 7);

        // Creates an integer spinner with 1 as min, 10 as max and 2 as initial value
        Spinner<Integer> spinner1 = new Spinner<>(1, 1000, 1);

        Spinner<Integer> spinner2 = new Spinner<>(1, 1000, 1);


// Creates an integer spinner with 0 as min, 100 as max and 10 as initial
// value and 10 as amount to increment or decrement by, per step
        // Spinner<Integer> spinner2 = new Spinner<>(0, 100, 10, 10);

//        Label quantityLabel = new Label("Quantity: ");
//        IntegerField quantityField = new IntegerField();
//        root1.add(quantityLabel, 1, 6);
//        root1.add(quantityField, 2, 6);
//
//        Label priceLabel = new Label("Price: ");
//        IntegerField priceField = new IntegerField();
//        root1.add(priceLabel, 1, 7);
//        root1.add(priceField, 2, 7);

//

        Label quantityLabel=new Label("Quantity:    ");
        quantityLabel.setTextFill(Color.WHITE);
        quantityLabel.setStyle("-fx-font-weight: bold;");
        root1.add(quantityLabel,1,9);
        root1.add(spinner1,4,9);


//        Label quantityLabel = new Label("Quantity: ");
//        quantityLabel.setTextFill(Color.web("white"));
//        quantityLabel.setStyle("-fx-font-weight: bold;");
//        root1.add(quantityLabel, 1, 6);
//        root1.add(spinner1,2,6);
//        TextField quantityField = new TextField();
//        root1.add(quantityField, 2, 8);

        Label priceLabel=new Label("Price:    ");
        priceLabel.setTextFill(Color.WHITE);
        priceLabel.setStyle("-fx-font-weight: bold;");
        root1.add(priceLabel,1,11);
        root1.add(spinner2,4,11);

//        Label priceLabel = new Label("Price: ");
//        priceLabel.setTextFill(Color.web("white"));
//        priceLabel.setStyle("-fx-font-weight: bold;");
//        root1.add(quantityLabel, 1, 7);
//        root1.add(spinner2,2,7);
//        TextField priceField = new TextField();
//        root1.add(priceField, 2, 8);


        Label createdOnLabel = new Label("Creation (Auto Calc. Now): ");
        createdOnLabel.setTextFill(Color.WHITE);
        createdOnLabel.setStyle("-fx-font-weight: bold;");
        TextField createdOnField = new TextField();
        root1.add(createdOnLabel, 1, 12);
        root1.add(createdOnField, 4, 12);

        Button createComputerButton = new Button("-Computer Registration-");
        createComputerButton.setStyle("-fx-font-weight: bold;"); //letters are written in bold type
        createComputerButton.setTextFill(Color.DEEPSKYBLUE); //Letters of findButton is LIGHTBLUE
        createComputerButton.setId("createComputerButton-button");
        createComputerButton.setStyle("-fx-background-color:#000000;"); //Background is Black
        HBox h1=new HBox(); //Declare h box
        h1.getChildren().add(createComputerButton); //Adding button inside the hBox
        root1.add(createComputerButton, 4, 14);

        createComputerButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                String computerName = computerNameField.getText();
                String computerType = computerTypeField.getText();
                String isbn = isbnField.getText();
                String supplier = supplierField.getText();
                Integer quantity = spinner1.getValue();
                Integer price = spinner2.getValue();
                LocalDateTime createdOn = LocalDateTime.now();
                //String supplier = supplierField.getText();
                // boolean isRememberMe = remember.isSelected();

                ComputerFactory bookFactory = new ComputerFactory();
                boolean isRegistered = bookFactory.createComputerSection(computerName, computerType, isbn, supplier, quantity, price, createdOn);

                if (!isRegistered) {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setHeaderText("There was an error");
                    errorAlert.setContentText("The registration was not done correctly");
                    errorAlert.showAndWait();
                } else {
                    Employee currentEmployee=new Employee();
                    Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    successAlert.setHeaderText("The computer was registered successfully");
                    successAlert.showAndWait();
                    stage.setScene(new CashierHomeView(currentEmployee).execute(stage));
                    successAlert.close();
                }

            }

        });

        BorderPane mainPane = new BorderPane();
        MenuBar menuBar = new MenuBar();

        Label backLabel=new Label("Back");
        backLabel.setStyle("-fx-font-weight: bold;");
        Menu back=new Menu("", backLabel);
        backLabel.setOnMouseClicked(e->{
            CashierHomeView homeView= new CashierHomeView(currentUser);
            stage.setScene(homeView.execute(stage));
        });

        menuBar.getMenus().add(back);
        mainPane.setTop(menuBar);



        root1.setStyle("-fx-background-image: url('img_9.png')");
        mainPane.setCenter(root1);
        Scene scene = new Scene(mainPane, 626, 417);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.setTitle("Register Computers");
        stage.show();

        return scene;

    }
}