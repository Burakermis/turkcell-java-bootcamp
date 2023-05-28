package projects.bootcamp.turkcell.application.services;

import projects.bootcamp.turkcell.entities.base.Campaign;
import projects.bootcamp.turkcell.entities.base.User;

public interface CampaignServiceDao {
    void create(Campaign campaign);
    void delete(Campaign campaign);
    void update(Campaign campaign);
}
