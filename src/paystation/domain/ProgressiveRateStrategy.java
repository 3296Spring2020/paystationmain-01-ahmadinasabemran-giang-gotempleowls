package paystation.domain;

public class ProgressiveRateStrategy implements RateStrategy {

    private int moneyInserted = 0;
    private int time = 0;

    public ProgressiveRateStrategy(int moneyInserted) {
        this.moneyInserted = moneyInserted;
    }

    @Override
    public int calculateTime(int moneyInserted) {
        return 0;
    }
}
