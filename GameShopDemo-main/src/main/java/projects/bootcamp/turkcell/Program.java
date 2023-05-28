package projects.bootcamp.turkcell;

import projects.bootcamp.turkcell.application.base.CampaignManager;
import projects.bootcamp.turkcell.application.base.CartManager;
import projects.bootcamp.turkcell.application.users.GamerManager;
import projects.bootcamp.turkcell.core.base.Logger;
import projects.bootcamp.turkcell.entities.base.*;
import projects.bootcamp.turkcell.entities.users.Gamer;

import java.time.LocalDate;
import java.util.*;

public class Program {
    List<User> users;
    List<Game> games;
    List<Campaign> campaigns;
    GamerManager gamerManager;
    CampaignManager campaignManager;
    CartManager cartManager;
    Logger logger;

    private static Scanner _scanner = new Scanner(System.in);

    public Program(List<User> users, List<Game> games, List<Campaign> campaigns, Cart cart, Logger logger) {
        this.users = users;
        this.games = games;
        this.campaigns = campaigns;
        this.logger = logger;

        gamerManager = new GamerManager(users, logger);
        campaignManager = new CampaignManager(campaigns, logger);
        cartManager = new CartManager(cart, logger);
    }

    public void displayRegistrationPage(Gamer gamer) {
        System.out.println("\n-------------------- REGISTRATION --------------------");
        createGamer(gamer);
        System.out.println("------------------------------------------------------");
    }

    public void displayUpdateUserPage(Gamer gamer) {
        System.out.println("\n-------------------- UPDATE USER --------------------");
        updateGamer(gamer);
        System.out.println("------------------------------------------------------");
    }

    public void displayDeleteGamerPage(Gamer gamer) {
        System.out.println("\n-------------------- DELETE USER --------------------");
        deleteGamer(gamer);
        System.out.println("------------------------------------------------------");
    }


    public void displayCreateCampaignPage(Campaign campaign) {
        System.out.println("\n-------------------- CREATE CAMPAIGN --------------------");
        createCampaign(campaign);
        System.out.println("---------------------------------------------------------");
    }

    public void displayUpdateCampaignPage(Campaign campaign) {
        System.out.println("\n------------------------------ UPDATE CAMPAIGN ------------------------------");
        listCampaigns();
        updateCampaign(campaign);
        System.out.println("-----------------------------------------------------------------------------");
    }

    public void displayDeleteCampaignPage(Campaign campaign) {
        System.out.println("\n------------------------------ DELETE CAMPAIGN ------------------------------");
        listCampaigns();
        deleteCampaign(campaign);
        System.out.println("-----------------------------------------------------------------------------");
    }

    public void displayBuyAGamePage(List<Game> games, Gamer gamer, Cart cart) {
        String option = "";
        System.out.println("\n-------------------- GAMES --------------------");
        listGames(games);
        System.out.println("-----------------------------------------------");
        System.out.println("Exit: (Press Any Key)");
        System.out.print("Choose a Game: ");
        option = _scanner.nextLine();
        if (!option.toLowerCase(Locale.ENGLISH).equals("exit")) {
            cartManager.addGameToCart(games.get(Integer.parseInt(option) - 1), gamer, cart);
        }
    }

    public void displayCartPage(Cart cart) {
        System.out.println("\n-------------------- CART --------------------");
        if (cart.getGames() != null && !cart.getGames().isEmpty()) {
            listGames(cart.getGames());
            System.out.println("----------------------------------------------");
            System.out.println("------------------------------ CAMPAIGNS ------------------------------");
            listCampaigns();
            System.out.println("------------------------------------------------------------------------");
            addCampaignToCart(cart);
            System.out.println("Checkout: (C)\tExit: (Press Any Key)");
            System.out.print("Choose an action: ");
        } else {
            System.out.println("Cart is empty!");
            System.out.println("----------------------------------------------");
            System.out.println("Exit: (Press 'Enter')");
            _scanner.nextLine();
        }
    }

    public void displayCheckoutPage(Cart cart) {
        double totalPrice = totalPrice(cart.getGames());
        System.out.println("\n-------------------- CHECKOUT --------------------");
        listGames(cart.getGames());
        System.out.println("--------------------------------------------------");
        System.out.println("TOTAL: " + discount(totalPrice, cart.getCampaign().getDiscountRate()) + " instead of " + totalPrice);
        System.out.println("--------------------------------------------------");
        System.out.println("Buy: (B)\tExit: (Press Any Key)");
        System.out.print("Choose an action: ");
    }

    public void displayOrdersPage(Gamer gamer) {
        System.out.println("-------------------- ORDERS --------------------");
        listGames(gamer.getPurchasedGames());
        System.out.println("------------------------------------------------");
        System.out.println("Exit: (Press 'Enter')");
        _scanner.nextLine();
    }


