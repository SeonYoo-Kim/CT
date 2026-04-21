import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int N, K, map[][], tops[][], max;
	static boolean[][] visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			tops = new int[5][2];
			for (int[] top : tops)
				Arrays.fill(top, -1);

			int tall = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > tall)
						tall = map[i][j];
				}
			}
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == tall) {
						tops[cnt][0] = i;
						tops[cnt++][1] = j;
					}
				}
			}

			max = 0;
			for (int[] top : tops) {
				// len = 0;
				int x = top[0];
				int y = top[1];
				if (x == -1 || y == -1)
					break;
				int[][] copy = new int[N][N];
				for (int i = 0; i < N; i++) {
					copy[i] = map[i].clone();
				}
				visited = new boolean[N][N];
				visited[x][y] = true;
				dfs(x, y, 0, 1);

			}

			System.out.println("#" + tc + " " + max);
		}

	}

	private static void dfs(int x, int y, int broken, int len) {

		max = Math.max(len, max);

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (!inRange(nx, ny) || visited[nx][ny]) continue;

			if (map[nx][ny] < map[x][y]) {
				visited[nx][ny] = true;
				dfs(nx, ny, broken, len + 1);
				visited[nx][ny] = false;
			}
			else {
				if (broken == 0 && map[nx][ny] - K < map[x][y]) {
					int original = map[nx][ny];
					map[nx][ny] = map[x][y] - 1;
					
					visited[nx][ny] = true;
					dfs(nx, ny, 1, len + 1);
					visited[nx][ny] = false;
					
					map[nx][ny] = original;
				}
				
			}

		}
	}

	private static boolean inRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

}
