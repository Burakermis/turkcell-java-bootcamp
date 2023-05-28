package projects.bootcamp.turkcell.application.base;

import projects.bootcamp.turkcell.application.services.CampaignServiceDao;
import projects.bootcamp.turkcell.core.base.Logger;
import projects.bootcamp.turkcell.entities.base.Campaign;

import java.util.List;

public class CampaignManager implements CampaignServiceDao {
    private List<Campaign> campaigns;
    private Logger logger;

    public CampaignManager(List<Campaign> campaigns, Logger logger) {
        this.campaigns = campaigns;
        this.logger = logger;
    }

    @Override
    public void create(Campaign campaign) {
        if (campaign.getDiscountRate() <= 100) {
            campaigns.add(campaign);
            System.out.println("Created campaign!");
        }

        logger.log();
    }

    @Override
    public void delete(Campaign campaign) {
        campaigns.remove(campaign);
        System.out.println("Deleted campaign!");
        logger.log();
    }

    @Override
    public void update(Campaign campaign) {
        int index = 0;
        for (Campaign c : campaigns) {
            if (c.getId() == campaign.getId()) {
                break;
            }
            index++;
        }

        campaigns.set(index, campaign);
        System.out.println("Updated campaign!");
        logger.log();
    }
}
