package projects.bootcamp.turkcell.adapters;

import projects.bootcamp.turkcell.entities.users.Gamer;
import projects.bootcamp.turkcell.external.service.egovernment.EGovernmentService;

public class EGovernmentServiceAdapter {

    public EGovernmentServiceAdapter() {
    }

    public boolean checkIfRealPerson(Gamer gamer) {
        EGovernmentService eGovernmentService = new EGovernmentService();

        return eGovernmentService.validatePerson(gamer.getIdentityNumber(), gamer.getFirstName(), gamer.getLastName(), gamer.getDateOfBirth().getYear());
    }
}
