
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class SortProgram {

    //function that

    /**
     *  test threshould 2.if greater than 100, use single thread sorting else use insertion sort
     * @param arr
     */
    public void completeProgram_single_merge(int[] arr, boolean display, boolean algr_test) {

        int threshold = 100;

        if (arr.length > threshold && algr_test==true) {

            System.out.println("Over 100 elements, singlethreading mergesort implement:");
            MergeSortSingleThreading ms = new MergeSortSingleThreading();
            ms.sort(arr,0,arr.length-1);

        } else {
            System.out.println("Within 100 elements, insertion sort implement:");
            InsertionSort is = new InsertionSort();
            is.sort(arr);
        }

        if(display==true){
            printArray(arr);
        }
    }

    /**
     * 1. test threshould 2.if greater than 100, use multi-thread sorting else use insertion sort
     * @param arr
     */
    public void completeProgram_multi_merge(int[] arr,boolean display,boolean algr_test) {

        int threshold = 100;

        if (arr.length > threshold && algr_test==true) {
            System.out.println("Over 100 elements, mutithreading mergesort implement:");
            ForkJoinPool pool1 = ForkJoinPool.commonPool();
            pool1.invoke(new MergeSortMultithreading(arr, 0, arr.length-1));

        } else {
            System.out.println("Within 100 elements, insertion sort implement:");
            InsertionSort is = new InsertionSort();
            is.sort(arr);
        }

        if(display==true){
            printArray(arr);
        }
    }

    public void completeProgram_single_quick(int[] arr,boolean dsiplay,boolean algr_test){

        int threshold =100;

        if(arr.length>threshold && algr_test==true){
            System.out.println("Over 100 elements, singlethreading quicksort implement:");
            QuickSortSingleThreading qs = new QuickSortSingleThreading();
            qs.quickSort(arr, 0, arr.length-1);
            

        }else{
            System.out.println("Within 100 elements, insertion sort implement:");
            InsertionSort is = new InsertionSort();
            is.sort(arr);
            
        }

        if(dsiplay==true){
            printArray(arr);
        }
    }

    //function that 1. test threshould 2.if greater than 100, use multi-thread quicksort else use insertion sort
    public void completeProgram_multi_quick(int[] arr, boolean display,boolean algr_test){

        int threshold =100;

        if(arr.length>threshold && algr_test==true){
            System.out.println("Over 100 elements, mutithreading quicksort implement:");
            ForkJoinPool pool = ForkJoinPool.commonPool();
            // Start the thread in fork
            pool.invoke(new QuickSortMutliThreading(0, arr.length - 1, arr));

        }else{
            System.out.println("Within 100 elements, insertion sort implement:");
            InsertionSort is = new InsertionSort();
            is.sort(arr);
        }

        if(display==true){
            printArray(arr);
        }
    }


    public static void printArray( int[] arr){
        if(arr != null)              System.out.println(Arrays.toString(arr));
    }

}













