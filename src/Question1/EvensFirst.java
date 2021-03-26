package Question1;

import java.util.Arrays;

public class EvensFirst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = { 1, 2, 3, 4, 5, 6 };
		
		RearrangeArrayEvenFirst(array, 0);
		
		System.out.println(Arrays.toString(array));
	}
	
	static void RearrangeArrayEvenFirst(int[] array, int locInArr) {
		if(locInArr > (array.length - 1)) {
			return;
		} else if(array[locInArr] % 2 == 0) {
			int temp = array[locInArr];
			
			// we shift all values from the current location to the right
			for (int i = (locInArr - 1); i >= 0; i--)             
			    array[i+1] = array[i];
			
			
			array[0] = temp;
			
		} 
		
		locInArr++;
		
		RearrangeArrayEvenFirst(array, locInArr);
		
	}

}
