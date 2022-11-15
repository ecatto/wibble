/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.solent.ood.hittastic;

/**
 *
 * @author 44774
 */
public class Order 
{
    //Attributes
    private String custId;
    private int orderNum, quantity;
    private Song songInOrder;
    
    //Constructor
    public Order(int orderNumIn, String custIdIn, Song songInOrderIn, int quantityIn)            
    {
        orderNum = orderNumIn;
        custId = custIdIn;
        songInOrder = songInOrderIn;
        quantity = quantityIn;
    }
    
    //Getter mthods
    public String getCustId()
    {
        return custId;
    }
    
    public int getorderNum()
    {
        return orderNum;
    }

    public int getQuantity()
    {
        return quantity;
    }

    //Setter method
    public Song getSongInOrder()
    {
        return songInOrder;
    }
    
    //Other methods
    public void display()
    {
        System.out.println("Order Number: " + orderNum + ". " + quantity + " copy/copies of " + getSongInOrder().getTitle() + " by " + getSongInOrder().getArtist());
    }
}
