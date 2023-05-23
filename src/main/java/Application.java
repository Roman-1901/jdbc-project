import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.City;
import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        //Создание
        Employee empNew = new Employee(1, "Ivan", "Ivanov", "Male", 25, 3);
        employeeDAO.create(empNew);

        //Обновление
        Employee empUpdate = employeeDAO.findById(6);
        empUpdate.setFirst_name("Petr");
        empUpdate.setLast_name("Petrov");
        employeeDAO.update(empUpdate);

        //Удаление
        Employee empDelete = employeeDAO.findById(12);
        employeeDAO.delete(empDelete);

        //Вывод всего списка
        List<Employee> employees = employeeDAO.findAll();
        employees.stream().forEach(System.out::println);
    }
}
