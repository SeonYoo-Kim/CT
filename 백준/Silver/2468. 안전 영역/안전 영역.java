
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main{
	static int map[][], N;
	static boolean visited[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int heighest = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > heighest)
					heighest = map[i][j];
			}

		}
		int max = 0;
		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };

		for (int t = 0; t <= heighest; t++) {

			ArrayDeque<int[]> q = new ArrayDeque<>();
			visited = new boolean[N][N];
			int cnt = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					if (!visited[i][j] && map[i][j] > t) {
						visited[i][j] = true;
						q.offer(new int[] { i, j });

						while (!q.isEmpty()) {

							int[] cur = q.poll();
							int x = cur[0];
							int y = cur[1];

							for (int d = 0; d < 4; d++) {
								int nx = x + dx[d];
								int ny = y + dy[d];

								if (inRange(nx, ny, t)) {
									visited[nx][ny] = true;
									q.offer(new int[] { nx, ny });
								}
							}
						}
						cnt++;
					}
				}
			}
			if (cnt > max)
				max = cnt;
		}

		System.out.println(max);
	}

	private static boolean inRange(int x, int y, int t) {
		return x >= 0 && x < N && y >= 0 && y < N && !visited[x][y] && map[x][y] > t;
	}
}
