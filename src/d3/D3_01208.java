package d3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D3_01208 {
	/*
	@author itsme
	@see https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AYHg4cRqHpADFAV6&contestProbId=AV139KOaABgCFAYh&probBoxId=AYHg4cRqHpEDFAV6+&type=PROBLEM&problemBoxTitle=8%EC%9B%94+1%EC%A3%BC&problemBoxCnt=++3+
	@performance 20812kb 114ms
	@category 기본 알고리즘
	@memo 덤핑 이후에 max,min 인덱스를 가져와야 함
	*/
	static BufferedReader input;
	static StringTokenizer tokens;
	static final int boxes=100;
	static int T=10,max_i=0,min_i=0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input=new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1;t<=T;t++) {
			int dump = Integer.parseInt(input.readLine());
			int[] box= new int[boxes];
			int max=Integer.MIN_VALUE;
			int min=Integer.MAX_VALUE;
			
			tokens=new StringTokenizer(input.readLine());
			
			for(int i=0;i<boxes;i++) {
				box[i]=Integer.parseInt(tokens.nextToken());
				
			}
			
			
			for(int i=0;i<dump;i++) {
				box[max_i]--;
				box[min_i]++;
				
				findMaxIndex(box);
				findMinIndex(box);
				if(box[max_i]-box[min_i]<=1) break;
				
			}
			System.out.printf("#%d %d%n",t,box[max_i]-box[min_i]);
		}
	}
	
	static void findMaxIndex(int[] b) {
		for(int i=0;i<b.length;i++) {
			if(b[i]>b[max_i]) {
				max_i=i;
			}
		}
		
	}
	
	static void findMinIndex(int[] b) {
		for(int i=0;i<b.length;i++) {
			if(b[i]<b[min_i]) {
				min_i=i;
			}
		}
		
	}

}
