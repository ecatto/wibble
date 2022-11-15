/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.solent.ood.hittastic;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 44774
 */
public class HitSite 
{    
    //Attributes
    private ArrayList<Song> songs;
    private ArrayList<Order> orders;
    
    //constructor
    public HitSite()
    {
        songs = new ArrayList<Song>();
        orders = new ArrayList<Order>();
    }

    //methods
    
    //add a song to the songs ArrayList
    public void addSong(Song s)
    {
        songs.add(s);
    }
    
    
    //Searches through all songs. Add all songs by the artist passed in to an ArrayList Retuens that ArrayList
    public ArrayList<Song> findSongsByArtist(String artist)
    {
        ArrayList<Song> foundArtist = new ArrayList<>();
        
        for(Song currentSong: songs)
        {
            if(currentSong.getArtist().equals(artist))
            {
                foundArtist.add(currentSong);
            }
        }
        return foundArtist;               
    }
    
    //Searches through all songs. Add all songs by the title passed in to an ArrayList Retuens that ArrayList    
    public ArrayList<Song> findSongsByTitle(String title)
    {
        ArrayList<Song> foundTitle = new ArrayList<>();

        for(Song currentSong: songs)
        {
            if(currentSong.getTitle().equals(title))
            {
                foundTitle.add(currentSong);
            }
        }
        return foundTitle;        
    }

    //ArrayList of songs by title passed in. If is more than one, get artist info from user
    //If no artist matches user input, repeat until artist matches 
    //Return song which has matching title and artist 
    public Song findSongByTitleAndArtist(ArrayList<Song> titles)
    {
        if (titles.size() >1)
        {                        
            boolean found = false;
                        
            Scanner scanner = new Scanner(System.in);
            System.out.println("There is more than 1 song with this title");
            while (found == false)
            {
                System.out.println("Please enter the artist: ");
                String searchArtist = scanner.nextLine();
                          
                for(Song currentSong: titles)
                {
                    if(currentSong.getArtist().equals(searchArtist))
                    {
                        found = true;
                        return currentSong;
                    }
                }
                
                if (found == true)
                {
                    break;
                }    
                else
                {
                    System.out.println("Sorry, no artists match that song title, please try again");      
                }                
            }
        }
                    
        else
        {
            for(Song currentSong: titles)
            {
                return currentSong;
            }                    
        }
        return null;
    }

    //get quantity and check that is more than zero       
    public int getQuantity()
    {               
        Scanner scanner = new Scanner(System.in);
        
        boolean validQuanity = false;                    
        while (validQuanity == false)
        {                    
            System.out.println("Enter the quantity you would like to purchase:");
            String input = scanner.nextLine();   
            int quantity = Integer.parseInt(input);
                        
            if (quantity >0)
            {
                validQuanity = true;
                return quantity;
            }
            else
            {
                System.out.println("Quantity must be more than zero");
            }
        }
        return 0;
    }

    //create new order and add to arraylist of all orders
    //update quantity sold        
    public void buySong(int ordNum, String custId, Song songIn, int quantity)
    {
        orders.add(new Order(ordNum, custId, songIn, quantity));
        songIn.addQuantitySold(quantity);       
    }
    
    
    //Display all orders for specified customer
    public ArrayList<Order> viewOrders(String custId)
    {
        ArrayList<Order> custOrders = new ArrayList<>();
        
        for (Order currentOrder: orders)
        {    
            if(currentOrder.getCustId().equals(custId))
            {
                custOrders.add(currentOrder);
            }
        }
        return custOrders;
    }    
}

