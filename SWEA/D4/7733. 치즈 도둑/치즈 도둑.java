
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Solution {
	static int[][] cheese;
	static boolean[][] eaten;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int N;

	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		st.nextToken();
		int T = (int) st.nval;

		for (int tc = 1; tc <= T; tc++) {
			st.nextToken();
			N = (int) st.nval;
			cheese = new int[N][N];

			int max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					st.nextToken();
					cheese[i][j] = (int) st.nval;
					if (cheese[i][j] > max)
						max = cheese[i][j];
				}
			}
//			for(int[]a : map)
//				System.out.println(Arrays.toString(a));
//			System.out.println(max);

			int maxChunk = 0;

			for (int i = 0; i < max; i++) {
				int chunk = 0;
				eaten = new boolean[N][N];

				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						if (cheese[j][k] <= i)
							eaten[j][k] = true;
					}
				}

				// 덩어리 세야함
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						chunk += search(j, k, 0);
					}
				}
				if (chunk > maxChunk)
					maxChunk = chunk;
			}
			System.out.println("#" + tc + " " + maxChunk);
		}
	}

	static int search(int x, int y, int cnt) {
		if (eaten[x][y]) return 0;
		eaten[x][y] = true;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
				if (!eaten[nx][ny]) {
					search(nx, ny, cnt);
				}
			}
		}
		cnt++;
		return cnt;
	}
}
