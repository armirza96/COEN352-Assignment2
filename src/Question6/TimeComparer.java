package Question6;

import java.awt.List;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class TimeComparer {

	public static void main(String[] args) {
	    Scanner scn = new Scanner(System.in);
	    System.out.println("Enter a size for the array: ");

	    String inputtedSize = scn.nextLine();
	    int size = Integer.parseInt(inputtedSize);
	    System.out.println("Size is: " + size);
		
		Time[] arr = new Time[size];
		
		Random rand = new Random();
		for(int i = 0; i < size; i++) {
			// 0 - 24
			int hour = rand.nextInt(25);
			
			// 0 - 60
			int min = rand.nextInt(61);
						
			// 0 - 60
			int sec = rand.nextInt(61);
			
			arr[i] = new Time(hour, min, sec);
		}
		
		Arrays.sort(arr);
		
		Hashtable<String, Integer> dupes = new Hashtable<String, Integer>();
		
		for(int i = 0; i < size; i++) {
			Time time = arr[i];
			
			String key = time.toString();
			if(dupes.containsKey(key)) {
				int count = dupes.get(key) + 1;
				dupes.put(key, count);
			}
			else {
				dupes.put(key, 1);
			}
			
			
			System.out.println(key);
		}
		
		for (Map.Entry<String, Integer> entry : dupes.entrySet()) {
		    String key = entry.getKey();
		    int val = entry.getValue();
		    
		    System.out.println(String.format("%s time has %d duplicates", key, val));
		}
		
	}

}
