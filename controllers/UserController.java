package controllers;
import entities.User;
import respositories.interfaces.IUserRepository;

import java.util.List;

public class UserController {
    private final IUserRepository repo;

    public UserController(IUserRepository repo) {
        this.repo = repo;
    }

    public String createUser(String name, Double price, Double expiration_date, String manufacturer, String usage) {
        User user = new User(name, price, expiration_date, manufacturer, usage);

        boolean created = repo.createUser(user);

        return (created ? "Medicine was created!" : "Medicine creation was failed!");
    }

    public String getUser(int id) {
        User user = repo.getUser(id);

        return (user == null ? "Medicine was not found!" : user.toString());
    }

    public String getAllUsers() {
        List<User> users = repo.getAllUsers();

        return users.toString();
    }
}