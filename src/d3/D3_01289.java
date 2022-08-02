package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_01289 {
	static BufferedReader input;
	static StringTokenizer tokens;
	static int T;
	
	public static void main(String[] args) throws IOException {
		input=new BufferedReader(new InputStreamReader(System.in));
		
		T=Integer.parseInt(input.readLine());
		for(int t=1;t<=T;t++) {
			String memory= input.readLine();
			int cnt=0;
			StringBuilder temp=new StringBuilder();
			
			for(int i=0;i<memory.length();i++) {
				if(cnt!=0){
					if(temp.charAt(i)!=memory.charAt(i)) {
						cnt++;
						for(int j=i;j<memory.length();j++) {
							temp.setCharAt(j, memory.charAt(i));
						}
						
					}
				}
				
				else if(cnt==0) {
					if(memory.charAt(i)=='1') {
						for(int j=i;j<memory.length();j++) {
							temp.append('1');
						}
						cnt++;
					}
					else {
						temp.append('0');
					}
				}
				
			}
			
			System.out.printf("#%d %d%n",t,cnt);
		}
	}

}
