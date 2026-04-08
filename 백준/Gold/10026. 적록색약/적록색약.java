import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

	static int N;
	static char[][] paint;
	static boolean[][] visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		paint = new char[N][N];
		visited = new boolean[N][N];
		ArrayDeque<int[]> q = new ArrayDeque<>();
		int normal = 0, blind = 0;
		for (int i = 0; i < N; i++)
			paint[i] = br.readLine().toCharArray();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if (!visited[i][j]) {
					char color = paint[i][j];
					visited[i][j] = true;
					q.add(new int[] { i, j });

					while (!q.isEmpty()) {
						int[] cur = q.poll();
						int x = cur[0];
						int y = cur[1];

						for (int d = 0; d < 4; d++) {
							int nx = x + dx[d];
							int ny = y + dy[d];

							if (inRange(nx, ny) && paint[nx][ny] == color) {
								q.add(new int[] { nx, ny });
								visited[nx][ny] = true;
							}
						}
					} normal++;
				}
			}
		}

		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if (!visited[i][j]) {
					char color = paint[i][j];
					visited[i][j] = true;
					q.add(new int[] { i, j });

					while (!q.isEmpty()) {
						int[] cur = q.poll();
						int x = cur[0];
						int y = cur[1];

						for (int d = 0; d < 4; d++) {
							int nx = x + dx[d];
							int ny = y + dy[d];

							if (inRange(nx, ny) && same(nx, ny, color)) {
								q.add(new int[] { nx, ny });
								visited[nx][ny] = true;
							}
						}
					} blind++;
				}
			}
		}
		System.out.println(normal + " " + blind);
	}

	private static boolean same(int x, int y, char color) {
		if(paint[x][y] == color) return true;
		switch (color) {
		case 'R': 
			if(paint[x][y] == 'G')
				return true;
		case 'G': 
			if(paint[x][y] == 'R')
				return true;
		default:
			return false;
		}
	}

	private static boolean inRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N && !visited[x][y];
	}

}
