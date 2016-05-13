package problems;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Problem41 {
	
	public static void main(String[] args) {
		/*
		 * Max possible is a 9 digit number
		 * sum of digits will give a bit of an understanding 
		 * into the divisibility of the number. Writing the numbers
		 * in reverse will give the max possible number.
		 * 
		 * 9 + 8 + 7 + 6 + 5 + 4 + 3 + 2 + 1 = 45 <- divisible by 3
		 * 8 + 7 + 6 + 5 + 4 + 3 + 2 + 1 = 36     <- divisible by 3
		 * 7 + 6 + 5 + 4 + 3 + 2 + 1 = 28         <- not divisible by 3
		 * 6 + 5 + 4 + 3 + 2 + 1 = 21             <- divisible by 3
		 * 5 + 4 + 3 + 2 + 1 = 15                 <- divisible by 3
		 * 4 + 3 + 2 + 1 = 10     				  <- not divisible by 3
		 * 3 + 2 + 1 = 6     					  <- divisible by 3
		 * 2 + 1 = 3     						  <- divisible by 3
		 * 1 = 1    							  <- divisible by 3
		 * 
		 * 4, 7 pandigital possible
		 * lets try 7
		 * So, the max number we can get is 7654321
		 */
		
		Set<Integer> prime = getPrimes(7654321);
		for(int i = 0 ; i < prime.size() ; i++) {
			int curMax = Collections.max(prime);
			prime.remove(curMax);
			if(isPandigital(curMax)) {
				System.out.println(curMax);
				break;
			}
		}
	}
	
	private static boolean isPandigital(int n) {
        int digits = 0;
        int count = 0;
        int tmp;

        while (n > 0) {
            tmp = digits;
            
            digits = digits | 1 << (int)((n % 10) - 1); 
            
            // if digit is unchanged after setting a bit, it 
            // means some value is repeated
            if (tmp == digits) { 
                return false;
            }

            count++;
            n /= 10;
        }

        return digits == (1 << count) - 1;
    }

	private static Set<Integer> getPrimes(int maxValue) {
		// REF: http://stackoverflow.com/questions/2068372/fastest-way-to-list-all-primes-below-n-in-python/3035188#3035188
		Set<Integer> known = new HashSet<Integer>();
		int n = maxValue;
		boolean correction = (n % 6) > 1;

		// closest number to calculate primes till
		switch (n % 6) {
			case 0:
				break;
			case 1:
				n = n - 1;
				break;
			case 2:
				n = n + 4;
				break;
			case 3:
				n = n + 3;
				break;
			case 4:
				n = n + 2;
				break;
			case 5:
				n = n + 1;
				break;
		}

		boolean[] sieve = new boolean[n / 3];
		for (int i = 1; i < sieve.length; i++)
			sieve[i] = true;

		for (int i = 0; i < (int)(Math.abs(Math.sqrt(n)) + 1); i++) {
			if (sieve[i]) {
				int k = (3 * i + 1) | 1;

				// sieve[      ((k*k)/3)      ::2*k]=[False]*((n/6-(k*k)/6-1)/k+1)
				int offset = (k * k) / 3;
				int stride = 2 * k;
				for (int indx = offset; indx < sieve.length; indx += stride)
					sieve[indx] = false;

				// sieve[(k*k+4*k-2*k*(i&1))/3::2*k]=[False]*((n/6-(k*k+4*k-2*k*(i&1))/6-1)/k+1)
				offset = (k * k + 4 * k - 2 * k * (i & 1)) / 3;
				for (int indx = offset; indx < sieve.length; indx += stride)
					sieve[indx] = false;
			}
		}

		known.add(2);
		known.add(3);
		for (int i = 0; i < n / 3 - (correction ? 1 : 0); i++)
			if (sieve[i])
				known.add((3 * i + 1) | 1);

		return known;
	}

}
