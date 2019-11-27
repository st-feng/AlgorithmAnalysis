import org.junit.Test;
import recursion.QuickSort;

import java.util.Arrays;

public class QuickSortTest {
  @Test
  public static void mainTest(String[] args) {
    int[] arr = {8,4,3,7,1,5,6,2};
    System.out.println("输入的数组为："+ Arrays.toString(arr));

    int point = (int) (Math.random() * (arr.length-1));

    QuickSort qs = new QuickSort();
    qs.quickSort(arr,point,7);

    System.out.println("排序后数组为："+Arrays.toString(arr));




  }

}
