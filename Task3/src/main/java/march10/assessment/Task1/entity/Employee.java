package march10.assessment.Task1.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Employee {

    @Id
    private int id;
    private String name;
    private String email;
    private double salary;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public Employee() {}

    public Employee(int id, String name, String email, double salary, Address address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.address = address;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public double getSalary() { return salary; }
    public Address getAddress() { return address; }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}