/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.solent.ood.hittastic;

/**
 *
 * @author 44774
 */
public class Song 
{
    //Attributes
    private String artist, title;
    private int quantitySold;
    
    //Constructor
    public Song(String artistIn, String titleIn)            
    {
        artist = artistIn;
        title = titleIn;
        quantitySold = 0;
    }
    
    //Getter methods
    public String getArtist()
    {
        return artist;
    }

    public String getTitle()
    {
        return title;
    }
    
    public int getQuantitySold()
    {
        return quantitySold;
    }
        
    //Other methods
    public void addQuantitySold(int quantityIn)
    {
            quantitySold = quantitySold + quantityIn;
    }
    

    public void display() 
    {
        System.out.println("Artist: " + artist + ", Song Title: " + title);
    }
}
