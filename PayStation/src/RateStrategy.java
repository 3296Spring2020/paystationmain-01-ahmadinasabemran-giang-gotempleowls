public interface RateStrategy {

    public double calculateTimeLinearRateStrategy(double moneyInserted);

    public double calculateTimeProgressiveRateStrategy(double moneyInserted);

    public double calculateTimeAlternatingRateStrategy(String dayOfTheWeek, double moneyInserted);

}
