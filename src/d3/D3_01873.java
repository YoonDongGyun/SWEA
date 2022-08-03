package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
  @author itsme
  @see https://swexpertacademy.com/main/talk/solvingClub/problemPassedUser.do?contestProbId=AV5LyE7KD2ADFAXc&solveclubId=AYHg4cRqHpADFAV6&problemBoxTitle=8%EC%9B%94+1%EC%A3%BC&problemBoxCnt=5&probBoxId=AYHg4cRqHpEDFAV6+
  @performance 23,184 kb 134 ms
  @category 기본 알고리즘 D3
  @memo 일반 String으로 출력하는 것보다 StringBuilder 사용해서 출력하는 것이 시간을 많이 단축 시킬 수 있다 (특히 이런 출력해야하는 데이터가 많은 경우에)
 */

public class D3_01873 {
	static BufferedReader input;
	static StringTokenizer tokens;
	static char[][] map;//맵 정보
	static char[] tank;//전차 이동 정보
	static int start_pointR, start_pointC;//전차 위치
	static int H,W,N;//맵 높이, 너비, 이동횟수
	static StringBuilder sb;//출력 위한 StringBuilder
	public static void main(String[] args) throws NumberFormatException, IOException {
		input=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(input.readLine());//test case
		
		for(int t=1;t<=T;t++) {
			tokens=new StringTokenizer(input.readLine());
			
			H=Integer.parseInt(tokens.nextToken());
			W=Integer.parseInt(tokens.nextToken());
			
			map=new char[H][W];
			
			for(int r=0;r<H;r++) {//맵과 전차 위치 저장
				String line=input.readLine();
				map[r]=line.toCharArray();
				for(int c=0;c<W;c++) {
					if(map[r][c]=='<' || map[r][c]=='>' || map[r][c]=='^' || map[r][c]=='v') {
						start_pointR=r;
						start_pointC=c;
					}
				}
			}
			
			N=Integer.parseInt(input.readLine());
			tank=new char[N];
			
			tank=input.readLine().toCharArray();//전차 이동 진행 char array로 저장
			
			for(int i=0;i<N;i++) {
				setDirection(tank[i]);//전차 방향 설정 및 이동
			}
			
			sb = new StringBuilder();

	        sb.append("#" + t + " ");
	        for(int i = 0; i < H; i++) {
	            for(int j = 0; j < W; j++) {
	                sb.append(map[i][j]);
	            }
	            sb.append("\n");
	        }

	        System.out.print(sb);
		}
	}
	static void setDirection(char m) {
		switch(m) {//이동 방법에 따라 전차 방향 설정 및 이동
		case 'U':
			map[start_pointR][start_pointC]='^';
			moveTank(map[start_pointR][start_pointC]);
			break;
		case 'D':
			map[start_pointR][start_pointC]='v';
			moveTank(map[start_pointR][start_pointC]);
			break;
		case 'L':
			map[start_pointR][start_pointC]='<';
			moveTank(map[start_pointR][start_pointC]);
			break;
		case 'R':
			map[start_pointR][start_pointC]='>';
			moveTank(map[start_pointR][start_pointC]);
			break;
		case 'S':
			shootTank(map[start_pointR][start_pointC]);
			break;
		}
	}
	
	static void moveTank(char tank) {
		int nr = 0,nc = 0;
		int[][] deltas= {{-1,0},{1,0},{0,-1},{0,1}};
		switch(tank) {//설정된 방향에 따라 전차를 한칸 이동 시킨다
		case '^':
			nr=start_pointR+deltas[0][0];
			nc=start_pointC+deltas[0][1];
			
			break;
		case 'v':
			nr=start_pointR+deltas[1][0];
			nc=start_pointC+deltas[1][1];
		
			break;
		case '<':
			nr=start_pointR+deltas[2][0];
			nc=start_pointC+deltas[2][1];
			
			break;
		case '>':
			nr=start_pointR+deltas[3][0];
			nc=start_pointC+deltas[3][1];
			
			break;
		}
		
		if(isIn(nr,nc) && map[nr][nc]=='.') {//평지를 만난다면 이동
			map[nr][nc]=map[start_pointR][start_pointC];
			map[start_pointR][start_pointC]='.';
			start_pointR=nr;
			start_pointC=nc;
		}
	}
	
	static void shootTank(char tank) {
		int nr = 0,nc = 0;
		int[][] deltas= {{-1,0},{1,0},{0,-1},{0,1}};
			switch(tank) {//설정된 방향에 따라 대포를 발사
			case '^':
				nr=start_pointR+deltas[0][0];
				nc=start_pointC+deltas[0][1];
				
				break;
			case 'v':
				nr=start_pointR+deltas[1][0];
				nc=start_pointC+deltas[1][1];
			
				break;
			case '<':
				nr=start_pointR+deltas[2][0];
				nc=start_pointC+deltas[2][1];
				
				break;
			case '>':
				nr=start_pointR+deltas[3][0];
				nc=start_pointC+deltas[3][1];
				
				break;
			}
			
			if(isIn(nr,nc) && (map[nr][nc]=='*')) {//벽을 만나면 부순다
				map[nr][nc]='.';
			}
			else if(isIn(nr,nc) && map[nr][nc]!='#'){//맵 내부에 있거나 강철로 만든 벽으로 막혀있지 않은 경우
				while(true) {
					switch(tank) {//설정된 방향에 부술 벽이 있는지 확인하기 위해 계속 탐색한다
					case '^':
						nr+=deltas[0][0];
						nc+=deltas[0][1];
						
						break;
					case 'v':
						nr+=deltas[1][0];
						nc+=deltas[1][1];
					
						break;
					case '<':
						nr+=deltas[2][0];
						nc+=deltas[2][1];
						
						break;
					case '>':
						nr+=deltas[3][0];
						nc+=deltas[3][1];
						
						break;
					}
					if(!isIn(nr,nc)) {//맵을 벗어나면 while을 벗어난다
						break;
					}
					
					if(map[nr][nc]=='#') {//강철로 만든 벽이 있다면 벗어난다
						break;
					}
					
					
					if(isIn(nr,nc) && (map[nr][nc]=='*')) {//벽을 만난다면 부순다
						map[nr][nc]='.';
						break;
					}
					
				}
			}
	}
		
	
	//맵 내부에 있는지 확인
	static boolean isIn(int r, int c) {
		return r>=0 && r<H && c>=0 && c<W;
	}
}
