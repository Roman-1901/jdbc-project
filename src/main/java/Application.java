import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.City;
import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {
        final String user = "postgres";
        final String password = "qwer";
        final String url = "jdbc:postgresql://localhost:5432/skypro";
        int id = 11;

        // ЗАДАНИЕ 1
//        try (Connection connection = DriverManager.getConnection(url, user, password);
//             PreparedStatement statement = connection.prepareStatement("SELECT e.*, c.city_name FROM employee e JOIN city c ON e.city_id = c.city_id WHERE id = (?)")
//        ) {
//            statement.setInt(1, id);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                System.out.print("id: " + resultSet.getInt("id") + "; first_name: " + resultSet.getString("first_name") + "; last_name: " + resultSet.getString("last_name") + "; " +
//                        "gender: " + resultSet.getString("gender") + "; age: " +resultSet.getInt("age") + "; city: " + resultSet.getString("city_name"));
//                System.out.println();
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }


        //ЗАДАНИЕ 2
        Connection connection = DriverManager.getConnection(url, user, password);
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl(connection);

        //Создание(добавление) сущности Employee в таблицу
        Employee employee = new Employee(10, "Roman", "Nasibullin", "Male", 34, 1);
        employeeDAO.create(employee);

        //Получение конкретного объекта Employee по id
       System.out.println(employeeDAO.findById(5));

        //Получение списка всех объектов Employee из базы
        List<Employee> employees = new ArrayList<>(employeeDAO.findAll());
        for(Employee empl : employees) {
            System.out.println(empl);
        }

        //Изменение конкретного объекта Employee в базе по id
        employeeDAO.updateById(11, "Svetlana", "Ignateva", "Female", 32, 2);

        //Удаление конкретного объекта Employee из базы по id
        employeeDAO.deleteById(10);
    }
}
