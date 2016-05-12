import java.util.Scanner;

public class floyd {

	static int[][] Floyd(int[][] g){
		int n = g.length;
		int[][] d = new int[n][n];
		for(int i = 0;i < n;i++)
			for(int j = 0;j < n;j++){
				d[i][j] = g[i][j];
			}
		for(int k = 0;k < n;k++)
			for(int i = 0;i < n;i++)
				for(int j = 0;j < n;j++){
					if(d[i][j] > d[i][k] + d[k][j])
						d[i][j] = d[i][k] + d[k][j];
				}
		return d;
	}
	
	static int[][] initG(int n){
		int[][] g = new int[n][n];
		for(int i = 0;i < n;i++)
			for(int j = 0;j < n;j++){
				g[i][j] = Integer.MAX_VALUE/2;
			}
//		Scanner input = new Scanner(System.in);
//		while(input.hasNextInt()){
//			int i = input.nextInt();
//			int j = input.nextInt();
//			int weight = input.nextInt();
//			g[i][j] = weight;
//		}
		return g;
	}
	
	static char inttochar(int i){
		char c = 0;
		switch(i){
		case 0:	c = 'A';	break;
		case 1: c = 'B';	break;
		case 2: c = 'C';	break;
		case 3: c = 'D';	break;
		case 4: c = 'E';	break;
		}
		return c;
	}
	
	public static void main(String[] args) {
//		System.out.println("请输入维度");
//		Scanner sc = new Scanner(System.in);
		int n = 5;
		int[][] g = initG(n);
		g[0][1] = -1;	g[0][2] = 3;
		g[1][2] = 3;	g[1][3] = 2;	g[1][4] = 2;
		g[3][1] = 1;	g[3][2] = 5;
		g[4][3] = -3;
		int[][] d = Floyd(g);
		for(int i = 0;i < n;i++)
			for(int j = 0;j < n;j++){
				if(d[i][j] < 10000){
					System.out.println("从" + inttochar(i) +"到" + inttochar(j) +"的最短距离为：" + d[i][j]);
				}
			}
	}

}
