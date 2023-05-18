package dao;

import model.Employee;

import java.util.List;

public interface EmployeeDAO {
    void create (Employee employee);
    Employee findById(int id);
    List<Employee> findAll();
    void updateById(int id, String first_name, String last_name, String gender, int age, int city_id);
    void deleteById(int id);
}
