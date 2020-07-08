import java.util.Scanner;

public class BinaryGap {
	public static int binaryGap(int n) {
	    n >>>= Integer.numberOfTrailingZeros(n);

	    int gap = 0;
	    
	    while ((n & (n + 1)) != 0) {
	        n |= n >>> 1;
	        gap++;
	    }
	    return gap;
	}
	
	public static int anotherWay(int n) {
	    int binaryGap = 0;
	    boolean found_one = false;
	    
	   for(int i = 0; n > 0; n /= 2) {
		   if(n % 2 == 0) {
			   i++;
		   } else {
			   if(i > binaryGap && found_one == true)
				   binaryGap = i;
			   i = 0;
			   found_one = true;
		   }
		   
	   }

	    return binaryGap;
	}
	
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)){
			System.out.print("Enter the number to find the binary gap: ");
			int n = scan.nextInt();
			String binaryString = Integer.toBinaryString(n);
			System.out.println("Binary: " + binaryString);
			System.out.println("Binaryn gap: " + binaryGap(n));
			System.out.println("Binaryn gap another way: " + anotherWay(n));
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}	
	}

}
