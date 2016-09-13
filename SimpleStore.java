
/**
 * Name: Bryce Sulin (sulin)
 * Course: CSCI 241 - Computer Science I
 * Section: 001
 * Assignment: 1
 * 
 * Project/Class Description
 *     The SimpleStore class keeps track of purchases at the local Simple
 *     Store. All items at the same store cost the same amount;
 *     an even dollar amount which may range from $1 up to $100.
 *     Shoppers continue to pay the SimpleStore until enough is entered,
 *     then they may complete their purchase and possibly receive
 *     change.
 *     
 * Known Bugs:
 *    none.
 */

public class SimpleStore
{
    // instance variables - replace the example below with your own
    private int cost;   //the cost of the item
    private int soFar;  //the amount collected so far
    private int sum;    //the total collected by the SimpleStore

    /**
       * Constructor for objects of class SimpleStore
         * Create a SimpleStore who will keep track of money collected
           */
          public SimpleStore(int dollarAmount)
    {
            cost = dollarAmount;
            soFar = 0;
            sum = 0;
    }
    
    // instance methods
    
    /**
       * Return the cost of an item at this store
         * @return cost of an item from this store
           */
          public int getCost()
    {
            return cost;
    }
    
    /**
       * Return the amount entered by the shopper so far
       * 
       * @return    the amount the shopper has gathered for payment
         */
        public int getSoFar()
        {
            return soFar;
        }
        /**
           * Return the sum needed to purchase all the shopper's items
           * 
           * @return    the sum of the shopper's purchases
             */
            public int getSum()
            {
                return sum;
            }
            
            /**
             * Collect money from shopper
             * 
             * @param dollars   money shopper gives SimpleStore
             */
            public void collectDollars (int dollars)
            {
                if (dollars > 0)    {
                    soFar = soFar + dollars;
                    System.out.println("SimpleStore received $" + dollars + ".");
                }
                else    {
                    System.out.println
                    ("Error: Please re-enter positive dollar amount.");
                }
            }
            
            /**
             * Print a receipt if enough money has been collected
             */
            public void printReceipt()
            {
                if (soFar >= cost) {
                    // Print the receipt
                    System.out.println("********************************");
                    System.out.println("* Total Purchases: $" + cost);
                    System.out.println("*");
                    System.out.println("* Thank you for shopping at your ");
                    System.out.println("* local Simple Store.");
                    System.out.println("********************************");
                    
                    // Update the shopper and cash register amounts
                    sum = sum + cost;
                    soFar = soFar - cost;
                }
                else    {
                    // Tell shopper they are short of money
                    System.out.println("Error:  Insufficient amount.");
                    System.out.print("Please enter an additional $");
                    System.out.println((cost - soFar) + ".");
                }
            }
            
            /**
             * Print amount overpaid
             */
            public void refundExtra()
            {
                int extra = soFar;
                soFar = 0;
                System.out.println ("Amount to refund: $" + extra + ".");
            }
            
            /**
             * main() method
             * 
             * Creates a SimpleStore object, and tests each of this class's
             * methods on it.
             */
            public static void main (String [] args)
            {
                // Create a SimpleStore object
                // At this store, every item costs $15
                SimpleStore chris = new SimpleStore (15) ;
                
                // First shopper gives SimpleStore enough money for one item,
                // and will therefore receive change
                chris.collectDollars (20) ;
                chris.printReceipt () ;
                chris.refundExtra ();
                System.out.println ();
                
                // Second shopper gives SimpleStore only 8 dollars
                chris.collectDollars (8) ;
                chris.printReceipt () ;
                chris.collectDollars (-12) ;
                chris.collectDollars (17) ;
                chris.printReceipt () ;
                chris.refundExtra () ;
                System.out.println () ;
                
                // SimpileStore prints total receipts for her shift so far
                System.out.print ("Total collected today by current ") ;
                System.out.println ("SimpleStore: $" + chris.getSum ()) ;
            }
        }             