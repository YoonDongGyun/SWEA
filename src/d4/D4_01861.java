package d4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

@author itsme
@since 2022. 8. 9.
@see https://swexpertacademy.com/main/talk/solvingClub/problemSubmitHistory.do?contestProbId=AV5LtJYKDzsDFAXc&solveclubId=AYHg4cRqHpADFAV6&problemBoxTitle=8%EC%9B%94+2%EC%A3%BC&problemBoxCnt=4&probBoxId=AYJ7e5KK4AIDFAVG
@performance 29,464 kb 275 ms
@category #배열 완전탐색
@note 
*/
public class D4_01861 {
	  static BufferedReader input;
	    static StringBuilder output = new StringBuilder();
	    static StringTokenizer tokens;
	 
	    static int T;
	    static int N;
	    static int[][] map;
	    static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	    static int start;
	    static int max;
	 
	    public static void main(String[] args) throws IOException {
	    	input = new BufferedReader(new InputStreamReader(System.in));
	    	
	        T = Integer.parseInt(input.readLine());
	        for (int t = 1; t <= T; t++) {
	            N = Integer.parseInt(input.readLine());
	            map = new int[N][N];
	            for (int r = 0; r < N; r++) {
	                tokens = new StringTokenizer(input.readLine());
	                for (int c = 0; c < N; c++) {
	                    map[r][c] = Integer.parseInt(tokens.nextToken());
	                }
	            }
	 
	            start = 0;
	            max = 0;

	            travel();
	            output.append(String.format("#%d %d %d%n", t, start, max));
	        }
	        System.out.println(output);
	    }
	 
	    static void travel() {
	        for (int r = 0; r < N; r++) {
	            for (int c = 0; c < N; c++) {
	                int start_r = r;
	                int start_c = c;

	                int start_point = map[start_r][start_c];
	                int start_cnt = 1;
	                 
	                boolean canGo = true;
	                while(canGo) {
	
	                    canGo = false;

	                    for(int i=0; i<deltas.length; i++) {
	                        int nr = start_r + deltas[i][0];
	                        int nc = start_c + deltas[i][1];
	                        if(isIn(nr, nc) && map[start_r][start_c]+1 == map[nr][nc]) {
	                            canGo = true;
	                            start_r = nr;
	                            start_c = nc;
	                            start_cnt++;
	                            break;
	                        }
	                    }
	                }
	                 
	                if(start_cnt > max) {
	                    max = start_cnt;
	                    start = start_point;
	                }else if(start_cnt==max) {
	                    start = Math.min(start, start_point);
	                }
	            }
	        }
	    }
	 
	    static boolean isIn(int r, int c) {
	        return 0 <= r && r < N && 0 <= c && c < N;
	    }
	}