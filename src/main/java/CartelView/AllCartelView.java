package CartelView;//package CartelView;
//
//import BookView.BuyBookView;
//import LibraryManagementFunctionFactory.BookFactory;
//import LibraryManagementFunctionFactory.CartelFactory;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.EventHandler;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.control.cell.TextFieldTableCell;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//import javafx.util.converter.IntegerStringConverter;
//import model.Book;
//import model.Cartel;
//import model.Client;
//import model.Employee;
//import views.HomeView;
//
//import java.util.List;
//
//public class AllCartelView {
//    private Employee currentUser;
//
//    public AllCartelView(Employee currentUser) {
//        this.currentUser = currentUser;
//    }
//
//    private Client currentClient;
//
//    public AllCartelView(Client u){
//        this.currentClient = u;
//    }
//
//    private Book currentBook;
//
//    public AllCartelView(Book u){
//        this.currentBook = u;
//    }
//    public Scene showView(Stage stage) {
//
//        VBox root= new VBox();
//        CartelFactory cartelFactory=new CartelFactory();
//        BookFactory bookFactory= new BookFactory();
//        List<Book> books =bookFactory.findAllBookList();
//        ObservableList<Book> list= FXCollections.observableArrayList(books);
//
//        TableView<Book> table = new TableView();
//        table.setItems(list);
//        table.setEditable(true);
//
//        TableColumn cartelIDColumn = new TableColumn("Cartel ID");
//        cartelIDColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
//        cartelIDColumn.setCellValueFactory(new PropertyValueFactory("cartelId"));
//        cartelIDColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){
//
//            @Override
//            public void handle(TableColumn.CellEditEvent t) {
//                // TODO Auto-generated method stub
//
//                Cartel currentCartel= (Cartel) t.getTableView().getItems().get(t.getTablePosition().getRow());
//                int pos= table.getSelectionModel().getSelectedIndex();
//                Integer newCartelID=(Integer) t.getNewValue();
//
//                currentCartel.setCartelId(newCartelID);
//                cartelFactory.editCartel(currentCartel);
//            }
//
//        });
//
//        TableColumn employeeIDColumn = new TableColumn("Employee ID");
//        employeeIDColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
//        employeeIDColumn.setCellValueFactory(new PropertyValueFactory("employeesId"));
//        employeeIDColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){
//
//            @Override
//            public void handle(TableColumn.CellEditEvent t) {
//                // TODO Auto-generated method stub
//
//                Cartel currentCartel= (Cartel) t.getTableView().getItems().get(t.getTablePosition().getRow());
//                int pos= table.getSelectionModel().getSelectedIndex();
//                Employee newEmployeeID=(Integer) t.getNewValue();
//
//                currentCartel.setEmployee(newEmployeeID);
//                cartelFactory.editCartel(currentCartel);
//            }
//
//        });
//
//
//
//        TableColumn genereColumn = new TableColumn("Genere");
//        genereColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        genereColumn.setCellValueFactory(new PropertyValueFactory("genere"));
//        genereColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){
//
//            @Override
//            public void handle(TableColumn.CellEditEvent t) {
//                // TODO Auto-generated method stub
//
//                Book currentGenereBook= (Book) t.getTableView().getItems().get(t.getTablePosition().getRow());
//                int pos= table.getSelectionModel().getSelectedIndex();
//                String newGenereBook=(String) t.getNewValue();
//
//                currentGenereBook.setGenere(newGenereBook);
//                bookFactory.editBook(currentGenereBook);
//            }
//
//        });
//
//
////        TableColumn descriptionColumn = new TableColumn("Date Of Birth");
////        descriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
////        descriptionColumn.setCellValueFactory(new PropertyValueFactory("dateofbirth"));
////        descriptionColumn.setOnEditCommit(new EventHandler<CellEditEvent>(){
////
////            @Override
////            public void handle(CellEditEvent t) {
////                // TODO Auto-generated method stub
////
////                Employee currentUser= (Employee) t.getTableView().getItems().get(t.getTablePosition().getRow());
////                int pos= table.getSelectionModel().getSelectedIndex();
////                Object newDateOfBirth= t.getNewValue();
////
////                currentUser.setDateOfBirth(newDateOfBirth);
////                libraryManagementOptionsFactory.editUser(currentUser, pos);
////            }
////
////        });
//
//        TableColumn ISBNColumn = new TableColumn("ISBN");
//        ISBNColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        ISBNColumn.setCellValueFactory(new PropertyValueFactory("isbn"));
//        ISBNColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){
//
//            @Override
//            public void handle(TableColumn.CellEditEvent t) {
//                // TODO Auto-generated method stub
//
//                Book currentISBN= (Book) t.getTableView().getItems().get(t.getTablePosition().getRow());
//                int pos= table.getSelectionModel().getSelectedIndex();
//                String newIsbn =(String) t.getNewValue();
//
//                currentISBN.setIsbn(newIsbn);
//                bookFactory.editBook(currentISBN);
//            }
//
//        });
////
////        TableColumn dateofPublication = new TableColumn("DateofPublication");
////        dateofPublication.setCellFactory(TextFieldTableCell.forTableColumn());
////        dateofPublication.setCellValueFactory(new PropertyValueFactory("DateofPublication"));
////        dateofPublication.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){
////
////            @Override
////            public void handle(TableColumn.CellEditEvent t) {
////                // TODO Auto-generated method stub
////
////                Book currentBook= (Book) t.getTableView().getItems().get(t.getTablePosition().getRow());
////                int pos= table.getSelectionModel().getSelectedIndex();
////                LocalDateTime newDateofPubliciation=(LocalDateTime) t.getNewValue();
////
////                currentBook.setDateOfPublication(newDateofPubliciation);
////                libraryManagementOptionsFactory.editBook(currentBook, pos);
////            }
//
////        });
//
//        TableColumn descriptionColumn = new TableColumn("Description ");
//        descriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        descriptionColumn.setCellValueFactory(new PropertyValueFactory("description"));
//        descriptionColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){
//
//            @Override
//            public void handle(TableColumn.CellEditEvent t) {
//                // TODO Auto-generated method stub
//
//                Book currentBook= (Book) t.getTableView().getItems().get(t.getTablePosition().getRow());
//                int pos= table.getSelectionModel().getSelectedIndex();
//                String newDescription=(String) t.getNewValue();
//                System.out.println("Description");
//                currentBook.setDescription(newDescription);
//                bookFactory.editBook(currentBook);
//            }
//
//        });
//
//
//        TableColumn quantityColumn = new TableColumn("Quantity ");
//        quantityColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
//        quantityColumn.setCellValueFactory(new PropertyValueFactory("quantity"));
//        quantityColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){
//
//            @Override
//            public void handle(TableColumn.CellEditEvent t) {
//                // TODO Auto-generated method stub
//
//                Book currentBook= (Book) t.getTableView().getItems().get(t.getTablePosition().getRow());
//                int pos= table.getSelectionModel().getSelectedIndex();
//                Integer newQuantity=(Integer) t.getNewValue();
//
//                currentBook.setQuantity(newQuantity);
//                bookFactory.editBook(currentBook);
//            }
//
//        });
//
//
//        TableColumn priceColumn = new TableColumn("Price");
//        priceColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
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
//                bookFactory.editBook(currentBook);
//            }
//
//        });
//
////        TableColumn priceColumn = new TableColumn("Price ");
////        priceColumn.setCellFactory(TextFieldTableCell.forTableColumn());
////        priceColumn.setCellValueFactory(new PropertyValueFactory("price"));
////        priceColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){
////
////            @Override
////            public void handle(TableColumn.CellEditEvent t) {
////                // TODO Auto-generated method stub
////
////                Book currentBook= (Book) t.getTableView().getItems().get(t.getTablePosition().getRow());
////                int pos= table.getSelectionModel().getSelectedIndex();
////                Integer newPrice=(Integer) t.getNewValue();
////
////                currentBook.setPrice(newPrice);
////                libraryManagementOptionsFactory.editBook(currentBook, pos);
////            }
////
////        });
//
//
//        table.getColumns().addAll(cartelIDColumn, genereColumn, ISBNColumn, descriptionColumn, quantityColumn, priceColumn);//, quantityColumn, priceColumn);
//
//
//        Button save= new Button("Save");
//        save.setOnAction(e->{
//            HomeView hv = new HomeView(currentUser);
//            stage.setScene(hv.execute(stage));
//        });
//
//        Button buyBook= new Button("Buy Book");
//        buyBook.setOnAction(e->{
//            BuyBookView buyBookView = new BuyBookView(currentUser);
//            stage.setScene(buyBookView.execute(stage));
//        });
//
//        root.getChildren().addAll(table, save, buyBook);
//
//        Scene scene= new Scene(root, 450, 450);
//        return scene;
//
//
//    }
//}
