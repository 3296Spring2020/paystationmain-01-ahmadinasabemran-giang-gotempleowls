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

package edu.temple.cis.paystation;
import java.util.*;

public class PayStationImpl implements PayStation {
    
    private int insertedSoFar;
    private int timeBought;
    private int totalAmount;
    private Map<Integer, Integer> map;

    @Override
    public void addPayment(int coinValue)
            throws IllegalCoinException {
        switch (coinValue) {
            case 5: break;
            case 10: break;
            case 25: break;
            default:
                throw new IllegalCoinException("Invalid coin: " + coinValue);
        }
        insertedSoFar += coinValue;
        timeBought = insertedSoFar / 5 * 2;
    }

    @Override
    public int readDisplay() {
        return timeBought;
    }

    @Override
    public Receipt buy() {
        Receipt r = new ReceiptImpl(timeBought);
        reset();
        //map.clear();
        return r;
    }

    @Override
    public Map <Integer, Integer> cancel(){
        Map<Integer, Integer> temp = this.map;
    	reset();
    	return temp;
    }
    
    @Override
    public void cancel1() {
    	totalAmount = insertedSoFar;
    }
    
    private void reset() {
        timeBought = insertedSoFar = 0;
    }
    
<<<<<<< HEAD
    public int empty() {
    	insertedSoFar = 0;
    	return insertedSoFar;
=======
    @Override
    public int empty(){
        int ret = insertedSoFar;
        insertedSoFar = 0;
        reset();
        return ret;
    }
    
    @Override
    public int empty1() {
    	totalAmount = insertedSoFar = 0;
    	return totalAmount;
>>>>>>> 9266973e2e21ef61372ba9d4bc26f14e8db195fe
    }
    
    @Override
    public int empty2() {
    	totalAmount = insertedSoFar;
    	return totalAmount;
    }
    
    @Override
    public int empty3() {
    	totalAmount = insertedSoFar;
    	return totalAmount;
    }

    /*
    @Override
    public Map<Integer, Integer> cancel2() {
        return map;
    }
    */
}
