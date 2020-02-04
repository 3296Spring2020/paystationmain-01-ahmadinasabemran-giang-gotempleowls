/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paystation.domain;

import java.util.*;



/**
 *
 * @author Steven Giang

 * Created: 2020 1 28 Tuesday
 * CIS 3296: Software Design
 * Professor: Dominic Letarte
 * Lab 4: PayStation Rate Strategies and Main Program
 * 
 * Main class:
 * Demonstrates the functionalities of the PayStation through a menu
 * 
 */

public class Main {

    
    private static PayStationImpl ps;
    private static Menu ms;
    
    //int related to the RateStrategy being used
    //Depending on the value here, use a different timeCalculate method
    //Can be edited through changeRateStrategy()
    private int currentRate = 1;
    
    public void setup(){
        ps = new PayStationImpl();
        ms = new Menu();
    }
    
    //Accept coins for payment
    //Can accept 5, 10, 25 coins
    public void depositCoins(int coin) throws IllegalCoinException{
        ps.addPayment(coin);
    }
    
    //Displays the current amount of time bought
    public int display(){
        int timeBought = ps.readDisplay();
        System.out.println(timeBought + " minutes bought");
        return timeBought;
    }
    
    //Calls the corresponding method in PayStationImpl
    //Print the receipt
    public void buyTicket(){
        //Receipt has a single value for timeBought
        Receipt r = ps.buy();
        
    }
    
    //Calls the corresponding method in PayStationImpl
    //Prints the total returned coin value
    //Prints number of each coin
    public void cancel(){
        //Hold is a copy of the PayStation coinMap
        //Maps from coin type to number of coins
        Map<Integer,Integer> hold = ps.cancel();
        int nickels = 0;
        int dimes = 0;
        int quarters = 0;
        int totalRet = nickels + dimes + quarters;
        
    }
    
    //Changes the rate strategy
    //To be developed further
    public int changeRateStrategy(){
        return -1;
    }
    
    
    public static void main(String[] args) throws IllegalCoinException{
        
        Scanner kbd = new Scanner(System.in);
        
        //Allow the user to select a function:
        //Deposit Coins
        //Display
        //Buy Ticket
        //Cancel
        //Change Rate Strategy
        System.out.println("Enter a number corresponding to an option: ");
        System.out.println("1. Deposit Coins \n"
                + "2. Display Time Bought \n"
                + "3. Buy Ticket\n"
                + "4. Cancel \n"
                + "Change Rate Strategy");
        
        
        
        kbd.close();
    }
}
