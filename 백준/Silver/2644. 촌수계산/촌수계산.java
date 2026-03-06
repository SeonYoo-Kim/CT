
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(br.readLine());

		ArrayList<Integer>[] nodes = new ArrayList[N + 1];

		for (int i = 1; i < N + 1; i++) {
			nodes[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			nodes[c].add(d);
			nodes[d].add(c);
		}

		Queue<int[]> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N + 1];
		q.offer(new int[] { a, 0 });
		visited[a] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int idx = cur[0];
			int step = cur[1];
			
			if(idx == b) {
				System.out.println(step);
				return;
			}

			for (int p : nodes[idx]) {

				if (!visited[p]) {
					visited[p] = true;
					q.offer(new int[] { p, step + 1 });
				}
			}
		}
		System.out.println(-1);
	}

}
