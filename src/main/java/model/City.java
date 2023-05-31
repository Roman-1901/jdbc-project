package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name =  "City")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int city_id;
    private String city_name;
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Employee> employees;

    @Override
    public String toString() {
        return "City{" +
                "city_id=" + city_id +
                ", city_name='" + city_name + '\'' +
                '}';
    }
}
