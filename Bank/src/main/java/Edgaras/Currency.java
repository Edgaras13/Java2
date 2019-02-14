package Edgaras;

public enum Currency {
    EUR(1.00),
    USD(0.88288),
    GBP(1.14205),
    JPY(0.00804);

    private double rate;

    Currency(double rate){
        this.rate = rate;
    }

    public double getRate(){
        return rate;
    }
}
