package march10.assessment.Task1.main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import march10.assessment.Task1.entity.Address;
import march10.assessment.Task1.entity.Employee;

public class JavaApp {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("employee-unit");

    public void addEmployee() {

        EntityManager em = emf.createEntityManager();

        Address address = new Address(1,"123 Main St","New York","10001");

        Employee emp =
                new Employee(101,"John Doe","john@example.com",50000,address);

        em.getTransaction().begin();
        em.persist(emp);
        em.getTransaction().commit();

        System.out.println("Employee added successfully");

        printEmployee(emp);

        em.close();
    }

    public void searchEmployee(int id) {

        EntityManager em = emf.createEntityManager();

        Employee emp = em.find(Employee.class,id);

        if(emp == null) {
            System.out.println("No employee found.");
            return;
        }

        printEmployee(emp);

        em.close();
    }

    public void updateSalary(int id,double salary) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Employee emp = em.find(Employee.class,id);

        if(emp != null) {
            emp.setSalary(salary);
            System.out.println("Employee salary updated successfully");
        }

        em.getTransaction().commit();

        em.close();
    }

    public void updateAddress(int id,String street,String city,String zip) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Employee emp = em.find(Employee.class,id);

        if(emp != null) {

            emp.getAddress().setStreet(street);
            emp.getAddress().setCity(city);
            emp.getAddress().setZipcode(zip);

            System.out.println("Address updated successfully");
        }

        em.getTransaction().commit();

        em.close();
    }

    public void deleteEmployee(int id) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Employee emp = em.find(Employee.class,id);

        if(emp != null) {
            em.remove(emp);
            System.out.println("Employee deleted successfully");
        }

        em.getTransaction().commit();

        em.close();
    }

    private void printEmployee(Employee e) {

        System.out.println("ID: " + e.getId());
        System.out.println("Name: " + e.getName());
        System.out.println("Email: " + e.getEmail());
        System.out.println("Salary: " + e.getSalary());

        System.out.println("Address:");
        System.out.println("  Street: " + e.getAddress().getStreet());
        System.out.println("  City: " + e.getAddress().getCity());
        System.out.println("  Zipcode: " + e.getAddress().getZipcode());
    }
}