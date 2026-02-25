
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] graph;
	static boolean[] visitedDepth, visitedBreadth;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		graph = new boolean[N+1][N+1];
		visitedDepth = new boolean[N+1];
		visitedBreadth = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = true;
			graph[b][a] = true;
		}
		
		dfs(V);
		System.out.println();
		bfs(V);
		
	}

	private static void dfs(int v) {
		if(visitedDepth[v]) return;
		visitedDepth[v] = true;
		System.out.print(v + " ");
		for (int i = 0; i < graph.length; i++) {
			if(!visitedBreadth[i]) {
				if(graph[v][i]) {
					dfs(i);
				}
			}
			
		}
		
		
	}
	
	private static void bfs(int v) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(v);
		visitedBreadth[v] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur + " ");
			
			for (int i = 0; i < graph.length; i++) {
				if(!visitedBreadth[i]) {
					if(graph[cur][i]) {
						visitedBreadth[i] = true;
						q.offer(i);
					}
				}
			}
		}
	}
}
