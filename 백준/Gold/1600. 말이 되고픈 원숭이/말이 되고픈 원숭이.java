import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int map[][], W, H, K;
	static boolean[][][] visited;
	static int[][] dx = { { 0, 0, 1, -1 }, { 1, 1, 2, 2, -1, -1, -2, -2 } };
	static int[][] dy = { { 1, -1, 0, 0 }, { 2, -2, 1, -1, 2, -2, 1, -1 } };
//	static int[] dxHorse = { 1, 1, 2, 2, -1, -1, -2, -2 };
//	static int[] dyHorse = { 2, -2, 1, -1, 2, -2, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		visited = new boolean[H][W][K + 1];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] { 0, 0, 0, 0 });
		visited[0][0][0] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int dist = cur[2];
			int jump = cur[3];

			if (x == H - 1 && y == W - 1) {
				System.out.println(dist);
				return;
			}
			for (int i = 0; i < 2; i++) {
				for (int d = 0; d < dx[i].length; d++) {
					int nx = x + dx[i][d];
					int ny = y + dy[i][d];
					if (inRange(nx, ny)) {
						if (i == 0) {
							if (!visited[nx][ny][jump]) {
								visited[nx][ny][jump] = true;
								q.offer(new int[] { nx, ny, dist + 1, jump });
							}
						} else {
							if (jump < K && !visited[nx][ny][jump + 1]) {
								visited[nx][ny][jump + 1] = true;
								q.offer(new int[] { nx, ny, dist + 1, jump + 1 });
							}
						}
					}
				}
			}
		}

		System.out.println(-1);

	}

	private static boolean inRange(int x, int y) {
		return x >= 0 && x < H && y >= 0 && y < W && map[x][y] == 0;
	}

}
