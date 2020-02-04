import java.util.HashMap;
import java.util.Map;

public class PayStationImpl implements PayStation, RateStrategy {

    private int insertedSoFar;
    private int timeBought;
    private Map<Integer, Integer> coinMap = new HashMap<Integer, Integer>();
    private boolean nickleBool = false;
    private boolean dimeBool = false;
    private boolean quarterBool = false;
    private String[] WeekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    private String[] Weekend = {"Saturday", "Sunday"};

    @Override
    public void addPayment(int coinValue) throws IllegalCoinException {

        switch (coinValue) {
            case 5:
                if(!nickleBool)
                {
                    coinMap.put(1, 1);
                    nickleBool = true;
                }
                else
                {
                    coinMap.put(1, (int)coinMap.get(1) + 1);

                }
                break;

            case 10:
                if(!dimeBool)
                {
                    coinMap.put(2, 1);
                    dimeBool = true;
                }
                else
                {
                    coinMap.put(2, (int)coinMap.get(2) + 1);
                }
                break;

            case 25:
                if(!quarterBool)
                {
                    coinMap.put(3, 1);
                    quarterBool = true;
                }
                else
                {
                    coinMap.put(3, (int)coinMap.get(3) + 1);
                }
                break;

            default:
                throw new IllegalCoinException("Invalid coin: " + coinValue);
        }

        insertedSoFar += coinValue;

        timeBought = ((insertedSoFar / 5) * 2);

    }

    @Override
    public int readDisplay() {

        return timeBought;

    }

    @Override
    public ReceiptImpl buy() {

        ReceiptImpl r = new ReceiptImpl(timeBought);
        reset();
        return r;

    }

    @Override
    public Map<Integer, Integer> cancel() {

        Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>(coinMap);
        reset();
        return tempMap;

    }

    private void reset() {

        timeBought = insertedSoFar = 0;
        nickleBool = false;
        dimeBool = false;
        quarterBool = false;
        coinMap.clear();

    }

    @Override
    public int empty() {

        int total = insertedSoFar;
        insertedSoFar = 0;
        return total;

    }

    // Rate Strategies: Linear Rate Strategy, Progressive Rate Strategy, Alternating Rate Strategy
    // Implemented From The RateStrategy Interface

    @Override
    // Linear Rate Strategy
    // Implemented From The Rate Strategy Interface
    public double calculateTimeLinearRateStrategy(double moneyInserted) {

        double time;
        time = (moneyInserted * 2.0) / 5.0;
        return time;

    }

    @Override
    // Progressive Rate Strategy
    // Implemented From The Rate Strategy Interface
    public double calculateTimeProgressiveRateStrategy(double moneyInserted) {

        double time = 0.0;

        if(moneyInserted < 150.0) {
            time = ((moneyInserted * 2.0) / 5.0);
        }
        if((150.0 <= moneyInserted) && (moneyInserted < 350.0)) {
            time = (((moneyInserted - 150.0) * (3.0 / 10.0)) + 60.0);
        }
        if(moneyInserted >= 350.0) {
            time = (((moneyInserted - 350.0) / 5.0) + 120.0);
        }

        return time;

    }

    @Override
    // Alternating Rate Strategy
    // Implemented From The Rate Strategy Interface
    public double calculateTimeAlternatingRateStrategy(String dayOfTheWeek, double moneyInserted) {

        double time = 0.0;

        for (String weekDay : WeekDays)
            if (weekDay.equals(dayOfTheWeek)) {
                time = ((moneyInserted * 2.0) / 5.0);
                break;
            }

        for (String weekend : Weekend) {
            if (weekend.equals(dayOfTheWeek)) {
                if (moneyInserted < 150.0) {
                    time = ((moneyInserted * 2.0) / 5.0);
                }
                if ((150.0 <= moneyInserted) && (moneyInserted < 350.0)) {
                    time = (((moneyInserted - 150.0) * (3.0 / 10.0)) + 60.0);
                }
                if (moneyInserted >= 350.0) {
                    time = (((moneyInserted - 350.0) / 5.0) + 120.0);
                }
            }
        }

        return time;

    }
}
