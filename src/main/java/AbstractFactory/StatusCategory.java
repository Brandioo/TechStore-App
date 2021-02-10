package AbstractFactory;

import javafx.stage.Stage;
import model.Employee;

import java.util.Optional;

public interface StatusCategory {
    void start(Stage primaryStage) throws ExceptionExample;

    Optional<Employee> getAction() throws ExceptionExample;

}
