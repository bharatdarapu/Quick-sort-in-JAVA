package syr.qs;

import java.util.Random;

public class QuickSort_Modified {

	static int qsa[] = new int[500];
	
	public static void main(String[] args) {
		long time=0;
		
		for(int i=0;i<100;i++)
		{
		generate_Random();
		long start=System.nanoTime();
		quicksort(0,qsa.length-1);
		long stop=System.nanoTime();
		time=time+(stop-start);
		}
		System.out.println("Total time taken--"+(time/100));
		/*for (int i = 0; i < 500; i++) {
			System.out.println("Sorted---" + qsa[i]);
		}*/
	}

	
	public static void selection_sort(int low, int high){
		for (int i = low; i <= high; i++)
        {
            int index = i;
            for (int j = i + 1; j <= high; j++)
                if (qsa[j] < qsa[index]) 
                    index = j;
            int temp = qsa[index];  
            qsa[index] = qsa[i];
            qsa[i] = temp;
        }
		  }
	
	
	public static void quicksort(int low, int high) {
		
			    int i = low, j = high;
			    // The pivot element will be from the middle of the array
			    int pivot = qsa[low + (high-low)/2];

			    if((high-low)<=10)
			    {
			    	//Applying selection sort as size of the array is <=10
			    	//selection_sort(Arrays.copyOfRange(qsa,low,high));
			    	selection_sort(low,high);
			    }

			    else{
			    // Dividing the initial array into two parts
			    while (i <= j) {
			      // If the current value from the left part is smaller than the pivot
			      // element then get the next element from the left part
			      while (qsa[i] < pivot) {
			        i++;
			      }
			      // If the current value from the right part is larger then the pivot
			      // element then get the next element from the right part
			      while (qsa[j] > pivot) {
			        j--;
			      }

			      //If a value from the left part is greater than the pivot element and a value from the right part is smaller than the pivot element
			      //is found then exchange them and so we increase i and decrease j
			      //when i=j then the pivot element is in its proper position with all left elements smaller and right elements greater.
			      if (i <= j) {
			        exchange(i, j);
			        i++;
			        j--;
			      }
			    }
			    // Recursively repeating the above process with the two sub parts
			    if (low < j)
			      quicksort(low, j);
			    if (i < high)
			      quicksort(i, high);
			  }
	}
			  private static void exchange(int i, int j) {
			    int temp = qsa[i];
			    qsa[i] = qsa[j];
			    qsa[j] = temp;
			  }
		

	public static void generate_Random() {
		Random randomGenerator = new Random();
		for (int i = 0; i < 500; i++) {
			qsa[i] = randomGenerator.nextInt(1000);
		}
	}

}
