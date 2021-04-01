package utility;
import java.util.ArrayList;

public class Wallet {

    double totalBalanceInRupees;
    ArrayList<Currency> listOfCurrencies = new ArrayList<>();
    double dollarValueInRupees = 74.85;

    public boolean checkIfXDollarsIsEqualToYRupees(Currency dollar, Currency rupee) {
        if (rupee.currencyValue == (dollar.convertOneCurrencyToOther("rupees"))) {
            return true;
        }
        return false;
    }

    public void addCurrencyAmountToWallet(Currency currency) {
        listOfCurrencies.add(currency);
        if (currency.currencyType.equals("rupees")) {
            totalBalanceInRupees += currency.currencyValue;
        } else {
            totalBalanceInRupees += currency.convertOneCurrencyToOther("rupees");
        }
    }

    public double getTotalAmountInPreferredCurrency(String preferredCurrency) {

        if (preferredCurrency.equals("rupees")) {
            return Double.parseDouble(String.format("%.2f", totalBalanceInRupees));

        }
        return Double.parseDouble(String.format("%.2f", totalBalanceInRupees / dollarValueInRupees));

    }


    public String withDrawAmount(Currency withDrawCurrency)  {

        double withdrawAmount=withDrawCurrency.currencyValue;
        if(withDrawCurrency.currencyType.equals("dollars")){
             withdrawAmount = withDrawCurrency.convertOneCurrencyToOther("rupees");
        }
        if(withdrawAmount > totalBalanceInRupees){
            throw new RuntimeException("Balance insufficient");
        }
        else{
            totalBalanceInRupees -= withdrawAmount;
            return "Remaining Balance : "+getTotalAmountInPreferredCurrency(withDrawCurrency.currencyType);
        }

    }
}
