package march10.assessment.Task1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Address {

    @Id
    private int id;
    private String street;
    private String city;
    private String zipcode;

    @OneToOne(mappedBy = "address")
    private Employee employee;

    public Address() {}

    public Address(int id, String street, String city, String zipcode) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
    }

    public String getStreet() { return street; }
    public String getCity() { return city; }
    public String getZipcode() { return zipcode; }

    public void setStreet(String street) { this.street = street; }
    public void setCity(String city) { this.city = city; }
    public void setZipcode(String zipcode) { this.zipcode = zipcode; }
}