    public void createGamer(Gamer gamer) {
        gamer = new Gamer();
        gamer.setId(1);
        gamer.setRoleId(2);

        System.out.print("Enter Username: ");
        gamer.setUsername(_scanner.nextLine());

        System.out.print("Enter Email: ");
        gamer.setEmail(_scanner.nextLine());

        System.out.print("Enter Password: ");
        gamer.setPassword(_scanner.nextLine());

        System.out.print("Enter Identity Number: ");
        gamer.setIdentityNumber(_scanner.nextLine());

        System.out.print("Enter First Name: ");
        gamer.setFirstName(_scanner.nextLine());

        System.out.print("Enter Last Name: ");
        gamer.setLastName(_scanner.nextLine());

        System.out.print("Enter Birth Day: ");
        int day = Integer.parseInt(_scanner.nextLine());

        System.out.print("Enter Birth Month: ");
        int month = Integer.parseInt(_scanner.nextLine());

        System.out.print("Enter Birth Year: ");
        int year = Integer.parseInt(_scanner.nextLine());

        gamer.setDateOfBirth(LocalDate.of(year, month, day));

        if (!gamerManager.create(gamer)) {
            System.out.println("BURADA");
            gamer = null;
        }
    }

    public void updateGamer(Gamer gamer) {
        gamer.setId(1);
        gamer.setRoleId(2);

        System.out.print("Enter Username: ");
        gamer.setUsername(_scanner.nextLine());

        System.out.print("Enter Email: ");
        gamer.setEmail(_scanner.nextLine());

        System.out.print("Enter Password: ");
        gamer.setPassword(_scanner.nextLine());

        System.out.print("Enter Identity Number: ");
        gamer.setIdentityNumber(_scanner.nextLine());

        System.out.print("Enter First Name: ");
        gamer.setFirstName(_scanner.nextLine());

        System.out.print("Enter Last Name: ");
        gamer.setLastName(_scanner.nextLine());

        System.out.print("Enter Birth Day: ");
        int day = Integer.parseInt(_scanner.nextLine());

        System.out.print("Enter Birth Month: ");
        int month = Integer.parseInt(_scanner.nextLine());

        System.out.print("Enter Birth Year: ");
        int year = Integer.parseInt(_scanner.nextLine());

        gamer.setDateOfBirth(LocalDate.of(year, month, day));

        gamerManager.update(gamer);
    }

    public void deleteGamer(Gamer gamer) {
        gamerManager.delete(gamer);
        gamer = null;
        users.set(users.size() - 1, null);
    }


    public void createCampaign(Campaign campaign) {
        campaign.setId(campaigns.size());
        System.out.print("Enter Campaign Name: ");
        campaign.setName(_scanner.nextLine());

        System.out.print("Enter Campaign Description: ");
        campaign.setDescription(_scanner.nextLine());

        System.out.print("Enter Campaign Discount Rate: ");
        campaign.setDiscountRate(_scanner.nextInt());
        _scanner.nextLine(); // !!!!! CRUCIAL

        campaignManager.create(campaign);
    }

    public void updateCampaign(Campaign campaign) {
        campaign = chooseCampaignToProcess();
        campaign.setId(campaign.getId());
        System.out.print("Enter Campaign Name: ");
        campaign.setName(_scanner.nextLine());

        System.out.print("Enter Campaign Description: ");
        campaign.setDescription(_scanner.nextLine());

        System.out.print("Enter Campaign Discount Rate: ");
        campaign.setDiscountRate(_scanner.nextInt());
        _scanner.nextLine(); // !!!!! CRUCIAL

        campaignManager.update(campaign);
    }

    public void deleteCampaign(Campaign campaign) {
        campaign = chooseCampaignToProcess();
        campaignManager.delete(campaign);
        for (Campaign c : campaigns) {
            if (campaign.getName().equals(c.getName())) {
                campaigns.remove(campaign);
            }
        }
    }

    public void addCampaignToCart(Cart cart) {
        String option = "";
        System.out.print("Choose a Campaign: ");
        option = _scanner.nextLine();
        cartManager = new CartManager(cart, logger);
        cartManager.addCampaignToCart(campaigns.get(Integer.parseInt(option) - 1));
    }

    public Campaign chooseCampaignToProcess() {
        String option = "";
        System.out.print("Choose a Campaign: ");
        option = _scanner.nextLine();
        return campaigns.get(Integer.parseInt(option) - 1);
    }

    public void buy(Gamer gamer, Cart cart) {
        List<Double> prices = new ArrayList<>();
        for (Game game : games) {
            prices.add(game.getPrice());
        }

        cartManager = new CartManager(cart, logger);
        cartManager.buy(gamer);

        for (int i = 0; i < games.size(); i++) {
            games.get(i).setPrice(prices.get(i));
        }
    }

    public double discount(double totalPrice, int discountRate) {
        totalPrice -= (totalPrice * discountRate) / 100;
        return totalPrice;
    }

    public double totalPrice(List<Game> games) {
        double total = 0;
        for (Game game : games) {
            total += game.getPrice();
        }

        return total;
    }

    public void listGames(List<Game> games) {
        int index = 1;
        String categories = "";
        for (Game game : games) {
            for (Category category : game.getCategories()) {
                categories += category.getName() + ", ";
            }
            categories = categories.trim().substring(0, categories.length() - 2);

            System.out.println(index + ". " + game.getName() + " [" + categories + "] : $" + game.getPrice());
            index++;

            categories = "";
        }
    }

    public void listCampaigns() {
        int index = 1;
        for (Campaign campaign : campaigns) {
            System.out.println(index + ". " + campaign.getName() + " (" + campaign.getDescription() + ") - " + campaign.getDiscountRate() + "% discount.");
            index++;
        }
    }
}
