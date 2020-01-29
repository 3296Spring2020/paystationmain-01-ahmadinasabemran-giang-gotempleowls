package paystation.domain;
import java.util.*;

/**
 * Implementation of the pay station.
 *
 * Responsibilities:
 *
 * 1) Accept payment; 
 * 2) Calculate parking time based on payment; 
 * 3) Know earning, parking time bought; 
 * 4) Issue receipts; 
 * 5) Handle buy and cancel events.
 *
 * This source code is from the book "Flexible, Reliable Software: Using
 * Patterns and Agile Development" published 2010 by CRC Press. Author: Henrik B
 * Christensen Computer Science Department Aarhus University
 *
 * This source code is provided WITHOUT ANY WARRANTY either expressed or
 * implied. You may study, use, modify, and distribute it for non-commercial
 * purposes. For any commercial use, see http://www.baerbak.com/
 */
public class PayStation{

    private int insertedSoFar = 0;
    private int timeBought = 0;
    private Map coinMap = new HashMap();
    private boolean nickleBool = false;
    private boolean dimeBool = false;
    private boolean quarterBool = false;
    private int value = 0;
    private int moneyInserted = 0;
    private int time = 0;
    private String dayOfTheWeek;
    private String[] WeekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    private String[] Weekend = {"Saturday", "Sunday"};

    public PayStation() {}

    public PayStation(int timeBought) {
        this.timeBought = timeBought;
    }

    public PayStation (String dayOfTheWeek, int moneyInserted) {
        this.dayOfTheWeek = dayOfTheWeek;
        this.moneyInserted = moneyInserted;
    }

    public void addPayment(int coinValue)
            throws IllegalCoinException {

        switch (coinValue) {
            case 5:
                if (!nickleBool) {
                    coinMap.put(1, 1);
                    nickleBool = true;
                } else {
                    coinMap.put(1, (int) coinMap.get(1) + 1);

                }
                break;
            case 10:
                if (!dimeBool) {
                    coinMap.put(2, 1);
                    dimeBool = true;
                } else {
                    coinMap.put(2, (int) coinMap.get(2) + 1);
                }
                break;
            case 25:
                if (!quarterBool) {
                    coinMap.put(3, 1);
                    quarterBool = true;
                } else {
                    coinMap.put(3, (int) coinMap.get(3) + 1);
                }
                break;
            default:
                throw new IllegalCoinException("Invalid coin: " + coinValue);
        }
        insertedSoFar += coinValue;
        timeBought = insertedSoFar / 5 * 2;
    }

    public int readDisplay() {
        return timeBought;
    }

    public PayStation buy() {
        PayStation r = new PayStation(timeBought);
        reset();
        return r;
    }

    public Map<Integer, Integer> cancel() {
        Map tempMap = new HashMap();
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

    public int empty() {
        int total = insertedSoFar;
        insertedSoFar = 0;
        return total;
    }

    public int value() {
        return value;
    }

    public int calculateTimeUsingAlternatingRateStrategy(int moneyInserted) {

        for(int i = 0; i < WeekDays.length; i++) {
            if(WeekDays[i] == dayOfTheWeek) {
                time = ((moneyInserted * 2) / 5);
            }
        }

        for(int i = 0; i < Weekend.length; i++) {
            if(Weekend[i] == dayOfTheWeek) {
                if(moneyInserted < 150) {
                    time = ((moneyInserted * 2) / 5);
                }
                if((150 <= moneyInserted) && (moneyInserted < 350)) {
                    time = (((moneyInserted - 150) * (3 / 10)) + 60);
                }
                if(moneyInserted >= 350) {
                    time = (((moneyInserted - 350) / 5) + 120);
                }
            }
        }

        return time;
    }

    public int calculateTimeUsingLinearRateStrategy(int moneyInserted) {

        time = ((moneyInserted * 2) / 5);

        return time;
    }

    public int calculateTimeUsingProgressiveRateStrategy(int moneyInserted) {

        if(moneyInserted < 150) {
            time = ((moneyInserted * 2) / 5);
        }
        if((150 <= moneyInserted) && (moneyInserted < 350)) {
            time = (((moneyInserted - 150) * (3 / 10)) + 60);
        }
        if(moneyInserted >= 350) {
            time = (((moneyInserted - 350) / 5) + 120);
        }

        return time;
    }
}


