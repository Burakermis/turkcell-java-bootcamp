package projects.bootcamp.turkcell.entities.users;

import projects.bootcamp.turkcell.entities.base.User;

public class Admin extends User {
    public Admin(int id, int roleId, String username, String email, String password) {
        super(id, roleId, username, email, password);
    }

}
