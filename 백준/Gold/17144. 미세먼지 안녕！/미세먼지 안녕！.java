import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C, T, map[][];
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		int r = -1;

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					r = i;
				}
			}
		}

		for (int t = 0; t < T; t++) {
			spread();
			circulate(r);
		}

		int cnt = 2;
		for (int[] a : map)
			for (int b : a)
				cnt += b;

		System.out.println(cnt);
	}

	private static void spread() {
		int[][] changes = new int[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != 0) {
					int amount = map[i][j] / 5;

					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];

						if (inRange(nx, ny) && map[nx][ny] != -1) {
							changes[nx][ny] += amount;
							changes[i][j] -= amount;
						}
					}
				}
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] += changes[i][j];
			}
		}
	}

	private static void circulate(int r) {
		// circulate up (0, c-1)
		int x = r - 2, y = 0, d = 0;
		do {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(inRange(nx, ny) && nx < r) {
				map[x][y] = map[nx][ny];
				
			}else {
				d += 1;
				d %= 4;
				continue;
			}
			if(map[nx][ny] == -1) {
				map[x][y] = 0;
				break;
			}
			x = nx;
			y = ny;
		} while (map[x][y] != -1);

		// circulate down (0, c)
		x = r + 1;
		y = 0;
		d = 0;
		do {
			int nx = x + dx[(d + 2)%4];
			int ny = y + dy[d];
			if(inRange(nx, ny) && nx >= r) {
				map[x][y] = map[nx][ny];
				
			}else {
				d += 1;
				d %= 4;
				continue;
			}
			if(map[nx][ny] == -1) {
				map[x][y] = 0;
				break;
			}
			x = nx;
			y = ny;
		} while (map[x][y] != -1);

	}

	private static boolean inRange(int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C;
	}
}
