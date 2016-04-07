package problems;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Problem15 {

	public static void main(String[] args) {
		int n = 20;
		System.out.println( getNumPaths(n,n) );
	}
	
	public static BigInteger getNumPaths(int x, int y) {
		// possible paths from (0,0) to (x,y)
		// total movements needed (x+y)
		// number of right movements needed = x
		// possible ways -> from (x+y) choose x
		// so, ways = (x+y)! / (x!)(y!);
		long[] factorials = new long[x+y+1];
		for(int i = 1 ; i < factorials.length ; i++)
			factorials[i] = -1;
		factorials[0] = 1;
		factorials[1] = 1;
		
		BigInteger totalFact = getFactorial(x+y);
		BigInteger xFact = getFactorial(x);
		BigInteger yFact = getFactorial(y);
		
		return totalFact.divide( xFact.multiply(yFact) );
	}
	
	private static Map<Integer, BigInteger> factorialMap = new HashMap<Integer, BigInteger>();
	private static BigInteger getFactorial(int num) {
		if(num <= 1)
			return BigInteger.ONE;
		
		if(factorialMap.containsKey(num))
			return factorialMap.get(num);
		
		BigInteger factorial = BigInteger.valueOf(num).multiply(getFactorial(num-1));
		factorialMap.put(num, factorial);
		return factorial;
		
	}
}
