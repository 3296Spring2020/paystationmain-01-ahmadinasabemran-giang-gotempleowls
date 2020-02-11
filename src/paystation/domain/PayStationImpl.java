package paystation.domain;

import java.util.HashMap;
import java.util.Map;

public class PayStationImpl implements PayStation {
    
    private int insertedSoFar;
    private int timeBought;
    private Map<Integer, Integer> coinMap = new HashMap<Integer, Integer>();
    private boolean nickleBool = false;
    private boolean dimeBool = false;
    private boolean quarterBool = false;

    //int related to the RateStrategy being used
    //Depending on the value here, use a different timeCalculate method
    private int currentRate = 1;
    
    public static RateStrategyImpl rs;
    public void setup(){
        rs = new RateStrategyImpl();
    }
    
    @Override
    public void addPayment(int coinValue) throws IllegalCoinException {
        setup();
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

        //Make a call to different rateStrategies here based on currentRate
        switch(currentRate){
            case 1: //Linear rate strategy, Alphatown
                timeBought = rs.calculateTimeLinear(insertedSoFar);
                break;
            case 2: //Progressive rate strategy, Betatown
                timeBought = rs.calculateTimeProgressive(insertedSoFar);
                break;
            case 3: //Alternating rate strategy, Gammatown
                timeBought = rs.calculateTimeAlternating(insertedSoFar);
                break;
        }

    }
    
    @Override
    public int getInsertedSoFar(){
        return insertedSoFar;
    }
    
    @Override
    public int changeRate(int rate){
        setup();
        //Changes the value of currentRate if rate is a valid value
        //If rate is not a valid value, return -1
        if(rate >= 1 && rate <= 3){
            currentRate = rate;
            //After changing the rate, also change the value for timeBought
            switch(currentRate){
            case 1: //Linear rate strategy, Alphatown
                timeBought = rs.calculateTimeLinear(insertedSoFar);
                break;
            case 2: //Progressive rate strategy, Betatown
                timeBought = rs.calculateTimeProgressive(insertedSoFar);
                break;
            case 3: //Alternating rate strategy, Gammatown
                timeBought = rs.calculateTimeAlternating(insertedSoFar);
                break;
            }
            return rate;
        }
        return -1;
        
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
    
}
