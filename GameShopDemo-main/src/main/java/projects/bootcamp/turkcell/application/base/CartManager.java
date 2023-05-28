package projects.bootcamp.turkcell.application.base;

import projects.bootcamp.turkcell.core.base.Logger;
import projects.bootcamp.turkcell.entities.base.Campaign;
import projects.bootcamp.turkcell.entities.base.Cart;
import projects.bootcamp.turkcell.entities.base.Game;
import projects.bootcamp.turkcell.entities.users.Gamer;

import java.util.*;

public class CartManager {
    private Cart cart;
    private final Logger logger;

    public CartManager(Cart cart, Logger logger) {
        this.cart = cart;
        this.logger = logger;
    }

    public void addGameToCart(Game game, Gamer gamer, Cart cart) {
        List<Game> purchasedGames;
        if (cart.getGames() == null) {
            purchasedGames = new ArrayList<>();
        } else {
            purchasedGames = cart.getGames();
        }

        purchasedGames.add(game);
        cart.setId(1);
        cart.setUserId(gamer.getId());
        cart.setGames(purchasedGames);
        logger.log();
    }

    public void buy(Gamer gamer) {
        List<Game> purchasedGames = new ArrayList<>();
        if (gamer.getPurchasedGames() == null) {
            gamer.setPurchasedGames(new ArrayList<>());
        } else {
            purchasedGames = gamer.getPurchasedGames();
        }

        for (Game game : cart.getGames()) {
            game.setPrice(discount(game.getPrice(), cart.getCampaign().getDiscountRate()));
            purchasedGames.add(new Game(game.getId(), game.getName(), game.getPrice(), game.getReleaseDate(), game.getPublisher(), game.getCategories()));
        }

        gamer.setPurchasedGames(purchasedGames);
        cart.setGames(null);
        logger.log();
    }

    public void addCampaignToCart(Campaign campaign) {
        cart.setCampaign(campaign);
        logger.log();
    }

    public double discount(double totalPrice, int discountRate) {
        totalPrice -= (totalPrice * discountRate) / 100;
        return totalPrice;
    }
}
