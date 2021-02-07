package AdministratorViews;

import ComputerView.AllComputerView;
import ComputerView.ComputerFindingView;
import ComputerView.ComputerStockRegistrationView;
import CartelView.CartelCounts;
import ClientView.ClientFindingView;
import EmployeesView.AllUsersView;
import EmployeesView.FindEmployeeView;
import ComputerManagementFunctionFactory.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Employee;

public class AdministratorHomeView {
    private Employee currentUser;

    public AdministratorHomeView(Employee currentUser) {
        this.currentUser = currentUser;
    }

    public Scene execute(Stage stage) {
        //StackPane root = new StackPane();

        BorderPane mainPane = new BorderPane();
        MenuBar menuBar = new MenuBar();
        Menu userMenu = new Menu("User Control");
        userMenu.setStyle("-fx-font-weight: bold;");
        Menu createMenu = new Menu("Registration");
        createMenu.setStyle("-fx-font-weight: bold;");
        Menu findBookOrClient = new Menu("Find-Options");
        findBookOrClient.setStyle("-fx-font-weight: bold;");

        GridPane root1 = new GridPane();
        root1.setAlignment(Pos.CENTER);

        MenuItem getAllCartelRecord = new MenuItem("-Get All Cartel-Record Info-");
        getAllCartelRecord.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                CartelRecordFactory cartelRecordFactory = new CartelRecordFactory();
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("All Cartels-Record Information");
                successAlert.setContentText(cartelRecordFactory.findAllCartelRecord());
                successAlert.showAndWait();
                System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
            }

        });

        MenuItem getAllUser = new MenuItem("-Get All User Info-");
        getAllUser.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {

                EmployeeFactory employeeFactory = new EmployeeFactory();
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("All Users Information");
                successAlert.setContentText(employeeFactory.findAllEmployees());
                successAlert.showAndWait();
                System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
            }

        });

        MenuItem getAllUserTable = new MenuItem("-Get All User Table-");
        getAllUserTable.setStyle("-fx-font-weight: bold;");
        getAllUserTable.setId("findComputer-button");
        getAllUserTable.setStyle("-fx-background-color:#01FFFF;");
        getAllUserTable.setOnAction(event -> {
            AllUsersView av= new AllUsersView(currentUser);
            Scene scene= av.showView(stage);
            stage.setScene(scene);
        });


        MenuItem getAllClients = new MenuItem("-Get All Client Info-");
        getAllClients.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {

                ClientFactory clientFactory = new ClientFactory();
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("All Clients Information");
                successAlert.setContentText(clientFactory.findAllClient());
                successAlert.showAndWait();
                System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
            }

        });

        MenuItem getAllClientTable = new MenuItem("-Get All Client Table-");
        getAllClientTable.setStyle("-fx-font-weight: bold;");
        getAllClientTable.setId("getAllClientTable-button");
        getAllClientTable.setStyle("-fx-background-color:#01FFFF;");
        getAllClientTable.setOnAction(event -> {
            AllClientView av= new AllClientView(currentUser);
            Scene scene= av.showView(stage);
            stage.setScene(scene);
        });


        MenuItem getAllCartels = new MenuItem("-Get All Cartel Info-");
        getAllCartels.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                CartelFactory cartelFactory = new CartelFactory();
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("All Cartels Information");
                successAlert.setContentText(cartelFactory.findAllCartels());
                successAlert.showAndWait();
                System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
            }

        });


        MenuItem getAllBooks = new MenuItem("-Get All Computers Info-");
//        root.getChildren().add(getAllUser);

        getAllBooks.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                ComputerFactory bookFactory = new ComputerFactory();
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("All Computers Information");
                successAlert.setContentText(bookFactory.findAllComputers());
                successAlert.showAndWait();
                System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
            }

        });

        MenuItem getAllComputerTable = new MenuItem("-Get All Computers Table-");
        getAllComputerTable.setStyle("-fx-font-weight: bold;");
        getAllComputerTable.setId("getAllComputerTable-button");
        getAllComputerTable.setStyle("-fx-background-color:#01FFFF;");
        getAllComputerTable.setOnAction(event -> {
            AllComputerView av= new AllComputerView(currentUser);
            Scene scene= av.showView(stage);
            stage.setScene(scene);
        });

        MenuItem getUser = new MenuItem("-Get Current User Info-");
        getUser.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Name: "+this.currentUser.getFirstName()+"\n"+
                    "Surname: "+this.currentUser.getLastName()+"\n"+
                    "Role: "+this.currentUser.getRole()+"\n"+
                    "Email: "+this.currentUser.getEmail()+"\n"+
                    "Date Of Birth: "+this.currentUser.getDateOfBirth()+"\n"+
                    "Phone Number: "+this.currentUser.getPhoneNumber()+"\n"+
                    "User: "+this.currentUser.getUser()+"\n");
            alert.setHeaderText("The user Information");
            alert.showAndWait();

        });

        userMenu.getItems().addAll(getUser, getAllUser, getAllUserTable, getAllClients, getAllClientTable, getAllBooks,
                getAllComputerTable, getAllCartels, getAllCartelRecord);

        Label logOutLabel=new Label("Log Out");
        Menu logout=new Menu("", logOutLabel);
        logOutLabel.setOnMouseClicked(e->{
            AdministratorLoginView lv= new AdministratorLoginView();
            stage.setScene(lv.showView(stage));
        });

        menuBar.getMenus().add(userMenu);
        mainPane.setTop(menuBar);


        Button buyComputer = new Button("-Buy Computer-");
        buyComputer.setStyle("-fx-font-weight: bold;");
        root1.add(buyComputer, 2, 3);
