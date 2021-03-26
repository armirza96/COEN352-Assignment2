package Question5;

public class ThreeWayPartioning {

	public static void main(String[] args) {
		String input = "B A B A B A B A C A D A B R A";//"BABABABACADABRA";
		
		String[] arr = input.split(" ");
		
		System.out.println("lo  j   hi  0  1  2  3  4  5  6  7  8  9  10  11  12  13 14");
		System.out.println("-----------------------------------------------------------");
		System.out.println(formatString(arr, 0, 0, 0, true));
		System.out.println("-----------------------------------------------------------");
		
		sort(arr, 0, arr.length - 1);
		//System.out.println(formatString(arr, 0, 0, 0, true));
	}
    
    private static void sort(String[] arr, int lo, int hi) {
    	if(hi <= lo)
    		return;
    	
    	partition(arr, lo, hi);
    }

    private static void partition(String[] arr, int lo, int hi) {
    	int i = lo, j = hi+1;
    	
        int p = lo;
        int q = hi + 1;
    	
        String v = arr[lo];
        
    	while(true) {
            if (i > lo && Character.compare(arr[i].charAt(0), v.charAt(0)) == 0)
            	exch(arr, ++p, i);
            
            if (j <= hi && Character.compare(arr[j].charAt(0), v.charAt(0)) == 0)
            	exch(arr, --q, j);
            
            
    		while(Character.compare(arr[lo].charAt(0), arr[++i].charAt(0)) > 0)
    			if(i == hi) break;
    		
    		while(Character.compare(arr[--j].charAt(0), arr[lo].charAt(0)) > 0)
    			if(j == lo) break;
    		
            if (i == j && Character.compare(arr[i].charAt(0), v.charAt(0)) == 0) 
            	exch(arr, ++p, i);
    		
    		if(i >= j) 
    			break;
    		
    		exch(arr, i, j);
    		
    		System.out.println(formatString(arr, lo, j, hi, false));
    	}
    	
    	//exch(arr, lo, j);
    	
        i = j + 1;

        for(int k = lo; k <= p; k++) {
        	exch(arr, k, j--);
        	System.out.println(formatString(arr, lo, j, hi, false));
        }
        
        for(int k = hi; k >= q; k--) {
        	exch(arr, k, i++);
        	System.out.println(formatString(arr, lo, j, hi, false));
        }
    	
    	System.out.println(formatString(arr, lo, j, hi, false));
    	
    	sort(arr, lo, j);
    	sort(arr, i, hi);
    	
    	//return j;
    }
    
	 private static void exch(String[] a, int i, int j) {
		  String swap = a[i];
		  a[i] = a[j];
		  a[j] = swap;
	}
	 
    static String formatString(String[] arr, int lo, int j, int hi, boolean supressIndexes) {
    	String spaceLo = lo < 10 && lo >= 0 ? " " : "";
    	String spaceJ = j < 10 && j >= 0 ? " " : "";
    	String spaceHi = hi < 10 && hi >= 0 ? " " : "";
    	
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