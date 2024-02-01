import java.math.BigDecimal;
import java.math.RoundingMode;

public class PiPrimeFinder {

    public static void main(String[] args) {
        // Define the first 100 digits of Pi
        String piDigits = "3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679";

        // Remove the dot from the string and convert it to BigDecimal
        BigDecimal pi = new BigDecimal(piDigits.replace(".", ""));

        // Find the largest 5-digit prime number in the first 100 digits of Pi
        BigDecimal largestPrime = findLargest5DigitPrime(pi);

        System.out.println("Largest 5-digit prime number in the first 100 digits of Pi: " + largestPrime);
    }

    private static BigDecimal findLargest5DigitPrime(BigDecimal pi) {
        for (int i = 0; i <= pi.precision() - 5; i++) {
            // Extract a 5-digit substring from the BigDecimal
            BigDecimal subNumber = pi.setScale(i + 5, RoundingMode.FLOOR).subtract(pi.setScale(i, RoundingMode.FLOOR));

            // Check if the extracted number is a prime
            if (isPrime(subNumber.intValue())) {
                return subNumber;
            }
        }
        return BigDecimal.ZERO;  // If no prime is found
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