//        root.getChildren().add(getAllUser);

        buyComputer.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
//                VendingMachine vendingMachine=new VendingMachine();
//                vendingMachine.start();
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("Buying Computer");
                successAlert.showAndWait();
                    stage.setScene(new PaymentTypeAdministrator().showView(stage));
                System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
            }

        });

        MenuItem findComputer = new MenuItem("-Find Computer-");
        findComputer.setStyle("-fx-font-weight: bold;");
        findComputer.setId("findComputer-button");
        findComputer.setStyle("-fx-background-color:#01FFFF;");
        findComputer.setOnAction(e->{
            stage.setScene(new ComputerFindingView().execute(stage));
        });

        MenuItem findEmployee = new MenuItem("-Find Employee-");
        findEmployee.setStyle("-fx-font-weight: bold;");
        findEmployee.setId("findComputer-button");
        findEmployee.setStyle("-fx-background-color:#01FFFF;");
        findEmployee.setOnAction(e->{
            stage.setScene(new FindEmployeeView().execute(stage));
        });

        findBookOrClient.getItems().addAll(findComputer, findEmployee);
        mainPane.setTop(menuBar);

        MenuItem findClients = new MenuItem("-Find Clients-");
        findClients.setStyle("-fx-font-weight: bold;");
        findClients.setId("findClients-button");
        findClients.setStyle("-fx-background-color:#01FFFF;");
        findClients.setOnAction(e->{
            stage.setScene(new ClientFindingView().execute(stage));
        });

        findBookOrClient.getItems().addAll(findClients);
        mainPane.setTop(menuBar);

        MenuItem findCartelsByEmployees = new MenuItem("-Find Sells By One Employee-");
        findCartelsByEmployees.setStyle("-fx-font-weight: bold;");
        findCartelsByEmployees.setId("findClients-button");
        findCartelsByEmployees.setStyle("-fx-background-color:#01FFFF;");
        findCartelsByEmployees.setOnAction(e->{
            stage.setScene(new CartelCounts().execute(stage));
        });

        findBookOrClient.getItems().addAll(findCartelsByEmployees);
        mainPane.setTop(menuBar);


        MenuItem getVerificationStatus = new MenuItem("-Verification Status-");
        getVerificationStatus.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Your Account Is Verified*");
            alert.setHeaderText("The user Information");
            alert.showAndWait();

        });

        MenuItem createClientButton = new MenuItem("-Create Client Button-");
        createClientButton.setOnAction(e->{
            stage.setScene(new ClientSignUpView().execute(stage));
        });

        MenuItem createComputerButton = new MenuItem("-Create Computer Button-");
        createComputerButton.setOnAction(e->{
            stage.setScene(new ComputerStockRegistrationView().execute(stage));
        });

        createMenu.getItems().addAll(getVerificationStatus, createClientButton, createComputerButton);

        menuBar.getMenus().add(createMenu);
        menuBar.getMenus().add(findBookOrClient);
        menuBar.getMenus().add(logout);
        mainPane.setTop(menuBar);

        mainPane.setCenter(root1);

        HBox hBox=new HBox();

        // create a background fill
        BackgroundFill background_fill = new BackgroundFill(Color.ROSYBROWN,
                CornerRadii.EMPTY, Insets.EMPTY);

        // create Background
        Background background = new Background(background_fill);

        // set background
        root1.setBackground(background);



        root1.setStyle("-fx-background-image: url('img_1.png')");
        Scene sc = new Scene(mainPane, 626, 417);
        sc.getStylesheets().add("style.css");
        stage.setTitle("Home");

        return sc;
    }

}
