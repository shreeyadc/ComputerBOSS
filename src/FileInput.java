/*
 * 
 * SPD Project (Computer BOSS Store)
 * 
 * This file will filter through the data uploaded by a file and store it into an array of 12 Laptop objects
 * 
 */

//import statements
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//FileInput class that will take in information from a txt file
public class FileInput {
	
	//global array of Laptop objects
	public static Laptop[] laptopArray = new Laptop[12];
	
	//main method
	public static void main(String[] args) {
	
		//calling the methods
		fillLibray();
		displayArray();
		
	}
	
	//fillLibrary method that will take the information from a txt file and transfer it to the array
	public static void fillLibray() {
		
		try {
			//use the scanner object to access the file
			Scanner inputFile = new Scanner(new File("data/Laptops.txt"));
			
			//set a delimiter which will stop scanning the data for one laptop
			inputFile.useDelimiter(",|\r\n");
			
			//for loop that will iterate through all the indexes in the laptop array
			for(int index = 0; index < laptopArray.length; index++) {
				
				//create variables of each data needed for the laptops
				String brand = inputFile.next();
				String model = inputFile.next();
				String type = inputFile.next();
				double price = inputFile.nextDouble();
				String system = inputFile.next();
				String cpu = inputFile.next();
				String gpu = inputFile.next();
				int ssd = inputFile.nextInt();
				int ram = inputFile.nextInt();
				double weight = inputFile.nextDouble();
				int noOfUSBPorts = inputFile.nextInt();
				double displaySize = inputFile.nextDouble();
				String link = inputFile.next();
				double score = inputFile.nextDouble();
				int laptopNum = inputFile.nextInt();
				
				//add the data to the corresponding laptop
				laptopArray[index] = new Laptop(brand, model, type, price, system, cpu, gpu, ssd,
						ram, weight, noOfUSBPorts, displaySize, link, score, laptopNum);
				
			}
			
			inputFile.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File error");
		}
	}
	
	//displayArray method that will output each laptop in the laptop array
	public static void displayArray() {
		for(Laptop laptop: laptopArray) {
			System.out.println(laptop);
		}
	}
	
	public static String toString(int i) {
		fillLibray();
		
		return laptopArray[i].toString();
	}
	
	public static String getBrand(int i) {
		
		fillLibray();
		return laptopArray[i].getBrand();
	}
	
	public static String getName(int i) {
		
		fillLibray();
		return laptopArray[i].getModel();
	}
	
	public static String getPrice(int i) {
		
		fillLibray();
		return Double.toString(laptopArray[i].getPrice());
		
	}
	public static double getPriceDouble(int i) {
		
		fillLibray();
		return laptopArray[i].getPrice();
		
	}
	public static String getType(int i) {
		
		fillLibray();
		return laptopArray[i].getType();
		
	}
	public static int getSsd(int i) {
		
		fillLibray();
		return laptopArray[i].getSsd();
		
	}	
	
	
	//displayArray method that will sort the array alphabetically
	public static void displayArraySortedAlphabetical() {
		Arrays.sort(laptopArray, Comparator.comparing(Laptop:: getModel));
		for(Laptop book: laptopArray) {
			System.out.println(book);
		}
	}

}
