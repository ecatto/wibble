/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.solent.ood.hittastic;

/**
 *
 * @author 44774
 */
public class Customer 
{
    //Attributes    
    private String custId, custName;

    //Constructor
      public Customer(String custIdIn, String custNameIn)
      {
          custId = custIdIn;
          custName = custNameIn;
      }
    
    //Getter methods
    public String getCustId()
    {
        return custId;
    }

    public String getName()
    {
        return custName;
    }    
}
