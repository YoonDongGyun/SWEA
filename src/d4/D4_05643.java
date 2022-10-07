import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_05643 {
	static BufferedReader input;
	static StringTokenizer tokens;
	static StringBuilder output= new StringBuilder();
	static int T,N,M,INF=987654321;
	
	public static void main(String[] args) throws Exception{
		input= new BufferedReader(new InputStreamReader(System.in));
		
		T= Integer.parseInt(input.readLine());
		
		for(int t=1;t<=T;t++) {
			N=Integer.parseInt(input.readLine());
			M=Integer.parseInt(input.readLine());
			int result=0;

			int[][] graph=new int[N+1][N+1];
			
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					graph[i][j]=INF;
				}
			}
			
			for(int i=0;i<M;i++) {
				tokens= new StringTokenizer(input.readLine());
				
				int a=Integer.parseInt(tokens.nextToken());
				int b=Integer.parseInt(tokens.nextToken());
				
				graph[a][b]=1;
			}
			
			for (int k = 1; k <= N; k++) { 			// 경유지
				for (int i = 1; i <= N; i++) { 		// 출발지
					for (int j = 1; j <= N; j++) { 	// 도착지
						graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
					}
				}
			}
			
			for (int i = 1; i <= N; i++) {
				boolean flag = true;
				
				for (int j = 1; j <= N; j++) {
					if(i==j) continue;
					
					if (graph[i][j] == INF && graph[j][i] == INF) {
						flag = false;
						break;
					}
				}
				
				if (flag) {
					result++;
				}
			}
			
			output.append(String.format("#%d %d%n", t,result));
		}
		
		System.out.println(output);
	}
}
