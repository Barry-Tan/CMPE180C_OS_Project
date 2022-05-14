import org.junit.Test;

import java.util.concurrent.ForkJoinPool;

import org.junit.Assert;
import org.junit.Before;

public class QuickSortMutliThreadingTest {
    private QuickSortMutliThreading temp;

    @Before
    public void init() {
        temp = new QuickSortMutliThreading();
    }

    @Test
    public void swap() {
        int v1 = 0, v2 = 1;
        int arr[] = {3, 2, 1};
        int arr1[] = {2, 3, 1};
        long startTime = System.nanoTime();
        temp.swap(arr, v1, v2);
        long endTime = System.nanoTime();
        System.out.println("Execution time for swap:" + (endTime - startTime) + "ns");    
        Assert.assertArrayEquals(arr1, arr);
    }

    @Test
    public void compute() {
        int arr[] = {4, 5, 3, 2, 1};
        int arr1[] = {1, 2, 3, 4, 5};
        long startTime = System.nanoTime();
        ForkJoinPool pool = ForkJoinPool.commonPool();
        pool.invoke(new QuickSortMutliThreading(0, arr.length - 1, arr));
        long endTime = System.nanoTime();
        System.out.println("Execution time for QuickSortMutliThreading:" + (endTime - startTime) + "ns");  
        Assert.assertArrayEquals(arr1, arr);
    }
}
