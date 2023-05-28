package projects.bootcamp.turkcell.entities.base;

import projects.bootcamp.turkcell.entities.users.Publisher;

import java.util.Date;
import java.util.List;

public class Game {
    private int id;
    private String name;
    private double price;
    private Date releaseDate;
    private Publisher publisher;
    private List<Category> categories;

    public Game(int id, String name, double price, Date releaseDate, Publisher publisher, List<Category> categories) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.releaseDate = releaseDate;
        this.publisher = publisher;
        this.categories = categories;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
