
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static class edge{
		int from, to;
		long weight;
		
		public edge(int from, int to, long weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
	static int[] parents;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			parents = new int[N];
			makeSet(N);
			
			int[] x = new int[N];
			int[] y = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				x[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				y[i] = Integer.parseInt(st.nextToken());
			double E = Double.parseDouble(br.readLine());
			
			ArrayList<edge> graph = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = i; j < N; j++) {
					long dx = x[i] - x[j];
					long dy = y[i] - y[j];
					long weight = dx * dx + dy * dy; 
					graph.add(new edge(i, j, weight));
				}
			}
			graph.sort((a, b) -> Long.compare(a.weight, b.weight));
			
			int cnt = 0;
			long sum = 0;
			for (int i = 0; i < graph.size(); i++) {
				
				if(Union(graph.get(i).from, graph.get(i).to)) {
					cnt++;
					sum += graph.get(i).weight;
				}
					
				if(cnt == N - 1) break;
				
			}
			
			
			
			System.out.println("#" + tc + " " + Math.round(sum * E));
		}
	}
	private static boolean Union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB) return false;
		parents[rootB] = rootA;
		return true;
	}
	private static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	private static void makeSet(int n) {
		for (int i = 0; i < n; i++)
			parents[i] = i;		
	}

}
