package ComputerManagementFunctionFactory;

import model.CartelRecord;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtils;

public class CartelRecordFactory {
    Session session = HibernateUtils.getSessionFactory().openSession();

    public CartelRecordFactory(Session session) {
        this.session = session;
    }

    public CartelRecordFactory() {
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public void createCartelRecord(final CartelRecord cartelRecord) {
        Transaction transaction = session.beginTransaction();

        session.save(cartelRecord);

        transaction.commit();
    }

    public String findAllCartelRecord() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From CartelRecord: ");
        session.createQuery("from CartelRecord").getResultList().forEach(System.out::println);
        return null;
    }

}
