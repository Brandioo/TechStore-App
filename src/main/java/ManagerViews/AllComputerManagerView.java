package ManagerViews;

import AdministratorViews.AdministratorHomeView;
import ComputerManagementFunctionFactory.ComputerFactory;
import ComputerView.BuyComputerView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import model.Client;
import model.Computers;
import model.Employee;

import java.util.List;

public class AllComputerManagerView {
    private Employee currentUser;

    public AllComputerManagerView(Employee currentUser) {
        this.currentUser = currentUser;
    }

    private Client currentClient;

    public AllComputerManagerView(Client u){
        this.currentClient = u;
    }

    private Computers currentBook;

    public AllComputerManagerView(Computers u){
        this.currentBook = u;
    }
    public Scene showView(Stage stage) {

        VBox root= new VBox();
        ComputerFactory computerFactory= new ComputerFactory();
        List<Computers> computers =computerFactory.findAllComputerList();
        ObservableList<Computers> list= FXCollections.observableArrayList(computers);

        TableView<Computers> table = new TableView();
        table.setItems(list);
        table.setEditable(true);

        TableColumn computerName = new TableColumn("Computer Name");
        computerName.setCellFactory(TextFieldTableCell.forTableColumn());
        computerName.setCellValueFactory(new PropertyValueFactory("computerName"));
        computerName.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){

            @Override
            public void handle(TableColumn.CellEditEvent t) {
                // TODO Auto-generated method stub

                Computers currentBook= (Computers) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                String newComputerName=(String) t.getNewValue();

                currentBook.setComputerName(newComputerName);
                computerFactory.editComputers(currentBook);
            }

        });



        TableColumn computerType = new TableColumn("Computer Type");
        computerType.setCellFactory(TextFieldTableCell.forTableColumn());
        computerType.setCellValueFactory(new PropertyValueFactory("computerType"));
        computerType.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){

            @Override
            public void handle(TableColumn.CellEditEvent t) {
                // TODO Auto-generated method stub

                Computers currentComputerType= (Computers) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                String newComputerType=(String) t.getNewValue();

                currentComputerType.setComputerType(newComputerType);
                computerFactory.editComputers(currentComputerType);
            }

        });


//        TableColumn supplierColumn = new TableColumn("Date Of Birth");
//        supplierColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        supplierColumn.setCellValueFactory(new PropertyValueFactory("dateofbirth"));
//        supplierColumn.setOnEditCommit(new EventHandler<CellEditEvent>(){
//
//            @Override
//            public void handle(CellEditEvent t) {
//                // TODO Auto-generated method stub
//
//                Employee currentUser= (Employee) t.getTableView().getItems().get(t.getTablePosition().getRow());
//                int pos= table.getSelectionModel().getSelectedIndex();
//                Object newDateOfBirth= t.getNewValue();
//
//                currentUser.setDateOfBirth(newDateOfBirth);
//                libraryManagementOptionsFactory.editUser(currentUser, pos);
//            }
//
//        });

        TableColumn ISBNColumn = new TableColumn("ISBN");
        ISBNColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        ISBNColumn.setCellValueFactory(new PropertyValueFactory("isbn"));
        ISBNColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){

            @Override
            public void handle(TableColumn.CellEditEvent t) {
                // TODO Auto-generated method stub

                Computers currentISBN= (Computers) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                String newIsbn =(String) t.getNewValue();

                currentISBN.setIsbn(newIsbn);
                computerFactory.editComputers(currentISBN);
            }

        });
//
//        TableColumn dateofPublication = new TableColumn("DateofPublication");
//        dateofPublication.setCellFactory(TextFieldTableCell.forTableColumn());
//        dateofPublication.setCellValueFactory(new PropertyValueFactory("DateofPublication"));
//        dateofPublication.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){
//
//            @Override
//            public void handle(TableColumn.CellEditEvent t) {
//                // TODO Auto-generated method stub
//
//                Book currentBook= (Book) t.getTableView().getItems().get(t.getTablePosition().getRow());
//                int pos= table.getSelectionModel().getSelectedIndex();
//                LocalDateTime newDateofPubliciation=(LocalDateTime) t.getNewValue();
//
//                currentBook.setDateOfPublication(newDateofPubliciation);
//                libraryManagementOptionsFactory.editBook(currentBook, pos);
//            }

//        });

        TableColumn supplierColumn = new TableColumn("Supplier ");
        supplierColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        supplierColumn.setCellValueFactory(new PropertyValueFactory("supplier"));
        supplierColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){

            @Override
            public void handle(TableColumn.CellEditEvent t) {
                // TODO Auto-generated method stub

                Computers currentComputer= (Computers) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                String newSupplier=(String) t.getNewValue();
                System.out.println("Description");
                currentComputer.setSupplier(newSupplier);
                computerFactory.editComputers(currentComputer);
            }

        });


        TableColumn quantityColumn = new TableColumn("Quantity ");
        quantityColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        quantityColumn.setCellValueFactory(new PropertyValueFactory("quantity"));
        quantityColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){

            @Override
            public void handle(TableColumn.CellEditEvent t) {
                // TODO Auto-generated method stub

                Computers currentBook= (Computers) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                Integer newQuantity=(Integer) t.getNewValue();

                currentBook.setQuantity(newQuantity);
                computerFactory.editComputers(currentBook);
            }

        });


        TableColumn priceColumn = new TableColumn("Price");
        priceColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        priceColumn.setCellValueFactory(new PropertyValueFactory("price"));
        priceColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){

            @Override
            public void handle(TableColumn.CellEditEvent t) {
                // TODO Auto-generated method stub

                Computers currentBook= (Computers) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                Integer newPrice=(Integer) t.getNewValue();

                currentBook.setPrice(newPrice);
                computerFactory.editComputers(currentBook);
            }

        });

//        TableColumn priceColumn = new TableColumn("Price ");
//        priceColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        priceColumn.setCellValueFactory(new PropertyValueFactory("price"));
//        priceColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){
//
//            @Override
//            public void handle(TableColumn.CellEditEvent t) {
//                // TODO Auto-generated method stub
//
//                Book currentBook= (Book) t.getTableView().getItems().get(t.getTablePosition().getRow());
//                int pos= table.getSelectionModel().getSelectedIndex();
//                Integer newPrice=(Integer) t.getNewValue();
//
//                currentBook.setPrice(newPrice);
//                libraryManagementOptionsFactory.editBook(currentBook, pos);
//            }
//
//        });


        table.getColumns().addAll(computerName, computerType, ISBNColumn, supplierColumn, quantityColumn, priceColumn);//, quantityColumn, priceColumn);


        Button save= new Button("Save");
        save.setOnAction(e->{
            ManagerHomeView hv = new ManagerHomeView(currentUser);
            stage.setScene(hv.execute(stage));
        });


        root.getChildren().addAll(table, save);

        Scene scene= new Scene(root, 450, 450);
        return scene;


    }
}
