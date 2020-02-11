package paystation.domain;

public interface RateStrategy {
    
    //These methods return int values because the lowest value is 1, for 1 minute
    public int calculateTimeLinear(int insertedSoFar);

    public int calculateTimeProgressive(int insertedSoFar);

    public int calculateTimeAlternating(int insertedSoFar);

}
