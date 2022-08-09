package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**

@author itsme
@since 2022. 8. 9.
@see https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AWgv9va6HnkDFAW0&solveclubId=AYHg4cRqHpADFAV6&problemBoxTitle=8%EC%9B%94+2%EC%A3%BC&problemBoxCnt=3&probBoxId=AYJ7e5KK4AIDFAVG
@performance 20,400 kb 3,547 ms
@category #순열
@note 순열 활용 다시 복습하고 문제 꼼꼼히 읽어보자 
*/
public class D3_06808 {

	static BufferedReader input;
	static StringBuilder output;
	static StringTokenizer tokens;
	static int T,win,lose;
	static int[] cards_g = new int[9];
	static int[] cards_i = new int[9];
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		
		T=Integer.parseInt(input.readLine());
		
		for(int t=1;t<=T;t++) {
			tokens=new StringTokenizer(input.readLine());
			output=new StringBuilder();
			win=0;
			lose=0;
			
			for(int i=0;i<9;i++) {
				cards_g[i]=Integer.parseInt(tokens.nextToken());
			}
			
			int cnt=0;
			
			for(int i=1;i<=18;i++) {
				for(int j=0;j<9;j++) {
					if(i!=cards_g[j]) {
						if(j==8) {
							cards_i[cnt]=i;
							cnt++;
						}
					}
					else break;
				}
			}
			makePermutation(0, new int[9], new boolean [9]);
			
			output.append("#").append(t).append(" "+win).append(" ").append(lose);
			System.out.println(output);
		}
		
	}
	
	static void makePermutation(int nth, int[] choosed, boolean[] visited) {
        //기저조건: 몇 번째거를 고르는데 choosed를 다 채웠다면 끝
    	if(nth == choosed.length) {
    		int score=0; 
    		for(int i=0;i<9;i++) {
    			if(choosed[i]>cards_g[i]) {
    				score-=choosed[i]+cards_g[i];
    			}
    			else {
    				score+=choosed[i]+cards_g[i];
    			}
    		}
    		
    		if(score>0) {
    			win++;
    		}
    		else if (score<0) {
    			lose++;
    		}
    		return;
    	}
    	
    	//inductive part
    	for(int i=0;i<cards_i.length;i++) {
    		if(!visited[i]) {
    			//해당하는 것을 사용하기
    			visited[i]=true;
    			choosed[nth] = cards_i[i];
    			makePermutation(nth+1, choosed, visited);
    			
    			//해당하는 것을 사용 안한 척하기
    			visited[i]=false;
    		}
    	}
    }
	
}