import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int W, H, map[][];
	static boolean[][][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		visited = new boolean[H][W][K + 1];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dx = { { 0, 0, 1, -1 }, { 1, 1, 2, 2, -1, -1, -2, -2 } };
		int[][] dy = { { 1, -1, 0, 0 }, { 2, -2, 1, -1, 2, -2, 1, -1 } };
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { 0, 0, 0, 0 });
		visited[0][0][0] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int jump = cur[2];
			int dist = cur[3];

			if (x == H - 1 && y == W - 1) {
				System.out.println(dist);
				return;
			}

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[0][d];
				int ny = y + dy[0][d];
				if(inRange(nx, ny, jump)) {
					visited[nx][ny][jump] = true;
					q.offer(new int[] {nx, ny, jump, dist+1});
				}
			}
			if(jump < K) {
				for (int d = 0; d < 8; d++) {
					int nx = x + dx[1][d];
					int ny = y + dy[1][d];
					if(inRange(nx, ny, jump + 1)) {
						visited[nx][ny][jump + 1] = true;
						q.offer(new int[] {nx, ny, jump + 1, dist+1});
					}
				}				
			}
		}
		System.out.println(-1);
	}

	private static boolean inRange(int x, int y, int j) {
		return x >= 0 && x < H && y >= 0 && y < W && !visited[x][y][j] && map[x][y] == 0;
	}

}
