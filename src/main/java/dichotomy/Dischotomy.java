package dichotomy;
//二分法查找
// 按序号查找
// 按值查找
public class Dischotomy {
  public static void main(String[] args) {
    int[] arr = {1,8,12,15,16,21,30,35,39};

    int value = 30; //所要查找的值
    System.out.print("查找元素30的下标为：");
    printout(arr , 30);

    value = 20; //所要查找的值
    System.out.print("查找元素20的下标为：");
    printout(arr , 20);
  }

//对输出进行筛选后再进行输出，目的在于屏蔽错误返回值-1
  static void printout(int[] arr ,int value){
      //获得返回的下标值
    int re = serach(arr,value,0,arr.length-1) ;
      //如果下标值为错误值-1，则不输出该值
    if (re != -1){
        System.out.println(serach(arr,value,0,arr.length-1));
    }else { }
  }

//递归调用，二分法查找
  static int serach(int[] arr, int value ,int left, int right){
      //二分法，取列表中间为基准进行比较
    int mid = (left + right )/ 2;
      //判断是否已经变成 单元素
    if (left == right){
        //若干该元素正好为查找值，则返回下标
        if (arr[mid] == value){
            return mid ;
            //否则就是列表中无该元素。
        }else {
            System.out.println("无此元素。");
            //待搜索元素x=10不在数组中时，返回小于x的最大元素位置i和大于x的最小元素位置j。
            if (arr[mid] < value){
                System.out.println("小于"+value+"的最大元素位置i为：" + mid);
                System.out.println("大于"+value+"的最小元素位置j为：" + (mid +1));
            }else {
                //相反过来，则左边元素为小于value的最大值
                System.out.println("小于"+value+"的最大元素位置i为：" + (mid-1));
                System.out.println("大于"+value+"的最小元素位置j为：" + mid);
            }
            //返回错误值-1，否则会执行下面的代码，导致栈溢出
            return -1;
        }
    }

      //进行拆分

      //首先判断是否中值就是所找值
    if (arr[mid] == value){
        return mid;
    }else{
          //比较查找值与中值的关系
      if (arr[mid] < value){
          //扫描右半部分
          left = mid + 1;
          //递归返回的值赋给最外层的mid
          mid = serach(arr,value,left,right);
      }else {
                //扫描左半部分
                right = mid - 1;
                //递归返回的值赋给最外层的mid
                mid = serach(arr,value,left,right);
            }
    }
      //返回最终的中值 （单元素值）
    return mid;
  }
}


