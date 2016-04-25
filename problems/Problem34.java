package problems;

import java.util.Arrays;

public class Problem34 {
	public static void main(String[] args) {
		int[] facts = new int[10];
		facts[0] = 1;
		facts[1] = 1;
		for(int i = 2 ; i < facts.length ; i++) 
			facts[i] = (i) * facts[i-1];
		
		System.out.println(Arrays.toString(facts));
		
		int result = 0;
		
		for (int i = 10; i < 2540161; i++) {
		    int sumOfFacts = 0;
		    int number = i;
		    while (number > 0) {
		        int d = number % 10;
		        number /= 10;
		        sumOfFacts += facts[d];
		    }
		 
		    if (sumOfFacts == i) {
		        result += i;
		    }
		}

		System.out.println(result);
	}
}
