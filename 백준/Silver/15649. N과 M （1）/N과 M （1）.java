
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int M;
	private static int N;
	private static int[] selected;
	private static StringBuilder sb = new StringBuilder();
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1];
		selected = new int[M]; 

		def(0);

		System.out.println(sb);
		

	}

	private static void def(int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			selected[depth] = i;
			def(depth + 1);
			visited[i] = false;
		}
	}

}
