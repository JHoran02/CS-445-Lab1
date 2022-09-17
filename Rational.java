/**
 * A class that represents a rational number. 
 * 
 * @author Charles Hoot 
 * @version 4.0
*/

public class Rational
{
    // PUT PRIVATE DATA FIELDS HERE
	private int numerator;
	private int denominator;
	private int rational;
    /**
     * The default constructor for objects of class Rational.  Creates the rational number 1.
     */
    public Rational()
    {       
        numerator=1;
        denominator=1;
        rational=1/1;
        		// ADD CODE TO THE CONSTRUCTOR
    }

    /**
     * The alternate constructor for objects of class Rational.  Creates a rational number equivalent to n/d.
     * @param n The numerator of the rational number.
     * @param d The denominator of the rational number.
     */    
    public Rational(int n, int d)
    {
    	numerator=n;
    	denominator=d;
    	normalize();
    	if(denominator==0) {
    		throw new ZeroDenominatorException("Cannot Divide by Zero");
    	}
    	else {
    		rational=1/1;
    	}
        // ADD CODE TO THE ALTERNATE CONSTRUCTOR
    }
    
    /**
     * Get the value of the Numerator
     *
     * @return     the value of the numerator
     */
   
    public int getNumerator()
    {
    	return numerator;
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
        
    }
    
    /**
     * Get the value of the Denominator
     *
     * @return     the value of the denominator
     */
    public int getDenominator()
    {
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
        return denominator;
    }


    /**
     * Negate a rational number r
     * 
     * @return a new rational number that is negation of this number -r
     */    
    public Rational negate()
    {               
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
    	int num=getNumerator();
    	int den=getDenominator();
    	
    	num=num*-1;
    	
    	Rational negated=new Rational(num,den);
    			
        return negated ;
    }


    /**
     * Invert a rational number r 
     * 
     * @return a new rational number that is 1/r.
     */    
    public Rational invert()
    {               
    	int num=getNumerator();
    	int den=getDenominator();
    	if( num<0) {
    		num=num*-1;
    		den=den*-1;
    	}
    	Rational inverted=new Rational(den,num);
        return inverted;
    }





    /**
     * Add two rational numbers
     *
     * @param other the second argument of the add
     * @return a new rational number that is the sum of this and the other rational
     */    
    public Rational add(Rational other)
    {       
    	int num=getNumerator();
    	int den=getDenominator();
    	int num2=other.getNumerator();
    	int den2=other.getDenominator();
    	int commonden=den2*den;
    	int addedNum=num*den2+num2*den;
    	
    	//numerator=addedNum;
    	//denominator=commonden;
    	normalize();
    	
    	Rational added=new Rational(addedNum,commonden);
        return added;
    }
    
     /**
     * Subtract a rational number t from this one r
     *
     * @param other the second argument of subtract
     * @return a new rational number that is r-t
     */    
    public Rational subtract(Rational other)
    {               
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
    	int num=getNumerator();
    	int den=getDenominator();
    	int num2=other.getNumerator();
    	int den2=other.getDenominator();
    	int commonden=den2*den;
    	int addedNum=num*den2-num2*den;
    	
    	//numerator=addedNum;
    	//denominator=commonden;
    	normalize();
    	
    	Rational added=new Rational(addedNum,commonden);
    	//numerator=num;
    	//denominator=den;
        return added;
    }

    /**
     * Multiply two rational numbers
     *
     * @param other the second argument of multiply
     * @return a new rational number that is the sum of this object and the other rational.
     */    
    public Rational multiply(Rational other)
    {       
        // ADD NEW CODE AND CHANGE THE RETURN TO SOMETHING APPROPRIATE
       	int num=getNumerator();
    	int den=getDenominator();
    	int num2=other.getNumerator();
    	int den2=other.getDenominator();
    	int commonden=den2*den;
    	int multip=num2*num;
    	
    	
    	normalize();
    	
    	Rational multipl=new Rational(multip,commonden);
        return multipl;
        
    }
        
 
     /**
     * Divide this rational number r by another one t
     *
     * @param other the second argument of divide
     * @return a new rational number that is r/t
     */    
    public Rational divide(Rational other)
    {               
     	int num=getNumerator();
    	int den=getDenominator();
    	
    	int num2=other.getNumerator();
    	int den2=other.getDenominator();
    	int commonden=den*num2;
    	int multip=num*den2;
    	
    	
    	normalize();
    	
    	Rational divide=new Rational(multip,commonden);
        return divide;
    }
     
 
 
 /**
     * Put the rational number in normal form where the numerator
     * and the denominator share no common factors.  Guarantee that only the numerator
     * is negative.
     *
     */
    private void normalize()
    {
        // ADD CODE TO NORMALIZE THE RATIONAL NUMBER
    	int normalnum=getNumerator();
    	int normalden=getDenominator();
    	int gcdnum=Math.abs(normalnum);
    	int gcdden=Math.abs(normalden);
    	if(normalden<0&&normalnum<0) {
    		normalden=normalden*-1;
    		normalnum=normalnum*-1;
    	}
    	if(normalden<0&&normalnum>0) {
    		normalden=normalden*-1;
    		normalnum=normalnum*-1;
    	}
    	int gcd=gcd(gcdnum,gcdden);
    	 numerator=normalnum/gcd;
    	 denominator=normalden/gcd;
    }
    
    /**
     * Recursively compute the greatest common divisor of two positive integers
     *
     * @param a the first argument of gcd
     * @param b the second argument of gcd
     * @return the gcd of the two arguments
     */
    private int gcd(int a, int b)
    {
        int result = 0;
        if(a<b)
            result = gcd(b,a);
        else if(b==0)
            result = a;
        else
        {
            int remainder = a % b;
            result = gcd(b, remainder);
        }
        return result;
    }
   
    
    
}
