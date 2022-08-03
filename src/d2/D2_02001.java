package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 @author itsme
 @see https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AV5PzOCKAigDFAUq&solveclubId=AYHg4cRqHpADFAV6&problemBoxTitle=8%EC%9B%94+1%EC%A3%BC&problemBoxCnt=6&probBoxId=AYHg4cRqHpEDFAV6
 @performance 18,644 kb 107 ms
 @category D2 배열
 @memo 난이도 무난무난 배열 인덱스 정할 때 조금 더 꼼꼼히 하면 시간단축 많이 할 듯

 */
public class D2_02001 {
	static BufferedReader input;
	static StringTokenizer tokens;
	static int[][] map;
	static int[][] flapper;
	static int T,N,M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input=new BufferedReader(new InputStreamReader(System.in));
		
		
		T=Integer.parseInt(input.readLine());
		
		for(int t=1;t<=T;t++) {
			int max=Integer.MIN_VALUE;
			tokens=new StringTokenizer(input.readLine());
			
			N=Integer.parseInt(tokens.nextToken());
			M=Integer.parseInt(tokens.nextToken());
			
			map=new int[N][N];
			flapper=new int[N-M+1][N-M+1];
			
			for(int r=0;r<N;r++) {
				tokens= new StringTokenizer(input.readLine());
				for(int c=0;c<N;c++) {
					map[r][c]=Integer.parseInt(tokens.nextToken());
				}
			}
			
			for(int r=0;r<N-M+1;r++) {
				for(int c=0;c<N-M+1;c++) {
					for(int i=0;i<M;i++) {
						for(int j=0;j<M;j++) {
							flapper[r][c]+=map[r+i][c+j];
						}
					}
					if(max<flapper[r][c]) {
						max=flapper[r][c];
					}
				}
			}
			
			System.out.printf("#%d %d%n",t,max);
		}
	}

}
