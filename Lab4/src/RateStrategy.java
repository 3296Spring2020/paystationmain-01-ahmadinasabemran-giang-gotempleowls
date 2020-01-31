/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dumpus
 */
public interface RateStrategy {
    
    public int calculateTimeLinearRateStrategy(int moneyInserted);

    public int calculateTimeProgressiveRateStrategy(int moneyInserted);

    public int calculateTimeAlternatingRateStrategy(int moneyInserted);
}
