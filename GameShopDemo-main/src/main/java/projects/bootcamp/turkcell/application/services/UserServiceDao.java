package projects.bootcamp.turkcell.application.services;

import projects.bootcamp.turkcell.entities.base.User;

public interface UserServiceDao {
    //void create(User user);
    void delete(User user);
    void update(User user);
}
