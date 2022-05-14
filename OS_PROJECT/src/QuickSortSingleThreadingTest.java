import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class QuickSortSingleThreadingTest {
    private QuickSortSingleThreading temp;

    @Before
    public void init() {
        temp = new QuickSortSingleThreading();
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
    public void quickSort() {
        int arr[] = {4, 5, 3, 2, 1};
        int arr1[] = {1, 2, 3, 4, 5};
        long startTime = System.nanoTime();
        temp.quickSort(arr, 0, arr.length - 1);
        long endTime = System.nanoTime();
        System.out.println("Execution time for QuickSortSingleThreading:" + (endTime - startTime) + "ns");  
        Assert.assertArrayEquals(arr1, arr);
    }
}
