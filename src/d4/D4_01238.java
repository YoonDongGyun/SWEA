package d4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Queue;
/**

@author itsme
@since 2022. 8. 22.
@see
@performance
@category #
@note */
public class D4_01238{
	
	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static List<Integer>[] contacts= new List[100];
	static Queue<Integer> queue= new LinkedList<>();
	static int N, start, max;
	static boolean[] visited= new boolean[100];
	    
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<11; t++) {
			contacts=new List[100];
			queue=new LinkedList<>();
			visited=new boolean[100];
			
			for(int i=0;i<100;i++) { 
	        	contacts[i] = new LinkedList<>();                
	        }
	         
	        tokens = new StringTokenizer(input.readLine());
	        
	        N = Integer.parseInt(tokens.nextToken());
	        start = Integer.parseInt(tokens.nextToken())-1;
	              
	        tokens = new StringTokenizer(input.readLine());
	        
	        for(int i=0;i<N/2;i++) {
	            int start = Integer.parseInt(tokens.nextToken())-1;
	            int end = Integer.parseInt(tokens.nextToken())-1;
	            if(!contacts[start].contains(end)) {
	            	contacts[start].add(end);
	            }
	        }
	        
	        bfs(start);
	        output.append(String.format("#%d %d\n", t, max+1));
		
		}
       
    System.out.println(output);

}
	
	static void bfs(int s) {
        visited[s]=true;
        
        for(int i=0;i<contacts[s].size();i++) { 
        	queue.offer(contacts[s].get(i));
        }
        
        while(!queue.isEmpty()) {
            max = Integer.MIN_VALUE;
            int size= queue.size();
            
            for(int i=0;i<size;i++) {
                int current = queue.poll();
                for(int j=0;j<contacts[current].size();j++) {
                    if(!visited[contacts[current].get(j)]) {
                        visited[contacts[current].get(j)]=true;
                        queue.offer(contacts[current].get(j));
                    }
                }
               max = Math.max(current, max);
            }
        }
         
    }
}