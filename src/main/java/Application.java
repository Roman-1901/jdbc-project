import dao.CityDAOImpl;
import dao.CityDao;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.City;
import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {

        CityDao cityDao = new CityDAOImpl();
        //добавление города
        City cityNew = new City();
        cityNew.setCity_name("Ижевск");
        cityDao.create(cityNew);
        //поиск города по id
        City findCity = cityDao.findById(15);
        System.out.println(findCity);
        //список всех городов
        List<City> findAll = cityDao.findAll();
        for (City city : findAll) {
            System.out.println(city);
        }
        //изменить информацию по городу
        City update = cityDao.findById(15);
        update.setCity_name("Омск");
        cityDao.update(update);
        //удалить город
        City deleteCity = cityDao.findById(15);
        cityDao.delete(deleteCity);








//---------------------------------------------------------ЧЕРНОВИК
//        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
//        City findCity = cityDao.findById(2);
//
//        Employee empNew = new Employee(1, "Test2", "Test2", "Female", 45, findCity);
//        employeeDAO.create(empNew);

//        City city = cityDao.findById(1);
//        System.out.println(city);


//        Employee empNew2 = new Employee(1, "Test2", "Test2", "Female", 45, city);
//        employeeDAO.create(empNew2);

//        Employee empNew1 = employeeDAO.findById(14);
//        Employee empNew2 = employeeDAO.findById(17);
 //       employeeDAO.delete(empNew1);
//        employeeDAO.delete(empNew2);





        //Создание объектов сотрудников
//        Employee empNew1 = new Employee(1, "Ivan", "Ivanov", "Male", 25, city1);
//        employeeDAO.create(empNew1);
//
//        Employee empNew2 = new Employee(1, "Sergey", "Petrov", "Male", 45, city2);
//        employeeDAO.create(empNew2);


        //Обновление cотрудника
//        Employee empUpdate = employeeDAO.findById(9);
//        empUpdate.setFirst_name("Nadeshda");
//        empUpdate.setLast_name("Nosova");
//        empUpdate.setGender("Female");
//        empUpdate.setAge(29);
//        employeeDAO.update(empUpdate);
//
//        //Удаление
//        Employee empDelete = employeeDAO.findById(6);
//        employeeDAO.delete(empDelete);
//
//        //Вывод всего списка
//        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
//        List<Employee> employees = employeeDAO.findAll();
//        employees.stream().forEach(System.out::println);

 //      City city1 = cityDao.findById(7);
 //       cityDao.delete(city);



    }


}
