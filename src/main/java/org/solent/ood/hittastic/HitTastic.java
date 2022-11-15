/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package org.solent.ood.hittastic;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *-
 * @author Ellie Catto
 */
public class HitTastic 
{
    
    public static void main(String[] args) 
    {            
        HitSite wibble = new HitSite();
        wibble.addSong(new Song("Taylor Swift", "You belong with me"));
        wibble.addSong(new Song("Taylor Swift", "Red"));
        wibble.addSong(new Song("Queen", "Radio Gaga"));    
        wibble.addSong(new Song("Simply Red", "Red"));  
        
    //Once integrated the customer will be identified from an ArrayList when they log in    
        Customer example = new Customer("1234", "Ellie");
        
        Scanner scanner = new Scanner(System.in);

        String choice = "";

        int orderNumber = 1;
        
        // Loop until the option equals "5" (quit)
        while(! choice.equals("5"))
        {
            System.out.println(" ");
            System.out.println("1. Search for songs by artist");
            System.out.println("2. Search for songs by title");
            System.out.println("3. Purchase song");
            System.out.println("4. View order history");            
            System.out.println("5. Quit Program");

            System.out.println("Please enter a number: ");

            choice = scanner.nextLine();

            switch(choice)
            {
                // Search for songs by artist
                case "1":
                    System.out.println("Please enter the name of the artist:");
                    String artistName = scanner.nextLine();                                                          
                    
                     ArrayList<Song> foundArtist = wibble.findSongsByArtist(artistName);                    
                    // If no matches, the array list will be empty
                    if(foundArtist.isEmpty())
                    {
                        System.out.println("Sorry, no artists with that name exist");
                    }
                    else
                    {
                        // Loop through all songs by artist
                        // Add songs to the ArrayList                        
                        for(Song s: foundArtist)
                        {
                            s.display();
                        }
                    }             
                    break;

                // Search for songs by title
                case "2":
                    System.out.println("Please enter the title of the song:");
                    String titleName = scanner.nextLine();                                                          
                    
                     ArrayList<Song> foundTitle = wibble.findSongsByTitle(titleName);                    
                    // If no matches, the array list will be empty
                    if(foundTitle.isEmpty())
                    {
                        System.out.println("Sorry, no songs with that title exist");
                    }
                    else
                    {
                        // Loop through all songs by title
                        // Add songs to the ArrayList                        
                        for(Song s: foundTitle)
                        {
                            s.display();
                        }
                    }                    
                    break;

                // Purchase song
                    //find song wanted
                    //ask quantity
                    //call HitSite.buySong
                case "3":
                    System.out.println("Enter the title of the song you would like to purchase:");
                    String searchName = scanner.nextLine();

                    foundTitle = wibble.findSongsByTitle(searchName);                    
                    // If no matches, the array list will be empty
                    if(foundTitle.isEmpty())
                    {
                        System.out.println("Sorry, no songs with that title exist");
                        break;
                    }
                    else
                    {                        
                        // Loop through all songs by title
                        // Add songs to the ArrayList
                        
                        for(Song s: foundTitle)
                        {
                            s.display();
                        }
                    }
                    Song foundSong = wibble.findSongByTitleAndArtist(foundTitle);    

                    int quantity = wibble.getQuantity();
                                        
                    wibble.buySong(orderNumber, example.getCustId(), foundSong, quantity);
                    orderNumber++;
                    if (quantity ==1)
                    {
                        System.out.println("You have bought 1 copy of " + foundSong.getTitle() + " by " + foundSong.getArtist() );                        
                    } 
                    else
                    {
                        System.out.println("You have bought " + quantity + " copies of " + foundSong.getTitle() + " by " + foundSong.getArtist() );                            
                    }
                    
                    break;
                    
                // View order history
                case "4":                    
                    ArrayList<Order> orders = wibble.viewOrders(example.getCustId());
                    if (orders.isEmpty())
                    {
                        System.out.println("You have no orders to display");              
                    }
                    else
                    {
                        for(Order currentOrder: orders)
                        {
                            currentOrder.display();
                        }
                    }
                    break;                
            }
        }                
    }
}
