/**
###MergeSort
In der Antwortvorlage finden Sie eine fertige Implementierung eines Testrahmens für Sortieralgorithmen inkl. einer Implementierung von MergeSort.
Bis jetzt benutzt MergeSort allerdings nur einen Thread. Implementieren Sie die Möglichkeit, die Sortierung auf mehrere Threads aufzuteilen. Hierbei bietet es sich an, das Array in mehrere, wenn möglich gleich große, Teile zu partitionieren und mit diesen in mehreren Threads das MergeSort auszuführen. Anschließend müssen die bereits sortierten Teilarrays nur noch durch das bereits gegebene merge zusammengeführt werden.
Ihre Implementierung findet ausschließlich in der Methode parallelMergeSort(int[] a, int threadCount) und in von Ihnen erstellten Methoden statt. An dem gegebenen Code müssen Sie, bis auf die gewünschte Threadanzahl, nichts verändern.
Die gegebene Funktion mergeSort(int[] a) teilt das Array a in zwei Hälften und ruft sich mit diesen rekursiv selbst auf. Dies geschieht solange, bis die Funktion mit einem Array der Länge  aufgerufen wird. Enthält ein Array nur
Ausgehend davon wird auf die beiden zusammengehörenden Teilarrays die Funktion merge(int[] left, int[] right, int[] a) aufgerufen.
Diese Funktion fügt die bereits sortierten Teilarrays left und right zu einem sortieren Array a, welches aus den Teilarrays besteht, zusammen. Dies geschieht bis zu dem ursprünglich ersten Aufruf von mergeSort. So entsteht am Ende ein komplett sortiertes Array.
Angenommen Sie möchten das Array [2, 3, 1, 8, 5, 9, 7] parallel sortieren, so könnten Sie zwei Threads starten, in denen jeweils mergeSort ausgeführt wird. Einmal mit dem Array [2,3,1] und einmal mit dem Array [8,5,9,7]. Sobald die Threads fertig sind und damit die beiden Arrays sortiert sind, können Sie die Arrays mit dem gegebenen merge im main-Thread zusammenführen.
Vergleichen Sie anschließend die benötigten Zeiten für unterschiedliche Anzahlen an Threads und verschiedene Arraygrößen. Lohnt sich die Parallelisierung für kleine Arrays?
 */


import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Mergesort {
	private static final Random RNG = new Random(42); // random number generator

    private static final boolean DEBUG = false;

	public static void main(String[] args) {
		int LENGTH = 1024; // initial length of array to sort
		int RUNS = 16; // how many times to grow by 2?

		for (int i = 1; i <= RUNS; i++) {
			int[] a = createRandomArray(LENGTH);
            if(DEBUG) System.out.println("Array to be sorted: " + Arrays.toString(a));

			// run the algorithm and time how long it takes
			long start = System.currentTimeMillis();
			int[] a_sorted = parallelMergeSort(a, 10);
            if(DEBUG) System.out.println("a: " + Arrays.toString(a));
            if(DEBUG) System.out.println("a_sorted: " + Arrays.toString(a_sorted));
			long duration = System.currentTimeMillis() - start;

			if (!isSorted(a_sorted)) {
				throw new RuntimeException("not sorted afterward: " + Arrays.toString(a_sorted));
			}

			System.out.printf("%10d elements  =>  %6d ms%n", LENGTH, duration);
			LENGTH *= 2; // double size of array for next time
		}
	}

    private static int[][] splitArray(int[] a, int threadCount){
        if(DEBUG) System.out.println("Array to split in " + threadCount + " arrays: " + Arrays.toString(a));
        int n = a.length / threadCount;
        boolean additionalLastElement = a.length % threadCount != 0;
        if(DEBUG) System.out.println("additionalLastElement: " + additionalLastElement);
        int[][] arrays = new int[threadCount][n];
        for(int i = 0; i < threadCount - 1; ++i){
            for(int j = 0; j < n; ++j){
                arrays[i][j] = a[i * n + j];
            }
        }
        if (additionalLastElement){
            arrays[threadCount -1] = new int[n+1];
            for(int i = 0; i < n + 1; ++i){
                arrays[threadCount - 1][i] = a[(threadCount-1) * n + i];
            }
        }else {
            for(int i = 0; i < n; ++i){
                arrays[threadCount -1][i] = a[(threadCount-1) * n + i];
            }
        }
        
        if(DEBUG) System.out.println("Split array: " + Arrays.deepToString(arrays));
        return arrays;
    }

	public static int[] parallelMergeSort(int[] a, int threadCount) {
		if (threadCount <= 1) {
			mergeSort(a);
            return a;
		} else if (a.length >= 2) {
            int[][] arrays = splitArray(a, threadCount);
            try{
            ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
            
            for(int[] array : arrays){
                if(DEBUG) System.out.println("Sorting array of length " + array.length + ": " + Arrays.toString(array));
                executorService.execute(() -> mergeSort(array));
            }

            executorService.shutdown();
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            if(DEBUG) System.out.println("All arrays sorted: " + Arrays.deepToString(arrays));
        }catch(InterruptedException ie){
            System.err.println(ie.getStackTrace());
        }
            
            int[] sortedArray = arrays[0];
            for(int i = 1; i < arrays.length; ++i){
                if(DEBUG) System.out.println("Merging: " + Arrays.toString(sortedArray) + ", " + Arrays.toString(arrays[i]));
                int[] newSortedArray = new int [sortedArray.length + arrays[i].length];
                merge(sortedArray, arrays[i], newSortedArray);
                if(DEBUG) System.out.println("Merged array: " + Arrays.toString(newSortedArray));
                sortedArray = newSortedArray;
            }
            
            if(DEBUG) System.out.println("Final result: " + Arrays.toString(sortedArray));
            if(DEBUG) System.out.println("a before assignment: " + Arrays.toString(a));
            a = sortedArray;
            if(DEBUG) System.out.println("a after assignment: " + Arrays.toString(a));

            return a;
		}else{
            throw new IllegalStateException("Should end up here");
        }
	}

	// Arranges the elements of the given array into sorted order
	// using the "merge sort" algorithm, which splits the array in half,
	// recursively sorts the halves, then merges the sorted halves.
	// It is O(N log N) for all inputs.
	public static void mergeSort(int[] a) {
		if (a.length >= 2) {
			// split array in half
			int[] left  = Arrays.copyOfRange(a, 0, a.length / 2);
			int[] right = Arrays.copyOfRange(a, a.length / 2, a.length);

			// sort the halves
			mergeSort(left);
			mergeSort(right);

			// merge them back together
			merge(left, right, a);
		}
	}

	// Combines the contents of sorted left/right arrays into output array a.
	// Assumes that left.length + right.length == a.length.
	public static void merge(int[] left, int[] right, int[] a) {
		int j = 0;
		int k = 0;
		for (int i = 0; i < a.length; i++) {
			if (k >= right.length || (j < left.length && left[j] < right[k])) {
				a[i] = left[j];
				j++;
			} else {
				a[i] = right[k];
				k++;
			}
		}
	}

	// Returns true if the given array is in sorted ascending order.
	public static boolean isSorted(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				return false;
			}
		}
		return true;
	}

	// Creates an array of the given length, fills it with random
	// non-negative integers, and returns it.
	public static int[] createRandomArray(int length) {
		int[] a = new int[length];
		for (int i = 0; i < a.length; i++) {
			a[i] = RNG.nextInt(1_000_000);
		}
		return a;
	}
}