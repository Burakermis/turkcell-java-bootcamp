package projects.bootcamp.turkcell.application.services;

import projects.bootcamp.turkcell.entities.base.User;

public interface UserCheckService {
    boolean checkIfRealPerson(User user);
}
