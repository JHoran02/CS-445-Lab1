
/**
 * The counter class implements a counter that will roll over to the initial
 * value when it hits the maximum value.
 * 
 * @author Charles Hoot 
 * @version 4.0
 */
public class Counter
{
    // PUT PRIVATE DATA FIELDS HERE
	private int maximum;
	private int minimum;
	private int value;
	private boolean rolled;
	
    /**
     * The default constructor for objects of class Counter.  Minimum is 0 and the maximum
     * is the largest possible integer.
     */
    public Counter()
    {
    	maximum=Integer.MAX_VALUE;
    	minimum=0;
    	value=minimum;
        // ADD CODE FOR THE CONSTRUCTOR
    }
    
    
    /**
     * The alternate constructor for objects of class Counter.  The minimum and maximum values are given as parameters.
     * The counter starts at the minimum value.
     * @param min The minimum value that the counter can have
     * @param max The maximum value that the counter can have
     * */
    public Counter(int min, int max)
    {
    	
    	if( max<=min) {
    		throw new CounterInitializationException("Max cannot be less than or equal to min");
    	}
    	maximum=max;
    	minimum=min;
    	value=minimum;
    	
        // ADD CODE FOR THE ALTERNATE CONSTRUCTOR
    }
    
    /**
     * Determine if two counters are in the same state
     *
     * @param  otherObject   the object to test against for equality
     * @return     true if the objects are in the same state
     */
    public boolean equals(Object otherObject)
    {
        boolean result = true;
        if (otherObject instanceof Counter)
        {
        	if(rolled!=((Counter) otherObject).rolled||maximum!=((Counter) otherObject).maximum||minimum!=((Counter) otherObject).minimum||value!=((Counter) otherObject).value){
        		result=false;
        		
        	}
           
        }
        else {
        	result=false;
        }
        return result;
    }
    
    

    /**
     * Increases the counter by one
     */
    public void increase()
    {
    
    	value++;
    	if(value>maximum) {
    		value=minimum;
    		rolled=true;
    	}
    	else {
    		rolled=false;
    	}
    
    	
        // ADD CODE TO INCREASE THE VALUE OF THE COUNTER
    }
 
 
     /**
     * Decreases the counter by one
     */
    public void decrease()
    {
    	value--;
    	if(value<minimum) {
    		value=maximum;
    		rolled=true;
    	}
    	else {
    		rolled=false;
    	}
        // ADD CODE TO INCREASE THE VALUE OF THE COUNTER
    }
    
    /**
     * Get the value of the counter
     *
     * @return     the current value of the counter
     */
    public int value()
    {
        // CHANGE THE RETURN TO GIVE THE CURRENT VALUE OF THE COUNTER
        return value;
		
    }
    
    
    /**
     * Accessor that allows the client to determine if the counter
     *             rolled over on the last count
     *
     * @return     true if the counter rolled over
     */
    public boolean rolledOver()
    {
    	if(rolled==true) {
    		//value=minimum;
    		return true;
    		
    	}
    	else {
    		return false;
    	}
    }
    
    /**
     * Override the toString method to provide a more informative
     * description of the counter
     *
     * @return     a descriptive string about the object
     */
    public String toString()
    {
    	System.out.print("The counter's maximum value is "+maximum+" The counter's minimum value is "+minimum+". "+"Counter Rollover: "+rolled);
        // CHANGE THE RETURN TO A DESCRIPTION OF THE COUNTER
        return "";		
    }
 
}
