package utility;

public class Wallet {

    double dollarValueInRupees = 74.85;
    double totalBalanceInRupees;

    public boolean checkIfXDollarsIsEqualToYRupees(Currency dollar,Currency rupee) {
        if(rupee.currencyValue == (convertDollarsToRupees(dollar.currencyValue))){
            return true;
        }
        return false;
    }

    private double convertDollarsToRupees(double dollars) {
        return dollars * dollarValueInRupees;
    }

    private double convertRupeesToDollars(double currencyValue) {
        return currencyValue/dollarValueInRupees;
    }

    public void addCurrencyToWallet(Currency currency) {
        if(currency.currencyType.equals("rupees")){
            totalBalanceInRupees += currency.currencyValue;
        }
        else{
            totalBalanceInRupees += convertDollarsToRupees(currency.currencyValue);
        }

    }
    public double getTotalAmountInPreferredCurrency(String preferredCurrency) {
        if(preferredCurrency.equals("rupees")){

            return Double.parseDouble(String.format("%.2f", totalBalanceInRupees));

        }
        return Double.parseDouble(String.format("%.2f", convertRupeesToDollars(totalBalanceInRupees)));

    }


}
