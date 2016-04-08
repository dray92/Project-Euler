package problems;

import java.math.BigInteger;

public class Problem16 {

	public static void main(String[] args) {
		BigInteger val = BigInteger.valueOf(2);
		BigInteger power = BigInteger.ONE;
		
		int pow = 1000;
		
		for(int i = 0 ; i < pow ; i++)
			power = power.multiply(val);
		
		BigInteger TEN = BigInteger.valueOf(10);
		BigInteger sum = BigInteger.ZERO;
		while(!power.equals(BigInteger.ZERO)) {
			BigInteger modVal = power.mod(TEN);
			sum = sum.add(modVal);
			power = power.divide(TEN);
		}
		System.out.println(sum);
	}
}
