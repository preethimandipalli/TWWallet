package utility;

import java.util.HashMap;

public class Wallet {

    double totalBalanceInRupees;
    HashMap<String,Double> currencyValuesInRupees= new HashMap<>();

    public Wallet(){
        currencyValuesInRupees.put("dollar",74.85);
    }

    public boolean checkIfXDollarsIsEqualToYRupees(Currency dollar,Currency rupee) {
        if(rupee.currencyValue == (convertDollarsToRupees(dollar.currencyValue))){
            return true;
        }
        return false;
    }

   private double convertDollarsToRupees(double dollars) {
        return dollars * currencyValuesInRupees.get("dollar");
    }

    private double convertRupeesToDollars(double currencyValue) {
        return currencyValue/currencyValuesInRupees.get("dollar");
    }

    public void addCurrencyAmountToWallet(Currency currency) {
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
