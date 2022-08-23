import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**

@author itsme
@since 2022. 8. 23.
@see
@performance
@category #
@note */
public class D4_03124{
	
	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int V,E,T;
	static List<Node>[] graph;
	
	static class Node implements Comparable<Node>{
		int no;
		long cost;
		
		private Node(int no, long cost) {
			super();
			this.no = no;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.cost, o.cost);
		}

		@Override
		public String toString() {
			return "Node [no=" + no + ", cost=" + cost + "]";
		}
		
		
		
	}
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		
		T=Integer.parseInt(input.readLine());
		
		for(int t=1;t<=T;t++) {
			tokens=new StringTokenizer(input.readLine());
			
			V=Integer.parseInt(tokens.nextToken());
			E=Integer.parseInt(tokens.nextToken());
			
			graph= new ArrayList[V+1];
			
			for(int i=0;i<=V;i++) {
				graph[i]=new ArrayList<>();
			}
			
			for(int i=0;i<E;i++) {
				tokens=new StringTokenizer(input.readLine());
				
				int n1=Integer.parseInt(tokens.nextToken());
				int n2=Integer.parseInt(tokens.nextToken());
				long cost= Long.parseLong(tokens.nextToken());
				
				graph[n1].add(new Node(n2,cost));
				graph[n2].add(new Node(n1,cost));
			}
			
			output.append(String.format("#%d ", t));
			prim();
			
		}
		
		System.out.println(output);
	}
	
	private static void prim() {
		long totalCost=0;
		
		boolean[] visited= new boolean[V+1];
		PriorityQueue<Node> pq= new PriorityQueue<>();
		int nodeCnt=0;
		
		pq.offer(new Node(1,0));
		
		while(!pq.isEmpty()) {
			Node minCostHead= pq.poll();
			//이미 방문 된 노드면 skip
			if(visited[minCostHead.no]) {
				continue;
			}
			visited[minCostHead.no]=true;
			totalCost+=minCostHead.cost;
			nodeCnt++;
			
			if(nodeCnt==V) {
				break;
			}
			
			//자식 탐색
			List<Node> children = graph[minCostHead.no];
			
			for(int i=0; i<children.size(); i++) {
				if(!visited[children.get(i).no] ) {
					pq.offer(new Node(children.get(i).no,children.get(i).cost));
					//여기서 방문처리 하지 않음 방문할 지는 뺄때 결정
				}
			}
		}
		output.append(totalCost).append("\n");
	}
}
