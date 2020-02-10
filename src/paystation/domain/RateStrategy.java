package paystation.domain;

public interface RateStrategy {

    public int calculateTimeLinearRateStrategy(int insertedSoFar);

    public int calculateTimeProgressiveRateStrategy(int insertedSoFar);

    public int calculateTimeAlternatingRateStrategy(int insertedSoFar);

}
