import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int N, cheese[][];
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			cheese = new int[N][N];
			int maxDay = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
					if (cheese[i][j] > maxDay)
						maxDay = cheese[i][j];
				}
			}
			int max = 0;
			for (int day = 0; day <= maxDay; day++) {
				visited = new boolean[N][N];
				boolean[][] newCheese = new boolean[N][N];
				for (boolean[] a : newCheese)
					Arrays.fill(a, true);
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (cheese[i][j] <= day)
							newCheese[i][j] = false;
					}
				}
				int chunks = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(visited[i][j] || !newCheese[i][j]) continue;
						dfs(i, j, newCheese);
						chunks++;
					}
				}
				if (chunks > max)
					max = chunks;
			}
			System.out.println("#" + tc + " " + max);
		}
	}

	private static void dfs(int x, int y, boolean[][] cheese) {
		if (visited[x][y])
			return;
		visited[x][y] = true;

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (inRange(nx, ny) && cheese[x][y])
				dfs(nx, ny, cheese);
		}
	}

	private static boolean inRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

}
