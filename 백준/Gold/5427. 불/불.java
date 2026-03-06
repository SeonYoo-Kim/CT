
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int H, W, time[][];
	static char[][] map;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new char[H][W];
			time = new int[H][W];
			for (int[] a : time)
				Arrays.fill(a, -1);
			Queue<int[]> q = new ArrayDeque<>();
			int startX = 0, startY = 0;

			for (int i = 0; i < H; i++) {
				String line = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = line.charAt(j);
					if (map[i][j] == '@') {
						startX = i;
						startY = j;
						map[i][j] = '.';
					} else if (map[i][j] == '*') {
						q.offer(new int[] { i, j, 0 });
					}
				}
			}

			while (!q.isEmpty()) {

				int[] cur = q.poll();
				int x = cur[0];
				int y = cur[1];
				int t = cur[2];

				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					int nt = t + 1;

					if (inRange(nx, ny)) {
						time[nx][ny] = nt;
						q.offer(new int[] { nx, ny, nt });
					}
				}
			}
			bfs(startX, startY);
		}

	}

	private static void bfs(int startX, int startY) {

		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { startX, startY, 0 });
		boolean[][] visited = new boolean[H][W];
		visited[startX][startY] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int t = cur[2];

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				int nt = t + 1;

				if (inRange(nx, ny, nt)) {
					if (map[nx][ny] == '.' && (time[nx][ny] == -1 || time[nx][ny] > nt) && !visited[nx][ny]) {
						visited[nx][ny] = true;
						q.offer(new int[] { nx, ny, nt });
					}
				} else {
					System.out.println(nt);
					return;
				}
			}
		}
		System.out.println("IMPOSSIBLE");
	}

	private static boolean inRange(int x, int y, int t) {
		return x >= 0 && x < H && y >= 0 && y < W;
	}

	private static boolean inRange(int x, int y) {
		return x >= 0 && x < H && y >= 0 && y < W && map[x][y] == '.' && time[x][y] == -1;
	}

}
