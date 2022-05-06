import java.util.Random;
public class testing {
    
    // the main function that can

    /**
     * 1. verify and compare result from multi and single threading in quicksort and mergesort
     * 2. compare execution time between single and multi threading in
     *          a. quick sort
     *          b. merge sort
     * @param args
     * @throws Exception
     * */

    public static boolean display_result=true;
    public static boolean algorithm_test=true;
    public static boolean no_algorithm_test=false;
    public static boolean no_display_result=false;
    public static void main(String[] args) throws Exception {
        //test array for sorting
        //create array for testing

        // Array for testing if algorithm is correct
        int[] arr_algr_test = {2,8,4,5,7,8,2,1,6,5};

        // Array for testing time execution
        int[] arr_random=new int[5000000]; 
        int[] arr_sorted=new int[5000000];
        int[] arr_des =new int[5000000];

        for(int i=0;i<arr_random.length;i++){
            arr_random[i]=new Random().nextInt(1000000);
        }

        for(int i=0;i<arr_sorted.length;i++){
            arr_sorted[i]=i;
        }

        for(int i=0;i<arr_des.length;i++){
            arr_des[i]=arr_des.length-i;
        }

        // algorithm testing
        SortProgram tc = new SortProgram();

        System.out.println("Algrithm Testing:");
        System.out.println("The expected result:");
        System.out.println("[1, 2, 2, 4, 5, 5, 6, 7, 8, 8]\n");

        System.out.println("The insertion sort result:");
        tc.completeProgram_single_merge(arr_algr_test,display_result,no_algorithm_test);

        System.out.println("\nThe quicksort singlethread sort result:");
        tc.completeProgram_single_quick(arr_algr_test,display_result,algorithm_test);

        System.out.println("\nThe quicksort multithread sort result:");
        tc.completeProgram_multi_quick(arr_algr_test,display_result,algorithm_test);

        System.out.println("\nThe mergesort singlethread sort result:");
        tc.completeProgram_single_merge(arr_algr_test,display_result,algorithm_test);

        System.out.println("\nThe mergesort multithread sort result:");
        tc.completeProgram_multi_merge(arr_algr_test,display_result,algorithm_test);

        // Execution Time Testing
        System.out.println("\nRandom array,size=5 million");
        timeTesting(arr_random, tc, type.singleMerge);
        timeTesting(arr_random, tc, type.multiMerge);
        timeTesting(arr_random, tc, type.singleQuick);
        timeTesting(arr_random, tc, type.multiQuick);

        System.out.println("\nAlready Sorted Asceding Array, Size=5 million");
        timeTesting(arr_sorted, tc, type.singleMerge);
        timeTesting(arr_sorted, tc, type.multiMerge);
        timeTesting(arr_sorted, tc, type.singleQuick);
        timeTesting(arr_sorted, tc, type.multiQuick);

        System.out.println("\nAlready Sorted desceding Array, Size=5 million");
        timeTesting(arr_des, tc, type.singleMerge);
        timeTesting(arr_des, tc, type.multiMerge);
        timeTesting(arr_des, tc, type.singleQuick);
        timeTesting(arr_des, tc, type.multiQuick);
    }

    private enum type{
        singleQuick,multiQuick,singleMerge,multiMerge
    }

    private static void timeTesting(int[] arr,SortProgram mainProgram,type type){
        switch(type){
            case singleQuick:

                long start = System.currentTimeMillis();
                mainProgram.completeProgram_single_quick(arr, no_display_result, algorithm_test);
                long end = System.currentTimeMillis();
                System.out.println("SingleQuick Time: "+(end-start)+"ms\n");
                break;
            
            case multiQuick:
                start = System.currentTimeMillis();
                mainProgram.completeProgram_multi_quick(arr, no_display_result, algorithm_test);
                end = System.currentTimeMillis();
                System.out.println("MultiQuick Time: "+(end-start)+"ms\n");
                break;
            
            case singleMerge:
                start = System.currentTimeMillis();
                mainProgram.completeProgram_single_merge(arr, no_display_result, algorithm_test);
                end = System.currentTimeMillis();
                System.out.println("SingleMerge Time: "+(end-start)+"ms\n");
                break;   
            
            case multiMerge:
                start = System.currentTimeMillis();
                mainProgram.completeProgram_multi_merge(arr, no_display_result, algorithm_test);
                end = System.currentTimeMillis();
                System.out.println("MultiMerge Time: "+(end-start)+"ms\n");  
                break;
        }


        
    }

}
