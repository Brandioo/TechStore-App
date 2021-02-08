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

public class SupplierFactory {
    Session session = HibernateUtils.getSessionFactory().openSession();
    private ArrayList<Computers> computers;

    public SupplierFactory(Session session) {
        this.session = session;
    }

    public SupplierFactory() {
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public String findAllSuppliers() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Suppliers: ");
        session.createQuery("from Supplier ").getResultList().forEach(System.out::println);
        return null;
    }

    public List<Supplier> findAllSuppliersList() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Suppliers: ");
        Query query = session.createQuery("from Supplier ");

        List<Supplier> suppliers = query.getResultList();
        session.close();
        return suppliers;

    }

    public Supplier findSupplierByName(String supplierCompanyName) {

        Query query = session.createQuery("select b from Supplier b where b.supplierCompanyName=:supplierCompanyName");
        query.setParameter("supplierCompanyName", supplierCompanyName);
        List<Supplier> suppliers = query.getResultList();

        Supplier supplier = null;

        if (!suppliers.isEmpty()) {
            return suppliers.get(0);
        }
        session.close();
        return supplier;
    }


    public void createSuppliers(final Supplier supplier) {

        Transaction transaction = session.beginTransaction();

        session.save(supplier);

        transaction.commit();

    }

    public boolean createSupplierSection(String supplierCompanyName, String product, Integer quantity, Integer price, LocalDateTime createdOn) {

        // the data are okay
        // create the user
        Supplier supplier = new Supplier(supplierCompanyName, product, quantity, price, createdOn);
        //this.computers.add(computers);
        createSuppliers(supplier);
        return true;

    }


    public void editSuppliers(Supplier updatedSuppliers) {

        session = HibernateUtils.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        session.update(updatedSuppliers);

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



    public Supplier findSupplierByID(int Id) {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Supplier by id: ");
        return session.find(Supplier.class, Id);
    }

//    public void editBook(final Book updatedBook, int postion) {
//        Transaction transaction = session.beginTransaction();
//
//        session.update(String.valueOf(postion), updatedBook);
//
//        transaction.commit();
//    }

    public int countCost() {

        Query query = session.createQuery("select sum(c.price) from Supplier c");
        Integer cartels = Math.toIntExact((Long) query.getSingleResult());

        return cartels;

    }

}
