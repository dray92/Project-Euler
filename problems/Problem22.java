package problems;

import java.io.File;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Problem22 {
	
	public static void main(String[] args) {
		Scanner scanner = null;
		BigInteger sum = BigInteger.ZERO;
		try {
			scanner = new Scanner( new File("p022_names.txt"), "UTF-8" );
			String text = scanner.useDelimiter("\\A").next();
			String[] names = text.split(",");
			for(int i = 0 ; i < names.length ; i++) 
				names[i] = names[i].replaceAll("\"","");
			
			// sort by name
			Arrays.sort(names);
			
			for(int i = 0 ; i < names.length ; i++) {
				int alphabeticalValue = 0;
				for(int chars = 0 ; chars < names[i].length() ; chars++) 
					alphabeticalValue += (names[i].charAt(chars) - 'A' + 1);
				
				BigInteger bigAlphabeticalValue = BigInteger.valueOf(alphabeticalValue);
				BigInteger index = BigInteger.valueOf(i + 1);
				BigInteger product = bigAlphabeticalValue.multiply(index);
				
				if(names[i].equals("COLIN"))
					System.out.println(product);
				
				sum = sum.add(product);
			}
			
			System.out.println(sum);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close(); // Put this call in a finally block
		}
		
	}

}
