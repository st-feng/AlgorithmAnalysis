package DyPlaning;
import java.util.Arrays;

public class AllBags {
	int bag;  //容量
	int[] weight; //物品重量
	int[] value;  //物品价值
	int point;  //定位指针
	int[][] m;
	
	//构造函数
	AllBags(int bag,int[] weight, int[] value){
		this.bag = bag;
		this.weight = weight;
		this.value = value;
		this.point = weight.length -1;
//		记录表：横坐标从0~C；纵坐标为物品种类
		this.m = new int[weight.length][bag+1];
	}
	
	void pull() {
		//当背包容量比物品小时，放不进去
		for(int j=0 ;j < weight[point]; j++) {
			m[point][j] = 0;
		}
		//背包容量可容第一个物品（初始化表格第一行）
		for(int j=weight[point] ; j <= bag; j++) {
			m[point][j] = value[point];
		}
		//从第二行开始
		for(int i=point -1 ; i>=0;i--) {
			//当背包小于当前物品重量时，价值为0
			for(int j=0;j<weight[i];j++) {
				//装不进去，那就是相当于不装，结果为子问题的解
				m[i][j] = m[i+1][j];
			}
			//当恰能容纳当前物品重量时
			for(int j = weight[i]; j <= bag ;j++) {
				m[i][j] = Math.max(value[i] + m[i+1][j-(weight[i])], m[i+1][j]);
			}
		}
	}

	void printBag(){
		int[] x = new int[weight.length];
		for (int i = 0; i < weight.length-1; i++) {
			if (m[i][bag] == m[i+1][bag]){
				x[i] = 0;
			}else {
				x[i] = 1;
				bag -= weight[i];
			}
		}
//	判断容量是否能够放入最小子问题对应的物品
		x[weight.length-1] = (m[weight.length-1][bag]>0)?1:0;
		System.out.println("放入背包情况为："+Arrays.toString(x));
	}

	public static void main(String[] args) {
		int[] w = {5,4,8,6,9};
		int[] v = {20,6,8,15,18};
		AllBags allBags = new AllBags(18,w,v);
		allBags.pull();
		allBags.printBag();
		System.out.println("价值记录如下：");
		for(int[] value:allBags.m) {
			System.out.println(Arrays.toString(value));
		}
	}
	
	
}
