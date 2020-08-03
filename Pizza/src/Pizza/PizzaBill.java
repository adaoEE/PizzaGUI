
package Pizza;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class PizzaBill 
{
 // class constants
    static final double PIZZA = 1.25,
                        FRIES = 1.0,
                        DRINK = 0.75,
                        CHEESE = 0.50,
                        DEEP_DISH = 1.0,
                        SAUCE = 0.75;
    
    double total = 0.0;   // sum of all services provided
    double total1 = 0.0; 
    
    StringBuffer display = new StringBuffer(); // output
    
    // instance variables
    private boolean cheese;
    private boolean deepDish;
    private boolean sauce;
    private double slices;
    private double fries;
    private double drinks;
    private double pricePerSlice;
    // creates a new instance of PizzaBill;
    
    public PizzaBill()
    {
        
        cheese = false;
        deepDish = false;
        sauce = false;    
        slices = 0;
        fries = 0;
        drinks = 0;
    }
     // Overloarded constructor
    // contructor
    public PizzaBill(boolean ch, boolean de, boolean sa, double sl, double fr, double dr)
    {
       this.cheese = ch;
       this.deepDish = de;
       this.sauce = sa;     
       this.slices = sl;
       this.fries = fr;
       
       this.drinks = dr; 
    }
    
    
    // calculate Bill
    public double calculatePizzaBill()
    { pricePerSlice = PIZZA;
        if (cheese)
        {
            pricePerSlice += CHEESE; // add          
        }
        if (deepDish)
        {
            pricePerSlice += DEEP_DISH;
        }
        if (sauce)
        {
            pricePerSlice += SAUCE;
        }    
        total1 = pricePerSlice*slices;
        total = pricePerSlice*slices + FRIES*fries + DRINK*drinks;
        //else 
            
        return total;
    }
    
    /**
     * 
     */
    public StringBuffer displayBill()
    {
    NumberFormat dollars = NumberFormat.getCurrencyInstance();
    DecimalFormat quantity = new DecimalFormat("#");
    display.append("Item                       ");//, "Quantity", "Price" + '\n');
    display.append("Quantity                            ");
    display.append("Price  ");
    display.append('\n');
    display.append("---------------------------------------------------------------------" + '\n');
    if(slices != 0)
    display.append(padSpaces("Pizza Slices", quantity.format(slices),dollars.format(total1)+'\n'));
    if(fries != 0)
    display.append(padSpaces("Fries", quantity.format(fries), dollars.format(fries*FRIES)+'\n'));
    if(drinks != 0)
    display.append(padSpaces("Soft Drinks", quantity.format(drinks), dollars.format(drinks*DRINK)+'\n'));
    
    display.append("---------------------------------------------------------------------" + '\n');
                       //----------------------------------------------------------
                       if(total >10){
    display.append("total                                                         ");
                       
    display.append( dollars.format(total) + '\n');
                }
    else{
                           display.append("total                                                          ");
                       
    display.append( dollars.format(total) + '\n');
        }

    
    //display.append(padSpaces("Total","", dollars.format(calculatePizzaBill()) + '\n'));
    return display;
    }
    
    /**
     * 
     */
     private StringBuffer padSpaces(String first, String second, String third)
    {
        final int MAX_SPACES = 35; // with of the output textarea
        StringBuffer line = new StringBuffer(first);
        
        //find number of spaces needed to pad the string for right - justification
        int numSpaces = MAX_SPACES - first.length()- second.length();
        
        for (int i = 0; i<numSpaces; i++)
            line.append(" ");
        line.append(second);
        
        int numSpaces2 = MAX_SPACES -third.length()-second.length();
        
        for (int j = 0; j<numSpaces2; j++)
            line.append(" ");
        line.append(third);
        return line;
    }
}

   
    

