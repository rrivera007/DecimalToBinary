import java.util.Scanner;

public class Decimal 
{

	public static void main(String[] args) 
	{
		StringBuilder stringBuilder = new StringBuilder();
		String[] GetTwo = new String[2];
		int deci = Intro();
		String FirstBit = FirstBit(deci);
		String BitDecimal = Decimals(deci);
		double convert = Double.parseDouble(BitDecimal); 
		GetTwo = moveDecimalPoint(convert, BitDecimal);
		int Exponent = Integer.parseInt(GetTwo[1]);
		int lastBit = GetTwo[0].length();
		lastBit = 23 - lastBit;
		for (int i = 0; i<lastBit; i++)
		{
			stringBuilder.append('0');
		}
		String zero = stringBuilder.toString();
		int Biased = 127 + Exponent;
		String eightBit = GetEight(Biased);
		System.out.println("Binary Form: " + FirstBit + eightBit + GetTwo[0] + zero);
		

	}
	
	
	public static String GetEight(int Biased)
	{
		
		StringBuilder stringBuilder = new StringBuilder();
		int pos = 128;   //bit value 
		int bitTotal = 0;
		for (int i = 0; i<8;i++) //determines the place values that hold 1's and 0's and gives them their proper numeric value
		{
			
			if (Biased>=pos && (bitTotal+pos)<=Biased)						
			{
				
				stringBuilder.append("1");
				bitTotal = bitTotal + pos;
				pos = pos/2;
				
			}
			else
			{
				pos = pos/2;    // determines that a 0 is in place and moves the bit value 
				stringBuilder.append("0");
			}
			
		
		}
		String Final = stringBuilder.toString();
		return Final;
		
		
	}
	
	
	public static String[] moveDecimalPoint(double v, String decimal) 
	{
		String [] GetTwo = new String[2];
		int count = 0;
		int L = decimal.length();
	    for (int i = L-1; 0<i; i--)
	    {
	    		v /= Math.pow(10, 1);
	    		
	    		count++;
	    }
	     
	    String hold = Double.toString(v);
	    StringBuilder str = new StringBuilder(hold);
	    str.deleteCharAt(0);
	    str.deleteCharAt(0);
	
	    String Fixed = str.toString();
	    
	    GetTwo[0] = Fixed;
	    String cnt = Integer.toString(count);
	    GetTwo[1] = cnt;
	    return GetTwo;
	}
	
	
	public static String Decimals(int deci)
	{
		StringBuilder stringBuilder = new StringBuilder();
		int pos = 128;   //bit value 
		int bitTotal = 0;
		for (int i = 0; i<8;i++) //determines the place values that hold 1's and 0's and gives them their proper numeric value
		{
			
			if (deci>=pos && (bitTotal+pos)<=deci)						
			{
				
				stringBuilder.append("1");
				bitTotal = bitTotal + pos;
				pos = pos/2;
				
			}
			else
			{
				pos = pos/2;    // determines that a 0 is in place and moves the bit value 
				stringBuilder.append("0");
			}
				
		}
		 String Final = stringBuilder.toString();
		 StringBuilder str = new StringBuilder(Final);
		 for (int i = 0; i<Final.length();i++)
		 {
			 int p = 0;
			 if (str.charAt(p)=='0')
			 {
				 str.deleteCharAt(p); 
			 }
			 else
			 {
				 
				 String Fixed = str.toString();
				 return Fixed;
			 }
		 }

		 return Final;
	}
	
	
	
	
	public static String FirstBit(int deci)
	{
		if (deci>0)
		{
			String FB = "0";
			return FB;
		}
		else
		{
			String NFB = "1";
			return NFB;
		}
	}
	
	public static int Intro()
	{
		System.out.println("This program will calculate a given Decimal into it's 32-bit FPN equivalent\n");
		System.out.println("please enter a Decimal (no spaces): ");
		Scanner in = new Scanner(System.in);
		int Deci = in.nextInt();
		return Deci;
	}

}
