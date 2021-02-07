package ComputerManagementFunctionFactory;

import model.Computers;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ComputerFactory {
    Session session = HibernateUtils.getSessionFactory().openSession();
    private ArrayList<Computers> books;

    public ComputerFactory(Session session) {
        this.session = session;
    }

    public ComputerFactory() {
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public String findAllComputers() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Book: ");
        session.createQuery("from Computers").getResultList().forEach(System.out::println);
        return null;
    }

    public List<Computers> findAllComputerList() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Computer: ");
        Query query = session.createQuery("from Computers");

        List<Computers> books = query.getResultList();
        session.close();
        return books;

    }

    public Computers findComputersByName(String bookName) {

        Query query = session.createQuery("select b from Computers b where b.computerName=:bookName");
        query.setParameter("bookName", bookName);
        List<Computers> computers = query.getResultList();

        Computers computer = null;

        if (!computers.isEmpty()) {
            return computers.get(0);
        }
        session.close();
        return computer;
    }

    public Computers findComputersByIsbn(String isbn) {

        Query query = session.createQuery("select b from Computers b where b.isbn=:isbn");
        query.setParameter("isbn", isbn);
        List<Computers> computers = query.getResultList();

        Computers computer = null;

        if (!computers.isEmpty()) {
            return computers.get(0);
        }
        session.close();
        return computer;
    }

    public void createComputers(final Computers computers) {

        Transaction transaction = session.beginTransaction();

        session.save(computers);

        transaction.commit();

    }

    public boolean createComputerSection(String computerName, String computerType, String isbn,
                                         String supplier, Integer quantity, Integer price, LocalDateTime createdOn) {

        // the data are okay
        // create the user
        Computers computers = new Computers(computerName, computerType, isbn, supplier, quantity, price, createdOn);
        //this.computers.add(computers);
        createComputers(computers);
        return true;

    }


    public void editComputers(Computers updatedComputer) {

        session = HibernateUtils.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        session.update(updatedComputer);

        transaction.commit();

    }


//    public boolean updateBookSection(Book book, int position) {
//
//        // the data are okay
//        // create the user
//        //this.book.add(book);
//        editBook(book);
//        this.books.set(position,book);
//        return true;
//
//    }



    public Computers findComputersByID(int Id) {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Computer by id: ");
        return session.find(Computers.class, Id);
    }

//    public void editBook(final Book updatedBook, int postion) {
//        Transaction transaction = session.beginTransaction();
//
//        session.update(String.valueOf(postion), updatedBook);
//
//        transaction.commit();
//    }




}
