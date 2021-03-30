package utility;

public class Wallet {

    double dollarValueInRupees = 74.85;


    public boolean checkIfXDollarsIsEqualToYRupees(Currency dollar,Currency rupee) {
        if(rupee.currencyValue == (convertDollarsToRupees(dollar.currencyValue))){
            return true;
        }
        return false;
    }

    private double convertDollarsToRupees(double dollars) {
        return dollars * dollarValueInRupees;
    }
}
