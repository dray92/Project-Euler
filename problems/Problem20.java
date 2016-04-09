package problems;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Problem20 {

	public static void main(String[] args) {
		int num = 100;
		BigInteger value = getFactorial(num);
		BigInteger TEN = BigInteger.valueOf(10);
		BigInteger sum = BigInteger.ZERO;
		while(!value.equals(BigInteger.ZERO)) {
			BigInteger modVal = value.mod(TEN);
			sum = sum.add(modVal);
			value = value.divide(TEN);
		}
		System.out.println(sum);
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
