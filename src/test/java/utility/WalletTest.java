package utility;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WalletTest {
    @Test
    void TestIf1DollarEqualToNRupees() {
        Currency rupee = new Currency(1,"rupees");
        Currency dollar = new Currency(74.85,"dollars");
        Wallet wallet = new Wallet();
        
        boolean actualValue = wallet.checkIfXDollarsIsEqualToYRupees(rupee,dollar);

        assertEquals(true,actualValue);
    }

    @Test
    void TestIf1DollarNotEqualToNRupees() {
        Currency rupee = new Currency(1,"rupees");
        Currency dollar = new Currency(80,"dollars");
        Wallet wallet = new Wallet();

        boolean actualValue = wallet.checkIfXDollarsIsEqualToYRupees(rupee,dollar);

        assertEquals(false,actualValue);
    }


}


