package projects.bootcamp.turkcell.entities.base;

import java.util.List;

public class Cart {
    private int id;
    private int userId;
    private List<Game> games;
    private Campaign campaign;

    public Cart() {
    }

    public Cart(int id, int userId, List<Game> games) {
        this.id = id;
        this.userId = userId;
        this.games = games;
    }

    public Cart(int id, int userId, List<Game> games, Campaign campaign) {
        this.id = id;
        this.userId = userId;
        this.games = games;
        this.campaign = campaign;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }
}
