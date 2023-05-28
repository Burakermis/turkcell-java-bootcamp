package projects.bootcamp.turkcell.external.service.egovernment;

public class IdentityManager {
    public boolean validateIdentityNumber(String identityNumber) {
        return validateIfNumber(identityNumber) && validateIfIdentityNumber11Digits(identityNumber) && validateDigit10(identityNumber) && validateDigit11(identityNumber);
    }

    private boolean validateIfIdentityNumber11Digits(String identityNumber) {
        return identityNumber.length() == 11;
    }

    private boolean validateIfNumber(String identityNumber) {
        for (int i = 0; i < identityNumber.length(); i++) {
            if (!Character.isDigit(identityNumber.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    private boolean validateDigit10(String identityNumber) {
        int sumOfOddDigits = getSumOfOddDigitsUpTo9(identityNumber);
        int sumOfEvenDigits = getSumOfEvenDigitsUpTo9(identityNumber);
        int digit10 = Character.getNumericValue(identityNumber.charAt(9));

        return (sumOfOddDigits * 7 + sumOfEvenDigits * 9) % 10 == digit10;
    }

    private boolean validateDigit11(String identityNumber) {
        int sumOfOddDigits = getSumOfOddDigitsUpTo9(identityNumber);
        int sumOfDigitsUpTo10 = getSumOfDigitsUpTo10(identityNumber);
        int digit11 = Character.getNumericValue(identityNumber.charAt(10));

        return (sumOfOddDigits * 8) % 10 == digit11 && sumOfDigitsUpTo10 % 10 == digit11;
    }

    private int getSumOfOddDigitsUpTo9(String identityNumber) {
        int sumOfOddDigits = 0;

        for (int i = 0; i < 9; i = i + 2) {
            sumOfOddDigits += Character.getNumericValue(identityNumber.charAt(i));
        }

        return sumOfOddDigits;
    }

    private int getSumOfEvenDigitsUpTo9(String identityNumber) {
        int sumOfEvenDigits = 0;

        for (int i = 1; i < 9; i = i + 2) {
            sumOfEvenDigits += Character.getNumericValue(identityNumber.charAt(i));
        }

        return sumOfEvenDigits;
    }

    private int getSumOfDigitsUpTo10(String identityNumber) {
        int sumOfDigits = 0;

        for (int i = 0; i < 10; i++) {
            sumOfDigits += Character.getNumericValue(identityNumber.charAt(i));
        }

        return sumOfDigits;
    }
}
