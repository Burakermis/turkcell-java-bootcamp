package projects.bootcamp.turkcell.entities.users;

import projects.bootcamp.turkcell.entities.base.Game;
import projects.bootcamp.turkcell.entities.base.User;

import java.time.LocalDate;
import java.util.List;

public class Gamer extends User {

    // REMOVE GAMER ID
    private int gamerId;
    private String identityNumber;
    private String firstName;
    private String lastName;

    // CHANGED : CALENDAR => LOCALDATE
    private LocalDate dateOfBirth;
    private List<Game> purchasedGames;


    public Gamer() {
    }

    public Gamer(int gamerId, int roleId, String username, String email, String password) {
        super(gamerId, roleId, username, email, password);
    }

    public Gamer(int gamerId, int roleId, String username, String email, String password, String identityNumber, String firstName, String lastName, LocalDate dateOfBirth, List<Game> purchasedGames) {
        super(gamerId, roleId, username, email, password);
        this.gamerId = gamerId;
        this.identityNumber = identityNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.purchasedGames = purchasedGames;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Game> getPurchasedGames() {
        return purchasedGames;
    }

    public void setPurchasedGames(List<Game> purchasedGames) {
        this.purchasedGames = purchasedGames;
    }
}
