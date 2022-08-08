package d3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**

@author itsme
@since 2022. 8. 8.
@see
@git
@performance
@category #
@note */
public class D3_01228 {

	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static List<Integer> cryptogram= new ArrayList<>();
	static int N,state,point,cnt;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new FileReader("input.txt"));
		
		for(int t=1;t<=10;t++) {
			N=Integer.parseInt(input.readLine());
			
			tokens=new StringTokenizer(input.readLine());
			//System.out.println(input.readLine());
			for(int i=0;i<N;i++) {
				cryptogram.add(Integer.parseInt(tokens.nextToken()));
			}
			
			state=Integer.parseInt(input.readLine());
			
			tokens=new StringTokenizer(input.readLine());
			for(int i=0;i<state;i++) {
				tokens.nextToken();
				point=Integer.parseInt(tokens.nextToken());
				cnt=Integer.parseInt(tokens.nextToken());
				
				for(int j=0;j<cnt;j++) {
					cryptogram.add(point+j, Integer.parseInt(tokens.nextToken()));
				}
			}
			
			System.out.printf("#%d ",t);
			for(int r=0;r<10;r++) {
				System.out.printf("%d ",cryptogram.get(r));
			}
			System.out.println();
			cryptogram.clear();
		}
		
	}

}