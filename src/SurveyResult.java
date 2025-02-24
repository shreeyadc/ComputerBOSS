
public class SurveyResult {
	
	public static Laptop[] topThreeLaptops = new Laptop[3];
	public static int[] topLaptopsIndex = new int[3];
	public static int[] numOfMatches = new int[12];
	
	public static String[] results = new String[4];
	
	
	public static void main(String[] args) {
		
		findTopThree();	
	
	}
	public static void getMatches(String[] answerArray) {
		
		
		for (int i = 0; i < 12; i++) {
			
			int match = 0; //reset the number of matches to zero for each laptop
			String price; //declare the price variable
			int ssd = Integer.parseInt(answerArray[3]);
	
			//Check if the type of the laptop matches with the survey results
			if (FileInput.getType(i).equalsIgnoreCase(answerArray[0])) {
				match++;
				
			}
			else {
		
			}

			//Check if the price of the laptop matches with the survey results
			//See which price category the laptop is under
			if (FileInput.getPriceDouble(i) < 500) {
				price = "Budget";
			}
			else if (FileInput.getPriceDouble(i) >= 500 && FileInput.getPriceDouble(i) < 1000) {
				price = "Mid-Priced";
			}
			else if (FileInput.getPriceDouble(i) >= 1000 && FileInput.getPriceDouble(i) < 2000) {
				price = "High End";
			}
			else {
				price = "Ultra";
			}
			
			
			if (answerArray[1].equalsIgnoreCase(price)) {
				match++;
			}
			else {
			
			}
		
			
			//Check if the brand of the laptop matches with the survey results
			if(FileInput.getBrand(i).equalsIgnoreCase(answerArray[2])) {
				match++;
			}
			else {
			
			}
			
			if (FileInput.getSsd(i) >= ssd) {
				match++;
			}
			else {
			
			}
			

			numOfMatches[i] = match;

			findTopThree();
		}
		

	}
	public static void findTopThree() {
		
		FileInput.fillLibray();
		
		//find top match
		int top1 = 0;
		int index1 = 0;
		for (int i = 0; i < 12; i++) {
			if (numOfMatches[i] >= top1) {
				top1 = numOfMatches[i];
				topThreeLaptops[0] = FileInput.laptopArray[i];
				index1 = i;
			}
		}
		
		topLaptopsIndex[0] = index1;
		
		//find second best choice
		int top2 = 0;
		int index2 = 0;
		for (int i = 0; i < 12; i++) {
			if (numOfMatches[i] >= top2 && i != index1) {
				top2 = numOfMatches[i];
				topThreeLaptops[1] = FileInput.laptopArray[i];
				index2 = i;
			}
		}
		
		topLaptopsIndex[1] = index2;
		
		//find third best choice
		int top3 = 0;
		int index3 = 0;
		for (int i = 0; i < 12; i++) {
			if (numOfMatches[i] >= top3 && i != index1 && i != index2) {
				top3 = numOfMatches[i];
				topThreeLaptops[2] = FileInput.laptopArray[i];
			}
		}
		
		topLaptopsIndex[2] = index3;
		
	}
	
	public static double getPrice(int n) {
		
		findTopThree();	
		
		return topThreeLaptops[n].getPrice();
	}
	public static String getName(int n) {
		
		findTopThree();	
	
		return topThreeLaptops[n].getModel();
	}
	
	public static String getInfo(int n) {
		
		findTopThree();	
	
		return topThreeLaptops[n].toString();
	}
	public static String getLink(int i) {
		
		findTopThree();	
		
		return topThreeLaptops[i].getLink();
		
	}
	public static int getTopIndex(int i) {
		
		findTopThree();	
		
		return topThreeLaptops[i].getLaptopNum();
		
	}
	
}
