package recursion;
import java.util.Arrays;
public class QuickSort{
    int randomdevide(int[] a ,int p , int r){
        //产生一个介于p~r之间的随机数
        int i =(int) (p + (Math.random() * (r-p)));
        int temp = a[p];
        a[p] = a[i];
        a[i] = temp;
        return devide(a,p,r);
    }

    public void quickSort(int[] a, int p, int right){
//        p = (int) (Math.random() * right);
        if (p < right){

            int q = randomdevide(a,p,right);
            quickSort(a, p,q-1);
            quickSort(a, q+1,right);
        }
    }
    int devide(int[] a ,int point ,int right){

        int i = 0;
        int j = right;
        int x = a[point];

        while (true){
            while(a[i] - x <= 0 && i < right){
                i++;
            }
            while (a[j] - x > 0){
                j--;
            }
            if (i >= j) break;
            int temp;
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        a[point] = a[j];
        a[j] = x;
        return j;
    }
    public static void main(String[] args) {
        int[] arr = {8,4,3,7,1,5,6,2};
        QuickSort qs = new QuickSort();
        qs.quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
