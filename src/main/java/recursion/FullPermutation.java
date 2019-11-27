package recursion;

public class FullPermutation {
  static int count = 0;//计算有多少种排列
  public static void perm(int[] arr, int start , int end) {
    if(start == end ) {//如果没有交换的数就输出一种排列，并且计数器+1
      System.out.print("[ ");
      for(int i = 0 ;i < arr.length ;i++)
        System.out.print(arr[i] + " ");
      System.out.print("]");
      System.out.println();
      count++;
      return;
    }else {
      for(int i = start ; i <= end ; i++) {
        swap(arr , i , start);
        perm(arr , start + 1 , end);
        swap(arr , i , start);
      }
    }
  }
  //交换素组元素
  public static void swap(int[] arr , int start ,int end ) {
    int temp = arr[start];
    arr[start] = arr[end];
    arr[end] = temp;

  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int [] arr = new int[] {1, 2, 3, 4, 5};
    perm(arr , 0 , arr.length-1);
    System.out.println("共有：" + count + " 种排列方式");
  }
}
