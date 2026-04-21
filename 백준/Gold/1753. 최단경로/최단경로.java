import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node{
		int to, weighit;

		public Node(int to, int weighit) {
			super();
			this.to = to;
			this.weighit = weighit;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine()) - 1;
		int[] dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		ArrayList<Node>[] graph = new ArrayList[V];
		for (int i = 0; i < V; i++)
			graph[i] = new ArrayList<>();
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			graph[u].add(new Node(v, w));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.weighit, b.weighit));
		pq.offer(new Node(K, 0));
		dist[K] = 0;
		
		while(!pq.isEmpty()) {
			
			Node cur = pq.poll();
			
			if(cur.weighit > dist[cur.to]) continue;
			
			for (Node next : graph[cur.to]) {
				if(dist[cur.to] + next.weighit < dist[next.to]) {
					dist[next.to] = dist[cur.to] + next.weighit; 
					pq.offer(new Node(next.to, dist[next.to]));
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int a : dist)
			sb.append(a == Integer.MAX_VALUE ? "INF" : a).append("\n");
		System.out.println(sb);
	}

}
