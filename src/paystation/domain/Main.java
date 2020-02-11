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
 * 
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

    
    public static PayStationImpl ps;
    public static int currentRate = 1;
    
    public static void setup(){
        ps = new PayStationImpl();
    }
    
    //Accept coins for payment
    //Can accept 5, 10, 25 coins
    public static void depositCoins() throws IllegalCoinException{
        
        Scanner input = new Scanner(System.in);
        System.out.println("This machine accepts nickels, dimes, and quarters.\n"
                + "Please input the integer value of the coin "
                + "you would like to enter: ");
        
        int coin = input.nextInt();
        ps.addPayment(coin);
        System.out.println(coin + " cents added.");
        System.out.println("New total is " + ps.getInsertedSoFar() + " cents.");
        
    }
    
    //Displays the current amount of time bought
    public static int display(){
        int timeBought = ps.readDisplay();
        System.out.println(timeBought + " minutes bought.");
        return timeBought;
    }
    
    //Calls the corresponding method in PayStationImpl
    //Print the receipt
    public static void buyTicket(){
        //Receipt has a single value for timeBought
        Receipt r = ps.buy();
        System.out.println("Receipt: " + r.value() + " minutes bought.");
    }
    
    //Calls the corresponding method in PayStationImpl
    //Prints the total returned coin value
    //Prints number of each coin
    public static void cancel(){
        //Hold is a copy of the PayStation coinMap
        //Maps from coin type (1, 2, 3) to number of coins
        Map<Integer,Integer> hold = ps.cancel();
        int nickels = 0;
        int dimes = 0;
        int quarters = 0;
        
        //Count for each coin type
        //Try to copy values from coinMap
        //If coinMap does not have a value mapped, default to 0
        try{nickels = hold.get(1);} 
        catch(Exception e){}
        
        try{dimes = hold.get(2);}
        catch(Exception e){}
        
        try{quarters = hold.get(3);}
            catch(Exception e){}
        
        //Total coin value of everything in the map
        int totalRet = (nickels * 5) + (dimes * 10) + (quarters * 25);
        System.out.println("Coins entered: \n"
        + "Nickels: " + nickels + "\n"
        + "Dimes: " + dimes + "\n"
        + "Quarters: " + quarters + "\n"
        + "Total returned coin value: " + totalRet);
        
    }
    
    //Changes the rate strategy by calling a function 
    public static int changeRateStrategy(){
        
        //Get user input for new rate strategy
        Scanner kbd = new Scanner(System.in);
        int user_input;
        System.out.println("\nPlease enter an integer corresponding"
                + "to the desired rate strategy\n"
                + "1. Linear Rate - Alphatown\n"
                + "2. Progressive Rate - Betatown\n"
                + "3. Alternating Rate - Gammatown");
        
        user_input = kbd.nextInt();
        
        if(user_input >= 1 && user_input <= 3){
            ps.changeRate(user_input);
            currentRate = user_input;
            System.out.println("Successfully changed.");
            return currentRate;
        } else {
            System.out.println("Invalid input. Returning to menu.");
        }
        
        return -1;
    }
    
    public static void main(String[] args) throws IllegalCoinException{
        
        setup();
        Scanner kbd = new Scanner(System.in);
        int user_input = -1;
        
        //Simulation stops when Cancel or Buy are ran
        while (user_input != 3 && user_input != 4) {
            
            //Display the current town name
            switch(currentRate){
                case 1: 
                    System.out.println("|| Alphatown ||");
                    break;
                case 2:
                    System.out.println("|| Betatown ||");
                    break;
                case 3:
                    System.out.println("|| Gammatown ||");
                    break;
            }
            
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
                    + "5. Change Rate Strategy");

            //Get user input
            user_input = kbd.nextInt();
            if (user_input >= 1 && user_input <= 5) {
                //Use a switch to run different options based on the user's answer
                switch(user_input){
                    case 1: 
                        depositCoins();
                        break;
                    case 2:
                        display();
                        break;
                    case 3:
                        buyTicket();
                        break;
                    case 4:
                        cancel();
                        break;
                    case 5:
                        changeRateStrategy();
                        break;
                }
            } else {
                //Invalid input
                System.out.println("Invalid input ");
            }
            //Here, exits loop if 3. buyTicket() or 4. cancel() were entered
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
        System.out.println("Exiting program.");
        kbd.close();
    }
}
