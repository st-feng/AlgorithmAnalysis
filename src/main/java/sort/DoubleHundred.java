package sort;

public class DoubleHundred {
    public static void main (String[] args){
        //最外层为公鸡数量
        for (int m=1; m <=20 ; m++){
            //内层为母鸡数量
            for (int f=1; f<=33; f++){
               int s = 100-m -f;

                if (5*m + 3*f + s/3 == 100 && s % 3 ==0){

                    System.out.println("公鸡数量为： " +m);
                    System.out.println("母鸡数量为： " +f);
                    System.out.println("公鸡数量为： " +s);
                    System.out.println("==============分割线=========== " );
                }
            }
        }
    }
}
