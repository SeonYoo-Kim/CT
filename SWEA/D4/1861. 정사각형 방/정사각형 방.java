
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{

	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int room[][], N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			room = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					room[i][j] = Integer.parseInt(st.nextToken());
			}
			int max = 0;
			int argMax = -1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int len = dfs(i, j);
					if(len > max) {
						max = len;
						argMax = room[i][j];
					}else if(len == max) {
						argMax = Math.min(argMax, room[i][j]);
					}
				}
			}
			System.out.println("#" + tc + " " + argMax + " " + max);
		}
	}

	private static int dfs(int x, int y) {
		int len = 1;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(inRange(nx, ny) && room[x][y] + 1 == room[nx][ny]) {
				len = 1 + dfs(nx, ny);
			}
		}
		return len;
	}

	private static boolean inRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

}
