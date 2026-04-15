
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{

	static int[] dx = { 1, 1, -1, -1 }; // 우하부터 시계방향
	static int[] dy = { 1, -1, -1, 1 };
	static boolean selected[];
	static int startX, startY, N, map[][], cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			int max = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > max)
						max = map[i][j];
				}
			}
			int asw = -1;
			for (int i = 0; i < N - 1; i++) {
				for (int j = 0; j < N - 1; j++) {
					selected = new boolean[max];
					startX = i;
					startY = j;
					cnt = 0;
					selected[map[i][j] - 1] = true;
					dfs(i, j, 0, 1);
					
					if (cnt != 0 && cnt > asw)
						asw = cnt;
				}
			}
			System.out.println("#" + tc + " " + asw);
		}

	}

	private static void dfs(int x, int y, int d, int len) {
		
		for (int i = 0; i < 2; i++) {
			int nd = d + i;
			if(nd >= 4) continue;
			int nx = x + dx[nd];
			int ny = y + dy[nd];

			
			if(nx == startX && ny == startY && len >= 4) {
				cnt = Math.max(len, cnt);
				return;
			}
			if (inRange(nx, ny) && !selected[map[nx][ny] - 1]) {
				
				selected[map[nx][ny] - 1] = true;
				dfs(nx, ny, nd, len + 1);
				selected[map[nx][ny] - 1] = false;
				
			}
			
		}
		
	}

	private static boolean inRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

}
