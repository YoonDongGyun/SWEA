package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**

@author itsme
@since 2022. 8. 8.
@see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW8Wj7cqbY0DFAXN
@performance 34,336 kb 215 ms
@category #배열
@note */
public class D3_09229 {

	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T,N,M;
	static int[] snacks ;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		
		T=Integer.parseInt(input.readLine()); 
		
		for(int t=1;t<=T;t++) {
			int sum=-1;
			
			tokens=new StringTokenizer(input.readLine());
			
			N=Integer.parseInt(tokens.nextToken());
			M=Integer.parseInt(tokens.nextToken());
			
			snacks=new int[N];
			
			tokens=new StringTokenizer(input.readLine());
			for(int i=0;i<N;i++) {
				snacks[i]=Integer.parseInt(tokens.nextToken());
			}
			Arrays.sort(snacks);
			
			for(int i=N-1;i>=0;i--) {
				if(snacks[i]<M) {
					for(int j=i-1;j>=0;j--) {
						if(snacks[i]+snacks[j]<=M) {
							if(sum<snacks[i]+snacks[j]) {
								sum=snacks[i]+snacks[j];
							}
							
						}
					}
				}
			}
			
			System.out.printf("#%d %d%n",t,sum);
		}
		
	}

}