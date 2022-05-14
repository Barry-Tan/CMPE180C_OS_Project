import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class insertionSortTest {
    private InsertionSort temp;

    @Before
    public void init() {
        temp = new InsertionSort();
    }

    @Test
    public void sort()  {
        int arr[] = {5, 2, 1, 4, 3};
        int arr1[] = {1, 2, 3, 4, 5};
        long startTime = System.nanoTime();
        temp.sort(arr);
        long endTime = System.nanoTime();
        System.out.println("Execution time for sort:" + (endTime - startTime) + "ns");
        Assert.assertArrayEquals(arr1, arr);
    }

    @Test
    public void printArray() {
        int arr[] = {5, 2, 1, 4, 3};
        long startTime = System.nanoTime();
        temp.printArray(arr);
        long endTime = System.nanoTime();
        System.out.println("Execution time for printArray:" + (endTime - startTime) + "ns");    
    }

    
}

