package DyPlaning;

public class LargeSum {
  int[] arr ;
  int b=0 ,sum=0;
  LargeSum(int[] arr){
    this.arr = arr;
  }
  int doSum (){
    for(int i =0;i<arr.length;i++){
      if(b>0) b += arr[i];
        //逻辑上是需要判断，但因为有sum记录最大值，所以该判断可有可无
//      else if (arr[i] > 0) b = arr[i];
//      else b = 0;
      else  b = arr[i];
      if(b > sum) sum = b;
    }
    return sum;
  }

  public static void main(String[] args) {
    int[] a = { -3, 2, -4, 7, -1, 6, -3, 5};
    LargeSum ls = new LargeSum(a);
    System.out.println("序列子段和的最大值为：" + ls.doSum());
  }
}
