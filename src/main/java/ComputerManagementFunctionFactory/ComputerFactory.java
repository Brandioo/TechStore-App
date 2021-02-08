package ComputerManagementFunctionFactory;

import model.Computers;
import model.Supplier;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ComputerFactory {
    Session session = HibernateUtils.getSessionFactory().openSession();
    private ArrayList<Computers> computers;

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
        System.out.println("Print All From Computer: ");
        session.createQuery("from Computers").getResultList().forEach(System.out::println);
        return null;
    }

    public List<Computers> findAllComputerList() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Computer: ");
        Query query = session.createQuery("from Computers");

        List<Computers> computers = query.getResultList();
        session.close();
        return computers;

    }

    public Computers findComputersByName(String computerName) {

        Query query = session.createQuery("select b from Computers b where b.computerName=:computerName");
        query.setParameter("computerName", computerName);
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
        session.close();

        if (!computers.isEmpty()) {
            return computers.get(0);
        }

        return null;
    }

//    public List<Computers> findComputersBySupplier(String supplier) {
//
//        Query query = session.createQuery("select b from Computers b where b.supplier=:supplier");
//        query.setParameter("supplier", supplier);
//        List<Computers> computers = query.getResultList();
//
//        session.close();
//        return computers;
//    }

    public void createComputers(final Computers computers) {

        Transaction transaction = session.beginTransaction();

        session.save(computers);

        transaction.commit();

    }

//    public boolean createComputerSection(String computerName, String computerType, String isbn,
//                                         Integer quantity, Integer price, LocalDateTime createdOn, Supplier supplierID) {
//
//
//
//    }


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
