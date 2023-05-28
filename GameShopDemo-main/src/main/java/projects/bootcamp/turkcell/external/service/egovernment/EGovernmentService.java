package projects.bootcamp.turkcell.external.service.egovernment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EGovernmentService {
    private final List<Person> people;

    private static final IdentityManager _identityManager = new IdentityManager();

    public EGovernmentService() {
        people = new ArrayList<>();
        people.add(new Person(1, "33412125832", "Sırrı", "KÖMÜR", LocalDate.of(1997, 8, 1)));
        people.add(new Person(2, "35878059836", "Engin", "DEMİROĞ", LocalDate.of(1985, 8, 1)));
        people.add(new Person(3, "24919422036", "Doğa", "YEŞİM", LocalDate.of(1990, 8, 1)));
    }

    public boolean validatePerson(String identityNumber, String firstName, String lastName, int yearOfBirth) {
        return validateIdentityNumber(identityNumber, firstName, lastName, yearOfBirth) && isExistPerson(identityNumber, firstName, lastName, yearOfBirth);
    }

    public boolean validateIdentityNumber(String identityNumber, String firstName, String lastName, int yearOfBirth) {
        boolean isValidateIdentityNumber = false;

        if (_identityManager.validateIdentityNumber(identityNumber)) {
            isValidateIdentityNumber = true;
        }

        return isValidateIdentityNumber;
    }

    public boolean isExistPerson(String identityNumber, String firstName, String lastName, int yearOfBirth) {
        boolean isExistPerson = false;

        for (Person person : people) {
            if (person.getIdentityNumber().toLowerCase(Locale.forLanguageTag("tr-TR")).equals(identityNumber.toLowerCase(Locale.forLanguageTag("tr-TR"))) &&
                    person.getFirstName().toLowerCase(Locale.forLanguageTag("tr-TR")).equals(firstName.toLowerCase(Locale.forLanguageTag("tr-TR"))) &&
                    person.getLastName().toLowerCase(Locale.forLanguageTag("tr-TR")).equals(lastName.toLowerCase(Locale.forLanguageTag("tr-TR"))) &&
                    person.getDateOfBirth().getYear() == yearOfBirth) {
                isExistPerson = true;
                break;
            }
        }

        return isExistPerson;
    }
}
