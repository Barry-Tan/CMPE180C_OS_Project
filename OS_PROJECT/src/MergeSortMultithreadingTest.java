import org.junit.Test;

import java.util.concurrent.ForkJoinPool;

import org.junit.Assert;
import org.junit.Before;

public class MergeSortMultithreadingTest {
    private MergeSortMultithreading temp;

    @Before
    public void init() {
        temp = new MergeSortMultithreading();
    }

    @Test
    public void merge() {
        int arr[] = {1, 3, 5, 2, 4, 6};
        int arr1[] = {1, 2, 3, 4, 5, 6};
        long startTime = System.nanoTime();
        temp.merge(arr, 0, arr.length -1);
        long endTime = System.nanoTime();
        System.out.println("Execution time for merge:" + (endTime - startTime) + "ns");  
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
        System.out.println("Execution time for MergeSortMultithreading:" + (endTime - startTime) + "ns");  
        Assert.assertArrayEquals(arr1, arr);
    }
}
