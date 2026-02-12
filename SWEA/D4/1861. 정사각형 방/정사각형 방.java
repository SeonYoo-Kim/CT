
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Solution{

	static int[][] room;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int N, max, value;

	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		st.nextToken();
		int T = (int) st.nval;

		for (int tc = 1; tc <= T; tc++) {

			st.nextToken();
			N = (int) st.nval; // 1000 이하
			room = new int[N][N]; // 1 이상 n^2 이하 중복없음
			// 상하좌우로 이동 가능한데 현재방보다 1 커야만 갈수있음
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					st.nextToken();
					room[i][j] = (int) st.nval;
				}
			}

			max = 0;
			value = 0;
			for (int i = 0; i <N; i++) {
				for (int j = 0; j <N; j++) {
					int len = move(i, j);
					
					if(len > max) {
						max = len;
						value = room[i][j];
					}else if(len == max && room[i][j]<value) {
						value = room[i][j];
					}
				}
			}
			System.out.println("#" + tc + " " + value + " " + max);
		}
	}

	private static int move(int x, int y) {
		int cnt = 1;

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N) {

				if (room[x][y] + 1 == room[nx][ny]) {
					return cnt + move(nx, ny);
				}
			}
		}
		return cnt;
	}
}
