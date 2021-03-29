package utility;

public class Wallet {
    double dollars;
    double rupees;
    double dollarValueInRupees = 74.85;
    public Wallet(double dollars, double rupees) {
        this.dollars = dollars;
        this.rupees = rupees;
    }


    public boolean checkIfXDollarsIsEqualToYRupees() {
        if(convertDollarsToRupees() == rupees){
            return true;
        }
        return false;
    }

    private double convertDollarsToRupees() {
        return dollars*dollarValueInRupees;
    }
}
