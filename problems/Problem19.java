package problems;

import java.math.BigInteger;

public class Problem19 {
	
	public static void main(String[] args) {
		BigInteger f1 = BigInteger.ONE;
		BigInteger f2 = BigInteger.ONE;
		BigInteger f;
		int indx = 2;
		while(true) {
			indx++;
			
			f = f1.add(f2);
			
			if(f.toString().length() == 1000) {
				System.out.println(indx);
				break;
			}
			
			f1 = f2;
			f2 = f;
		}
	}

}
