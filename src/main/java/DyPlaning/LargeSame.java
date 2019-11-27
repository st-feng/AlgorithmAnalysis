package DyPlaning;
public class LargeSame {
  char[] X,Y;
  int m,n;
  //二维数组(包含了序列元素个数为null的情况)
  int[][] b,c ;

  //构造方法，传入两个序列
  LargeSame(char[] X,char[] Y){
    this.X = X;
    this.Y = Y;
    //行
    m = X.length;
    //列
    n = Y.length;
    c = new int[m+1][n+1];//用于记录长度
    b = new int[m+1][n+1];//用于记录步骤
  }

  //记录长度及步骤过程表格
  int resultLen (){
System.out.print("  ");
    for (int i=0; i<n; i++) System.out.print(Y[i]+" ");
System.out.println();
      //1.当任何一个序列为null时，公共序列Z为0
    for (int i=0; i <= m; i++ ){
      c[i][0] = 0;
    }
    for (int j=0; j <= n; j++)  c[0][j] = 0;
      //两个序列依次递增，找出所有子序列（填表过程）

    for (int i=1; i <= m; i++){     //(此处需要注意，i=1表示序列的第一个元素，而不是i=0)
System.out.print(X[i-1] + " ");
      for (int j=1; j<=n ; j++){
        //2.当X Y Z 第k元素相同时
        //问题递归为 C[i][j] = C[i-1][j-1] + 1
        //记录步骤为1
        if (X[i-1] == Y[j-1]){    //因为传入的数组X  Y 最后一个元素下标是length-1
          c[i][j] = c[i-1][j-1] + 1;
          b[i][j] = 1;
        }else {
          //3.当X||Y 第k元素不等于Z第k元素
          //3.1 Xm = Zk , Yn != Zk
          // 记录步骤为2
          if (c[i-1][j] >= c[i][j-1]){
            c[i][j] = c[i-1][j];
            b[i][j] = 2;
          }else {
            //3.2 Yn = Zk , Xm != Zk
            // 记录步骤为3
            c[i][j] = c[i][j-1];
            b[i][j] = 3;
          }
        }

System.out.print(b[i][j] +" ");
      }
      System.out.println();
    }
    return c[m][n];
  }

  void printLSame(int i,int j){

    //4.出口是当公共长度为0时
    if ( c[i][j]==0) return;
    //1.如果记录表b中值等于1，输出该字符
    if (b[i][j]==1){
      System.out.print(X[i-1]+" ");//因为数组从0开始，二维表从1开始
//      System.out.println("i:"+i+" "+"j:"+j);  //打印共同元素的位置
      printLSame(i-1,j-1);
    }else {
    //2.如果记录值等于2，跳到[i-1][j]
      if (b[i][j]==2){
        printLSame(i-1,j);
      }else {
    //3.如果记录值等于3，跳到[i][j-1]
        printLSame(i,j-1);
      }
    }
  }

  //测试程序
  public static void main(String[] args) {
    char[] X = {'i','A','C','T','C','C','T','A','G'};
    char[] Y = {'j','C','A','T','T','C','A','G','C'};

    LargeSame ls = new LargeSame(X,Y);
    System.out.println("最长子序列长度为:"+ls.resultLen());
    ls.printLSame(ls.m,ls.n);
  }
}
