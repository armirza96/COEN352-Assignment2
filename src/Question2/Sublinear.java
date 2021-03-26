package Question2;

import java.util.Arrays;

public class Sublinear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = { 6, 1,8,3,5,2,9,4,10,7};; //{ 2, 5, 1, 4, 6, 3};
		
		sort(array);
		
//		for(int el: array) {
//			System.out.println(el);
//		}
		System.out.println(Arrays.toString(array));
	}
	
	private static void sort(int[] arr) {
		
		//int[] aux = Arrays.copyOf(arr, arr.length);
		int n = arr.length;
		int m = 2; // n / 2
		
		int[] aux = new int[m];
		
		mBlockSort(arr, m);
		
		System.out.println(String.format("%d block sorted array", m));
		
//		for(int el: arr) {
//			System.out.println(el);
//		}
		System.out.println(Arrays.toString(arr));
		
		System.out.println("----------------------------");
		
		if(!isSortedAsc(arr)) {
	        for (int i = n / m - 1; i > 0; i--) {
	            for (int j = 0; j < i; j++) {
	                int lo = j * m;
	                int mid = (j + 1) * m - 1;
	                int hi = mid + m;
	    			merge(arr, aux, lo, mid, hi);
	                //merge(arr, aux, lo, mid, hi);
	            }
	        }

			//mergeSort(arr, aux, lo, hi, m, n / m - 1);
			//mergeSort(arr, aux, 0, m, m);
		}
	}
	
	private static void mBlockSort(int[] arr, int m) {
		for(int i = 0; i < arr.length ; i += m) {
			selectionSort(arr, i, i + m);
		}
	}
	
    private static void mergeSort(int[] a, int[] aux, int lo, int hi, int blockSize, int iterationCount) {
        if (iterationCount <= 0) return;
        int mid = (iterationCount + 1) * blockSize - 1;
        mergeSort(a, aux, lo, mid, blockSize, iterationCount -= 1);
        mergeSort(a, aux, mid + 1, hi, blockSize, iterationCount -= 1);
        merge(a, aux, lo, mid, hi);
    }

	
//    public static void merge(int[] arr, int[] aux, int lo, int mid, int hi)
//    {
//        for(int k = lo; k <= hi; k++) {
//        	aux[k] = arr[k];
//        }
//        
//        int i = lo, j = mid+1;
//        for (int k = lo; k <= hi; k++) {
//            if      (i > mid)              arr[k] = aux[j++];
//            else if (j > hi)               arr[k] = aux[i++];
//            else if (aux[j] < aux[i]) 	   arr[k] = aux[j++];
//            else                           arr[k] = aux[i++];
//        }
//    }
    private static void merge(int[] array, int[] aux, int low, int middle, int high) {
        int auxI = 0;

        for(int i = low; i <= middle; i++) {
            aux[auxI] = array[i];
            auxI++;
        }

        int loI = 0;
        int hiI = middle + 1;
        int arrI = low;

        while (loI < aux.length && hiI <= high) {
            if (aux[loI] <  array[hiI] ) {
                array[arrI] = aux[loI];
                loI++;
            } else {
                array[arrI] = array[hiI];
                hiI++;
            }

            arrI++;
        }

        while (loI < aux.length) {
            array[arrI] = aux[loI];

            loI++;
            arrI++;
        }
    }
	
    private static  void selectionSort(int[] arr, int beginIndex, int endIndex) { 
        for (int i = beginIndex; i < endIndex - 1; i++) 
        { 
            int minIndex = i; 
            for (int j = i+1; j < endIndex; j++) 
                if (arr[j] < arr[minIndex]) 
                	minIndex = j; 

            int temp = arr[minIndex]; 
            arr[minIndex] = arr[i]; 
            arr[i] = temp; 
        } 
    } 
	
    public static boolean isSortedAsc(int[] a) {
	    for (int i = 0; i < a.length - 1; i++) {
	        if (a[i] > a[i + 1]) {
	            return false;
	        }
	    }

	    return true; 
    }
	

}
