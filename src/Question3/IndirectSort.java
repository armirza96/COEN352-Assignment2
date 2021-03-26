package Question3;

import java.util.Arrays;

import Question6.Time;

public class IndirectSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 6,3,4,1,5,2};//{ 3,5,1,4,6,2};
						
		// perm should be {3,5,1,2,4,0} //{2,5,0,3,1,4}
		int[] perm = indirectSort(array);
		
//		for(int i = 0; i < perm.length; i++) {
//			
//			System.out.println(perm[i]);
//		}
		System.out.println(Arrays.toString(perm));
	}
	
	private static int[] indirectSort(int[] arr)
	{
		// Allocate space just once. Non-static aux used
		int[] aux = new int[arr.length];
		int[] perm = new int[arr.length];
		for (int i = 0; i < arr.length; i++)
			perm[i] = i;
		
		sort(arr, perm, aux, 0, arr.length - 1);
		
		return perm;
	} 
    

    private static void sort(int[] arr,int[] perm,int[] aux,  int lo, int hi)
    {
        if (hi <= lo)
        	return;
        	
        int mid = lo + (hi - lo) / 2;
 
        sort(arr, perm, aux, lo, mid);
        sort(arr, perm, aux, mid + 1, hi);

        merge(arr, perm, aux, lo, mid, hi);
        
    }
    
    private static void merge(int[] arr,int[] perm,int[] aux, int lo, int mid, int hi)
    {
		int i = lo, j = mid + 1;

		for (int k = lo; k <= hi; k++)
			aux[k] = perm[k];

		for (int k = lo; k <= hi; k++)
			if (i > mid) 
				perm[k] = aux[j++];
			else if (j > hi)  
				perm[k] = aux[i++];
			else if (arr[aux[j]] < arr [aux[i]])
				perm[k] = aux[j++];
			else
				perm[k] = aux[i++];
    }

}
