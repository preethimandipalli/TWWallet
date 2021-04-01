package utility;

public class Currency {

    double currencyValue;
    String currencyType;
    double dollarValueInRupees=74.85;

    public Currency(double currencyValue,String currencyType){
        this.currencyType=currencyType;
        this.currencyValue=currencyValue;
    }

    double convertOneCurrencyToOther(String type) {
        if(currencyType.equals("rupees") && type.equals("dollars") ) {
            return currencyValue / dollarValueInRupees;
        }
        System.out.println(currencyValue * dollarValueInRupees);
        return  currencyValue * dollarValueInRupees;
    }


}
