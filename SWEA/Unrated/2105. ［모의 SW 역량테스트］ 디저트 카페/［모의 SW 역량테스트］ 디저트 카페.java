import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int dx[] = { 1, 1, -1, -1 };
	static int dy[] = { 1, -1, -1, 1 };
	static int N, max, map[][], eaten, startX, startY, asw;
	static boolean selected[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			max = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > max)
						max = map[i][j];
				}
			}
			selected = new boolean[max + 1];
			asw = -1;
			for (int i = 0; i < N - 1; i++) {
				for (int j = 1; j < N - 1; j++) {
					startX = i;
					startY = j;
					// selected[map[i][j]] = true;
					//System.out.println("started : " + i + ", " + j);
					dfs(i, j, 0);
					// selected[map[i][j]] = false;
//					if(eaten != 0) {
//						
//					}
				}
			}
			System.out.println("#" + tc + " " + asw);
		}

	}

	private static void dfs(int x, int y, int d) {

		for (int i = 0; i < 2; i++) {
			int nd = d + i;

			if (nd == 3 && startX == x && startY == y) {
				eaten = 0;
				for(boolean a : selected) if(a) eaten++;
				asw = Math.max(asw, eaten);
				// System.out.println(eaten);
				return;
			}
			if(nd >= 4) {
				//System.out.println("direction over");
				return;
			}

			int nx = x + dx[nd];
			int ny = y + dy[nd];

			if (inRange(nx, ny) && !selected[map[nx][ny]]) {
				selected[map[nx][ny]] = true;
				//System.out.println(nx + ", " + ny);
				dfs(nx, ny, nd);
				selected[map[nx][ny]] = false;

			}

		}
	}

	private static boolean inRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}
