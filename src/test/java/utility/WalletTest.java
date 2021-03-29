package utility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WalletTest {
    @Test
    void TestIf1DollarEqualToNRupees() {
        double dollars = 1;
        double rupees = 74.85;
        Wallet wallet = new Wallet(dollars,rupees);

        boolean actualValue = wallet.checkIfXDollarsIsEqualToYRupees();

        assertEquals(true,actualValue);
    }

    @Test
    void TestIf1DollarIsNotEqualTo75Dollars() {
        double dollars = 1;
        double rupees = 75;
        Wallet wallet = new Wallet(dollars,rupees);

        boolean actualValue = wallet.checkIfXDollarsIsEqualToYRupees();

        assertEquals(false,actualValue);
    }

}
