
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

	static class edge {
		int from;
		int to;
		int weight;

		public edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}
		
	}

	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		makeSet(V);
		edge[] arr = new edge[E];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			arr[i] = new edge(A, B, C);
		}
		// for(edge a : arr) System.out.println(a.toString());
		Arrays.sort(arr, (o1, o2) -> Integer.compare(o1.weight, o2.weight));
		// for(edge a : arr) System.out.println(a.toString());
		int cnt = 0;
		int sum = 0;
		for (int i = 0; i < E; i++) {
			if(cnt == V-1) break;
			if(union(arr[i].to, arr[i].from)) {
				cnt ++;
				sum += arr[i].weight;
			}
		}
		
		System.out.println(sum);
	}

	private static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA != rootB) {
			parents[rootB] = rootA;
			return true;
		}
		return false;
	}

	private static int find(int x) {
		if(parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}

	private static void makeSet(int v) {
		parents = new int[v + 1];
		for (int i = 1; i <= v; i++)
			parents[i] = i;
	}

}
