
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main{

	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		makeSet(n);
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(op == 0) { // a 합 b
				union(a, b);
			}else { // a == b ??
				System.out.println(find(a) == find(b) ? "YES" : "NO");
			}
		}
	}

	private static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA != rootB) {
			parents[rootB] = rootA;
		}
	}

	private static int find(int n) {
		if(parents[n] == n) return n;
		return parents[n] = find(parents[n]);
	}

	private static void makeSet(int n) {
		parents = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
	}

}
