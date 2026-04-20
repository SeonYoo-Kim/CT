import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	
	static class Edge{
		int to, weight;

		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		ArrayList<Edge>[] graph = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph[from].add(new Edge(to, weight));
			graph[to].add(new Edge(from, weight));
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
		boolean[] visited = new boolean[V+1];
		pq.offer(new Edge(1, 0));
		int sum = 0;
		int cnt = 0;
		
		while(!pq.isEmpty()) {
			
			Edge cur = pq.poll();
			
			if(visited[cur.to]) continue;
			visited[cur.to] = true;
			cnt++;
			sum += cur.weight;
			
			if(cnt == V) break;
			
			for (Edge a : graph[cur.to]) {
				if(!visited[a.to])
					pq.offer(a);
				
			}
		}
		System.out.println(sum);
	}
}
