
package demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Bogdan Buzac
 */
@Entity
@Table(name="car_inventory")
public class CarInventory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String brand;

    @Column
    private String model;

    @Column
    private String body;

    @Column
    private Date registration;

    @Column
    private Integer year;

    @Column
    private String power;

    @Column
    private String fuel;

    @Column
    private Long kilometers;

    @Column
    private String description;

    @Column
    private Double price;

    public CarInventory() {
        // default constructor for hibernate mapping
    }

    public CarInventory(Long id, String brand, String model, Integer year, String fuel, String body, Double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuel = fuel;
        this.body = body;
        this.price = price;
    }

    public CarInventory(Long id, String brand, String model, String body, Date registration, Integer year, String power, String fuel, Long kilometers, String description, Double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.body = body;
        this.registration = registration;
        this.year = year;
        this.power = power;
        this.fuel = fuel;
        this.kilometers = kilometers;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getRegistration() {
        return registration;
    }

    public void setRegistration(Date registration) {
        this.registration = registration;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public Long getKilometers() {
        return kilometers;
    }

    public void setKilometers(Long kilometers) {
        this.kilometers = kilometers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}