
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		ArrayList<Integer>[] edges = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			
			edges[i] = new ArrayList<>();
		}
		for (int i = 0; i < N - 1; i++) {
//			System.out.println(i);
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			edges[a].add(b);
			edges[b].add(a);
		}
//		System.out.println(Arrays.toString(edges));

		boolean[] visited = new boolean[N + 1];
		int[] parent = new int[N + 1];

		Queue<Integer> q = new ArrayDeque<>();

		q.offer(1);
		visited[1] = true;

		while (!q.isEmpty()) {

			int cur = q.poll();

			for (int next : edges[cur]) {
				if (!visited[next]) {
					visited[next] = true;
					parent[next] = cur;
					q.offer(next);
				}
			}
		}
		for (int i = 2; i < parent.length; i++)
			System.out.println(parent[i]);

	}

}
