package projects.bootcamp.turkcell;

import projects.bootcamp.turkcell.core.logging.DatabaseLogger;
import projects.bootcamp.turkcell.entities.base.*;
import projects.bootcamp.turkcell.entities.users.Gamer;
import projects.bootcamp.turkcell.entities.users.Publisher;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        /* INITIALIZING */
        List<User> users = new ArrayList<>();
        List<Game> games = new ArrayList<>();
        List<Campaign> campaigns = new ArrayList<>();
        Cart cart = new Cart();
        List<Game> gamesInCart = new ArrayList<>();

        /* ROLES */
        List<Role> roles = new ArrayList<>();
        roles.add(new Role(1, "Admin"));
        roles.add(new Role(2, "Gamer"));
        roles.add(new Role(3, "Publisher"));

        /* CATEGORIES */
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1, "Action"));
        categories.add(new Category(2, "War"));
        categories.add(new Category(3, "Strategy"));
        categories.add(new Category(4, "Sport"));

        /* PUBLISHERS */
        Publisher publisher1 = new Publisher(2, roles.get(2).getId(), "sega", "sega@gmail.com", "123", "SEGA");

        /* GAMES */
        Game game1 = new Game(1, "Half-Life", 100, new Date(), publisher1, Arrays.asList(categories.get(0), categories.get(1)));
        Game game2 = new Game(2, "Fifa", 200, new Date(), publisher1, Arrays.asList(categories.get(3)));
        Game game3 = new Game(3, "Age of Empires", 50, new Date(), publisher1, Arrays.asList(categories.get(1), categories.get(2)));

        games.add(game1);
        games.add(game2);
        games.add(game3);

        /* CAMPAIGNS */
        Campaign campaign1 = new Campaign(1, "National Video Games Day Campaign", "Don't miss out! Special offer.", 50);
        Campaign campaign2 = new Campaign(2, "10th Anniversary Campaign", "Celebrating our 10th anniversary.", 30);
        Campaign campaign3 = new Campaign(3, "Cyber Monday", "Biggest discount of the year.", 60);
        Campaign campaign4 = new Campaign(4, "Special For You", "Discount for you in the cart.", 10);

        campaigns.add(campaign1);
        campaigns.add(campaign2);
        campaigns.add(campaign3);
        campaigns.add(campaign4);

        /* UI */
        Program program = new Program(users, games, campaigns, cart, new DatabaseLogger());
        run(program, users, games, gamesInCart, cart);
    }

    public static void run(Program program, List<User> users, List<Game> games, List<Game> gamesInCart, Cart cart) {
        Gamer gamer = null;
        Campaign campaign = null;

        Scanner scanner = new Scanner(System.in);
        String option = "";
        while (!option.equalsIgnoreCase("exit")) {
            menu(users);
            option = scanner.nextLine();
            System.out.println();
            if (option.equalsIgnoreCase("1")) {
                gamer = new Gamer();
                program.displayRegistrationPage(gamer);
            } else if (option.equalsIgnoreCase("2")) {
                program.displayUpdateUserPage(gamer);
            } else if (option.equalsIgnoreCase("3")) {
                program.displayDeleteGamerPage(gamer);
            } else if (option.equalsIgnoreCase("4")) {
                campaign = new Campaign();
                program.displayCreateCampaignPage(campaign);
            } else if (option.equalsIgnoreCase("5")) {
                program.displayUpdateCampaignPage(campaign);
            } else if (option.equalsIgnoreCase("6")) {
                program.displayDeleteCampaignPage(campaign);
            } else if (option.equalsIgnoreCase("7")) {
                if (gamer != null) {
                    cart = new Cart(1, gamer.getId(), gamesInCart);
                    program.displayBuyAGamePage(games, gamer, cart);
                }
            } else if (option.equalsIgnoreCase("8")) {
                program.displayCartPage(cart);
                if (cart.getGames() != null && !cart.getGames().isEmpty()) {
                    option = scanner.nextLine();
                    if (option.equalsIgnoreCase("C")) {
                        program.displayCheckoutPage(cart);
                        option = scanner.nextLine();
                        if (option.equalsIgnoreCase("B")) {
                            program.buy(gamer, cart);
                            gamesInCart = new ArrayList<>();
                        }
                    }
                }
            } else if (option.equalsIgnoreCase("9")) {
                program.displayOrdersPage(gamer);
            }
        }
    }

    public static void menu(List<User> users) {
        System.out.println("\n--------------- USER ---------------");
        if (users.isEmpty() || users.get(users.size() - 1) == null) {
            System.out.println("Register as a gamer! (Press '1')");
        } else {
            System.out.println("Hello, " + users.get(users.size() - 1).getUsername());
        }
        System.out.println("------------------------------------");

        System.out.println("\n-------- MENU --------");
        if (users.isEmpty() || users.get(users.size() - 1) == null) {
            System.out.println("1. Register new Gamer");
        } else {
            System.out.println("1. Register new Gamer");
            System.out.println("2. Update Gamer");
            System.out.println("3. Delete Gamer");
            System.out.println("4. Create new Campaign");
            System.out.println("5. Update Campaign");
            System.out.println("6. Delete Campaign");
            System.out.println("7. Buy a game");
            System.out.println("8. Cart");
            System.out.println("9. Orders");
        }
        System.out.println("----------------------");
        System.out.println("Exit: (Type 'exit')");
        System.out.print("Choose an action: ");
    }
}



