import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**

@author itsme
@since 2022. 8. 23.
@see
@performance
@category #
@note */
public class D4_03289{
	
	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T,n,m;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		
		T=Integer.parseInt(input.readLine());
		
		for(int t=1;t<=T;t++) {
			tokens=new StringTokenizer(input.readLine());
			
			n=Integer.parseInt(tokens.nextToken());
			m=Integer.parseInt(tokens.nextToken());
			
			parent=new int[n+1];
			makeSet();
			output.append(String.format("#%d ", t));
			
			for(int i=0;i<m;i++) {
				tokens=new StringTokenizer(input.readLine());
				
				int select = Integer.parseInt(tokens.nextToken());
				int n1=Integer.parseInt(tokens.nextToken());
				int n2=Integer.parseInt(tokens.nextToken());
				
				
				switch(select) {
				case 0:
					//합집합
					Union(n1,n2);
					break;
				case 1:
					//두 원소 같은 집합이냐
					if(findSet(n1)==findSet(n2)) {
						output.append(1);
					}
					else {
						output.append(0);
					}
					break;
				}
			}
			
			output.append("\n");
		}
		
		System.out.println(output);
	}
	static int findSet(int n) {
		if(n==parent[n]) {
			return n;
		}

		return parent[n]=findSet(parent[n]);
	}
	
	static void makeSet() {
		for(int i=0;i<n+1;i++) {
			parent[i]=i;
		}
	}
	
	static void Union(int n1, int n2) {
		n1=findSet(n1);
		n2=findSet(n2);
		
		if(n1!=n2) {
			parent[n2]=n1;
		}
	}
	
}
