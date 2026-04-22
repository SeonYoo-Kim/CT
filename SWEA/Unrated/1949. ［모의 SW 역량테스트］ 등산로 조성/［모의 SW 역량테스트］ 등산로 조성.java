
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution{

	static int N, K, map[][], tops[][], len, asw;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static boolean[][] visited;

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
			int max = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > max)
						max = map[i][j];
				}
			}
			int idx = 0;
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					if (map[i][j] == max) {
						tops[idx][0] = i;
						tops[idx++][1] = j;
					}
			asw = 0;
			for (int[] top : tops) {
				int x = top[0];
				int y = top[1];

				if (x != -1 && y != -1) {
					len = -1;
					visited = new boolean[N][N];
					visited[x][y] = true;
					dfs(x, y, 0, 1);
					
				}

			}

			System.out.println("#" + tc + " " + asw);
		}

	}

	private static void dfs(int x, int y, int broken, int len) {

		if(len > asw) asw = len;
		

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (inRange(nx, ny) && !visited[nx][ny]) {
				
				if (map[nx][ny] < map[x][y]) {
					// System.out.println(nx + ", " + ny + " : " + map[nx][ny] + " -> not break & len : " + len);
					visited[nx][ny] = true;
					dfs(nx, ny, broken, len + 1);
					visited[nx][ny] = false;

				} else {
					if (broken == 0 && map[nx][ny] - K < map[x][y]) {
						// System.out.println(x + ", " + y + " -> " + (map[nx][ny] - K)  + ", " + map[x][y]);
						int origin = map[nx][ny]; 
						map[nx][ny] = map[x][y] - 1;
						// System.out.println(nx + ", " + ny + " : " + map[nx][ny] + " breaked & -> len : " + len);
						visited[nx][ny] = true;
						dfs(nx, ny, 1, len + 1);
						map[nx][ny] = origin;
						visited[nx][ny] = false;
					}
				}
			}
		}
	}

	private static boolean inRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

}
