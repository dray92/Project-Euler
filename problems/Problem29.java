package problems;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Problem29 {
	public static void main(String[] args) {
		Set<BigInteger> set = new HashSet<BigInteger>();
		for(int i = 2 ; i <= 100 ; i++) {
			BigInteger a = BigInteger.valueOf(i);
			for(int j = 2 ; j <= 100 ; j++) {
				set.add(a.pow(j));
			}
		}
		System.out.println(set.size());
	}
}
