
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static class Island{
		int to;
		long weight;
		
		public Island(int to, long weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] x = new int[N];
			int[] y = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				x[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				y[i] = Integer.parseInt(st.nextToken());
			
			double E = Double.parseDouble(br.readLine());
			
			ArrayList<Island>[] graph = new ArrayList[N+1];
			for (int i = 0; i <= N; i++)
				graph[i] = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					long dx = x[i] - x[j];
					long dy = y[i] - y[j];
					
					long weight = dx*dx + dy*dy; 
					graph[i].add(new Island(j, weight));
					graph[j].add(new Island(i, weight));
				}
			}

			PriorityQueue<Island> pq = new PriorityQueue<>((o1, o2) -> Double.compare(o1.weight, o2.weight));
			pq.offer(new Island(0, 0));
			boolean[] visited = new boolean[N + 1];
			long tax = 0;
			int cnt = 0;
			
			while(!pq.isEmpty()) {
				Island cur = pq.poll();
				
				if(visited[cur.to]) continue;
				visited[cur.to] = true;
				
				tax += cur.weight;
				cnt++;
				
				if(cnt == N) break;
				
				for (Island next : graph[cur.to])
					if(!visited[next.to])
						pq.offer(next);
			}
			System.out.println("#" + tc + " " + Math.round(tax * E));
		}
	}
}
