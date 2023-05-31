package dao;

import model.City;
import model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class CityDAOImpl implements CityDao{
    @Override
    public void create(City city) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try (session) {
            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
        }
    }

    @Override
    public City findById(int city_id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try (session) {
            return session.get(City.class, city_id);
        }
    }

    @Override
    public List<City> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try (session) {
            return session.createQuery("FROM City ").list();
        }
    }

    @Override
    public void update(City city) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try (session) {
            Transaction transaction = session.beginTransaction();
            session.update(city);
            transaction.commit();
        }
    }

    @Override
    public void delete(City city) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try (session) {
            Transaction transaction = session.beginTransaction();
            session.delete(city);
            transaction.commit();
        }
    }
}
