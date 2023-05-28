package projects.bootcamp.turkcell.application.base;

import projects.bootcamp.turkcell.application.services.UserServiceDao;
import projects.bootcamp.turkcell.core.base.Logger;
import projects.bootcamp.turkcell.entities.base.User;

import java.util.List;

public class UserManager implements UserServiceDao {
    protected static List<User> users;
    private final Logger logger;

    public UserManager(List<User> users, Logger logger) {
        UserManager.users = users;
        this.logger = logger;
    }

    protected void create(User user) {
        users.add(user);
        System.out.println("Created user: " + user.getUsername());
        logger.log();
    }

    @Override
    public void delete(User user) {
        users.remove(user);
        System.out.println("Deleted user!");
        logger.log();
    }

    @Override
    public void update(User user) {
        int index = 0;
        for (User u : users) {
            if (u.getId() == user.getId()) {
                break;
            }
            index++;
        }

        users.set(index, user);
        System.out.println("Updated user!");
        logger.log();
    }
}
