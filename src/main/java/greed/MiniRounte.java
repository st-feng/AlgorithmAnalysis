package greed;

import java.util.ArrayList;
import java.util.Arrays;

//贪心算法实现有向图最短路径搜索
public class MiniRounte {
//有向图
//  起点及长度
    int start,len;
//  顶点集
    int[] allNode;
//  边集
    int[][] margin;
//  用于记录前一个点
    int[] pre;
//  用于记录代价
    int[] dist ;
//  源
    ArrayList<Integer> source;
//  与源相对应的，非源
    ArrayList<Integer> notSource;

//  用最长权值表示不可达路径
    int MAX;

//    初始化图，以及初始化源.形参start是指定起点
    public MiniRounte(int s){
        this.start = s - 1;
//        初始化时使用二维表记录有向图
        MAX = Integer.MAX_VALUE;
        int[][] margin = {
                {0,3,4,MAX,MAX,MAX},
                {MAX,0,1,9,4,MAX},
                {MAX,MAX,0,5,13,MAX},
                {MAX,MAX,MAX,0,MAX,8},
                {MAX,MAX,MAX,12,0,10},
                {MAX,MAX,MAX,MAX,MAX,MAX,0}
        };
        int[] allNode  = {1,2,3,4,5,6};
        len = allNode.length;
        source = new ArrayList<Integer>();
        notSource = new ArrayList<Integer>();
//        将第起点加入源
        source.add(allNode[start]);//因为数组下标从0开始
//        将其他点加入非源
        for (int i = start; i < allNode.length ; i++) {
            notSource.add(allNode[i]);
        }
//        初始化，当源中只有起点时
        dist = new int[len];
        pre =  new int[len];
        for (int i = 0; i < len; i++) {
            dist[i] = margin[start][i];
            if (margin[start][i] != MAX) pre[i] = allNode[start];
        }
        this.allNode = allNode;
        this.margin = margin;
    }

    public void go(){
        int next = -1;

        while (true){
            if (source.size() == len) break;

            next = arrMin(notSource); //这里的next是数据
            source.add(next);
            notSource.remove((Integer) next);
            next --; //到这里，next用来当作下标。下标比实际的数小1
            for (int i = 0; i < len; i++) {
//            如果新加入的点next，有可达路径
                if (margin[next][i] != MAX){ //下标减 1
//             该路径是否比已有路径短
//                margin[next][i] + dist[next] ?< dist[i] 将小的值压入
//                dist[i] = Math.min((margin[next][i] + dist[next]),dist[i]);  //这种写法是不考虑记录上一元素的
                    if (margin[next][i] + dist[next] < dist[i]){
                        dist[i] = margin[next][i] + dist[next];
//                    记录该路径
                        pre[i] = next;
                    }
                }
            }
        }
        System.out.println("从"+(start+1)+"出发，到达个点的最小代价依次为："+Arrays.toString(dist));
        System.out.println("相对应的经过的前一个结点为:"+Arrays.toString(pre));
    }

//    扫描数组中最小的元素（主要用于扫描非源）
    int arrMin(ArrayList a){
        int min = MAX;
        for (int i = 0; i < a.size() ; i++) {
            min = Math.min((int) a.get(i),min);
        }
        return min;
    }
}
