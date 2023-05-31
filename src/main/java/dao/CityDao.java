package dao;

import model.City;
import model.Employee;

import java.util.List;

public interface CityDao {
    void create (City city);
    City findById(int id);
    List<City> findAll();
    void update(City city);
    void delete(City city);
}
