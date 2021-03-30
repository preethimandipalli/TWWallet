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
        Currency rupee = new Currency(80,"rupees");
        Currency dollar = new Currency(1,"dollars");
        Wallet wallet = new Wallet();

        boolean actualValue = wallet.checkIfXDollarsIsEqualToYRupees(rupee,dollar);

        assertEquals(false,actualValue);
    }

    @Test
    void TestIfTotalAmountIsEqualToYRupees(){
        Currency rupee = new Currency(50,"rupees");
        Currency dollar = new Currency(1,"dollars");
        String preferredCurrency = "rupees";
        double expectedValue = 124.85;
        Wallet wallet = new Wallet();

        wallet.addCurrencyToWallet(rupee);
        wallet.addCurrencyToWallet(dollar);
        double actualValue = wallet.getTotalAmountInPreferredCurrency(preferredCurrency);

        assertEquals(expectedValue,actualValue);

    }

    @Test
    void TestIfTotalAmountIsEqualToYDollars(){
        Currency rupee = new Currency(74,"rupees");
        Currency dollar = new Currency(1,"dollars");
        String preferredCurrency = "dollars";
        double expectedAmount = 1.99;
        Wallet wallet = new Wallet();

        wallet.addCurrencyToWallet(rupee);
        wallet.addCurrencyToWallet(dollar);
        double actualAmount = wallet.getTotalAmountInPreferredCurrency(preferredCurrency);

        assertEquals(expectedAmount,actualAmount);

    }


}


