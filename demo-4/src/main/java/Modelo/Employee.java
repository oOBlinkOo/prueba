package Modelo;

/**
 * Created by oOBlinkOo on 7/13/15.
 */
import javax.persistence.*;

@Entity
@Table
public class Employee {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String department;


    public Employee() {}

    public Employee(String name, String  department) {
        this.name = name;
        this.department = department;
    }


    public Employee(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String name) {
        this.department = name;
    }





}