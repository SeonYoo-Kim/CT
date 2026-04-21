import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	
	static class Node{
		int to, weight;

		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Node [to=" + to + ", weight=" + weight + "]";
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Node>[] graph = new ArrayList[N+1];
		for (int i = 0; i <= N; i++)
			graph[i] = new ArrayList<>();
		
		for (int i = 1; i <= N; i++)
			graph[0].add(new Node(i, Integer.parseInt(br.readLine())));
		
		//int[][] matrix = new int[N][N];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(i!=j)
					graph[i].add(new Node(j, tmp));
			}
				
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));
		pq.add(new Node(0, 0));
		boolean visited[] = new boolean[N+1];
		// visited[1] = true;
		int cost = 0;
		
		while(!pq.isEmpty()) {
			
			Node cur = pq.poll();
//			System.out.println(cur.toString());
//			System.out.println(Arrays.toString(visited));
			
			if(visited[cur.to]) continue;
			visited[cur.to] = true;
//			System.out.println(cur.toString());
//			System.out.println(Arrays.toString(visited));
			
			cost += cur.weight;
			
			for(Node next : graph[cur.to]) {
				
				if(!visited[next.to]) {
					
			//		visited[next.to] = true;
					
					pq.offer(next);
					
				}
				
				
			}
					
			
		}
		
		
		System.out.println(cost);
	}

}
