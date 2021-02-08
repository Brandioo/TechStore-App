package ComputerManagementFunctionFactory;

import model.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFactory {
    Session session = HibernateUtils.getSessionFactory().openSession();
    private ArrayList<Employee> employees;

    public EmployeeFactory(Session session) {
        this.session = session;
    }

    public EmployeeFactory() {
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public ArrayList<Employee> getUsers() {
        return employees;
    }


    public void createEmployee(final Employee employee) {
        Transaction transaction = session.beginTransaction();

        session.save(employee);

        transaction.commit();
    }

    public Employee findAllEmployeesByID(int Id) {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Employee by id: ");
        return session.find(Employee.class, Id);
    }

    public String findAllEmployees() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Employee: ");
        session.createQuery("from Employee ").getResultList().forEach(System.out::println);
        return null;
    }

    public void findAllEmployeesNames() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All Names From Employee: ");
        session.createQuery("select e.firstName from Employee e").getResultList().forEach(System.out::println);
    }

    public List<Employee> findAllEmployeeList() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Employee: ");
        Query query = session.createQuery("from Employee ");

        List<Employee> employees = query.getResultList();
        session.close();
        return employees;

    }

    public Employee findEmployeeID() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Employee: ");
        Query query = session.createQuery("select e.employeesId from Employee e");
        Employee employee= (Employee) query.getResultList();
        session.close();
        return employee;

    }

    public Employee findEmployeeByName(String firstName) {

        Query query  = session.createQuery("select e from Employee e where e.firstName=:firstName");
        query.setParameter("firstName", firstName);
        List<Employee> employees = query.getResultList();

        Employee employee = null;

        if (!employees.isEmpty()) {
            return employees.get(0);
        }
        session.close();
        return employee;
    }

    public Employee logIn(String user, String password) {

        Query query  = session.createQuery("select e from Employee e where e.user=:user and e.password=:password");
        query.setParameter("user", user);
        query.setParameter("password", password);
        List<Employee> employees = query.getResultList();

        Employee employee = null;

        if (!employees.isEmpty()) {
            return employees.get(0);
        }
        session.close();
        return employee;
    }

    public boolean signUp(String firstName, String lastName, LocalDate dateOfBirth, String email,
                          String phoneNumber, String role, String user, String password, String verifiedPassword,
                          Integer salary, LocalDateTime createdOn) {
        if (password.equals(verifiedPassword)) {
            // the data are okay
            // create the user
            Employee employee = new Employee( firstName, lastName, dateOfBirth, email, phoneNumber, role
                    , user, password, salary, createdOn);
            //this.employees.add(employee);
            createEmployee(employee);
            return true;
        }
        return false;
    }

    public void editEmployee(Employee updatedUser) {
        session = HibernateUtils.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        session.update(updatedUser);

        transaction.commit();
    }


    public void findAdministrator() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Administrator from Employee: ");
        session.createQuery("select e.firstName from Employee e where e.role='Manager'").getResultList().forEach(System.out::println);
    }

    public void findOperator() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Sellers from Employee: ");
        session.createQuery("select e.firstName from Employee e where e.role='Seller'").getResultList().forEach(System.out::println);
    }

    public int countSalaries() {

        Query query = session.createQuery("select sum(c.salary) from Employee c");
        Integer cartels = Math.toIntExact((Long) query.getSingleResult());

        return cartels;

    }
}
