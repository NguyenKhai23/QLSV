package model;

import java.time.LocalDate;


public class Person {
    private Integer id;
    private String name;
    private LocalDate dateOfBirth;
    private String address;
    private Float height;
    private Float weight;

    static int count = 1;

    // khoi tao constructor
    public Person() {

    }

    public Person(String name, LocalDate dateOfBirth, String address, Float height, Float weight) {
        this.id = count++;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.height = height;
        this.weight = weight;
    }

    // khoi tao getter va setter
    public void setId(Integer id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getHeight() {
        return height;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getWeight() {
        return weight;
    }

    // phuong thuc toString

    public String toString() {
        return "\n{ " + " id = " + id + " | " + " name = " + name + " | " + " dateOfBirth = " + dateOfBirth + " | " +
                " address = " + address + " | " + " height = " + height + " | " + " weight = " + weight + " }";
    }
   
}
