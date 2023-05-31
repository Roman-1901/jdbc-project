package dao;


import model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void create(Employee employee) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try (session) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }

    @Override
    public Employee findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try (session) {
            return session.get(Employee.class, id);
        }
    }

    @Override
    public List<Employee> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try (session) {
            return session.createQuery("FROM Employee").list();
        }
    }

    @Override
    public void update(Employee employee) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try (session) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }

    @Override
    public void delete(Employee employee) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try (session) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }
}
