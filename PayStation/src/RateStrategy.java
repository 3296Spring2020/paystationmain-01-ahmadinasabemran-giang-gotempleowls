public interface RateStrategy {

    public int calculateTimeLinearRateStrategy(int moneyInserted);

    public int calculateTimeProgressiveRateStrategy(int moneyInserted);

    public int calculateTimeAlternatingRateStrategy(int moneyInserted);

}
