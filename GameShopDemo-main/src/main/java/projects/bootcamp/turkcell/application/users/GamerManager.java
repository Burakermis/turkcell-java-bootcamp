package projects.bootcamp.turkcell.application.users;

import projects.bootcamp.turkcell.adapters.EGovernmentServiceAdapter;
import projects.bootcamp.turkcell.application.base.UserManager;
import projects.bootcamp.turkcell.application.services.UserServiceDao;
import projects.bootcamp.turkcell.core.base.Logger;
import projects.bootcamp.turkcell.entities.base.User;
import projects.bootcamp.turkcell.entities.users.Gamer;

import java.util.List;

public class GamerManager extends UserManager {

    private static EGovernmentServiceAdapter eGovernmentServiceAdapter;
    List<User> users;

    public GamerManager(List<User> users, Logger logger) {
        super(users, logger);
        this.users = users;
        eGovernmentServiceAdapter = new EGovernmentServiceAdapter();
    }

    //@Override
    public boolean create(Gamer gamer) {
        if (eGovernmentServiceAdapter.checkIfRealPerson(gamer)) {
            super.create(gamer);
            return true;
        }

        System.out.println("T.C. Kimlik No doğrulaması başarısız oldu!");
        return false;
    }

    public boolean update(Gamer gamer) {
        if (eGovernmentServiceAdapter.checkIfRealPerson(gamer)) {
            super.update(gamer);
            return true;
        }

        System.out.println("T.C. Kimlik No doğrulaması başarısız oldu!");
        return false;
    }


}
