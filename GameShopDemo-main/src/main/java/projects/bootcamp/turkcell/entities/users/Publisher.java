package projects.bootcamp.turkcell.entities.users;

import projects.bootcamp.turkcell.entities.base.User;

public class Publisher extends User {
    private int publisherId;
    private String name;

    public Publisher() {
    }

    public Publisher(int id, int roleId, String username, String email, String password) {
        super(id, roleId, username, email, password);
    }

    public Publisher(int publisherId, int roleId, String username, String email, String password, String name) {
        super(publisherId, roleId, username, email, password);
        this.publisherId = publisherId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
