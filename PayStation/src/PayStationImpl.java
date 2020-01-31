import java.util.HashMap;
import java.util.Map;

public class PayStationImpl implements PayStation {

    private int insertedSoFar;
    private int timeBought;
    private Map coinMap = new HashMap();
    private boolean nickleBool = false;
    private boolean dimeBool = false;
    private boolean quarterBool = false;

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
    public Receipt buy() {

        Receipt r = new ReceiptImpl(timeBought);
        reset();
        return r;

    }

    @Override
    public Map<Integer, Integer> cancel() {

        Map tempMap =  new HashMap();
        tempMap.putAll(coinMap);
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
}
