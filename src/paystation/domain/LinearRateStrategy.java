package paystation.domain;

public class LinearRateStrategy implements RateStrategy {

    private int moneyInserted = 0;
    private int time = 0;

    public LinearRateStrategy(int moneyInserted) {
        this.moneyInserted = moneyInserted;
    }

    @Override
    public int calculateTime(int moneyInserted) {
        return 0;
    }
}
