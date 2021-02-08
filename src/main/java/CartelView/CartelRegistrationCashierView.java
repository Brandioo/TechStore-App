package CartelView;

import CartelRecordView.CartelRecordRegistrationCashierView;
import CartelRecordView.CartelRecordRegistrationView;
import CashierView.BuyComputerCashierView;
import CashierView.FindEmployeeCashiersView;
import CashierView.PaymentTypeCashier;
import ClientView.ClientFindingView;
import ClientView.ClientFindingViewCashier;
import ComputerManagementFunctionFactory.CartelFactory;
import ComputerManagementFunctionFactory.ClientFactory;
import ComputerManagementFunctionFactory.EmployeeFactory;
import ComputerView.BuyComputerView;
import EmployeesView.FindEmployeeView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Cartel;
import model.Computers;
import model.Employee;

import java.time.LocalDateTime;

public class CartelRegistrationCashierView {
    private Employee currentUser;
    private Computers currentComputer;

    public CartelRegistrationCashierView(Computers currentBook) {
        this.currentComputer = currentBook;
    }

    public Scene execute(Stage stage) {
        GridPane root1 = new GridPane();
        root1.setHgap(10);
        root1.setVgap(10);
        root1.setPadding(new Insets(10, 10, 10, 10));
        root1.setAlignment(Pos.BOTTOM_CENTER);

        // Creates an integer spinner with 1 as min, 10 as max and 2 as initial value
        Spinner<Integer> spinner1 = new Spinner<>(1, 1000, 2);

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

        Label employeeIDLabel=new Label("Employees ID: ");
        employeeIDLabel.setTextFill(Color.BLACK);
        employeeIDLabel.setStyle("-fx-font-weight: bold;");
        root1.add(employeeIDLabel,2,9);
        root1.add(spinner1,3,9);


//        Label quantityLabel = new Label("Quantity: ");
//        quantityLabel.setTextFill(Color.web("white"));
//        quantityLabel.setStyle("-fx-font-weight: bold;");
//        root1.add(quantityLabel, 1, 6);
//        root1.add(spinner1,2,6);
//        TextField quantityField = new TextField();
//        root1.add(quantityField, 2, 8);

        Label clientID=new Label("Client ID: ");
        clientID.setTextFill(Color.BLACK);
        clientID.setStyle("-fx-font-weight: bold;");
        root1.add(clientID,2,11);
        root1.add(spinner2,3,11);

//        Label priceLabel = new Label("Price: ");
//        priceLabel.setTextFill(Color.web("white"));
//        priceLabel.setStyle("-fx-font-weight: bold;");
//        root1.add(quantityLabel, 1, 7);
//        root1.add(spinner2,2,7);
//        TextField priceField = new TextField();
//        root1.add(priceField, 2, 8);


        Label createdOnLabel = new Label("Created On (Auto Calc. Now): ");
        createdOnLabel.setTextFill(Color.BLACK);
        createdOnLabel.setStyle("-fx-font-weight: bold;");
        TextField createdOnField = new TextField();
        root1.add(createdOnLabel, 2, 12);
        root1.add(createdOnField, 3, 12);

        Button createCartelButton = new Button("-Cartel Registration-");
        createCartelButton.setStyle("-fx-font-weight: bold;"); //letters are written in bold type
        createCartelButton.setTextFill(Color.PALEGOLDENROD); //Letters of findButton is LIGHTBLUE
        createCartelButton.setId("createCartelButton-button");
        createCartelButton.setStyle("-fx-background-color:#000000;"); //Background is Black
        HBox h1=new HBox(); //Declare h box
        h1.getChildren().add(createCartelButton); //Adding button inside the hBox
        root1.add(createCartelButton, 3, 14);

        createCartelButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                //String description = descriptionArea.getText();
                // boolean isRememberMe = remember.isSelected();

                CartelFactory cartelFactory = new CartelFactory();
                ClientFactory clientFactory=new ClientFactory();
                EmployeeFactory employeeFactory=new EmployeeFactory();
                Cartel cartel=new Cartel();

                Integer clientID = spinner2.getValue();
                cartel.setClient(clientFactory.findClientByID(clientID));

                Integer employeeID = spinner1.getValue();
                cartel.setEmployee(employeeFactory.findAllEmployeesByID(employeeID));

                LocalDateTime createdOn = LocalDateTime.now();
                cartel.setCreatedOn(createdOn);

                cartelFactory.createCartel(cartel);

                if (currentComputer ==null) {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setHeaderText("There was an error");
                    errorAlert.setContentText("Register Computer At Buy Book Section");
                    errorAlert.showAndWait();
                } else {
                    //Employee currentEmployee=new Employee();
                    Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    successAlert.setHeaderText("The Cartel was registered successfully");
                    successAlert.showAndWait();
                    stage.setScene(new CartelRecordRegistrationCashierView(cartel).execute(stage));
                    //stage.setScene(new HomeView(currentEmployee).execute(stage));
                    successAlert.close();

                }
            }

        });

        BorderPane mainPane = new BorderPane();
        MenuBar menuBar = new MenuBar();

        Label backLabel=new Label("Payment");
        backLabel.setStyle("-fx-font-weight: bold;");
        Menu back=new Menu("", backLabel);
        backLabel.setOnMouseClicked(e->{
            PaymentTypeCashier paymentTypeCashier= new PaymentTypeCashier(currentUser);
            stage.setScene(paymentTypeCashier.showView(stage));
        });

        menuBar.getMenus().add(back);
        mainPane.setTop(menuBar);

        Label findEmployeeViewLabel=new Label("Find Employee ID");
//        findEmployeeViewLabel.setStyle("-fx-font-weight: bold;");
        Menu findEmployeeID=new Menu("", findEmployeeViewLabel);
        findEmployeeViewLabel.setOnMouseClicked(e->{
            FindEmployeeCashiersView findEmployeeView1= new FindEmployeeCashiersView(currentUser);
            stage.setScene(findEmployeeView1.execute(stage));
        });

        menuBar.getMenus().add(findEmployeeID);
        mainPane.setTop(menuBar);

        Label findClientViewLabel=new Label("Find Client ID");
//        findClientViewLabel.setStyle("-fx-font-weight: bold;");
        Menu findClientID=new Menu("", findClientViewLabel);
        findClientViewLabel.setOnMouseClicked(e->{
            ClientFindingViewCashier clientFindingView= new ClientFindingViewCashier(currentUser);
            stage.setScene(clientFindingView.execute(stage));
        });

        menuBar.getMenus().add(findClientID);
        mainPane.setTop(menuBar);
//
//        Label findClientViewLabel=new Label("Find Client ID");
//        findClientViewLabel.setStyle("-fx-font-weight: bold;");
//        Menu findClientID=new Menu("", findClientViewLabel);
//        findClientViewLabel.setOnMouseClicked(e->{
//            FindClient findEmployeeView1= new FindEmployeeView(currentUser);
//            stage.setScene(findEmployeeView1.execute(stage));
//        });
//
//        menuBar.getMenus().add(findClientID);
//        mainPane.setTop(menuBar);

        root1.setStyle("-fx-background-image: url('imgg.png')");
        mainPane.setCenter(root1);
        Scene scene = new Scene(mainPane, 960, 350);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.setTitle("Register Cartels");
        stage.show();

        return scene;

    }
}
