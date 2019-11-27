package DyPlaning;

public class BiSearchTree{
  int len;
  int[] arr;
  int[] Hz ;
//  构造方法
  BiSearchTree( int[] arr,int[] Hz){
    this.arr = arr;
    this.Hz = Hz;
    this.len = arr.length;
  }



//  @Test
  void biTreeTest(){
    int[] a = {3,3,1,1};
    int[] h = {2, 3, 1, 1, 1};
    BiSearchTree biTree = new BiSearchTree(a,h);
  }
}