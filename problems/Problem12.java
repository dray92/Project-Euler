package problems;

import java.util.TreeSet;
import java.util.Set;

public class Problem12 {
	
	private static final int UPPER = 75000;
	private static Set<Integer> knownPrimes;
	
	public static void main(String[] args) {
		int number = 1;
        int i = 2;
        int cnt = 0;
        int Dn1 = 2;
        int Dn = 2;
        
        while (cnt < 500) {
            if (i % 2 == 0) {                    
                Dn = primeFactorisationNumberOfDivisors(i + 1);
                cnt = Dn * Dn1;
            } else {                    
                Dn1 = primeFactorisationNumberOfDivisors((i + 1) / 2);
                cnt = Dn*Dn1;
            }
            i++;                                                                
        }
        number = i * (i - 1) / 2;
        System.out.println(number);
	}

	private static int primeFactorisationNumberOfDivisors(int number) {
        int nod = 1;
        int exponent;
        int remain = number;
        
        for (Integer prime: knownPrimes) {

            // In case there is a remainder this is a prime factor as well
            // The exponent of that factor is 1
            if (prime * prime > number) {
                return nod * 2;
            }

            exponent = 1;
            while (remain % prime == 0) {
                exponent++;
                remain = remain / prime;
            }
            nod *= exponent;

            //If there is no remainder, return the count
            if (remain == 1) {
                return nod;
            }
        }
        return nod;
    }
	
	static {
		// REF: http://stackoverflow.com/questions/2068372/fastest-way-to-list-all-primes-below-n-in-python/3035188#3035188
		knownPrimes = new TreeSet<Integer>();
		int n = UPPER;
		boolean correction = (n % 6) > 1;
		
		// closest number to calculate primes till
		switch(n%6) {
			case 0:
				break;
			case 1:
				n = n-1;
				break;
			case 2:
				n = n+4;
				break;
			case 3:
				n = n+3;
				break;
			case 4:
				n = n+2;
				break;
			case 5:
				n = n+1;
				break;
		}
		
		boolean[] sieve = new boolean[n/3];
		for(int i = 1 ; i < sieve.length ; i++)
			sieve[i] = true;
		
		for(int i = 0 ; i < (int)(Math.abs(Math.sqrt(n)) + 1) ; i++) {
			if(sieve[i]) {
				int k = (3*i + 1) | 1;
				
				// sieve[      ((k*k)/3)      ::2*k]=[False]*((n/6-(k*k)/6-1)/k+1)
				int offset = (k*k)/3;
				int stride = 2*k;
				for(int indx = offset ; indx < sieve.length ; indx+=stride)
					sieve[indx] = false;
				
				// sieve[(k*k+4*k-2*k*(i&1))/3::2*k]=[False]*((n/6-(k*k+4*k-2*k*(i&1))/6-1)/k+1)
				offset = (k * k + 4 * k - 2 * k * (i & 1) ) / 3;
				for(int indx = offset ; indx < sieve.length ; indx+=stride)
					sieve[indx] = false;
			}
		}
		
		knownPrimes.add(2);
		knownPrimes.add(3);
		for(int i = 0 ; i < n/3 - (correction ? 1: 0) ; i++) 
			if(sieve[i])
				knownPrimes.add((3*i + 1) | 1);
	}
}
