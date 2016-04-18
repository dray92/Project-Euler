package problems;

import java.io.File;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Problem42 {
	
	static Set<Integer> triangleNums = new TreeSet<Integer>();
	
	static {
		for(int i = 1 ; i <= 2000 ; i++) 
			triangleNums.add( (i*(i+1))/2 );
		
	}
	
	public static void main(String[] args) {
		Scanner scanner = null;
		int count = 0;
		try {
			scanner = new Scanner( new File("p042_words.txt"), "UTF-8" );
			String text = scanner.useDelimiter("\\A").next();
			String[] names = text.split("\",\"");
			names[0] = names[0].replace("\"", "");
			names[names.length-1] = names[names.length-1].replace("\"", "");
			for(String name: names) {
				int sum = 0;
				for(int i = 0 ; i < name.length() ; i++) 
					sum += (name.charAt(i) + 1 - 'A');
				if(triangleNums.contains(sum))
					count++;
			}
			System.out.println(count);
		} catch(Exception e) {
			
		}
	}

}
