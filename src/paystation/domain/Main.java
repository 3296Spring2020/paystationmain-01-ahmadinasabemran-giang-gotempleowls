/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paystation.domain;

import java.util.*;

//Import for Menus
import java.awt.*;
import java.awt.event.*;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;
import javax.swing.ImageIcon;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JFrame;

/**
 *
 * @author Steven Giang
 */
public class Main {

    JTextArea output;
    JScrollPane scrollPane;
    
    private static PayStationImpl ps;
    public void setup(){
        ps = new PayStationImpl();
    }
    
    
    //From the Oracle JMenu tutorial
    public JMenuBar createMenuBar(){
        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem;
        JRadioButtonMenuItem rbMenuItem;
        JCheckBoxMenuItem cbMenuItem;
        
        //Menu Bar
        menuBar = new JMenuBar();
        
        menu = new JMenu("A Menu");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menuBar.add(menu);
        
        //a group of JMenuItems
        menuItem = new JMenuItem("A text-only menu item", KeyEvent.VK_T);
        
        
        
    }
    
    public static void main(String[] args) throws IllegalCoinException{

	System.out.println("Hello, World!\n");
	
        //Allow the user to select a function
        //Deposit Coins
        //Display
        //Buy Ticket
        //Cancel
        //Change Rate Strategy
    }
}
