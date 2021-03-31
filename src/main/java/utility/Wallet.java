package utility;

import java.util.ArrayList;
import java.util.HashMap;

public class Wallet {

    double totalBalanceInRupees;
    ArrayList<Currency> listOfCurrencies = new ArrayList<>();
    HashMap<String,Double> currencyValuesInRupees= new HashMap<>();

    public Wallet(){
        currencyValuesInRupees.put("dollars",74.85);
    }

    public boolean checkIfXDollarsIsEqualToYRupees(Currency dollar,Currency rupee) {
        if(rupee.currencyValue == (convertOneCurrencyToOther(dollar,"rupees"))){
            return true;
        }
        return false;
    }


    private double convertOneCurrencyToOther(Currency currency, String expectedType){
        if(expectedType.equals("rupees")){
            return currency.currencyValue * currencyValuesInRupees.get(currency.currencyType);

        }
        else if(currency.currencyType.equals("rupees")){
            String expected=currency.currencyType;
            System.out.println(currencyValuesInRupees.get("dollars"));
            return currency.currencyValue / currencyValuesInRupees.get(expectedType);

        }
        else {
           double valueInRupees =  (convertOneCurrencyToOther(currency,"rupees"));
           return convertOneCurrencyToOther(new Currency(valueInRupees,"rupees"), expectedType);
        }

    }

    public void addCurrencyAmountToWallet(Currency currency) {
        listOfCurrencies.add(currency);
        if(currency.currencyType.equals("rupees")){
            totalBalanceInRupees += currency.currencyValue;
        }
        else{
            totalBalanceInRupees += convertOneCurrencyToOther(currency,"rupees");
        }

    }
    public double getTotalAmountInPreferredCurrency(String preferredCurrency) {

        if(preferredCurrency.equals("rupees")){

            return Double.parseDouble(String.format("%.2f", totalBalanceInRupees));

        }
        return Double.parseDouble(String.format("%.2f", convertOneCurrencyToOther(new Currency(totalBalanceInRupees,"rupees"),preferredCurrency)));

    }


}
