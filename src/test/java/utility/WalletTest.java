package utility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class WalletTest {
    @Test
    void TestIf1DollarEqualToNRupees() {
        Currency rupee = new Currency(74.85,"rupees");
        Currency dollar = new Currency(1,"dollars");
        Wallet wallet = new Wallet();

        boolean actualValue = wallet.checkIfXDollarsIsEqualToYRupees(dollar,rupee);

        assertEquals(true,actualValue);
    }

    @Test
    void TestIf1DollarNotEqualToNRupees() {
        Currency rupee = new Currency(80,"rupees");
        Currency dollar = new Currency(1,"dollars");
        Wallet wallet = new Wallet();

        boolean actualValue = wallet.checkIfXDollarsIsEqualToYRupees(dollar,rupee);

        assertEquals(false,actualValue);
    }

    @Test
    void TestIfTotalAmountIsEqualToYRupees(){
        Currency rupee = new Currency(50,"rupees");
        Currency dollar = new Currency(1,"dollars");
        String preferredCurrency = "rupees";
        double expectedValue = 124.85;
        Wallet wallet = new Wallet();

        wallet.addCurrencyAmountToWallet(rupee);
        wallet.addCurrencyAmountToWallet(dollar);
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

        wallet.addCurrencyAmountToWallet(rupee);
        wallet.addCurrencyAmountToWallet(dollar);
        double actualAmount = wallet.getTotalAmountInPreferredCurrency(preferredCurrency);

        assertEquals(expectedAmount,actualAmount);

    }

    @Test
    void TestIfTotalAmountDepositedIsEqualToYDollars(){
        Currency rupee1 = new Currency(74.85,"rupees");
        Currency dollar = new Currency(1,"dollars");
        Currency rupee2 = new Currency(149.7,"rupees");
        String preferredCurrency = "dollars";
        double expectedValue = 4;
        Wallet wallet = new Wallet();

        wallet.addCurrencyAmountToWallet(rupee1);
        wallet.addCurrencyAmountToWallet(dollar);
        wallet.addCurrencyAmountToWallet(rupee2);
        double actualValue = wallet.getTotalAmountInPreferredCurrency(preferredCurrency);

        assertEquals(expectedValue,actualValue);

    }
    @Test
    void TestAmountWithdrawnInRupees(){
        Currency depositAmountInRupee = new Currency(74.85,"rupees");
        Currency depositAmountInDollar = new Currency(1,"dollars");
        Currency withdrawAmountInRupee = new Currency(2,"rupees");
        String expectedValue = "Remaining Balance : 147.7";
        Wallet wallet = new Wallet();

        wallet.addCurrencyAmountToWallet(depositAmountInRupee);
        wallet.addCurrencyAmountToWallet(depositAmountInDollar);
        String actualValue = wallet.withDrawAmount(withdrawAmountInRupee);

        assertEquals(expectedValue,actualValue);

    }
    @Test
    void TestAmountWithdrawnInDollars(){
        Currency depositAmountInRupee = new Currency(74.85,"rupees");
        Currency depositAmountInDollar = new Currency(1,"dollars");
        Currency withdrawAmountInDollar = new Currency(2,"dollars");
        String expectedValue = "Remaining Balance : 0.0";
        Wallet wallet = new Wallet();

        wallet.addCurrencyAmountToWallet(depositAmountInRupee);
        wallet.addCurrencyAmountToWallet(depositAmountInDollar);
        String actualValue = wallet.withDrawAmount(withdrawAmountInDollar);

        assertEquals(expectedValue,actualValue);

    }
    @Test
    void TestThrowsExceptionIfBalanceIsInsufficient(){
        Currency depositAmountINRupee = new Currency(74.85,"rupees");
        Currency depositAmountInDollar = new Currency(1,"dollars");
        Currency withdrawAmountInRupee = new Currency(500,"rupees");
        String expectedMsg = "Balance insufficient";
        Wallet wallet = new Wallet();

        wallet.addCurrencyAmountToWallet(depositAmountINRupee);
        wallet.addCurrencyAmountToWallet(depositAmountInDollar);

        Throwable exception= Assertions.assertThrows(RuntimeException.class, () -> { wallet.withDrawAmount(withdrawAmountInRupee); });
        assertEquals(expectedMsg,exception.getMessage());

    }

}


