package Question4;

public class EntropyOptimalSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "B A B A B A B A C A D A B R A";//"BABABABACADABRA";
		
		String[] arr = input.split(" ");
		
		System.out.println("lo  j   hi  0  1  2  3  4  5  6  7  8  9  10  11  12  13 14");
		System.out.println("-----------------------------------------------------------");
		System.out.println(formatString(arr, 0, 0, 0, true));
		System.out.println("-----------------------------------------------------------");
		
		sort(arr, 0, arr.length - 1);
		
	}

	 private static void exch(String[] a, int i, int j) {
	  String swap = a[i];
	  a[i] = a[j];
	  a[j] = swap;
	}
    
    private static void sort(String[] arr, int lo, int hi) {
    	if(hi <= lo)
    		return;
    	
    	int j = partition(arr, lo, hi);
    	//System.out.println(formatString(arr, lo, j, hi, false));
    	sort(arr, lo, j-1);
    	sort(arr, j+1, hi);
    }

    private static int partition(String[] arr, int lo, int hi) {
    	int i = lo, j = hi+1;
    	while(true) {
    		// arr[++i] < arr[lo]
    		while(Character.compare(arr[lo].charAt(0), arr[++i].charAt(0)) > 0) // (Character.compare(arr[++i].charAt(0), arr[lo].charAt(0)) < 0)
    			if(i == hi) break;
    		
    		//(arr[lo] < arr[--j])
    		while(Character.compare( arr[--j].charAt(0), arr[lo].charAt(0)) > 0)//(Character.compare(arr[lo].charAt(0), arr[--j].charAt(0)) < 0)
    			if(j == lo) break;
    		
    		if(i >= j) 
    			break;
    		
    		exch(arr, i, j);
    		
    		System.out.println(formatString(arr, lo, j, hi, false));
    	}
    	
    	exch(arr, lo, j);
    	
    	System.out.println(formatString(arr, lo, j, hi, false));
    	
    	return j;
    }
    
    static String formatString(String[] arr, int lo, int j, int hi, boolean supressIndexes) {
    	String spaceLo = lo < 10 ? " " : "";
    	String spaceJ = j < 10 ? " " : "";
    	String spaceHi = hi < 10 ? " " : "";
    	
    	String formatIndexes = "%d slo %d sj %d shi ";
    	formatIndexes = formatIndexes.replace("slo", spaceLo);
    	formatIndexes = formatIndexes.replace("sj", spaceJ);
    	formatIndexes = formatIndexes.replace("shi", spaceHi);
    	
    	formatIndexes = String.format
		(
				formatIndexes,
				lo, 
				j, 
				hi
		);
    	
    	String formatLetters = "%s  %s  %s  %s  %s  %s  %s  %s  %s  %s  %s   %s   %s   %s  %s";
    	formatLetters = String.format(formatLetters, (Object[]) arr);
    	
    	return supressIndexes ? "            " + formatLetters : formatIndexes + formatLetters;
    }

}
