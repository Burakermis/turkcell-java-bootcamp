package projects.bootcamp.turkcell.application.users;

import projects.bootcamp.turkcell.application.base.UserManager;
import projects.bootcamp.turkcell.core.base.Logger;
import projects.bootcamp.turkcell.entities.base.User;

import java.util.List;

public class PublisherManager extends UserManager {
    public PublisherManager(List<User> users, Logger logger) {
        super(users, logger);
    }
}
