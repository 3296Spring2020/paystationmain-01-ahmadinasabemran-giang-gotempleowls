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
    
    public void setup(){
        ps = new PayStationImpl();
        ms = new Menu();
    }
    
    //Accept coins for payment
    //Can accept 5, 10, 25 coins
    public void depositCoins(int coin){
        
    }
    
    //Displays the current amount of time bought
    public int display(){
        return -1;
    }
    
    //Calls the corresponding method in PayStationImpl
    //Print the receipt
    public void buyTicket(){
        //return;
    }
    
    //Calls the corresponding method in PayStationImpl
    //Prints the total returned coin value
    //Prints number of each coin
    public void cancel(){
    
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
