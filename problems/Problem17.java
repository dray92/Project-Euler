package problems;

public class Problem17 {
	
	private String[] digits = {" one",
							    " two",
							    " three",
							    " four",
							    " five",
							    " six",
							    " seven",
							    " eight",
							    " nine"};
	private String[] teens = {" eleven",
							    " twelve",
							    " thirteen",
							    " fourteen",
							    " fifteen",
							    " sixteen",
							    " seventeen",
							    " eighteen",
							    " nineteen"};
	private String[] bigs = {"",
							"thousand", 
							"million", 
							"billion"};
	private String[] tens = {" ten",
						    " twenty",
						    " thirty",
						    " forty",
						    " fifty",
						    " sixty",
						    " seventy",
						    " eighty",
						    " ninety"};

	public String num2String(int num) {
		if(num == 0)
			return "zero";
		else if(num < 0)
			return "negative" + num2String(-1*num);
		
		int count = 0;
		String st = "";

		while(num > 0) {
			if(num % 1000 != 0) {
				st = num2String100s(num % 1000) + " " + bigs[count] + " " + st;
			}
			num /= 1000;
			count++;
		}
		
		return st;
	}

	private String num2String100s(int num) {
		String st = "";
		
		// hundreds place
		if(num >= 100) {
			st = digits[num/100 - 1] + " hundred ";
			num %= 100;
		}
		
		// tens place
		if(num >= 11 && num <= 19) {
			return st + teens[num - 11] + " ";
		} else if(num == 10 || num>=20) {
			// get tens
			st += tens[num/10 - 1] + " ";
			num %= 10;
		}
		
		if(num >= 1 && num <= 9)
			st += digits[num - 1] + " ";
		
		return st;
	}
	
	public static void main(String[] args) {
		Problem17 Int2English = new Problem17();
		int sum = 0;
		for(int num = 1 ; num <= 1000 ; num++) {
			String st = Int2English.num2String(num).replaceAll(" ", "");
			sum += st.length();
			
			if(num > 100 && num%100 != 0)
				sum+=3;
		}
		System.out.println(sum);
		
	}
	
	
	
}
