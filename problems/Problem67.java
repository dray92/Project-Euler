package problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Problem67 {
	public static void main(String[] args) throws IOException {
		String[] lines = readFile("p067_triangle.txt");
		
		String[] last = lines[lines.length - 1].split(" ");
		
		for(int i = lines.length - 2 ; i >= 0 ; i--) {
			String[] cur = lines[i].split(" ");
			StringBuilder newString = new StringBuilder();
			
			// every number at index `x` in cur will 
			// lead to index `x` and `x+1` in last
			for(int j = 0 ; j < cur.length ; j++) {
				int curVal = Integer.parseInt(cur[j]);
				
				int left = curVal + Integer.parseInt(last[j]);
				int right = curVal + Integer.parseInt(last[j+1]);
				
				int max = Math.max(left, right);
				newString.append(max);
				newString.append(" ");
			}
			
			last = newString.toString().split(" ");
		}
		System.out.println(Arrays.toString(last));
	}
	
	private static String[] readFile( String file ) throws IOException {
	    BufferedReader reader = new BufferedReader( new FileReader (file));
	    String         line = null;
	    StringBuilder  stringBuilder = new StringBuilder();
	    String         ls = System.getProperty("line.separator");

	    try {
	        while( ( line = reader.readLine() ) != null ) {
	            stringBuilder.append( line );
	            stringBuilder.append( ls );
	        }

	        return stringBuilder.toString().split("\n");
	    } finally {
	        reader.close();
	    }
	}
}
