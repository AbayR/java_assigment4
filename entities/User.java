package entities;

import javax.swing.*;
import java.util.Date;

public class User {
    private int id;
    private String name;
    private Double price;
    private Date expiration_date;
    private String manufacturer;
    private String usage;

    public User() {

    }

    public User(String name, Double price, Date expiration_date, String manufacturer, String usage) {
        setName(name);
        setPrice(price);
        setExpiration_date(expiration_date);
        setManufacturer(manufacturer);
        setUsage(usage);
    }

    public User(int id, String name, Double price, Date expiration_date, String manufacturer, String usage) {
        setId(id);
        setPrice(price);
        setExpiration_date(expiration_date);
        setManufacturer(manufacturer);
        setUsage(usage);
    }

    public User(String name, Double price, Double expiration_date, String manufacturer, String usage) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", expiration date=" + (expiration_date) + '\'' +
                ", manufacturer=" + (manufacturer) + '\'' +
                ", usage=" + (usage) +
                '}';
    }
}