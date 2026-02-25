
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int[][] map;
	static boolean[][] visited;
	static byte[] dx = { 0, 0, 1, -1 };
	static byte[] dy = { 1, -1, 0, 0 };
	static int N, M;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Byte.parseByte(line[j]);
			}
		}

		System.out.println(bfs(0, 0));

	}

	private static int bfs(int i, int j) {

		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { i, j });
		visited[i][j] = true;

		while (!q.isEmpty()) {

			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];

			if (x == N - 1 && y == M - 1)
				return map[x][y];

			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny] != 0) {
					q.offer(new int[] { nx, ny });
					visited[nx][ny] = true;
					map[nx][ny] = map[x][y] + 1;
				}
			}
		}
		return 0;
	}
}
